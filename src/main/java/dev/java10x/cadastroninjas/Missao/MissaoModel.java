package dev.java10x.cadastroninjas.Missao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.cadastroninjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_missao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;

    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List<NinjaModel> ninjas;

    @Column(name = "recompensa")
    private BigDecimal recompensa;
}
