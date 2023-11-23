package bitshow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitshow.model.entidade.Resposta;
import bitshow.model.repository.RespostaRepository;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private PerguntaService perguntaService;

    public Resposta criarResposta(Resposta resposta) {
        if (resposta.getTexto() == null || resposta.getTexto().isEmpty()) {
            throw new IllegalArgumentException("O texto da resposta não pode ser nulo ou vazio");
        }
        if (perguntaService.getPerguntaById(resposta.getPergunta().getId()) == null) {
            throw new IllegalArgumentException("A pergunta associada não existe");
        }
        return respostaRepository.save(resposta);
    }

    public Resposta getRespostaById(Long id) {
        return respostaRepository.findById(id).orElse(null);
    }

    public List<Resposta> getRespostasPorPergunta(Long idPergunta) {
        return respostaRepository.findAllByPerguntaId(idPergunta);
    }

}
