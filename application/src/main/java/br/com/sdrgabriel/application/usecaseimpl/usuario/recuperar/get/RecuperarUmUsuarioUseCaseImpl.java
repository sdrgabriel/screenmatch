package br.com.sdrgabriel.application.usecaseimpl.usuario.recuperar.get;

import br.com.sdrgabriel.adapters.gateway.usuario.RecuperarUmUsuarioGateway;
import br.com.sdrgabriel.adapters.usecase.usuario.recuperar.get.RecuperarUmUsuarioUseCase;
import br.com.sdrgabriel.core.domain.Usuario;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RecuperarUmUsuarioUseCaseImpl implements RecuperarUmUsuarioUseCase {

    private final RecuperarUmUsuarioGateway recuperarUmUsuarioGateway;

    @Override
    public Usuario execute(Long id) {

        if (id <= 0) {
            throw new IllegalArgumentException("Id não pode ser menor ou igual a zero");
        }

        return recuperarUmUsuarioGateway.recuperar(id);
    }
}
