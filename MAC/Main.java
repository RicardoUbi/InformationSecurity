import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // Strings
        String senha = "R!c@rd0Ub!r@j@r@T&rr&5d05S@nt05F!1h0";
        String salBase64 = "HCzOP4/7VQzv7sfhQcgGEA==";
        String chavePropostaBase64 = "uf2Us3RpNlwCC7vWY0dA7szAGTZHQYcIdc1OT9cZOV2tl6VYn5LSkR66nLmb88QRkMLZEYgGIzP6IhPuMrEJsw==";

        // Converter para array de bytes
        byte[] sal = Base64.getDecoder().decode(salBase64);
        byte[] chaveProposta = Base64.getDecoder().decode(chavePropostaBase64);

        // Parâmetros do PBKDF2
        int iteracoes = 65536;
        int tamanhoChave = 512;
        PBEKeySpec spec = new PBEKeySpec(senha.toCharArray(), sal, iteracoes, tamanhoChave);

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");

        // Gerar a chave derivada
        byte[] chaveDerivada = factory.generateSecret(spec).getEncoded();

        String chaveDerivadaBase64 = Base64.getEncoder().encodeToString(chaveDerivada);

        // Comparação entre chaves
        boolean autenticado = java.util.Arrays.equals(chaveDerivada, chaveProposta);

        if (autenticado) {
            System.out.println("Autenticado");
            System.out.println("Chave Proposta em array de bytes: "+chaveProposta);
            System.out.println("Chave Derivada em array de bytes: "+chaveDerivada);
            System.out.println("Chave Proposta em base 64: "+chavePropostaBase64);
            System.out.println("Chave Derivada em base 64: "+chaveDerivadaBase64);


        } else {
            System.out.println("Falha na autenticação");
            System.out.println("Chave Proposta em array de bytes: "+chaveProposta);
            System.out.println("Chave Derivada em array de bytes: "+chaveDerivada);
            System.out.println("Chave Proposta em base 64: "+chavePropostaBase64);
            System.out.println("Chave Derivada em base 64: "+chaveDerivadaBase64);
        }
    }
}
