package com.thegoodseeds.seedsaversapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "tb_roles")
public class Role implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>(); // Um perfil tem uma lista de Usuários associados a ele.


    public Role(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }


}
