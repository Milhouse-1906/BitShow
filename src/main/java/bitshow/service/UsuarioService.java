package bitshow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitshow.exception.UsuarioNotFoundException;
import bitshow.model.entidade.Usuario;
import bitshow.model.repository.UsuarioRepository;

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

//        String senhaCifrada = new BCryptPasswordEncoder().encode(usuario.getSenha());
//        usuario.setSenha(senhaCifrada);
        return usuarioRepository.save(usuario);
    }

    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

	public boolean excluirUsuario(Long id) throws UsuarioNotFoundException {
		boolean retorno = false;
//		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
//        if (usuarioOptional.isPresent()) {
//        	retorno = true;
//            Usuario usuario = usuarioOptional.get();
            usuarioRepository.deleteById(id);
//        } else {
//            throw new UsuarioNotFoundException("Usuário não encontrado com o ID: " + id);
//        }
		return retorno;
		
	}

//	public Usuario atualizarUsuario(Long id, Usuario usuario) throws UsuarioNotFoundException {
//		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
//
//        if (usuarioOptional.isPresent()) {
//            Usuario usuarioExistente = usuarioOptional.get();
//
//            usuarioExistente.setUsuario(usuario.getUsuario());
//            usuarioExistente.setE_mail(usuario.getE_mail());
//            usuarioExistente.setTelefone(usuario.getTelefone());
//            usuarioExistente.setSenha(usuario.getSenha());
//            usuarioExistente.setEndereco(usuario.getEndereco());
//            
//            return usuarioRepository.save(usuarioExistente);
//        } else {
//            throw new UsuarioNotFoundException("Usuário não encontrado com o ID: " + id);
//        }
//    }

	public List<Usuario> listarTodos() {
		return usuarioRepository.findAll();
	}

	public Usuario atualizarUsuario(Usuario usuario) throws UsuarioNotFoundException{
		return usuarioRepository.save(usuario);
	}
	
}
