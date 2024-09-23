package com.vendaseuvoto.usuarios;


import com.vendaseuvoto.usuarios.exceptions.UsuarioJaExisteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuariosService {


    @Autowired
    private UsuariosRepository usuariosRepositorio;

    @Autowired
    private PasswordEncoderService passwordEncoderService;



    public Usuarios inserir(Usuarios obj) {
        if (usuariosRepositorio.findByEmail(obj.getEmail()).isPresent()) {
            throw new UsuarioJaExisteException("Usuário com o e-mail digitado já existe.");
        }

        String encodedPassword = passwordEncoderService.encode(obj.getPassword());

        obj.setAccountNonExpired(true);
        obj.setAccountNonLocked(true);
        obj.setCredentialsNonExpired(true);
        obj.setEnabled(true);

        obj.setPassword(encodedPassword);

        obj = usuariosRepositorio.save(obj);

        return obj;
    }




}
