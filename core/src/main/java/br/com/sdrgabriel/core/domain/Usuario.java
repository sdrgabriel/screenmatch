package br.com.sdrgabriel.core.domain;


import br.com.sdrgabriel.core.domain.enums.Cargo;
import lombok.Builder;

@Builder
public record Usuario(Long id, String nome, String senha, String email, Cargo cargo) {}
