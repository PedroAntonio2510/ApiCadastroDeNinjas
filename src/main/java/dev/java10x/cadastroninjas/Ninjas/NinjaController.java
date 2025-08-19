package dev.java10x.cadastroninjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de boas vindas", description =  "Essa rota da uma mensagem de boas vindas para quem acessa ela")
    public String boasVindas() {
        return "Essa e a minha mensagem nessa rota";
    }

    //Adicionar Ninja(CREATE)
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro na criacao do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    //Mostrar todos os ninjas(READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Mostrar Ninja por ID(READ)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o ninja por ID", description = "Rota lista um ninja por seu id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Ninja nao encontrado")
    })
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listaNinjaPorId(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja nao encontrado");
    }

    //Alterar dados dos ninjas(UPDATE)
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera o ninja por id", description = "Rota altera um ninja pelo seu id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Ninja nao encontrado, nao foi possivel alterar")
    })
    public ResponseEntity<String> alterarNinjaPorId(
        @Parameter(description = "Id do ninja a ser alterado")
        @PathVariable Long id, 
        @Parameter(description = "Usuario manda os dados do ninja a ser atualizado no corpo da requisição")
        @RequestBody NinjaDTO ninjaAtualizado){
        NinjaDTO ninjaNovo = ninjaService.atualizarNinja(id, ninjaAtualizado);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja atualizado com sucesso: " + ninjaNovo.getNome() + " (ID): " + ninjaNovo.getId());
    }

        // Deletar Ninja(DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
        return ResponseEntity.noContent().build();
    }

}
