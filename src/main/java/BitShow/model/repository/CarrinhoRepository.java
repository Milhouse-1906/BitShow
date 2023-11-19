package BitShow.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import BitShow.model.ntidade.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

	List<Carrinho> findAllByUsuarioId(Long idUsuario);
   
}
