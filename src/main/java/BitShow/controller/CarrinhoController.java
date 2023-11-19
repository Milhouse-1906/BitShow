package BitShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BitShow_Model_Entidade.Carrinho;

@RestController
@RequestMapping("/api")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping("/carrinho")
    public ResponseEntity<Carrinho> adicionarAoCarrinho(@RequestBody Carrinho carrinho) {
        Carrinho novoCarrinho = carrinhoService.adicionarAoCarrinho(carrinho);
        return new ResponseEntity<>(novoCarrinho, HttpStatus.CREATED);
    }

    @GetMapping("/carrinho/{id}")
    public ResponseEntity<Carrinho> getCarrinhoById(@PathVariable Long id) {
        Carrinho carrinho = carrinhoService.getCarrinhoById(id);
        return new ResponseEntity<>(carrinho, HttpStatus.OK);
    }

    // Adicione outros métodos conforme necessário
}