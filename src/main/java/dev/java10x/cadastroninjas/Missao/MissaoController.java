package dev.java10x.cadastroninjas.Missao;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissaoController {

    @GetMapping("/listar")
    public String listarMissoes() {
        return "Missoes listadas";
    }

    @PostMapping("/criar")
    public String criarMissao() {
        return "Missao criada com sucesso";
    }

    @PutMapping("/alterarID")
    public String alterarMissao() {
        return "Missao alterada com sucesso";
    }

    @DeleteMapping("/deletarID")
    public String deletarMissao() {
        return "Missao deletada com sucesso";
    }
}
