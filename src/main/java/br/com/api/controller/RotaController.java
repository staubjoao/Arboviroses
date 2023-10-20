package br.com.api.controller;

import br.com.api.model.Rota;
import br.com.api.responses.Response;
import br.com.api.service.impl.RotaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rota")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RotaController {

    @Autowired
    private RotaServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Rota>> post(@Valid @RequestBody Rota rota, BindingResult result) {
        return service.salvar(rota, result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<Rota> getAll() {
        return service.getlAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<Response<Rota>> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Rota>> put(@Valid @RequestBody Rota rota, BindingResult result) {
        return service.salvar(rota, result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response<Rota>> delete(@PathVariable Integer id) {
        return service.deleteById(id);
    }

}
