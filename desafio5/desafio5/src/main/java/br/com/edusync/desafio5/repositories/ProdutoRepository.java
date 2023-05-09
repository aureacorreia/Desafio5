package br.com.edusync.desafio5.repositories;

import br.com.edusync.desafio5.Models.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public abstract class ProdutoRepository implements JpaRepository<Produto, Integer> {

    public static EntityManager entityManager = null;
    private EntityManager entityManager;

    public ProdutoRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public abstract List<Produto> getFiltro(produtoFilterParam params){
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaBuilder query = (CriteriaBuilder) criteriaBuilder.createQuery(Produto.class);

        Expression<String> produtoRoot = query.trim(Produto.class);
        List<Predicate> predicates = new ArrayList<>();

        if (params.getDescricao() != null){
            predicates.add(criteriaBuilder.like(produtoRoot.getAlias("descricao"),"%" + params.getDescricao() + "%"));
        }
        if (params.getDataValidade() != null ){
            predicates.add(criteriaBuilder.equal(produtoRoot.getAlias("dataValidade"),params.getDataValidade()));
        }
        if (params.getPrecoVenda() != null){
            predicates.add(criteriaBuilder.equal(produtoRoot.getAlias("precoVenda"), params.getPrecoVenda()));
        }
        if (!predicates.isEmpty()){
            query.le(predicates.stream().toArray(Predicate[]::new));
        }

        TypedQuery<Produto> queryResult = (TypedQuery<Produto>) this.entityManager.createQuery(String.valueOf(query));
        return queryResult.getResultList();
    }

    public static class produtoFilterParam {
        private String descricao;
        private Object dataValidade;
        private Object precoVenda;

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public Object getDataValidade() {
            return dataValidade;
        }

        public void setDataValidade(Object dataValidade) {
            this.dataValidade = dataValidade;
        }

        public Object getPrecoVenda() {
            return precoVenda;
        }

        public void setPrecoVenda(Object precoVenda) {
            this.precoVenda = precoVenda;
        }
    }
}
