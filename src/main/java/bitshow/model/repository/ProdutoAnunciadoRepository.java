package bitshow.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import bitshow.model.entidade.Produto_Anunciado;

public interface ProdutoAnunciadoRepository extends JpaRepository<Produto_Anunciado, Long>, JpaSpecificationExecutor<Produto_Anunciado> {
	@Query("SELECT p FROM Produto_Anunciado p WHERE p.categoria.id = :idCategoria")
	List<Produto_Anunciado> findByCategoriaId(Long idCategoria);
	List<Produto_Anunciado> findAllByCategoriaId(Long idCategoria);
}

