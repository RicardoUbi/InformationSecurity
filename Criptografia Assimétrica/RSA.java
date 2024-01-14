import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.ChaCha20ParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class RSA {
    public static void main(String[] args) throws Exception {

        // STRINGS RSA
        String cipherRSA = "IuEz2WfztP5SqgHdupnhmR8x83LMic5Lyeqd6Ihqyk8KkVqLoLGCuk9qVwu6GDmd4Dh8i2z9AJULaObUxsLo1tgsIi/kqGbqowBnFE1Yn+q3lqPHHLZ0pUiinyUxMmyzWmtx2/aGX/Ba6oLoZf16oUv7RP4JW+W500MLRPr/xe7WJ4kHC5NYHF5lSbYhJ5EcMOawcFfCn8X0E9JAhw+msGT1AFCQPmHUNf6sB8fW8JKhJcI8cPCmMDLgKaB4WD4tk+tMSv3YKI5taXwunbwdtArpTGfNmAYKsugbFt03eKD/Q53dP1gTvvPBO3pjFBNEV/NvOqu7bdUBLxJablYwEg==";
        String keyRSA = "/Downloads/public.key"; //Substitua pelo diretório do arquivo

        // STRINGS CHACHA20
        String cipherText = "CxCmmXknBA9aCLuEuvqt4UUJ7eALOYiP0Kg4cjZkLF8Hjdq0Mb4qFKBIaHVefhHg2VTjHPG/7Foo5jUMe4+8Nyf7/lWEdZnkd48nQuBOTL5GSg==";
        String nonceText = "k0OcpEDh4sfih9DF";
        int counter = 0;

        try {
            // RSA
            PublicKey keyBytesRSA = carregarChavePublica(keyRSA);
            byte[] KEYchacha20Decrypt = decryptRSA(cipherRSA, keyBytesRSA);
            // CHACHA20
            byte[] cipherBytes = Base64.getDecoder().decode(cipherText);
            byte[] nonceBytes = Base64.getDecoder().decode(nonceText);
            byte[] decryptedBytes = decryptCHACHA20(cipherBytes, KEYchacha20Decrypt, nonceBytes, counter);
            String decryptedText = new String(decryptedBytes);
            System.out.println("Mensagem decifrada: " + decryptedText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PublicKey carregarChavePublica(String keyRSA) throws IOException {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            File publicKeyFile = new File(keyRSA);
            byte[] publicKeyBytes = Files.readAllBytes(publicKeyFile.toPath());
            EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
            return keyFactory.generatePublic(publicKeySpec);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    // Descriptar RSA
    private static byte[] decryptRSA(String mensagemCriptografada, PublicKey chavePublica) throws Exception {
        try {
            byte[] cipherText = Base64.getDecoder().decode(mensagemCriptografada);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, chavePublica);
            return cipher.doFinal(cipherText);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    // Descriptar ChaCha20
    public static byte[] decryptCHACHA20(byte[] cipherBytes, byte[] key, byte[] nonce, int counter) {
        try {
            Cipher cipher = Cipher.getInstance("ChaCha20");
            ChaCha20ParameterSpec paramSpec = new ChaCha20ParameterSpec(nonce, counter);
            SecretKeySpec keySpec = new SecretKeySpec(key, "ChaCha20");
            cipher.init(Cipher.DECRYPT_MODE, keySpec, paramSpec);
            return cipher.doFinal(cipherBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

