package br.com.api.controller;

import br.com.api.model.Bairro;
import br.com.api.model.Imovel;
import br.com.api.model.TipoImovel;
import br.com.api.model.Logradouro;
import br.com.api.repository.ImovelRepository;
import br.com.api.repository.BairroRepository;
import br.com.api.repository.LogradouroRepository;
import br.com.api.repository.TipoImovelRepository;
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

    @GetMapping
    private List<Imovel> getAll() {
        return imovelRepository.findAll();
    }

    @PostMapping
    private Imovel inserirImovel(@RequestBody Imovel imovel) {
        Bairro bairro = bairroRepository.findById(imovel.getBairro().getId()).orElse(null);
        Logradouro logradouro = logradouroRepository.findById(imovel.getLogradouro().getId()).orElse(null);
        TipoImovel tipoImovel = tipoImovelRepository.findById(imovel.getTipoImovel().getId()).orElse(null);

        imovel.setBairro(bairro);
        imovel.setLogradouro(logradouro);
        imovel.setTipoImovel(tipoImovel);

        return imovelRepository.save(imovel);
    }

    @GetMapping("/{id}")
    private Imovel getImovel(@PathVariable Integer id) {
        return imovelRepository.findById(id).get();
    }

    @PutMapping
    private Imovel getImovel(@RequestBody Imovel imovel) {
        return imovelRepository.save(imovel);
    }

    @DeleteMapping("/{id}")
    private void deletarImovel(@PathVariable Integer id) {
        Imovel imovel = imovelRepository.findById(id).get();
        imovelRepository.delete(imovel);
    }
}
