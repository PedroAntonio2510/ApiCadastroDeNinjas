package dev.java10x.cadastroninjas.Missao;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
@RequestMapping("/missoes/ui")
public class MissaoControllerUi {

    private final MissaoService missaoService;

    public MissaoControllerUi(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @GetMapping("/listar")
    public String listarMissoes(Model model) {
        List<MissaoDTO> missoes = missaoService.listarMissoes();
        model.addAttribute("missoes", missoes);
        return "listarMissoes";
    }

    @GetMapping("/deletar/{id}")
    public String deletarMissaoPorId(@PathVariable Long id) {
        missaoService.deletarMissaoPorId(id);
        return "redirect:/missoes/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String listarMissaoPorId(@PathVariable Long id, Model model) {
        MissaoDTO missao = missaoService.listarMissaoPorId(id);
        if (missao != null) {
            model.addAttribute("missao", missao);
            return "detalhesMissao";
        }
        model.addAttribute("mensagem", "Missão não encontrada");
        return "redirect:/missoes/ui/listar";
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarNinja(Model model) {
        model.addAttribute("missao", new MissaoDTO());
        return "adicionarMissao";
    }

    @PostMapping("/salvar")
    public String salvarMissao(@ModelAttribute MissaoDTO missao, RedirectAttributes redirectAttributes) {
        missaoService.criarMissao(missao);
        redirectAttributes.addFlashAttribute("mensagem", "Missão adicionada com sucesso");
        return "redirect:/missoes/ui/listar";
    }
    
    

    

}
