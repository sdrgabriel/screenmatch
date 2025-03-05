package br.com.sdrgabriel.infrastructure.controller;

import br.com.sdrgabriel.adapters.usecase.usuario.criar.CriarUsuarioUseCase;
import br.com.sdrgabriel.adapters.usecase.usuario.login.LoginUsuarioUseCase;
import br.com.sdrgabriel.adapters.usecase.usuario.recuperar.get.RecuperarUmUsuarioUseCase;
import br.com.sdrgabriel.adapters.usecase.usuario.recuperar.list.RecuperarTodosUsuariosInput;
import br.com.sdrgabriel.adapters.usecase.usuario.recuperar.list.RecuperarTodosUsuariosUseCase;
import br.com.sdrgabriel.infrastructure.dto.request.CriarUsuarioForm;
import br.com.sdrgabriel.infrastructure.dto.request.LogarUsuarioForm;
import br.com.sdrgabriel.infrastructure.dto.response.TokenDTO;
import br.com.sdrgabriel.infrastructure.dto.response.UsuarioDTO;
import br.com.sdrgabriel.infrastructure.dto.response.UsuarioPaginadoDTO;
import br.com.sdrgabriel.infrastructure.dto.response.BaseResposta;
import br.com.sdrgabriel.infrastructure.mapper.UsuarioMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static br.com.sdrgabriel.infrastructure.utils.Log.log;

@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioMapper usuarioMapper;
    private final CriarUsuarioUseCase criarUsuarioUseCase;
    private final RecuperarUmUsuarioUseCase recuperarUmUsuarioUseCase;
    private final RecuperarTodosUsuariosUseCase recuperarTodosUsuariosUseCase;
    private final LoginUsuarioUseCase loginUsuarioUseCase;

    @GetMapping
    public ResponseEntity<UsuarioPaginadoDTO> listarUsuarios(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        log.info("Inicio da Listagem de usuários::UsuarioController");
        var input = new RecuperarTodosUsuariosInput(page, size);
        var output = recuperarTodosUsuariosUseCase.execute(input);
        log.info("Usuários listados com sucesso::UsuarioController");
        return ResponseEntity.ok(usuarioMapper.toUsuarioPaginadoDTO(output));
    }

    @GetMapping("{id}")
    public ResponseEntity<UsuarioDTO> recuperarUsuarioPorId(@PathVariable("id") long id) {
        log.info("Inicio da recuperação do usuário::UsuarioController");
        var usuario = recuperarUmUsuarioUseCase.execute(id);
        log.info("Usuário recuperado com sucesso::UsuarioController");
        return ResponseEntity.ok(usuarioMapper.toUsuarioDTO(usuario));
    }

    @PostMapping
    public ResponseEntity<BaseResposta<UsuarioDTO>> registrarUsuario(
            @Valid
            @RequestBody CriarUsuarioForm body) {
        log.info("Inicio da criação do usuário::UsuarioController");
        var usuario = criarUsuarioUseCase.execute(usuarioMapper.toUsuario(body));
        log.info("Usuário criado com sucesso::UsuarioController");
        return new ResponseEntity<>(BaseResposta.<UsuarioDTO>builder().sucesso(true).resposta(usuarioMapper.toUsuarioDTO(usuario)).build(), HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<TokenDTO> logarUsuario(
            @Valid
            @RequestBody LogarUsuarioForm body) {
        log.info("Inicio login do usuário::UsuarioController");
        var token = loginUsuarioUseCase.execute(usuarioMapper.toUsuario(body));
        log.info("Usuário logado com sucesso::UsuarioController");
        return ResponseEntity.ok(new TokenDTO(token.value()));
    }
}
