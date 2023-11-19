package BitShow.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BitShow.model.ntidade.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
    // Adicione métodos de consulta personalizados, se necessário
}
