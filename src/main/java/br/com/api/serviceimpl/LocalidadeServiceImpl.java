package br.com.api.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.api.model.LocalidadeModel;
import br.com.api.repository.LocalidadeRepository;
import br.com.api.services.LocalidadeService;

import java.util.List;

@Component
public class LocalidadeServiceImpl implements LocalidadeService{
    
    @Autowired
    private LocalidadeRepository repository;

    @Override
    public LocalidadeModel save(LocalidadeModel localidade) {
        return repository.save(localidade);
    }

    @Override
    public List<LocalidadeModel> getAll() {
        return repository.findAll();
    }

    @Override
    public LocalidadeModel getById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(LocalidadeModel localidade)
    {
        repository.delete(localidade);
    }


}
