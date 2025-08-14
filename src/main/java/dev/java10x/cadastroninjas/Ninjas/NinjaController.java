package dev.java10x.cadastroninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
public class NinjaController {

    @GetMapping
    public String boasVindas() {
        return "Essa e a minha mensagem nessa rota";
    }

    //Adicionar Ninja(CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    //Mostrar todos os ninjas(READ)
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas() {
        return "Mostrar Ninja";
    }

    //Mostrar Ninja por ID(READ)
    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasPorId() {
        return "Mostrar Ninja por ID";
    }

    //Alterar dados dos ninjas(UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar Ninja por id";
    }

    // Deletar Ninja(DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId() {
        return "Deletar Ninja por id";
    }

}
