package bitshow.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import bitshow.model.entidade.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

	List<Carrinho> findAllByUsuarioId(Long idUsuario);
}
