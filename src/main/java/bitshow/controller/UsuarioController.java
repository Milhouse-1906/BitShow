package bitshow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitshow.exception.UsuarioNotFoundException;
import bitshow.model.entidade.Usuario;
import bitshow.service.UsuarioService;


@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = {"http://localhost:4200", "http://127.0.0.1:5500"}, maxAge = 3600)
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.criarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id);
    
    }
    
    @GetMapping
    public List<Usuario> listarTodos(){
    	List<Usuario> usuarios = usuarioService.listarTodos();
		return usuarios;
    }

    @PutMapping("/{id}")
    public boolean atualizarUsuario(@RequestBody Usuario usuario) throws UsuarioNotFoundException {
        return usuarioService.atualizarUsuario(usuario) != null;
    }

    @DeleteMapping("/{id}")
    public boolean excluirUsuario(@PathVariable Long id) throws UsuarioNotFoundException {
        return usuarioService.excluirUsuario(id);
    }
}