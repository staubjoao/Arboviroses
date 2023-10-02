package br.com.api.controller;

import br.com.api.model.Imovel;
import br.com.api.responses.Response;
import br.com.api.services.impl.ImovelServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imovel")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ImovelController {

    @Autowired
    private ImovelServiceImpl imovelService;

    @PostMapping
    @ResponseStatus
    private ResponseEntity<Response<Imovel>> inserir(
            @Valid @RequestBody Imovel imovel, BindingResult result) {
        
        Response<Imovel> response = new Response<>();
        response.setData(imovel);
        if(result.hasErrors()) {
            for (ObjectError erros :
                    result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }

        imovelService.save(imovel);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    private List<Imovel> getAll() {
        return imovelService.getAll();
    }

    @GetMapping("/{id}")
    private Imovel getImovel(@PathVariable Integer id) {
        return imovelService.getById(id);
    }

    @PutMapping
    private Imovel getImovel(@RequestBody Imovel imovel) {
        return imovelService.put(imovel);
    }

    @DeleteMapping("/{id}")
    private void deletarImovel(@PathVariable Integer id) {
        Imovel imovel = imovelService.getById(id);
        imovelService.delete(imovel);
    }
}
