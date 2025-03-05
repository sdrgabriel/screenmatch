package br.com.sdrgabriel.core.domain;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record Conteudo(
        String titulo,
        String descricao,
        LocalDate dataDePublicacao,
        String genero,
        String idioma,
        double nota,
        String quantidadeDeVotos,
        String tipo,
        String totalDeTemporadas
) {}
