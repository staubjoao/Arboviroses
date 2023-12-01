package br.com.api.controller;

import br.com.api.dtos.ImovelDTO;
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
@RequestMapping("/api/imovel")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ImovelController {

    @Autowired
    private ImovelServiceImpl service;

    @Autowired
    private BairroServiceImpl serviceBairro;

    @Autowired
    private LogradouroServiceImpl serviceLogradouro;

    @Autowired
    private QuarteiraoServiceImpl serviceQuarteirao;

    @Autowired
    private RegistroAntivetorialServiceImpl serviceRegistro;

    @Autowired
    private TipoImovelServiceImpl serviceTipoImovel;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Imovel>> post(@Valid @RequestBody ImovelDTO imovelDTO, BindingResult result) {
        Imovel imovel = new Imovel();

        imovel.setId(imovelDTO.getId());
        imovel.setLocalidade(imovelDTO.getLocalidade());
        imovel.setNumero(imovelDTO.getNumero());
        imovel.setComplemento(imovelDTO.getComplemento());

        ResponseEntity<Response<Bairro>> bairro = serviceBairro.getById((imovelDTO).getBairroId());
        ResponseEntity<Response<Logradouro>> logradouro = serviceLogradouro.getById(imovelDTO.getLogradouroId());
        ResponseEntity<Response<Quarteirao>> quarteirao = serviceQuarteirao.getById(imovelDTO.getQuarteiraoId());
//        ResponseEntity<Response<RegistroAntivetorial>> registro = serviceRegistro.getById(imovelDTO.getRegistroAntivetorialId());
        ResponseEntity<Response<TipoImovel>> tipoImovel = serviceTipoImovel.getById(imovelDTO.getTipoImovelId());

        imovel.setBairro(bairro.getBody().getData());
        imovel.setLogradouro(logradouro.getBody().getData());
        imovel.setQuarteirao(quarteirao.getBody().getData());
//        imovel.setRegistroAntivetorial(registro.getBody().getData());
        imovel.setTipoImovel(tipoImovel.getBody().getData());

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
    @ResponseStatus(HttpStatus.OK)
    private List<Imovel> getByQuarteirao(@PathVariable Integer quarteiraoId)
    {
        Quarteirao quarteirao = serviceQuarteirao.getById(quarteiraoId).getBody().getData();
        return service.getByQuateirao(quarteirao);
        
    }
}
