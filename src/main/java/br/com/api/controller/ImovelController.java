package br.com.api.controller;

import br.com.api.model.Imovel;
import br.com.api.model.Quarteirao;
import br.com.api.responses.Response;
import br.com.api.service.impl.ImovelServiceImpl;
import br.com.api.service.impl.QuarteiraoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imovel")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ImovelController {

    @Autowired
    private ImovelServiceImpl service;

    @Autowired
    private QuarteiraoServiceImpl serviceQuarteirao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Imovel>> post(@Valid @RequestBody Imovel imovel, BindingResult result) {
        return service.salvar(imovel, result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    private List<Imovel> getAll() {
        return service.getlAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Imovel>> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Imovel>> put(@Valid @RequestBody Imovel imovel, BindingResult result) {
        return service.salvar(imovel, result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Imovel>> delete(@PathVariable Integer id) {
        return service.deleteById(id);
    }

    @GetMapping("/quarteirao/{quarteiraoId}")
    @ResponseStatus(HttpStatus.CREATED)
    private List<Imovel> getByQuarteirao(@PathVariable Integer quarteiraoId)
    {
        Quarteirao quarteirao = serviceQuarteirao.getById(quarteiraoId).getBody().getData();
        return service.getByQuateirao(quarteirao);
    }
}
