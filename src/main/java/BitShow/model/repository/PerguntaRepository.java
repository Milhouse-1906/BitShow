package BitShow.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import BitShow.model.ntidade.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {

	Pergunta findAllByUsuarioId(Long idUsuario);
}
