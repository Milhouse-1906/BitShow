package BitShow.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import BitShow.model.ntidade.Produto_Anunciado;

public interface ProdutoAnunciadoRepository extends JpaRepository<Produto_Anunciado, Long> {
	 @Query("SELECT p FROM Produto_Anunciado p WHERE p.categoria.id = :idCategoria")
	    List<Produto_Anunciado> findByCategoriaId(Long idCategoria);
	    List<Produto_Anunciado> findAllByCategoriaId(Long idCategoria);
	}

