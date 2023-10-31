package br.com.api.controller;

import java.util.List;

import br.com.api.model.Quarteirao;
import br.com.api.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.model.RotasAgentes;
import br.com.api.responses.Response;
import br.com.api.service.impl.RotasAgentesServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/rotas-agentes")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RotasAgentesController {
    @Autowired
    private RotasAgentesServiceImpl service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<RotasAgentes>> post(@Valid @RequestBody RotasAgentes rotasAgentes, BindingResult result) {
        return service.salvar(rotasAgentes, result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    private List<RotasAgentes> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<RotasAgentes>> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<RotasAgentes>> put(@Valid @RequestBody RotasAgentes rotasAgentes, BindingResult result) {
        return service.salvar(rotasAgentes, result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<RotasAgentes>> delete(@PathVariable Integer id) {
        return service.deleteById(id);
    }


    @GetMapping("/agente/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Quarteirao> getQuarteiroesByAgente(@PathVariable Long id) {
         return service.getQuarteiroesByAgenteId(id);
    }
}
