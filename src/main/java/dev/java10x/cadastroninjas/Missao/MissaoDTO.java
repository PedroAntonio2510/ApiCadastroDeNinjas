package dev.java10x.cadastroninjas.Missao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MissaoDTO {
    private Long id;
    private String nome;
    private String dificuldade;
    private BigDecimal recompensa;
}
