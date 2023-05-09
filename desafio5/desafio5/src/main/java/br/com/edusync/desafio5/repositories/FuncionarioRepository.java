package br.com.edusync.desafio5.repositories;

import br.com.edusync.desafio5.Models.EstoqueDeMovimento;
import br.com.edusync.desafio5.Models.FuncionarioResponsavel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioResponsavel, Integer> {
    static void deletById(Integer id) {
    }

    static boolean existById(Integer id) {
    }
}
