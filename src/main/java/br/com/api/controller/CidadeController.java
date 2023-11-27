package br.com.api.controller;

import br.com.api.model.Cidade;
import br.com.api.responses.Response;
import br.com.api.service.impl.BloqueioServiceImpl;
import br.com.api.service.impl.CidadeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cidade")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CidadeController {

    @Autowired
    private CidadeServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Cidade>> post(@Valid @RequestBody Cidade cidade, BindingResult result) {
        cidade.setCidade(cidade.getCidade().toUpperCase());
        return service.salvar(cidade, result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<Cidade> getAll() {
        return service.getlAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<Response<Cidade>> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Cidade>> put(@Valid @RequestBody Cidade cidade, BindingResult result) {
        return service.salvar(cidade, result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response<Cidade>> delete(@PathVariable Integer id) {
        return service.deleteById(id);
    }
}
