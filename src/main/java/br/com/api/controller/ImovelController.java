package br.com.api.controller;

import br.com.api.model.*;
import br.com.api.pojos.ImovelRequest;
import br.com.api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imovel")
public class ImovelController {

    @Autowired
    private ImovelRepository imovelRepository;
    @Autowired
    private BairroRepository bairroRepository;
    @Autowired
    private LogradouroRepository logradouroRepository;
    @Autowired
    private TipoImovelRepository tipoImovelRepository;
    @Autowired
    private QuarteiraoRepository quarteiraoRepository;

    @GetMapping
    private List<Imovel> getAll() {
        return imovelRepository.findAll();
    }

    @PostMapping
    private Imovel inserirImovel(@RequestBody ImovelRequest imovelRequest) {
        Bairro bairro = bairroRepository.findById(imovelRequest.bairro_id).get();
        Logradouro logradouro = logradouroRepository.findById(imovelRequest.logradouro_id).get();
        TipoImovel tipoImovelModel = tipoImovelRepository.findById(imovelRequest.tipo_imovel_id).get();
        Quarteirao quarteiraoModel = quarteiraoRepository.findById(imovelRequest.quarteirao_id).get();

        Imovel imovelModel = new Imovel();
        imovelModel.setId(imovelRequest.id);
        imovelModel.setNumero(imovelRequest.numero);
        imovelModel.setLocalidade(imovelRequest.localidade);
        imovelModel.setComplemento(imovelRequest.complemento);
        imovelModel.setBairroModel(bairro);
        imovelModel.setLogradouroModel(logradouro);
        imovelModel.setTipoImovelModel(tipoImovelModel);
        imovelModel.setQuarteiraoModel(quarteiraoModel);
        return imovelRepository.save(imovelModel);
    }

    @PutMapping
    private Imovel getImovel(@RequestBody ImovelRequest imovelRequest) {
        Bairro bairro = bairroRepository.findById(imovelRequest.bairro_id).get();
        Logradouro logradouro = logradouroRepository.findById(imovelRequest.logradouro_id).get();
        TipoImovel tipoImovelModel = tipoImovelRepository.findById(imovelRequest.tipo_imovel_id).get();
        Quarteirao quarteiraoModel = quarteiraoRepository.findById(imovelRequest.quarteirao_id).get();

        Imovel imovelModel = new Imovel();
        imovelModel.setId(imovelRequest.id);
        imovelModel.setNumero(imovelRequest.numero);
        imovelModel.setLocalidade(imovelRequest.localidade);
        imovelModel.setComplemento(imovelRequest.complemento);
        imovelModel.setBairroModel(bairro);
        imovelModel.setLogradouroModel(logradouro);
        imovelModel.setTipoImovelModel(tipoImovelModel);
        imovelModel.setQuarteiraoModel(quarteiraoModel);
        return imovelRepository.save(imovelModel);
    }

    @DeleteMapping("/{id}")
    private void deletarImovel(@PathVariable Integer id) {
        Imovel imovelModel = imovelRepository.findById(id).get();
        imovelRepository.delete(imovelModel);
    }

    @GetMapping("/{id}")
    private Imovel getImovel(@PathVariable Integer id) {
        return imovelRepository.findById(id).get();
    }
}
