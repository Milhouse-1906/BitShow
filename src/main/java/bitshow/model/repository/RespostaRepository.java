package bitshow.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bitshow.model.entidade.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
	@Query("SELECT r FROM Resposta r WHERE r.pergunta.id = :idPergunta")
		List<Resposta> findAllByPerguntaId(Long idPergunta);
	    List<Resposta> findByPerguntaId(Long idPergunta);
	}

