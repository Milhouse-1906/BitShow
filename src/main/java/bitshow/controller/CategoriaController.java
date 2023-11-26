package bitshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import bitshow.exception.CategoriaNotFoundException;
import bitshow.model.entidade.Categoria;
import bitshow.service.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public Categoria criarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.criarCategoria(categoria);
    }

    @GetMapping("/{id}")
    public Categoria getCategoriaById(@PathVariable Long id) {
        return categoriaService.getCategoriaById(id);
    }

    @PutMapping("/{id}")
    public Categoria atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) throws CategoriaNotFoundException {
        return categoriaService.atualizarCategoria(id, categoria);
    }

    @DeleteMapping("/{id}")
    public void excluirCategoria(@PathVariable Long id) throws CategoriaNotFoundException {
        categoriaService.excluirCategoria(id);
    }
}
