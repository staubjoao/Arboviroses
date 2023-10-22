package br.com.api.controller;

import java.util.List;
import br.com.api.model.AmostraLaboratorial;
import br.com.api.service.impl.AmostraLaboratorialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import br.com.api.responses.Response;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/amostra_laboratorial")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AmostraLaboratorialController {
    
    @Autowired
    private AmostraLaboratorialServiceImpl service;

    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<AmostraLaboratorial>> post(@Valid @RequestBody AmostraLaboratorial amostraLaboratorial, BindingResult result) {
        return service.salvar(amostraLaboratorial, result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    private List<AmostraLaboratorial> getAll() {
        return service.getlAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<AmostraLaboratorial>> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<AmostraLaboratorial>> put(@Valid @RequestBody AmostraLaboratorial amostraLaboratorial, BindingResult result) {
        return service.salvar(amostraLaboratorial, result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<AmostraLaboratorial>> delete(@PathVariable Integer id) {
        return service.deleteById(id);
    }
}
