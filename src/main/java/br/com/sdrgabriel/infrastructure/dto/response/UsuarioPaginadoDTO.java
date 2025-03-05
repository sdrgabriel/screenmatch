package br.com.sdrgabriel.infrastructure.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record UsuarioPaginadoDTO(int page, int size, long total, int totalPages, List<UsuarioDTO> usuarios) {}
