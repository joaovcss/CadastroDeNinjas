package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    //GET  -> Mostrar todos os Ninjas
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.status(HttpStatus.OK)
                .body(ninjas);
    }

    //GET  -> Mostrar Ninja por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> mostrarNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);
        if(ninja != null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja not found");
        }
    }

    //POST  -> Adicionar ninja
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Created ninja successfully" + novoNinja.getNome() + "ID: " + novoNinja.getId());
    }

    //PUT  -> Alterar dados dos ninjas
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaBody) {
        NinjaDTO ninja = ninjaService.editarNinja(id, ninjaBody);
        if(ninja != null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja not found");
        }
    }

    //DELETE  -> Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id){
        if(ninjaService.listarNinjaPorId(id) != null){
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja with ID " + id + " deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja not found");
        }
    }
}
