package br.com.api.services;

import br.com.api.model.Quarteirao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface QuarteiraoService {
    public Quarteirao save(Quarteirao quarteirao);
    public List<Quarteirao> getAll();
    public Optional<Quarteirao> buscaId(int id);
    public void delete(Quarteirao quarteirao);
}
