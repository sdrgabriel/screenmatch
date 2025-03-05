package br.com.sdrgabriel.infrastructure.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDate;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record ConteudoDTO(
        @JsonProperty("title")
        String titulo,
        @JsonProperty("plot")
        String descricao,
        @JsonProperty("released")
        @JsonFormat(pattern = "dd MMM yyyy", locale = "en")
        LocalDate dataDePublicacao,
        @JsonProperty("genre")
        String genero,
        @JsonProperty("language")
        String idioma,
        @JsonProperty("imdbRating")
        double nota,
        @JsonProperty("imdbVotes")
        String quantidadeDeVotos,
        @JsonProperty("type")
        String tipo,
        @JsonProperty("totalSeasons")
        String totalDeTemporadas
) {
}
