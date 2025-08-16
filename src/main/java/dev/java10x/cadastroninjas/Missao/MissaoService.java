package dev.java10x.cadastroninjas.Missao;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    private MissoesRepository missoesRepository;
    private MissaoMapper missaoMapper;

    public MissaoService(MissoesRepository missoesRepository, MissaoMapper missaoMapper) {
        this.missoesRepository = missoesRepository;
        this.missaoMapper = missaoMapper;
    }

    // Criar missao
    public MissaoDTO criarMissao(MissaoDTO missaoDTO) {
        MissaoModel missao = missaoMapper.map(missaoDTO);
        missao = missoesRepository.save(missao);
        return missaoMapper.map(missao);
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

