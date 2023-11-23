package bitshow.model.specification;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import bitshow.model.entidade.Produto_Anunciado;

public class ProdutoAnunciadoSpecifications {

    public static Specification<Produto_Anunciado> porCategoria(Long idCategoria) {
        return (root, query, builder) ->
                builder.equal(root.get("categoria").get("id"), idCategoria);
    }

    public static Specification<Produto_Anunciado> porUsuario(Long idUsuario) {
        return (root, query, builder) ->
                builder.equal(root.get("usuario").get("id"), idUsuario);
    }

    public static Specification<Produto_Anunciado> produtoNaoNulo() {
        return (root, query, builder) ->
                builder.isNotNull(root.get("produtoAnunciado"));
    }

    public static Specification<Produto_Anunciado> descricaoNaoVazia() {
        return (root, query, builder) ->
                builder.isNotEmpty(root.get("descricao"));
    }

    public static Specification<Produto_Anunciado> dataAnuncioValida() {
        return (root, query, builder) ->
                builder.greaterThanOrEqualTo(root.get("dataAnuncio"), LocalDate.now());
    }

    
}
