package br.com.api.controller;

import br.com.api.model.Bloqueio;
import br.com.api.responses.Response;
import br.com.api.service.impl.BloqueioServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bloqueio")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BloqueioController {

    @Autowired
    private BloqueioServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Bloqueio>> post(@Valid @RequestBody Bloqueio bloqueio, BindingResult result) {
        return service.salvar(bloqueio, result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<Bloqueio> getAll() {
        return service.getlAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<Response<Bloqueio>> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Bloqueio>> put(@Valid @RequestBody Bloqueio bloqueio, BindingResult result) {
        return service.salvar(bloqueio, result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response<Bloqueio>> delete(@PathVariable Integer id) {
        return service.deleteById(id);
    }

}
