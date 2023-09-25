package br.com.api.services;

import br.com.api.model.BairroModel;
import br.com.api.model.LocalidadeModel;
import br.com.api.repository.BairroRepository;
import br.com.api.repository.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LocalidadeService {
    @Autowired
    LocalidadeRepository localidadeRepository;

    @Transactional
    public LocalidadeModel save(LocalidadeModel localidadeModel){
        return localidadeRepository.save(localidadeModel);
    }
    public List<LocalidadeModel> getAll() {
        return localidadeRepository.findAll();
    }

    public Optional<LocalidadeModel> buscaId(int id) {
        return localidadeRepository.findById(id);
    }
    @Transactional
    public void delete(LocalidadeModel localidadeModel) {
        localidadeRepository.delete(localidadeModel );
    }
}
