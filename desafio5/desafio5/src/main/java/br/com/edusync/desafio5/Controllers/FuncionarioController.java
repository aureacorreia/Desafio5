package br.com.edusync.desafio5.Controllers;

import br.com.edusync.desafio5.Models.FuncionarioResponsavel;
import br.com.edusync.desafio5.Services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity adicionarProduto(@RequestBody FuncionarioResponsavel funcionarioResponsavel) {
        FuncionarioService.adicionar(funcionarioResponsavel);
        return new ResponseEntity<>(funcionarioResponsavel, HttpStatus.CREATED);
    }
    @GetMapping
    public RestController listarTudo(){
        return (RestController) new ResponseEntity<>(funcionarioService.listarTudo(), HttpStatus.OK);
    }

    public ResponseEntity<FuncionarioResponsavel> ResponseEntity  (@RequestParam Integer id){
        return new ResponseEntity<>(funcionarioService.buscarPorId(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{cpf}")
    public ResponseEntity remover() {
        return remover(null);
    }
    @DeleteMapping(value = "/{cpf}")
    public ResponseEntity remover(@PathVariable Integer id){
        funcionarioService.remover(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}
