package br.com.sdrgabriel.infrastructure.dto.response.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record ErroResposta(String mensagem, List<ErroValidacao> validacoes) {}
