package dev.java10x.cadastroninjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping
    public String boasVindas() {
        return "Essa e a minha mensagem nessa rota";
    }
}
