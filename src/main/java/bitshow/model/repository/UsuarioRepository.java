package bitshow.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bitshow.model.entidade.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
   
    @Query("SELECT u FROM Usuario u WHERE u.e_mail = :email")
    Usuario findByEmail(String email);
    Object findByUsuario(String usuario);
}
