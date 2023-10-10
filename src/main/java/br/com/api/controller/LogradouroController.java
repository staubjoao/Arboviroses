package br.com.api.controller;

import br.com.api.model.Bairro;
import br.com.api.model.Logradouro;
import br.com.api.responses.Response;
import br.com.api.services.impl.LogradouroServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/logradouro")
public class LogradouroController {

    @Autowired
    private LogradouroServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Logradouro>> post(@Valid @RequestBody Logradouro logradouro, BindingResult result) {
        return service.salvar(logradouro, result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    private List<Logradouro> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Logradouro>> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Logradouro>> put(@Valid @RequestBody Logradouro logradouro, BindingResult result) {
        return service.salvar(logradouro, result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Logradouro>> delete(@PathVariable Integer id) {
        return service.deleteById(id);
    }
}
