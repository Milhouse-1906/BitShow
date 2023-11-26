package bitshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import bitshow.exception.CarrinhoNotFoundException;
import bitshow.model.entidade.Carrinho;
import bitshow.service.CarrinhoService;

@RestController
@RequestMapping("/api")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping("/carrinho")
    public Carrinho adicionarAoCarrinho(@RequestBody Carrinho carrinho) {
        return Carrinho.adicionarAoCarrinho(carrinho);
    }

    @GetMapping("/carrinho/{id}")
    public Carrinho getCarrinhoById(@PathVariable Long id) {
        return Carrinho.getCarrinhoById(id);
    }
    
    @DeleteMapping("/{id}")
    public void removerDoCarrinho(@PathVariable Long id) throws CarrinhoNotFoundException {
        carrinhoService.removerDoCarrinho(id);
    }

    @PutMapping("/{id}")
    public Carrinho atualizarCarrinho(@PathVariable Long id, @RequestBody Carrinho carrinho) throws CarrinhoNotFoundException {
        return carrinhoService.atualizarCarrinho(id, carrinho);
    }
}
