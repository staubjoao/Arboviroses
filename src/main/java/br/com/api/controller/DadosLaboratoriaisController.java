package br.com.api.controller;

import br.com.api.model.DadosLaboratoriais;
import br.com.api.responses.Response;
import br.com.api.service.impl.DadosLaboratoriaisServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dadosLaboratoriais")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DadosLaboratoriaisController {
    @Autowired
    private DadosLaboratoriaisServiceImpl service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<DadosLaboratoriais>> post(@Valid @RequestBody DadosLaboratoriais dadosLaboratoriais, BindingResult result) {
        return service.salvar(dadosLaboratoriais, result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    private List<DadosLaboratoriais> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<DadosLaboratoriais>> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<DadosLaboratoriais>> put(@Valid @RequestBody DadosLaboratoriais dadosLaboratoriais, BindingResult result) {
        return service.salvar(dadosLaboratoriais, result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<DadosLaboratoriais>> delete(@PathVariable Integer id) {
        return service.deleteById(id);
    }
}
