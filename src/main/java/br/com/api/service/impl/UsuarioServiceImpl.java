package br.com.api.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import br.com.api.exception.CustomException;
import br.com.api.model.Role;
import br.com.api.model.Usuario;
import br.com.api.repository.UsuarioRepository;
import br.com.api.security.JwtTokenFilter;
import br.com.api.security.JwtTokenUtil;
import io.jsonwebtoken.Claims;

@Service
@Transactional

public class UsuarioServiceImpl {
    
    @Autowired
	private UsuarioRepository usuarioRepository;
	// @Autowired
	// private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtTokenFilter jwtTokenFilter;
		
	
	public String signin(String login, String password) throws Exception {
		try {			
			Usuario usuario = usuarioRepository.findByLogin(login).get();
			List<SimpleGrantedAuthority> authorities = new ArrayList<>();	        
			for (Role role: usuario.getRoles()) {
	            authorities.add(new SimpleGrantedAuthority(role.getName()));
	        }		        			
	        String roles = authorities.toString();			
	        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, password));
			return jwtTokenUtil.generateAccessToken(usuario, roles);
		} catch (AuthenticationException e) {
			throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	
	public Optional<Usuario> getUser(String login, String senha){	
		try {			
			Usuario user = new Usuario( login, senha);
			return Optional.of(user);
		} catch (Exception e) {			
			throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
		}			
	}
	
	
	public Usuario whoami(HttpServletRequest req) {		
		String token = jwtTokenFilter.getAccessToken(req);		
		Usuario userDetails = new Usuario();
		Claims claims = jwtTokenUtil.parseClaims(token);
		String subject = (String) claims.get(Claims.SUBJECT);
		String roles = (String) claims.get("roles");
		roles = roles.replace("[", "").replace("]", "");
		String[] roleNames = roles.split(",");		
		for (String aRoleName : roleNames) {
			userDetails.addRole(new Role(aRoleName));
		}		
		String[] jwtSubject = subject.split(",");
		userDetails.setId( Long.parseLong(jwtSubject[0]));
		userDetails.setLogin(jwtSubject[1]);
		return userDetails;	
	}
}
