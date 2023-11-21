package BitShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BitShow.excepition.PerguntaNotFoundException;
import BitShow.model.DTO.PerguntaDTO;
import BitShow.model.ntidade.Pergunta;
import BitShow.service.PerguntaService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200", "http://127.0.0.1:5500"}, maxAge = 3600)
public class PerguntaController {

    @Autowired
    private PerguntaService perguntaService;

    @PostMapping("/perguntas")
    public ResponseEntity<Pergunta> criarPergunta(@RequestBody Pergunta pergunta) {
        Pergunta novaPergunta = ((PerguntaService) perguntaService).criarPergunta(pergunta);
        return new ResponseEntity<>(novaPergunta, HttpStatus.CREATED);
    }

    @GetMapping("/perguntas/{id}")
    public ResponseEntity<Pergunta> getPerguntaById(@PathVariable Long id) {
        Pergunta pergunta = perguntaService.getPerguntaById(id);
        return new ResponseEntity<>(pergunta, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPergunta(@PathVariable Long id) throws PerguntaNotFoundException {
        perguntaService.excluirPergunta(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Pergunta> atualizarPergunta(@PathVariable Long id, @RequestBody PerguntaDTO perguntaDTO) throws PerguntaNotFoundException {
        Pergunta pergunta = perguntaService.atualizarPergunta(id, perguntaDTO);
        return ResponseEntity.ok(pergunta);
    }
}