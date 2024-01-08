package br.com.api.controller;

import br.com.api.model.*;
import br.com.api.responses.Response;
import br.com.api.service.impl.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imovel_sequencia")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ImovelSequenciaController {

    @Autowired
    private ImovelSequenciaServiceImpl service;

    @Autowired
    private ImovelServiceImpl serviceImovel;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<ImovelSequencia>> post(@Valid @RequestBody br.com.api.model.ImovelSequencia imovelSequencia, BindingResult result) {
        return service.salvar(imovelSequencia, result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    private List<ImovelSequencia> getAll() {
        return service.getlAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<ImovelSequencia>> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<ImovelSequencia>> put(@Valid @RequestBody ImovelSequencia imovelSequencia, BindingResult result) {
        return service.salvar(imovelSequencia, result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<ImovelSequencia>> delete(@PathVariable Integer id) {
        return service.deleteById(id);
    }

    @GetMapping("/quarteirao/{imovelId}")
    @ResponseStatus(HttpStatus.OK)
    private List<ImovelSequencia> getByQuarteirao(@PathVariable Integer imovelId)
    {
        Imovel imovel = serviceImovel.getById(imovelId).getBody().getData();
        return service.getByImovel(imovel);

    }
}
