package bitshow.model.specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import bitshow.model.entidade.Produto_Anunciado;
import bitshow.model.seletor.ProdutoSeletor;
import jakarta.persistence.criteria.Predicate;

public class ProdutoAnunciadoSpecifications {

	public static Specification<Produto_Anunciado> comFiltros(ProdutoSeletor seletor) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (seletor.getNome() != null && !seletor.getNome().isEmpty()) {
				predicates.add(cb.like(cb.lower(root.get("nome")), "%" + seletor.getNome().toLowerCase() + "%"));
			}
			if (seletor.getCategoria() != null && !seletor.getCategoria().isEmpty()) {
				predicates.add(cb.like(cb.lower(root.join("categoria").get("nome")),
						"%" + seletor.getCategoria().toLowerCase() + "%"));
			}

			if (seletor.getValorMinimo() != null && seletor.getValorMaximo() != null) {

				predicates.add(cb.between(root.get("preco"), seletor.getValorMinimo(), seletor.getValorMaximo()));

			}
			else {
				if (seletor.getValorMinimo() != null) {
					predicates.add(cb.greaterThanOrEqualTo(root.get("preco"), seletor.getValorMinimo()));
				}
				if (seletor.getValorMaximo() != null) {
					predicates.add(cb.lessThanOrEqualTo(root.get("preco"), seletor.getValorMaximo()));
				}
			}
			
			
			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

	public static Specification<Produto_Anunciado> porCategoria(Long idCategoria) {
		return (root, query, builder) -> builder.equal(root.get("categoria").get("id"), idCategoria);
	}

	public static Specification<Produto_Anunciado> porUsuario(Long idUsuario) {
		return (root, query, builder) -> builder.equal(root.get("usuario").get("id"), idUsuario);
	}

	public static Specification<Produto_Anunciado> produtoNaoNulo() {
		return (root, query, builder) -> builder.isNotNull(root.get("produtoAnunciado"));
	}

	public static Specification<Produto_Anunciado> descricaoNaoVazia() {
		return (root, query, builder) -> builder.isNotEmpty(root.get("descricao"));
	}

	public static Specification<Produto_Anunciado> dataAnuncioValida() {
		return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get("dataAnuncio"), LocalDate.now());
	}

}
