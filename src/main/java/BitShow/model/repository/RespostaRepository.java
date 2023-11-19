package BitShow.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BitShow.model.ntidade.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
    // Adicione métodos de consulta personalizados, se necessário
}
