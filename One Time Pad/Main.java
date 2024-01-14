class Main {

  public static void main(String[] args) {

      String texto = "F897320BE34A6CABEF7F2576CF9E199A00133892EC908B1292064619E29EF7BF96FD7B3025D63DAD9E0F9F83EE7CCEB0A41255D0ABD7394A6AFB225447D545";

      String chave = "A9E2572B8C394CD88A0A5656BCF177F26F6018E689B0E777E4632B3992FF85DEB692155440F6528DED6AEAA38D13BCD143F13AF0D8B2532B4A9D47382EAF6B";



      String msgdecifrada = decifrar(texto, chave);

    

      System.out.println("texto cifrado: " + texto +"\n");

      System.out.println("chave: " + chave +"\n");

      System.out.println("mensagem decifrada: " + msgdecifrada +"\n");

  }



  public static String decifrar(String texto, String chave) {

      StringBuilder resultad = new StringBuilder();



      byte[] txtCBytes = hexStringToByteArray(texto);

      byte[] chaveBytes = hexStringToByteArray(chave);



      for (int i = 0; i < txtCBytes.length; i++) {

          int xorResult = Byte.toUnsignedInt(txtCBytes[i]) ^ Byte.toUnsignedInt(chaveBytes[i % chaveBytes.length]);

          resultad.append((char) xorResult);

      }

      return resultad.toString();

  }



  public static byte[] hexStringToByteArray(String hexString) {

      int length = hexString.length();

      byte[] byteArray = new byte[length / 2];

      for (int i = 0; i < length; i += 2) {

          byteArray[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)

                  + Character.digit(hexString.charAt(i + 1), 16));

      }

      return byteArray;

  }

}