package med.voll.api.infra.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GerarSenhas {
        public static void main(String[] args) {
            // Supondo que a senha do usuário seja "123456"
            String plainPassword = "123456";

            // Codificando a senha usando BCrypt
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(plainPassword);

            System.out.println("Senha codificada em BCrypt: " + encodedPassword);

            // Verificando se a senha fornecida corresponde à versão codificada
            boolean isMatch = encoder.matches(plainPassword, encodedPassword);
        }
    }