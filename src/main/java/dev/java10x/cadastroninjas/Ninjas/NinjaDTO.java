package dev.java10x.cadastroninjas.Ninjas;

import dev.java10x.cadastroninjas.Missao.MissaoModel;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private String img_url;
    private int idade;
    private MissaoModel missoes;
    private String rank;

}
