package dev.java10x.cadastroninjas.Missao;

import org.springframework.stereotype.Component;

@Component
public class MissaoMapper {

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
