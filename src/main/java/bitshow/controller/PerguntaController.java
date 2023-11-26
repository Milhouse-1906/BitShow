package bitshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import bitshow.exception.PerguntaNotFoundException;
import bitshow.model.entidade.Pergunta;
import bitshow.service.PerguntaService;

@RestController
@RequestMapping("/api/pergunta")
public class PerguntaController {

    @Autowired
    private PerguntaService perguntaService;

    @PostMapping()
    public Pergunta criarPergunta(@RequestBody Pergunta pergunta) {
        return perguntaService.criarPergunta(pergunta);
    }

    @GetMapping("/{id}")
    public Pergunta getPerguntaById(@PathVariable Long id) {
        return perguntaService.getPerguntaById(id);
    }

    @DeleteMapping("/{id}")
    public void excluirPergunta(@PathVariable Long id) throws PerguntaNotFoundException {
        perguntaService.excluirPergunta(id);
    }
    
    @PutMapping("/{id}")
    public Pergunta atualizarPergunta(@PathVariable Long id, @RequestBody Pergunta pergunta) throws PerguntaNotFoundException {
        return perguntaService.atualizarPergunta(id, pergunta);
    }
}
