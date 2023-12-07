package bitshow.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bitshow.model.entidade.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

	@Query("SELECT c FROM Carrinho c WHERE c.usuario.id = :userId")
	List<Carrinho> findByUserId(@Param("userId") Long userId);

	List<Carrinho> findAllByUsuarioId(Long id);

}
