package br.com.api.controller;

import br.com.api.model.Geolocalizacao;
import br.com.api.responses.Response;
import br.com.api.service.impl.GeolocalizacaoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/geolocalizacao")
@CrossOrigin(origins = "*", maxAge = 3600)
public class GeolocalizacaoController {

    @Autowired
    private GeolocalizacaoServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Geolocalizacao>> post(@Valid @RequestBody Geolocalizacao geolocalizacao, BindingResult result) {
        return service.salvar(geolocalizacao, result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    private List<Geolocalizacao> getAll() {
        return service.getlAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Geolocalizacao>> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Geolocalizacao>> put(@Valid @RequestBody Geolocalizacao geolocalizacao, BindingResult result) {
        return service.salvar(geolocalizacao, result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Geolocalizacao>> delete(@PathVariable Integer id) {
        return service.deleteById(id);
    }

}
