package com.vendaseuvoto.usuarios;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vendaseuvoto.permissoes.Permissoes;
import com.vendaseuvoto.pessoa.Pessoa;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Usuarios implements UserDetails,Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;

    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private Boolean enabled;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;


    @ManyToMany(fetch =FetchType.EAGER)
    @JoinTable(name = "usuarios-permissao", joinColumns = { @JoinColumn ( name = " id_usuario")},
            inverseJoinColumns = {@JoinColumn( name = "id_permissao")}
    )
    private List<Permissoes> permissoes;


    public Usuarios() {
    }

    public Usuarios(Long id, String email, String password, Boolean accountNonExpired, Boolean accountNonLocked, Boolean credentialsNonExpired, Boolean enabled, Pessoa pessoa, List<Permissoes> permissoes) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.pessoa = pessoa;
        this.permissoes = permissoes;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Permissoes> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissoes> permissoes) {
        this.permissoes = permissoes;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }




    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }




    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }




    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }




    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }




    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }




    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }




    public Boolean getEnabled() {
        return enabled;
    }




    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuarios usuarios = (Usuarios) o;
        return Objects.equals(id, usuarios.id) && Objects.equals(password, usuarios.password) && Objects.equals(permissoes, usuarios.permissoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, permissoes);
    }


}
