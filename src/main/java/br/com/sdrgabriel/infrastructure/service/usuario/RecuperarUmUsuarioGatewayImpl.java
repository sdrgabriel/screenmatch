package br.com.sdrgabriel.infrastructure.service.usuario;

import br.com.sdrgabriel.adapters.gateway.usuario.RecuperarUmUsuarioGateway;
import br.com.sdrgabriel.core.domain.Usuario;
import br.com.sdrgabriel.core.exception.UsuarioNaoEncontradoException;
import br.com.sdrgabriel.infrastructure.mapper.UsuarioMapper;
import br.com.sdrgabriel.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.sdrgabriel.infrastructure.utils.Log.log;

@Service
@RequiredArgsConstructor
public class RecuperarUmUsuarioGatewayImpl implements RecuperarUmUsuarioGateway {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario recuperar(Long id) {
        log.info("Inicio da recuperação do usuário::CriarUsuarioGatewayImpl");
        var usuario = usuarioRepository.findById(id)
                .orElseThrow(UsuarioNaoEncontradoException::new);
        log.info("Fim da recuperação do usuário::CriarUsuarioGatewayImpl");
        return usuarioMapper.toUsuario(usuario);
    }

}
