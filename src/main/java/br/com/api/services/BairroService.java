package br.com.api.services;

import br.com.api.model.Bairro;
import br.com.api.repository.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BairroService {
    @Autowired
    BairroRepository bairroRepository;

    @Transactional
    public Bairro save(Bairro bairro){
        return  bairroRepository.save(bairro);
    }
    public List<Bairro> getAll() {
        return bairroRepository.findAll();
    }

    public Optional<Bairro> buscaId(int id) {
        return bairroRepository.findById(id);
    }
    @Transactional
    public void delete(Bairro bairro) {
        bairroRepository.delete(bairro);
    }
}