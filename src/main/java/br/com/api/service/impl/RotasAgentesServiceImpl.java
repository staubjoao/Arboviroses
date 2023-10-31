package br.com.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.api.controller.UsuarioController;
import br.com.api.model.Quarteirao;
import br.com.api.model.Usuario;
import br.com.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import br.com.api.model.RotasAgentes;
import br.com.api.repository.RotasAgentesRepository;
import br.com.api.responses.Response;
import br.com.api.service.RotasAgentesService;
import jakarta.validation.Valid;
import org.springframework.web.server.ResponseStatusException;

@Component
public class RotasAgentesServiceImpl implements RotasAgentesService {
	
	@Autowired
    RotasAgentesRepository repository;
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public ResponseEntity<Response<RotasAgentes>> salvar(@Valid RotasAgentes rotasAgentes, BindingResult result) {
        Response<RotasAgentes> response = new Response<RotasAgentes>();
        response.setData(rotasAgentes);
        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }
        repository.save(rotasAgentes);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<RotasAgentes> getAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Response<RotasAgentes>> getById(Integer id) {
        Response<RotasAgentes> response = new Response<RotasAgentes>();
        RotasAgentes obj = null;
        try {
            obj = repository.findById(id).get();
        } catch (NullPointerException ex) {
            response.getErrors().add("RotasAgentes inválido");
        } catch (Exception ex) {
            response.getErrors().add("RotasAgentes inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<RotasAgentes>> deleteById(Integer id) {
        Response<RotasAgentes> response = new Response<RotasAgentes>();
        RotasAgentes obj = null;
        try {
            obj = repository.findById(id).get();
            repository.delete(obj);
        } catch (NullPointerException ex) {
            response.getErrors().add("RotasAgentes inválido");
        } catch (Exception ex) {
            response.getErrors().add("RotasAgentes inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }
    @Override
    public List<Quarteirao> getQuarteiroesByAgenteId(Long id) {
        Usuario obj = usuarioRepository.findById(id).orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado"));;

        List<RotasAgentes> rotasAgentes = repository.findByUsuario(obj);

        List<Quarteirao> quarteiroes = rotasAgentes.stream()
                .map(RotasAgentes::getQuarteirao)
                .collect(Collectors.toList());
        return quarteiroes;
    }


    @Override
    public ResponseEntity<Response<List<RotasAgentes>>> cadastrarRotaParaAgente(Long idUsuario, List<Quarteirao> quarteiroes) {
        Response<List<RotasAgentes>> response = new Response<>();

        Usuario agenteId = usuarioRepository.findById(idUsuario).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agente não encontrado"));

        Usuario agente = new Usuario();
        agente.setId(agenteId.getId());
        agente.setLogin(agenteId.getLogin());
        agente.setNome(agenteId.getNome());
        agente.setProfile(agenteId.getProfile());
        agente.setSenha(agenteId.getSenha());

        List<RotasAgentes> rotas = new ArrayList<>();
        for (Quarteirao quarteirao : quarteiroes) {
            RotasAgentes rota = new RotasAgentes();
            rota.setUsuario(agente);
            rota.setQuarteirao(quarteirao);
            rotas.add(rota);
        }

        List<RotasAgentes> savedRotas = repository.saveAll(rotas);
        response.setData(savedRotas);
        System.out.println("Teste");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
