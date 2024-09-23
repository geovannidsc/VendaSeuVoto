package com.vendaseuvoto.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {



    @Query("SELECT u FROM Usuarios u WHERE u.email =:email")
    Optional<Usuarios> findByEmail(@Param("email") String email);

}
