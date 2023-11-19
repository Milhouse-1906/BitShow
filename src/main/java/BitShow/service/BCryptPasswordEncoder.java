package BitShow.service;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class BCryptPasswordEncoder {

    public String encode(String senha) {
        
        String salt = BCrypt.gensalt();

        String senhaCodificada = BCrypt.hashpw(senha, salt);

        return senhaCodificada;
    }
}