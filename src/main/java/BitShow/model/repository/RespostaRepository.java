package BitShow.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import BitShow.model.ntidade.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {

	List<Resposta> findAllByPerguntaId(Long idPergunta);
   
}
