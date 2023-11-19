package BitShow.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BitShow_Model_Entidade.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Adicione métodos de consulta personalizados, se necessário
}
