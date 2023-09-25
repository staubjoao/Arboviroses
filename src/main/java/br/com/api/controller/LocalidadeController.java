package br.com.api.controller;

import java.util.List;
import java.util.Optional;

import br.com.api.dtos.BairroDTO;
import br.com.api.dtos.LocalidadeDTO;
import br.com.api.model.BairroModel;
import br.com.api.services.LocalidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.model.LocalidadeModel;
import br.com.api.repository.LocalidadeRepository;

import javax.validation.Valid;


@RestController
@RequestMapping("api/localidade")
public class LocalidadeController {
    
    @Autowired
    private LocalidadeService localidadeService;

    @GetMapping("/todos")
    public ResponseEntity<List<LocalidadeModel>> listarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(localidadeService.getAll());
    }

    @PostMapping("/novo")
    public ResponseEntity<Object> iserirLocalidade(@RequestBody @Valid LocalidadeDTO localidadeDTO){
        var localidadeModel = new LocalidadeModel(localidadeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(localidadeService.save(localidadeModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listaUmaLocalidade(@PathVariable(value = "id") int id) {
        Optional<LocalidadeModel> localidadeModelOptional = localidadeService.buscaId(id);
        if (!localidadeModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Localidade não encontrada na base de dados");
        }
        return ResponseEntity.status(HttpStatus.OK).body(localidadeModelOptional);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deletarBairro(@PathVariable(value = "id") int id){
        Optional<LocalidadeModel> localidadeModelOptional = localidadeService.buscaId(id);
        if (!localidadeModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Localidade não encontrada na base de dados");
        }
        localidadeService.delete(localidadeModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Localidade deletada com sucesso!!");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Object> editarLocalidade(@PathVariable(value = "id") int id,
                                               @RequestBody @Valid LocalidadeDTO localidadeDTO){
        Optional<LocalidadeModel> localidadeModelOptional = localidadeService.buscaId(id);
        if (!localidadeModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Localidade não encontrada na base de dados");
        }
        var localidadeModel = new LocalidadeModel();
        BeanUtils.copyProperties(localidadeDTO, localidadeModel);
        localidadeModel.setId(localidadeModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(localidadeService.save(localidadeModel));
    }
}
