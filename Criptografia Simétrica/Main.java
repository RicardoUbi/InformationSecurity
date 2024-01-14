package criptomoeda;



import javax.crypto.SecretKey;

import javax.crypto.spec.IvParameterSpec;

import javax.crypto.spec.SecretKeySpec;

import javax.crypto.Cipher;

import java.util.Base64;

import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

import java.security.InvalidKeyException;

import java.security.InvalidAlgorithmParameterException;

import javax.crypto.IllegalBlockSizeException;

import javax.crypto.BadPaddingException;

import java.io.File;

import java.io.IOException;

import java.nio.file.Files;

import javax.crypto.spec.ChaCha20ParameterSpec;



public class ETH {



public static void main(String[] args) {



// STRINGS AES

String cipherAES = "/Downloads/Arquivo.enc";

String keyAES = "qBGHDVgFdCTOq2QBvdC2rayPWFnjnkeZToGr7BPZ6h0=";

String ivAES = "X7V+a95m44s+pC7w21Vqyg==";

String algorithm = "AES/CBC/PKCS5Padding";



// STRINGS CHACHA20

String cipherText = "8+iDjAdbjaeK5/6XM3ztV3Qmj7Akj+fsgiQ0q+UNs44WczWOmcKw9MTHplh64bEXw8LWGEmpSNFTOWwyuA==";

String nonceText = "OpLk4OoQFw9p1Iqa";

int counter = 0;



try {

// AES

byte[] fileBytesAES = readBytesFromFile(cipherAES);

byte[] keyBytesAES = Base64.getDecoder().decode(keyAES);

byte[] ivBytesAES = Base64.getDecoder().decode(ivAES);

byte[] DecryptedBytesAES = decryptAES(algorithm, fileBytesAES, keyBytesAES, ivBytesAES);

String decryptedTextAES = new String(DecryptedBytesAES);

System.out.println("AES: " + decryptedTextAES);



// CHACHA20

byte[] cipherBytes = Base64.getDecoder().decode(cipherText);

byte[] nonceBytes = Base64.getDecoder().decode(nonceText);

byte[] decryptedBytes = decryptCHACHA20(cipherBytes, DecryptedBytesAES, nonceBytes, counter);

String decryptedText = new String(decryptedBytes);

System.out.println("ChaCha20: " + decryptedText);



} catch (IOException e) {

e.printStackTrace();

}

}



// Ler o arquivo

public static byte[] readBytesFromFile(String filePath) throws IOException {

File file = new File(filePath);

return Files.readAllBytes(file.toPath());

}



// Descriptar AES

public static byte[] decryptAES(String algorithm, byte[] cipherBytes, byte[] keyBytes, byte[] ivBytes) {

byte[] DecryptedBytesAES = null;

SecretKey key = new SecretKeySpec(keyBytes, "AES");

IvParameterSpec iv = new IvParameterSpec(ivBytes);

try {

Cipher cipher = Cipher.getInstance(algorithm);

cipher.init(Cipher.DECRYPT_MODE, key, iv);

DecryptedBytesAES = cipher.doFinal(cipherBytes);

} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException

| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

e.printStackTrace();

}

return DecryptedBytesAES;

}



// Descriptar ChaCha20

public static byte[] decryptCHACHA20(byte[] cipherBytes, byte[] key, byte[] nonce, int counter) {

byte[] decryptedBytes = null;

Cipher cipher;

try {

cipher = Cipher.getInstance("ChaCha20");

ChaCha20ParameterSpec paramSpec = new ChaCha20ParameterSpec(nonce, counter);

SecretKeySpec keySpec = new SecretKeySpec(key, "ChaCha20");

cipher.init(Cipher.DECRYPT_MODE, keySpec, paramSpec);

decryptedBytes = cipher.doFinal(cipherBytes);

} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException

| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

e.printStackTrace();

}

return decryptedBytes;

}

}