package br.com.api.controller;

import java.util.List;

import br.com.api.model.Bairro;
import br.com.api.service.impl.BairroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import br.com.api.responses.Response;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/bairro")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BairroController {

    @Autowired
    private BairroServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Bairro>> post(@Valid @RequestBody Bairro bairro, BindingResult result) {
        bairro.setNome(bairro.getNome().toUpperCase());
        return service.salvar(bairro, result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    private List<Bairro> getAll() {
        return service.getlAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Bairro>> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Bairro>> put(@Valid @RequestBody Bairro bairro, BindingResult result) {
        return service.salvar(bairro, result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Bairro>> delete(@PathVariable Integer id) {
        return service.deleteById(id);
    }
}