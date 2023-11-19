package BitShow.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import BitShow.model.ntidade.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    @Query("SELECT c FROM Categoria c WHERE c.nome = :nome")
    Categoria findByNome(String nome);
}
