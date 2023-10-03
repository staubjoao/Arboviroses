package br.com.api.services.impl;

import br.com.api.model.Imovel;
import br.com.api.repository.ImovelRepository;
import br.com.api.services.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImovelServiceImpl implements ImovelService {
    @Autowired
    private ImovelRepository imovelRepository;
    @Override
    public Imovel save(Imovel imovel) {
        return imovelRepository.save(imovel);
    }

    @Override
    public List<Imovel> getAll() {
        return imovelRepository.findAll();
    }

    @Override
    public Imovel getById(Integer id) {
        return imovelRepository.findById(id).get();
    }

    @Override
    public void delete(Imovel imovel) {
        imovelRepository.delete(imovel);
    }

    @Override
    public Imovel put(Imovel imovel) {
        return imovelRepository.save(imovel);
    }
}
