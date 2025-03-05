package br.com.sdrgabriel.infrastructure.dto.response;

import lombok.Builder;

@Builder
public record UsuarioDTO(Long id, String nome, String email) {}
