package br.com.edusync.desafio5.Services;

import br.com.edusync.desafio5.Models.Produto;
import br.com.edusync.desafio5.repositories.EstoqueRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private List<Produto> listaDeProdutos = new ArrayList<>();
    public void adicionarAoEstoque(Produto produto) {

        EstoqueRepository.save(produto);
    }

    public List<Produto> listarEstoque(String busca){return EstoqueRepository.findAll();}

    public Produto buscarPorId(Integer id){
        Optional<Produto> optionalProduto = EstoqueRepository.findById(id);
        if (optionalProduto.isEmpty()){
            throw new RuntimeException("Produto não encontrado");
        }
        return optionalProduto.get();
    }

    public void remover(Integer id) {
        if (!EstoqueRepository.existsById(id)) return;
        EstoqueRepository.deleteById(id);
    }


    public List filtrar(Produto produtoFilterParam) {
        return null;
    }
}
