package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos os ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    //Listar ninja por ID
    public NinjaModel listarNinjaPorId(Long id){
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        return ninja.orElse(null);
    }

    //Criar novo ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    //Atualizar ninja
    public NinjaModel editarNinja(Long id, NinjaModel ninjaAtualizado){
        if(ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }

    //Deletar ninja por ID
    public void deletarNinja(Long id){
        ninjaRepository.deleteById(id);
    }
}
