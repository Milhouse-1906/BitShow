package BitShow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BitShow.model.ntidade.Usuario;
import BitShow.model.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario) {
        if (usuario.getUsuario() == null || usuario.getUsuario().isEmpty()) {
            throw new IllegalArgumentException("Nome de usuário não pode ser nulo ou vazio");
        }

        if (usuarioRepository.findByUsuario(usuario.getUsuario()) != null) {
            throw new RuntimeException("Nome de usuário já está em uso");
        }

        String senhaCifrada = new BCryptPasswordEncoder().encode(usuario.getSenha());
        usuario.setSenha(senhaCifrada);
        return usuarioRepository.save(usuario);
    }

    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

}
