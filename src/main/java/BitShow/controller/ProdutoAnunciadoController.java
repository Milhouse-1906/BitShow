package BitShow.controller;

import java.util.List;

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

import BitShow.excepition.ProdutoAnunciadoNotFoundException;
import BitShow.model.ntidade.Produto_Anunciado;
import BitShow.service.ProdutoAnunciadoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoAnunciadoController {

    @Autowired
    private ProdutoAnunciadoService produtoAnunciadoService;

    @GetMapping
    public ResponseEntity<List<Produto_Anunciado>> listarProdutos() {
        List<Produto_Anunciado> produtos = produtoAnunciadoService.listarProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto_Anunciado> obterProdutoPorId(@PathVariable Long id) {
        Produto_Anunciado produto = produtoAnunciadoService.obterProdutoPorId(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<Produto_Anunciado> criarProduto(@RequestBody Produto_Anunciado produtoAnunciado) {
        Produto_Anunciado produtoCriado = produtoAnunciadoService.criarProdutoAnunciado(produtoAnunciado);
        return new ResponseEntity<>(produtoCriado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto_Anunciado> atualizarProduto(
            @PathVariable Long id,
            @RequestBody Produto_Anunciado produto) throws ProdutoAnunciadoNotFoundException {
        Produto_Anunciado produtoAtualizado = produtoAnunciadoService.atualizarProduto(id, produto);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id) throws ProdutoAnunciadoNotFoundException {
        produtoAnunciadoService.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }
}
