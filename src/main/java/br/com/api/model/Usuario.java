package br.com.api.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


@Entity
@Table(name = "usuario")
@Data
public class Usuario  implements UserDetails{

    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;
    
    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;
    
    @Column(name = "profile")
    private String profile;
    
    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "users_roles",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id")
	)
    private Set<Role> roles = new HashSet<>();
  

    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();		
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}
	

	@Override
	public String getPassword() {		
		return this.senha;
	}

	@Override
	public String getUsername() {		
		return this.login;
	}

	public void addRole(Role role) {
		this.roles.add(role);
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", nome=" + nome + ", senha=" + senha + ", roles=" + roles
				+ "]";
	}
	
	
	
}


