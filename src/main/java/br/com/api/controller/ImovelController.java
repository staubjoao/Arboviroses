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
    private List<ImovelModel> getAll() {
        return imovelRepository.findAll();
    }

    @PostMapping
    private ImovelModel inserirImovel(@RequestBody ImovelRequest imovelRequest) {
        BairroModel bairro = bairroRepository.findById(imovelRequest.bairro_id).get();
        Logradouro logradouro = logradouroRepository.findById(imovelRequest.logradouro_id).get();
        TipoImovelModel tipoImovelModel = tipoImovelRepository.findById(imovelRequest.tipo_imovel_id).get();
        Quarteirao quarteirao = quarteiraoRepository.findById(imovelRequest.quarteirao_id).get();

        ImovelModel imovelModel = new ImovelModel();
        imovelModel.setId(imovelRequest.id);
        imovelModel.setNumero(imovelRequest.numero);
        imovelModel.setLocalidade(imovelRequest.localidade);
        imovelModel.setComplemento(imovelRequest.complemento);
        //imovelModel.setBairroModel(bairro);
        imovelModel.setLogradouro(logradouro);
        imovelModel.setTipoImovelModel(tipoImovelModel);
        imovelModel.setQuarteirao(quarteirao);
        return imovelRepository.save(imovelModel);
    }

    @PutMapping
    private ImovelModel getImovel(@RequestBody ImovelRequest imovelRequest) {
        BairroModel bairro = bairroRepository.findById(imovelRequest.bairro_id).get();
        Logradouro logradouro = logradouroRepository.findById(imovelRequest.logradouro_id).get();
        TipoImovelModel tipoImovelModel = tipoImovelRepository.findById(imovelRequest.tipo_imovel_id).get();
        Quarteirao quarteirao = quarteiraoRepository.findById(imovelRequest.quarteirao_id).get();

        ImovelModel imovelModel = new ImovelModel();
        imovelModel.setId(imovelRequest.id);
        imovelModel.setNumero(imovelRequest.numero);
        imovelModel.setLocalidade(imovelRequest.localidade);
        imovelModel.setComplemento(imovelRequest.complemento);
        //imovelModel.setBairroModel(bairro);
        imovelModel.setLogradouro(logradouro);
        imovelModel.setTipoImovelModel(tipoImovelModel);
        imovelModel.setQuarteirao(quarteirao);
        return imovelRepository.save(imovelModel);
    }

    @DeleteMapping("/{id}")
    private void deletarImovel(@PathVariable Integer id) {
        ImovelModel imovelModel = imovelRepository.findById(id).get();
        imovelRepository.delete(imovelModel);
    }

    @GetMapping("/{id}")
    private ImovelModel getImovel(@PathVariable Integer id) {
        return imovelRepository.findById(id).get();
    }
}
