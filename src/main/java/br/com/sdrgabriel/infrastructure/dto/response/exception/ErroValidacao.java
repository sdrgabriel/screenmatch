package br.com.sdrgabriel.infrastructure.dto.response.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record ErroValidacao(String campo, String mensagem) {}
