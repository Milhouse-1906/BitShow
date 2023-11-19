package BitShow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}



