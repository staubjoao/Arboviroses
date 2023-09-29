package br.com.api.controller;

import br.com.api.model.TipoImovel;
import br.com.api.responses.Response;
import br.com.api.services.impl.TipoImovelServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo_imovel")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TipoImovelController {

    @Autowired
    private TipoImovelServiceImpl serviceTipoImovel;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<TipoImovel>> inserir(
            @Valid @RequestBody TipoImovel tipoImovel, BindingResult result) {

        Response<TipoImovel> response = new Response<TipoImovel>();
        response.setData(tipoImovel);
        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }
        serviceTipoImovel.save(tipoImovel);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    private List<TipoImovel> getAll() {
        return serviceTipoImovel.getAll();
    }

    @GetMapping("/{id}")
    private TipoImovel getTipoImovel(@PathVariable Integer id) {
        return serviceTipoImovel.getById(id);
    }

    @PutMapping
    private TipoImovel alterarTipoImovel(@RequestBody TipoImovel tipoImovel) {
        return serviceTipoImovel.put(tipoImovel);
    }

    @DeleteMapping("/{id}")
    private void deletarTipoImovel(@PathVariable Integer id) {
        TipoImovel tipoImovel = serviceTipoImovel.getById(id);
        serviceTipoImovel.delete(tipoImovel);
    }

}
