package br.com.api.controller;

import br.com.api.model.Municipio;
import br.com.api.responses.Response;
import br.com.api.service.impl.MunicipioServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/municipio")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MunicipioController {

    @Autowired
    private MunicipioServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Municipio>> post(@Valid @RequestBody Municipio municipio, BindingResult result) {
        municipio.setMunicipio(municipio.getMunicipio().toUpperCase());
        return service.salvar(municipio, result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<Municipio> getAll() {
        return service.getlAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<Response<Municipio>> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Municipio>> put(@Valid @RequestBody Municipio municipio, BindingResult result) {
        return service.salvar(municipio, result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response<Municipio>> delete(@PathVariable Integer id) {
        return service.deleteById(id);
    }
}
