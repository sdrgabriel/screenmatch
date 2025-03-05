package br.com.sdrgabriel.application.usecaseimpl.usuario.recuperar.list;

import br.com.sdrgabriel.adapters.gateway.usuario.RecuperarTodosUsuariosGateway;
import br.com.sdrgabriel.adapters.usecase.usuario.recuperar.list.RecuperarTodosUsuariosInput;
import br.com.sdrgabriel.adapters.usecase.usuario.recuperar.list.RecuperarTodosUsuariosOutput;
import br.com.sdrgabriel.adapters.usecase.usuario.recuperar.list.RecuperarTodosUsuariosUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RecuperarTodosUsuariosUseCaseImpl implements RecuperarTodosUsuariosUseCase {

    private final RecuperarTodosUsuariosGateway recuperarTodosUsuariosGateway;

    @Override
    public RecuperarTodosUsuariosOutput execute(RecuperarTodosUsuariosInput input) {
        return recuperarTodosUsuariosGateway.recuperar(input);
    }
}
