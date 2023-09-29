package br.com.api.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.api.model.BairroModel;
import br.com.api.repository.BairroRepository;
import br.com.api.services.BairroService;

import java.util.List;

@Component
public class BairroServiceImpl implements BairroService {

    @Autowired
    private BairroRepository repository;

    @Override
    public BairroModel save(BairroModel bairro) {
        return repository.save(bairro);
    }

    @Override
    public List<BairroModel> getAll() {
        return repository.findAll();
    }

    @Override
    public BairroModel getById(Integer id)
    {
        return repository.findById(id).get();
    }

    @Override
    public void delete(BairroModel bairro) {
        repository.delete(bairro);
    }

}
