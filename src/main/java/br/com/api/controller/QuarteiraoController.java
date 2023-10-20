package br.com.api.controller;

import br.com.api.model.Quarteirao;
import br.com.api.responses.Response;
import br.com.api.service.impl.QuarteiraoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/quarteirao")
@CrossOrigin(origins = "*", maxAge = 3600)
public class QuarteiraoController {
    @Autowired
    private QuarteiraoServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Quarteirao>> post(@Valid @RequestBody Quarteirao quarteirao, BindingResult result) {
        return service.salvar(quarteirao, result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    private List<Quarteirao> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Quarteirao>> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Quarteirao>> put(@Valid @RequestBody Quarteirao quarteirao, BindingResult result) {
        return service.salvar(quarteirao, result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Quarteirao>> delete(@PathVariable Integer id) {
        return service.deleteById(id);
    }
}
