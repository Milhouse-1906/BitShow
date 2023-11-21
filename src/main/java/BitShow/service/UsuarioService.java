package BitShow.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BitShow.excepition.UsuarioNotFoundException;
import BitShow.model.DTO.UsuarioDTO;
import BitShow.model.ntidade.Usuario;
import BitShow.model.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private static UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario) {
        if (usuario.getUsuario() == null || usuario.getUsuario().isEmpty()) {
            throw new IllegalArgumentException("Nome de usuário não pode ser nulo ou vazio");
        }

        if (usuarioRepository.findByUsuario(usuario.getUsuario()) != null) {
            throw new RuntimeException("Nome de usuário já está em uso");
        }

//        String senhaCifrada = new BCryptPasswordEncoder().encode(usuario.getSenha());
//        usuario.setSenha(senhaCifrada);
        return usuarioRepository.save(usuario);
    }

    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

	public static void excluirUsuario(Long id) throws UsuarioNotFoundException {
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuarioRepository.delete(usuario);
        } else {
            throw new UsuarioNotFoundException("Usuário não encontrado com o ID: " + id);
        }
		
	}

	public static Usuario atualizarUsuario(Long id, UsuarioDTO usuarioDTO) throws UsuarioNotFoundException {
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            Usuario usuarioExistente = usuarioOptional.get();

            usuarioExistente.setUsuario(usuarioDTO.getUsuario());
            usuarioExistente.setE_mail(usuarioDTO.getE_mail());
            usuarioExistente.setTelefone(usuarioDTO.getTelefone());
            usuarioExistente.setSenha(usuarioDTO.getSenha());
            usuarioExistente.setEndereco(usuarioDTO.getEndereco());
            
            return usuarioRepository.save(usuarioExistente);
        } else {
            throw new UsuarioNotFoundException("Usuário não encontrado com o ID: " + id);
        }
    }
	
}
