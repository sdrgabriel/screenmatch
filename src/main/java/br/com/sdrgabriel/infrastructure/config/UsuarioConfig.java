package br.com.sdrgabriel.infrastructure.config;

import br.com.sdrgabriel.adapters.gateway.usuario.CriarUsuarioGateway;
import br.com.sdrgabriel.adapters.gateway.usuario.LoginUsuarioGateway;
import br.com.sdrgabriel.adapters.gateway.usuario.RecuperarTodosUsuariosGateway;
import br.com.sdrgabriel.adapters.gateway.usuario.RecuperarUmUsuarioGateway;
import br.com.sdrgabriel.adapters.usecase.usuario.criar.CriarUsuarioUseCase;
import br.com.sdrgabriel.adapters.usecase.usuario.login.LoginUsuarioUseCase;
import br.com.sdrgabriel.adapters.usecase.usuario.recuperar.get.RecuperarUmUsuarioUseCase;
import br.com.sdrgabriel.adapters.usecase.usuario.recuperar.list.RecuperarTodosUsuariosUseCase;
import br.com.sdrgabriel.application.usecaseimpl.usuario.criar.CriarUsuarioUseCaseImpl;
import br.com.sdrgabriel.application.usecaseimpl.usuario.login.LoginUsuarioUseCaseImpl;
import br.com.sdrgabriel.application.usecaseimpl.usuario.recuperar.get.RecuperarUmUsuarioUseCaseImpl;
import br.com.sdrgabriel.application.usecaseimpl.usuario.recuperar.list.RecuperarTodosUsuariosUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    public CriarUsuarioUseCase criarUsuarioUseCase(CriarUsuarioGateway criarUsuarioGateway) {
        return new CriarUsuarioUseCaseImpl(criarUsuarioGateway);
    }

    @Bean
    public RecuperarUmUsuarioUseCase recuperarUmUsuarioUseCase(RecuperarUmUsuarioGateway recuperarUmUsuarioGateway) {
        return new RecuperarUmUsuarioUseCaseImpl(recuperarUmUsuarioGateway);
    }

    @Bean
    public RecuperarTodosUsuariosUseCase recuperarTodosUsuariosUseCase(RecuperarTodosUsuariosGateway recuperarTodosUsuariosGateway) {
        return new RecuperarTodosUsuariosUseCaseImpl(recuperarTodosUsuariosGateway);
    }

    @Bean
    public LoginUsuarioUseCase loginUsuarioUseCase(LoginUsuarioGateway loginUsuarioGateway) {
        return new LoginUsuarioUseCaseImpl(loginUsuarioGateway);
    }

}
