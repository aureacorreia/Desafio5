package br.com.edusync.desafio5.Controllers;

import br.com.edusync.desafio5.Models.Produto;
import br.com.edusync.desafio5.Services.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EstoqueMovimentoController {

    @Autowired
    private EstoqueService service;

    @PostMapping(value = "/estoque/cadastrarproduto")
    public ResponseEntity novoProduto(@RequestBody Produto produto,
                                          @RequestParam Integer id) {
        service.adicionar(produto);
        return new ResponseEntity(produto + " " + id, HttpStatus.CREATED);
    }

    @GetMapping(value = "/estoque/listar")
    public ResponseEntity listarTodos(){
        return new ResponseEntity(service.listarEstoque(),HttpStatus.OK);

    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity deletar(@PathVariable Integer id){
        service.removerProduto(id);
        return  new ResponseEntity(HttpStatus.OK);
    }
}
