package br.com.edusync.desafio5.Services;

import br.com.edusync.desafio5.Models.FuncionarioResponsavel;
import br.com.edusync.desafio5.Models.Produto;
import br.com.edusync.desafio5.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    public static void adicionar(FuncionarioResponsavel novoFuncionario){

        FuncionarioRepository.<FuncionarioResponsavel>save(novoFuncionario);
    }

    public FuncionarioResponsavel buscarPorId(Integer id){
        Optional<FuncionarioResponsavel> optionalFuncionarioResponsavel = FuncionarioRepository.findById(id);
        if (optionalFuncionarioResponsavel.isEmpty()){
            throw new RuntimeException("Funcionario não cadastrado");
        }
        return optionalFuncionarioResponsavel.get();
    }

    public List<FuncionarioResponsavel> listarTudo(){
        return Collections.unmodifiableList(FuncionarioRepository.findAll());
    }

    public void remover(Integer id) {
        if (FuncionarioRepository.existById(id))
            FuncionarioRepository.deletById(id);
    }



}
