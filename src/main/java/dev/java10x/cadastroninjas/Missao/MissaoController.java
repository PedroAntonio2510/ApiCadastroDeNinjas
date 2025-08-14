package dev.java10x.cadastroninjas.Missao;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissaoController {

    @GetMapping("/listar")
    public String listarMissoes() {
        return "Missoes listadas";
    }

    @PostMapping
    public String criarMissao() {
        return "Missao criada com sucesso";
    }

    @PutMapping("/")
    public String alterarMissao() {
        return "Missao alterada com sucesso";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Missao deletada com sucesso";
    }
}
