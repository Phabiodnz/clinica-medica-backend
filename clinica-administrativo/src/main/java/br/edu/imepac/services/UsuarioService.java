package br.edu.imepac.services;

import br.edu.imepac.dtos.UsuarioCreateRequest;
import br.edu.imepac.dtos.UsuarioDto;
import br.edu.imepac.models.UsuarioModel;
import br.edu.imepac.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    public List<UsuarioDto> findAll() {
        List<UsuarioModel> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuario -> {
            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setId(usuario.getId());
            usuarioDto.setIdentificacaoUsuario(usuario.getIdentificacaoUsuario());
            usuarioDto.setSenha(usuario.getSenha());
            return usuarioDto;
        }).collect(Collectors.toList());
    }

    public UsuarioDto update(Long id, UsuarioDto usuarioDetails) {
        Optional<UsuarioModel> optionalUsuario = usuarioRepository.findById(id);

        if (optionalUsuario.isPresent()) {
            UsuarioModel usuarioModel = optionalUsuario.get();
            usuarioModel.setIdentificacaoUsuario(usuarioDetails.getIdentificacaoUsuario());
            usuarioModel.setSenha(usuarioDetails.getSenha()); // Atualizamos a senha também se necessário

            UsuarioModel updatedUsuario = usuarioRepository.save(usuarioModel);

            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setId(updatedUsuario.getId());
            usuarioDto.setIdentificacaoUsuario(updatedUsuario.getIdentificacaoUsuario());
            usuarioDto.setSenha(updatedUsuario.getSenha());

            return usuarioDto;
        } else {
            return null;
        }
    }

    public UsuarioDto save(UsuarioCreateRequest usuarioRequest) {
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setIdentificacaoUsuario(usuarioRequest.getIdentificacaoUsuario());
        usuarioModel.setSenha(usuarioRequest.getSenha());

        UsuarioModel savedUsuario = usuarioRepository.save(usuarioModel);

        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(savedUsuario.getId());
        usuarioDto.setIdentificacaoUsuario(savedUsuario.getIdentificacaoUsuario());
        usuarioDto.setSenha(savedUsuario.getSenha());

        return usuarioDto;
    }

    public UsuarioDto findById(Long id) {
        Optional<UsuarioModel> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            UsuarioModel usuarioModel = optionalUsuario.get();
            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setId(usuarioModel.getId());
            usuarioDto.setIdentificacaoUsuario(usuarioModel.getIdentificacaoUsuario());
            usuarioDto.setSenha(usuarioModel.getSenha());

            return usuarioDto;
        } else {
            return null;
        }
    }
}


