package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    @GetMapping("/todasMissoes")
    public List<MissoesModel> verMissoes(){
        return missoesService.verMissoes();
    }

    @GetMapping("/verMissao/{id}")
    public MissoesModel verMissao(@PathVariable Long id){
        return missoesService.verMissao(id);
    }

    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao){
        return missoesService.criarMissao(missao);
    }

    @PutMapping("/alterar/{id}")
    public String editarMissao(){
        return "Missão editada";
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missoesService.deletarMissao(id);
    }
}
