package BitShow.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BitShow.excepition.PerguntaNotFoundException;
import BitShow.model.DTO.PerguntaDTO;
import BitShow.model.ntidade.Pergunta;
import BitShow.model.repository.PerguntaRepository;

@Service
public class PerguntaService {

    @Autowired
    private PerguntaRepository perguntaRepository;

    public Pergunta criarPergunta(Pergunta pergunta) {
        if (pergunta.getTexto() == null || pergunta.getTexto().isEmpty()) {
            throw new IllegalArgumentException("O texto da pergunta não pode ser nulo ou vazio");
        }
        return perguntaRepository.save(pergunta);
    }

    public Pergunta getPerguntaById(Long id) {
        return perguntaRepository.findById(id).orElse(null);
    }

    public Pergunta getPerguntasPorUsuario(Long idUsuario) {
        return perguntaRepository.findAllByUsuarioId(idUsuario);
    }

	public void excluirPergunta(Long id) throws PerguntaNotFoundException {
		Optional<Pergunta> perguntaOptional = perguntaRepository.findById(id);

        if (perguntaOptional.isPresent()) {
            Pergunta pergunta = perguntaOptional.get();
            
            perguntaRepository.delete(pergunta);
        } else {
            throw new PerguntaNotFoundException("Pergunta não encontrada com o ID: " + id);
        }
    }

	public Pergunta atualizarPergunta(Long id, Pergunta pergunta) throws PerguntaNotFoundException {
		Optional<Pergunta> perguntaOptional = perguntaRepository.findById(id);

        if (perguntaOptional.isPresent()) {
            Pergunta perguntaExistente = perguntaOptional.get();
            perguntaExistente.setTexto(pergunta.getTexto());
            return perguntaRepository.save(perguntaExistente);
        } else {
            throw new PerguntaNotFoundException("Pergunta não encontrada com o ID: " + id);
        }
    }
}




