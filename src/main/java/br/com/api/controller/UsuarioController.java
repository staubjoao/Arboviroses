package br.com.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.api.dtos.AuthRequest;
import br.com.api.dtos.AuthResponse;
import br.com.api.model.Role;
import br.com.api.model.Usuario;
import br.com.api.repository.RoleRepository;
import br.com.api.repository.UsuarioRepository;
import br.com.api.responses.Response;
import br.com.api.security.JwtTokenUtil;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired 
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired 
	private AuthenticationManager authManager;
	
	@Autowired 
	private JwtTokenUtil jwtUtil;
		
	@PostMapping("/{roleName}")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Usuario salvarComRole(@RequestBody @Valid Usuario usuario, @PathVariable String roleName) {
		Role role = roleRepository.findByName(roleName).get();		
		usuario.addRole(role);
		usuario.setProfile(roleName);
		usuario.setSenha(passwordEncoder.encode(usuario.getPassword()));		
		return repository.save(usuario);		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseEntity<Response<Usuario>> salvar(@RequestBody @Valid Usuario usuario, @PathVariable String roleName, BindingResult result) {
		Role role = roleRepository.findByName(roleName).get();		
		usuario.addRole(role);
		usuario.setProfile(roleName);
		usuario.setSenha(passwordEncoder.encode(usuario.getPassword()));
		
		Response<Usuario> response = new Response<Usuario>();
		response.setData(usuario);
		if(result.hasErrors()) {			
			for (ObjectError erros: result.getAllErrors()) {
				response.getErrors().add(erros.getDefaultMessage());
			}
			return ResponseEntity.badRequest().body(response);
		}
		repository.save(usuario);		
		return ResponseEntity.ok(response);				
	}
	
	@PutMapping("/{roleName}")	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ResponseBody
	public ResponseEntity<Response<Usuario>> alterar(
			@RequestBody @Valid Usuario usuario, 
			@PathVariable String roleName,
			BindingResult result) {
			
		Role role = roleRepository.findByName(roleName).get();		
		usuario.addRole(role);		
		Response<Usuario> response = new Response<Usuario>();		
		response.setData(usuario);
		if(result.hasErrors()) {			
			for (ObjectError erros: result.getAllErrors()) {
				response.getErrors().add(erros.getDefaultMessage());
			}
			return ResponseEntity.badRequest().body(response);
		}								
		usuario = repository.save(usuario);
		return ResponseEntity.ok(response);				
	}
	
	@GetMapping
	//@RolesAllowed({"ROLE_ADMIN", "ROLE_GERENTE"})
	//@RolesAllowed("[ADMIN]")
    public List<Usuario> getAll() {	
		List<Usuario> lista = repository.findAll();		
		for (Usuario usuario : lista) {
			System.out.println(usuario.getLogin());
		}		
        return lista;
    }
		
	@GetMapping("/{id}")
    public Usuario  getById(@PathVariable Long id) {
		return repository.findById(id).orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado"));
    }
		
	@DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {				
		repository
		.findById(id)
		.map( categoria -> {
			repository.delete(categoria);
			return Void.TYPE;
		})
		.orElseThrow(  ()-> new ResponseStatusException(HttpStatus.NOT_FOUND) );		
    }
			
	@PostMapping("/alterar-senha/{novaSenha}")
	public ResponseEntity<?> alterarSenha(@RequestBody @Valid AuthRequest request, @PathVariable String novaSenha) {		
		try {
			Authentication authentication = authManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							request.getLogin(), request.getPassword())
			);
			Usuario usuario = (Usuario) authentication.getPrincipal();
			usuario.setSenha(passwordEncoder.encode(novaSenha));
			usuario = repository.save(usuario);	
			return ResponseEntity.ok().body(usuario);
		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

}
