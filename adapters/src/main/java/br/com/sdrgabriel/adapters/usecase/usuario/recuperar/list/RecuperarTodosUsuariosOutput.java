package br.com.sdrgabriel.adapters.usecase.usuario.recuperar.list;

import br.com.sdrgabriel.core.domain.Usuario;
import lombok.Builder;

import java.util.List;

@Builder
public record RecuperarTodosUsuariosOutput(int page, int size, long total, int totalPages, List<Usuario> usuarios) {}
