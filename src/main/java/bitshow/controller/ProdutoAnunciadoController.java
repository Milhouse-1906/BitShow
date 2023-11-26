package bitshow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import bitshow.exception.ProdutoAnunciadoNotFoundException;
import bitshow.model.entidade.Produto_Anunciado;
import bitshow.service.ProdutoAnunciadoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoAnunciadoController {

    @Autowired
    private ProdutoAnunciadoService produtoAnunciadoService;

    @GetMapping
    public List<Produto_Anunciado> listarProdutos() {
        return produtoAnunciadoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public Produto_Anunciado obterProdutoPorId(@PathVariable Long id) {
        return produtoAnunciadoService.obterProdutoPorId(id);
    }

    @PostMapping
    public Produto_Anunciado criarProduto(@RequestBody Produto_Anunciado produtoAnunciado) {
        return produtoAnunciadoService.criarProdutoAnunciado(produtoAnunciado);
    }

    @PutMapping("/{id}")
    public Produto_Anunciado atualizarProduto(
            @PathVariable Long id,
            @RequestBody Produto_Anunciado produto) throws ProdutoAnunciadoNotFoundException {
        return produtoAnunciadoService.atualizarProduto(id, produto);
    }

    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable Long id) throws ProdutoAnunciadoNotFoundException {
        produtoAnunciadoService.excluirProduto(id);
    }
}