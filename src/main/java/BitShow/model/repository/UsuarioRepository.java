package BitShow.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BitShow.model.ntidade.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsuario(String usuario);
    
}
