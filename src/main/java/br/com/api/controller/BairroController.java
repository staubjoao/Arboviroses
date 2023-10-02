package br.com.api.controller;


import br.com.api.dtos.BairroDTO;
import br.com.api.model.Bairro;
import br.com.api.services.BairroService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bairro")
public class BairroController {

    @Autowired
    private BairroService bairroService;

    @GetMapping("/todos")
    public ResponseEntity<List<Bairro>> listarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(bairroService.getAll());
    }

    @PostMapping("/novo")
    public ResponseEntity<Object> iserirBairro(@RequestBody @Valid BairroDTO bairroDTO){
        var bairroModel = new Bairro(bairroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(bairroService.save(bairroModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listaUmUsuario(@PathVariable(value = "id") int id) {
        Optional<Bairro> bairroModelOptional = bairroService.buscaId(id);
        if(!bairroModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bairro não encontrado na base de dados");
        }
        return ResponseEntity.status(HttpStatus.OK).body(bairroModelOptional);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deletarBairro(@PathVariable(value = "id") int id){
        Optional<Bairro> bairroModelOptional = bairroService.buscaId(id);
        if (!bairroModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bairro não encontrado na base de dados");
        }
        bairroService.delete(bairroModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Bairro deletado com sucesso!!");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Object> editarBairro(@PathVariable(value = "id") int id,
                                               @RequestBody @Valid BairroDTO bairroDTO){
        Optional<Bairro> bairroModelOptional = bairroService.buscaId(id);
        if (!bairroModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bairro não encontrado na base de dados");
        }
        var bairroModel = new Bairro();
        BeanUtils.copyProperties(bairroDTO, bairroModel);
        bairroModel.setId(bairroModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(bairroService.save(bairroModel));
    }

}
