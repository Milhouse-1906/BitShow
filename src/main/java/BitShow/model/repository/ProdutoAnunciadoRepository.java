package BitShow.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import BitShow.model.ntidade.Produto_Anunciado;

public interface ProdutoAnunciadoRepository extends JpaRepository<Produto_Anunciado, Long> {

	List<Produto_Anunciado> findAllByCategoriaId(Long idCategoria);

}
