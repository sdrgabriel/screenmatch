package br.com.sdrgabriel.application.usecaseimpl.usuario.login;

import br.com.sdrgabriel.adapters.gateway.usuario.LoginUsuarioGateway;
import br.com.sdrgabriel.adapters.usecase.usuario.login.LoginUsuarioUseCase;
import br.com.sdrgabriel.core.domain.Token;
import br.com.sdrgabriel.core.domain.Usuario;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoginUsuarioUseCaseImpl implements LoginUsuarioUseCase {

    private final LoginUsuarioGateway loginUsuarioGateway;

    @Override
    public Token execute(Usuario input) {
        return loginUsuarioGateway.logar(input);
    }
}
