package bitshow.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bitshow.model.entidade.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {
		@Query("SELECT p FROM Pergunta p WHERE p.usuario.id = :idUsuario")
	    List<Pergunta> findByUsuarioId(Long idUsuario);
		Pergunta findAllByUsuarioId(Long idUsuario);
	}


