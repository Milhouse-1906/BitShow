package BitShow.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BitShow.model.ntidade.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Adicione métodos de consulta personalizados, se necessário
}
