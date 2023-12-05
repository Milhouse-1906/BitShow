package bitshow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitshow.model.entidade.Resposta;
import bitshow.service.RespostaService;

@RestController
@RequestMapping("/api/resposta")
public class RespostaController {

    @Autowired
    private RespostaService respostaService;

    @PostMapping()
    public Resposta criarResposta(@RequestBody Resposta resposta) {
        return respostaService.criarResposta(resposta);
    }

    @GetMapping("/{id}")
    public Resposta getRespostaById(@PathVariable Long id) {
        return respostaService.getRespostaById(id);
    }
    
//    @GetMapping("/{id}")
//    public List <Resposta> getRespostasPorPergunta(@PathVariable Long idPergunta) {
//        return respostaService.getRespostasPorPergunta(idPergunta);
//    }
}
