package dev.java10x.cadastroninjas.Missao;

import dev.java10x.cadastroninjas.Ninjas.NinjaDTO;
import dev.java10x.cadastroninjas.Ninjas.NinjaMapper;
import dev.java10x.cadastroninjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MissaoMapper {

    private NinjaMapper ninjaMapper;

    public MissaoMapper(NinjaMapper ninjaMapper) {
        this.ninjaMapper = ninjaMapper;
    }

    public MissaoModel map(MissaoDTO missaoDTO) {
        if (missaoDTO == null) {
            return null;
        }
        MissaoModel missaoModel = new MissaoModel();
        missaoModel.setId(missaoDTO.getId());
        missaoModel.setNome(missaoDTO.getNome());
        missaoModel.setDificuldade(missaoDTO.getDificuldade());
        missaoModel.setRecompensa(missaoDTO.getRecompensa());

        return missaoModel;
    }

    public MissaoDTO map(MissaoModel missaoModel) {
        if (missaoModel == null) {
            return null;
        }
        MissaoDTO missaoDTO = new MissaoDTO();
        missaoDTO.setId(missaoModel.getId());
        missaoDTO.setNome(missaoModel.getNome());
        missaoDTO.setDificuldade(missaoModel.getDificuldade());
        missaoDTO.setRecompensa(missaoModel.getRecompensa());

        return missaoDTO;
    }
}
