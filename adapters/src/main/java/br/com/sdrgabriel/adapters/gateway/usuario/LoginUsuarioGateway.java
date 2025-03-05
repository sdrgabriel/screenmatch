package br.com.sdrgabriel.adapters.gateway.usuario;

import br.com.sdrgabriel.core.domain.Token;
import br.com.sdrgabriel.core.domain.Usuario;

public interface LoginUsuarioGateway {

    Token logar(Usuario usuario);

}

