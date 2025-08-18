package dev.java10x.cadastroninjas.Missao;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public List<MissaoDTO> listarMissoes() {
        List<MissaoModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missaoMapper::map)
                .toList();
    }

    // Lista missao por id
    public MissaoDTO listarMissaoPorId(Long id) {
        Optional<MissaoModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.map(missaoMapper::map).orElse(null);
    }

    // Deleta missao por ID
    public void deletarMissaoPorId(Long id) {
        missoesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Missao nao encontrada"));
        missoesRepository.deleteById(id);
    }

    public MissaoDTO atualizarMissao(Long id, MissaoDTO missaoDTO) {
        missoesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        MissaoModel missaoAtualizada = missaoMapper.map(missaoDTO);
        missaoAtualizada.setId(id);
        MissaoModel missaoSalva = missoesRepository.save(missaoAtualizada);
        return missaoMapper.map(missaoSalva);
    }

}

