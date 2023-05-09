package br.com.edusync.desafio5.Services;

import br.com.edusync.desafio5.Models.Produto;
import br.com.edusync.desafio5.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {
    @Autowired
    private ProdutoRepository produtoRepository;

    private List<Produto> listaDeProdutos = new ArrayList<>();

    public void adicionar(Produto produtoGuardado){

        produtoRepository.save(produtoGuardado);
    }

    // busca o produto pelo id dentro do banco
    public Produto buscarPorId(Integer id){
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if (optionalProduto.isEmpty()){
            throw new RuntimeException("Produto não encontrado");
        }
        return optionalProduto.get();
    }

    //busca o produto dentro do banco de dados e o remove
    public void removerProduto(Integer id) {
        if (produtoRepository.existsById(id))
       produtoRepository.deleteById(id);
    }
    //listar o estoque mosttrando a lista de produtos
    public List<Produto> listarEstoque(){
        return produtoRepository.findAll();
    }


}
