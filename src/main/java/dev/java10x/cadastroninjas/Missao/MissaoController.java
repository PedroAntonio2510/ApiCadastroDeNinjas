package dev.java10x.cadastroninjas.Missao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissaoController {

    private final MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissaoDTO>> listarMissoes() {
        List<MissaoDTO> missoes = missaoService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissaoPorId(@PathVariable Long id) {
        MissaoDTO missao = missaoService.listarMissaoPorId(id);
        if (missao != null) {
            return ResponseEntity.ok(missao);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NInja nao encontrado");
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissaoDTO missao) {
        MissaoDTO novaMissao = missaoService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED).body("Nova missão criada com sucesso: " + novaMissao.getNome() + " ID: " + novaMissao.getId());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarMissao(@PathVariable Long id,
                                                @RequestBody MissaoDTO missaoDTO) {
        MissaoDTO missao = missaoService.atualizarMissao(id, missaoDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Missao atualizada com sucesso " + missao.getNome() + " ID: " + missao.getId());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarMissao(@PathVariable Long id) {
        missaoService.deletarMissaoPorId(id);
        return ResponseEntity.noContent().build();
    }
}
