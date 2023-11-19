package BitShow.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BitShow.model.ntidade.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {
    // Adicione métodos de consulta personalizados, se necessário
}
