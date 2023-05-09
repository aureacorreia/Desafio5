package br.com.edusync.desafio5.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity (name = "tb_estoque_movimento")
public class EstoqueDeMovimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
   Date dataHora;
    String tipoMovimento;
    Integer quantidade;

    @ManyToOne
            @JoinColumn (name = "produto_id")
    Produto produto;
    @ManyToOne
            @JoinColumn (name = "funcionario_id")
    FuncionarioResponsavel funcionarioResponsavel;

}
