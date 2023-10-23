package br.com.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.api.dtos.AuthRequest;
import br.com.api.dtos.AuthResponse;
import br.com.api.model.Role;
import br.com.api.model.Usuario;
import br.com.api.security.JwtTokenUtil;
import br.com.api.service.impl.UsuarioServiceImpl;
import org.modelmapper.ModelMapper;

@RestController
@RequestMapping("/auth")
public class AuthApi {

	@Autowired AuthenticationManager authManager;
	@Autowired JwtTokenUtil jwtUtil;
	@Autowired UsuarioServiceImpl userService;
	
	@Bean
	ModelMapper modelMapper() {
		ModelMapper  modelMapper = new ModelMapper();
		return  modelMapper;		
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
		try {	
			
			Authentication authentication = authManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							request.getLogin(), request.getPassword())
			);
			Usuario user = (Usuario) authentication.getPrincipal();			
			List<SimpleGrantedAuthority> authorities = new ArrayList<>();
	        
			for (Role role: user.getRoles()) {
	            authorities.add(new SimpleGrantedAuthority(role.getName()));
	        }
				
			String roles = authorities.toString();
			
			String accessToken = jwtUtil.generateAccessToken(user, roles);
			
			AuthResponse response = new AuthResponse(user.getLogin(), accessToken, roles);			
			return ResponseEntity.ok().body(response);
			
		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@GetMapping(value = "/me")
	public Usuario whoami(HttpServletRequest req) {
	    return modelMapper().map(userService.whoami(req), Usuario.class);
	}
}


















