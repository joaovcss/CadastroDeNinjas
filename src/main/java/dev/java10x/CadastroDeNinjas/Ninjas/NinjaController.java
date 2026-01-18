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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }

    //PUT  -> Alterar dados dos ninjas
    @PutMapping("/alterar/{id}")
    public NinjaModel atualizarNinja(@PathVariable Long id, @RequestBody NinjaModel ninjaBody) {
        return ninjaService.editarNinja(id, ninjaBody);
    }

    //DELETE  -> Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    public void deletarNinja(@PathVariable Long id){
        ninjaService.deletarNinja(id);
    }

    @GetMapping("/status")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }
}
