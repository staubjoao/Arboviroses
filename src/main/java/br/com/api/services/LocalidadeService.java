package br.com.api.services;

import br.com.api.model.Localidade;
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
    public Localidade save(Localidade localidade){
        return localidadeRepository.save(localidade);
    }
    public List<Localidade> getAll() {
        return localidadeRepository.findAll();
    }

    public Optional<Localidade> buscaId(int id) {
        return localidadeRepository.findById(id);
    }
    @Transactional
    public void delete(Localidade localidade) {
        localidadeRepository.delete(localidade);
    }
}
