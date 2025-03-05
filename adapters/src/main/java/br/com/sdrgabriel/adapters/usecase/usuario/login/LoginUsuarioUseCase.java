package br.com.sdrgabriel.adapters.usecase.usuario.login;

import br.com.sdrgabriel.adapters.usecase.UseCase;
import br.com.sdrgabriel.core.domain.Token;
import br.com.sdrgabriel.core.domain.Usuario;

public interface LoginUsuarioUseCase extends UseCase<Usuario, Token> {}
