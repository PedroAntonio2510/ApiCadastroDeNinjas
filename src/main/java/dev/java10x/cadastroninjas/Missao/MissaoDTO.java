package dev.java10x.cadastroninjas.Missao;

import dev.java10x.cadastroninjas.Ninjas.NinjaDTO;
import dev.java10x.cadastroninjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MissaoDTO {
    private Long id;
    private String nome;
    private String dificuldade;
}
