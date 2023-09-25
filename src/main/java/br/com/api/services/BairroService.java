package br.com.api.services;

import br.com.api.model.BairroModel;
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
    public BairroModel save(BairroModel bairroModel){
        return  bairroRepository.save(bairroModel);
    }
    public List<BairroModel> getAll() {
        return bairroRepository.findAll();
    }

    public Optional<BairroModel> buscaId(int id) {
        return bairroRepository.findById(id);
    }
    @Transactional
    public void delete(BairroModel bairroModel) {
        bairroRepository.delete(bairroModel);
    }
}