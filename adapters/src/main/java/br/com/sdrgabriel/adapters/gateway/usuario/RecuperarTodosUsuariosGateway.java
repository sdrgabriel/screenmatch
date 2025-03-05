package br.com.sdrgabriel.adapters.gateway.usuario;

import br.com.sdrgabriel.adapters.usecase.usuario.recuperar.list.RecuperarTodosUsuariosInput;
import br.com.sdrgabriel.adapters.usecase.usuario.recuperar.list.RecuperarTodosUsuariosOutput;

public interface RecuperarTodosUsuariosGateway {

    RecuperarTodosUsuariosOutput recuperar(RecuperarTodosUsuariosInput input);

}
