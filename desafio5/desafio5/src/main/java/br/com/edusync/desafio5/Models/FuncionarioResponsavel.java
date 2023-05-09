package br.com.edusync.desafio5.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity (name = "tb_funcionario_responsavel")
public class FuncionarioResponsavel {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String nome;
    String cpf;
    String cargo;
}
