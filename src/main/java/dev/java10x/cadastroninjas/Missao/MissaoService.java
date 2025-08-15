package dev.java10x.cadastroninjas.Missao;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    private MissoesRepository missoesRepository;

    public MissaoService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Cria a missao
    public MissaoModel criarMissao(MissaoModel missao) {
        return missoesRepository.save(missao);
    }

    // Listar missoes
    public List<MissaoModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    // Lista missao por id
    public MissaoModel listarMissaoPorId(Long id) {
        Optional<MissaoModel> missaoModel = missoesRepository.findById(id);
        return missaoModel.orElse(null);
    }

    // Deleta missao por ID
    public void deletarMissaoPorId(Long id) {
        missoesRepository.deleteById(id);
    }
}

