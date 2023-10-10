package br.com.api.controller;

import java.util.List;

import jakarta.validation.Valid;
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

import br.com.api.model.Localidade;

import br.com.api.responses.Response;
import br.com.api.services.impl.LocalidadeServiceImpl;

@RestController
@RequestMapping("/api/localidade")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LocalidadeController {

    @Autowired
    private LocalidadeServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Localidade>> post(@Valid @RequestBody Localidade localidade, BindingResult result) {
        return service.salvar(localidade, result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    private List<Localidade> getAll() {
        return service.getAll();

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Localidade>> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Localidade>> put(@Valid @RequestBody Localidade localidade, BindingResult result) {
        return service.salvar(localidade, result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Localidade>> delete(@PathVariable Integer id) {
        return service.deleteById(id);
    }

}