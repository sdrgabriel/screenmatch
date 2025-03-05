package br.com.sdrgabriel.infrastructure.service.usuario;

import br.com.sdrgabriel.adapters.gateway.usuario.LoginUsuarioGateway;
import br.com.sdrgabriel.core.domain.Token;
import br.com.sdrgabriel.core.domain.Usuario;
import br.com.sdrgabriel.infrastructure.entity.UsuarioEntity;
import br.com.sdrgabriel.infrastructure.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import static br.com.sdrgabriel.infrastructure.utils.Log.log;

@Service
@RequiredArgsConstructor
public class LoginUsuarioGatewayImpl implements LoginUsuarioGateway {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Override
    public Token logar(Usuario usuario) {
        log.info("Inicio login do usuário::LoginUsuarioGatewayImpl");
        var usernamePassword = new UsernamePasswordAuthenticationToken(usuario.nome(),  usuario.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UsuarioEntity) auth.getPrincipal());

        log.info("Fim login do usuário::LoginUsuarioGatewayImpl");
        return new Token(token);
    }
}
