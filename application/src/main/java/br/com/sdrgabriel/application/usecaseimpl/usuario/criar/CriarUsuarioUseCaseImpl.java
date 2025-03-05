package br.com.sdrgabriel.application.usecaseimpl.usuario.criar;

import br.com.sdrgabriel.adapters.gateway.usuario.CriarUsuarioGateway;
import br.com.sdrgabriel.adapters.usecase.usuario.criar.CriarUsuarioUseCase;
import br.com.sdrgabriel.core.domain.Usuario;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriarUsuarioUseCaseImpl implements CriarUsuarioUseCase {

    private final CriarUsuarioGateway criarUsuarioGateway;

    @Override
    public Usuario execute(Usuario input) {

        if (input.nome().isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }

        return criarUsuarioGateway.criar(input);
    }
}
