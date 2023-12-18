package br.com.api.controller;

import br.com.api.model.*;
import br.com.api.responses.Response;
import br.com.api.service.impl.LarvicidaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/larvicida")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LarvicidaController {

    @Autowired
    private LarvicidaServiceImpl service;

    @PostMapping
    public ResponseEntity<Response<Larvicida>> post(@Valid @RequestBody Larvicida larvicida, BindingResult result) {
        return service.salvar(larvicida, result);
    }

    @GetMapping
    public List<Larvicida> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Larvicida>> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping
    public ResponseEntity<Response<Larvicida>> put(@Valid @RequestBody Larvicida larvicida, BindingResult result) {
        return service.salvar(larvicida, result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Larvicida>> delete(@PathVariable Long id) {
        return service.deleteById(id);
    }
}
