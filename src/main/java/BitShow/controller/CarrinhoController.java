package BitShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BitShow.model.ntidade.Carrinho;
import BitShow.service.CarrinhoService;

@RestController
@RequestMapping("/api")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping("/carrinho")
    public ResponseEntity<Carrinho> adicionarAoCarrinho(@RequestBody Carrinho carrinho) {
        Carrinho novoCarrinho = Carrinho.adicionarAoCarrinho(carrinho);
        return new ResponseEntity<>(novoCarrinho, HttpStatus.CREATED);
    }

    @GetMapping("/carrinho/{id}")
    public ResponseEntity<Carrinho> getCarrinhoById(@PathVariable Long id) {
        Carrinho carrinho = Carrinho.getCarrinhoById(id);
        return new ResponseEntity<>(carrinho, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerDoCarrinho(@PathVariable Long id) {
        carrinhoService.removerDoCarrinho(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrinho> atualizarCarrinho(@PathVariable Long id, @RequestBody Carrinho carrinhoDTO) {
        Carrinho carrinho = carrinhoService.atualizarCarrinho(id, carrinhoDTO);
        return ResponseEntity.ok(carrinho);
    }

    
   }
    
