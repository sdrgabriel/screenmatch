package br.com.sdrgabriel.infrastructure.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record LogarUsuarioForm(
        @JsonProperty(value = "nome", required = true)
        @NotEmpty(message = "Nome não pode ser vazio")
        String nome,

        @JsonProperty(value = "senha", required = true)
        @NotEmpty(message = "Senha não pode ser vazio")
        @Size(min = 8, message = "Senha deve ter no mínimo 8 caracteres")
        String senha
) {
}
