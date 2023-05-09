package br.com.edusync.desafio5.repositories;

import br.com.edusync.desafio5.Models.EstoqueDeMovimento;
import br.com.edusync.desafio5.Models.Produto;
import br.com.edusync.desafio5.Services.EstoqueService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<EstoqueDeMovimento, Integer> {
    static void save(Produto produto) {
    }
}
