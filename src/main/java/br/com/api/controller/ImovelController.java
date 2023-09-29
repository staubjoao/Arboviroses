package br.com.api.controller;

import br.com.api.dtos.ImovelDTO;
import br.com.api.model.*;
import br.com.api.repository.*;
import br.com.api.services.ImovelService;
import br.com.api.services.TipoImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imovel")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ImovelController {

    @Autowired
    private ImovelService imovelService;
    @Autowired
    private BairroRepository bairroRepository;
    @Autowired
    private LogradouroRepository logradouroRepository;
    @Autowired
    private TipoImovelService tipoImovelService;
    @Autowired
    private QuarteiraoRepository quarteiraoRepository;

    @GetMapping
    private List<Imovel> getAll() {
        return imovelService.getAll();
    }

    @PostMapping
    private Imovel inserirImovel(@RequestBody ImovelDTO imovelRequest) {
        Bairro bairro = bairroRepository.findById(imovelRequest.getBairro_id()).get();
        Logradouro logradouro = logradouroRepository.findById(imovelRequest.getLogradouro_id()).get();
        TipoImovel tipoImovel = tipoImovelRepository.findById(imovelRequest.getTipo_imovel_id()).get();
        Quarteirao quarteirao = quarteiraoRepository.findById(imovelRequest.getQuarteirao_id()).get();

        Imovel imovel = new Imovel();
        imovel.setId(imovelRequest.id);
        imovel.setNumero(imovelRequest.numero);
        imovel.setLocalidade(imovelRequest.localidade);
        imovel.setComplemento(imovelRequest.complemento);
        imovel.setBairro(bairro);
        imovel.setLogradouro(logradouro);
        imovel.setTipoImovel(tipoImovel);
        imovel.setQuarteirao(quarteirao);
        return imovelService.save(imovel);
    }

    @PutMapping
    private Imovel getImovel(@RequestBody ImovelRequest imovelRequest) {
        Bairro bairro = bairroRepository.findById(imovelRequest.bairro_id).get();
        Logradouro logradouro = logradouroRepository.findById(imovelRequest.logradouro_id).get();
        TipoImovel tipoImovel = tipoImovelRepository.findById(imovelRequest.tipo_imovel_id).get();
        Quarteirao quarteirao = quarteiraoRepository.findById(imovelRequest.quarteirao_id).get();

        Imovel imovel = new Imovel();
        imovel.setId(imovelRequest.get);
        imovel.setNumero(imovelRequest.numero);
        imovel.setLocalidade(imovelRequest.localidade);
        imovel.setComplemento(imovelRequest.complemento);
        imovel.setBairro(bairro);
        imovel.setLogradouro(logradouro);
        imovel.setTipoImovel(tipoImovel);
        imovel.setQuarteirao(quarteirao);
        return imovelRepository.save(imovel);
    }

    @DeleteMapping("/{id}")
    private void deletarImovel(@PathVariable Integer id) {
        Imovel imovel = imovelRepository.findById(id).get();
        imovelRepository.delete(imovel);
    }

    @GetMapping("/{id}")
    private Imovel getImovel(@PathVariable Integer id) {
        return imovelRepository.findById(id).get();
    }
}
