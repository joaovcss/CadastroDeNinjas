package dev.java10x.CadastroDeNinjas.Ninjas;

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
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    //GET  -> Mostrar Ninja por ID
    @GetMapping("/listar/{id}")
    public NinjaModel mostrarNinjasPorId(@PathVariable Long id) {
        return ninjaService.listarNinjaPorId(id);
    }

    //POST  -> Adicionar ninja
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    //PUT  -> Alterar dados dos ninjas
    @PutMapping("/atualizar/{id}")
    public String atualizarNinja() {
        return "Ninja atualizado!";
    }

    //DELETE  -> Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    public String deletarNinja(){
        return "Ninja deletado!";
    }

    @GetMapping("/status")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }
}
