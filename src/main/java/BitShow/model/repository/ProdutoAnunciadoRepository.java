package BitShow.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BitShow.model.ntidade.Produto_Anunciado;

public interface ProdutoAnunciadoRepository extends JpaRepository<Produto_Anunciado, Long> {
    // Adicione métodos de consulta personalizados, se necessário
}
