package br.com.sdrgabriel.infrastructure.dto.request;

import br.com.sdrgabriel.core.domain.enums.Cargo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CriarUsuarioForm(
        @NotEmpty
        String nome,

        @NotEmpty
        @Size(min = 8, message = "Senha deve ter no mínimo 8 caracteres")
        String senha,

        @NotEmpty
        @Email(message = "Email inválido")
        String email,

        @NotNull
        Cargo cargo) {
}
