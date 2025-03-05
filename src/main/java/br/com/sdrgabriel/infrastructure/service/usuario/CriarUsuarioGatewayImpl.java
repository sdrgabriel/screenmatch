package br.com.sdrgabriel.infrastructure.service.usuario;

import br.com.sdrgabriel.adapters.gateway.usuario.CriarUsuarioGateway;
import br.com.sdrgabriel.core.domain.Usuario;
import br.com.sdrgabriel.infrastructure.mapper.UsuarioMapper;
import br.com.sdrgabriel.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.sdrgabriel.infrastructure.utils.Log.log;

@Service
@RequiredArgsConstructor
public class CriarUsuarioGatewayImpl implements CriarUsuarioGateway {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario criar(Usuario usuario) {
        log.info("Inicio da criação do usuário::CriarUsuarioGatewayImpl");
        var usuarioEntity = usuarioMapper.toEntity(usuario);
        usuarioEntity = usuarioRepository.save(usuarioEntity);
        log.info("Fim da criação do usuário::CriarUsuarioGatewayImpl");
        return usuarioMapper.toUsuario(usuarioEntity);
    }

}
