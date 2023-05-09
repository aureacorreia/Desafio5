package br.com.edusync.desafio5.Controllers;

import br.com.edusync.desafio5.Models.Produto;
import br.com.edusync.desafio5.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ProdutoControllers {

    @Autowired
    private ProdutoService service;

    @PostMapping(value = "/novo")
    public ResponseEntity novoProduto(@RequestBody Produto produto){
        service.adicionarAoEstoque(produto);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity listarTodos(){
        String busca = null;
        return new ResponseEntity<>(service.listarEstoque(busca), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity listarPorId(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity remover(@PathVariable Integer id){
        service.remover(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "nome")
    public ResponseEntity listarPorNome(@RequestParam(defaultValue = "") String busca){
        return new ResponseEntity<>(service.listarEstoque(busca), HttpStatus.OK);
    }

    @GetMapping(value = "/filtro")
    public ResponseEntity filtrar(Produto produtoFilterParam){
        return new ResponseEntity<>(service.filtrar(produtoFilterParam), HttpStatus.OK);
    }

}
