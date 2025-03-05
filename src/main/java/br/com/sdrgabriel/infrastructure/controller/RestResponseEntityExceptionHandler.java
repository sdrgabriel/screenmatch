package br.com.sdrgabriel.infrastructure.controller;

import br.com.sdrgabriel.core.exception.ConteudoNaoEncontrado;
import br.com.sdrgabriel.core.exception.FalhaEmConverterConteudo;
import br.com.sdrgabriel.core.exception.UsuarioNaoEncontradoException;
import br.com.sdrgabriel.infrastructure.dto.response.BaseResposta;
import br.com.sdrgabriel.infrastructure.dto.response.exception.ErroResposta;
import br.com.sdrgabriel.infrastructure.dto.response.exception.ErroValidacao;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.NonNull;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({UsuarioNaoEncontradoException.class, ConteudoNaoEncontrado.class, FalhaEmConverterConteudo.class})
    public ResponseEntity<BaseResposta<String>> usuarioNaoEncontradoException(RuntimeException ex) {
        return new ResponseEntity<>(BaseResposta.<String>builder().sucesso(false).mensagem(ex.getMessage()).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<BaseResposta<String>> dataIntegrityViolationException() {
        return new ResponseEntity<>(BaseResposta.<String>builder().sucesso(false).mensagem("Usuario já existe no banco").build(), HttpStatus.CONFLICT);
    }


    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            @NonNull HttpMessageNotReadableException ex,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatusCode status,
            @NonNull WebRequest request) {
        String detalhesErro = "Unaccepted JSON request " + ex.getMessage();

        if (ex.getCause() instanceof InvalidFormatException ifx
            && ifx.getTargetType() != null && ifx.getTargetType().isEnum()) {
                detalhesErro = "Valor de enum invalido: '%s' para o campo: '%s'. O valor deve ser um destes: %s."
                        .formatted(ifx.getValue(), ifx.getPath().getLast().getFieldName(), Arrays.toString(ifx.getTargetType().getEnumConstants()));
        }

        var baseResponse = BaseResposta.<ErroResposta>builder().sucesso(false).mensagem(detalhesErro).build();
        return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            @NonNull MethodArgumentNotValidException ex,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatusCode status,
            @NonNull WebRequest request) {
        List<ErroValidacao> errosValidacao = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(
                        error -> {
                            String fieldName = ((FieldError) error).getField();
                            String errorMessage = error.getDefaultMessage();
                            return new ErroValidacao(fieldName, errorMessage);
                        }).toList();
        var erroResposta = new ErroResposta("Erro ao processar a requisição", errosValidacao);
        var baseResponse = BaseResposta.<ErroResposta>builder().sucesso(false).erro(erroResposta).build();
        return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
    }
}
