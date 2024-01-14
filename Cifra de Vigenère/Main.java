class Main {

  static String tChave(String texto, String chave){ 
  
      int letra = texto.length();
  
      for (int i = 0; ; i++){
  
          if (letra == i)
  
              i = 0;
  
          if (chave.length() == texto.length())
  
              break;
  
          chave += (chave.charAt(i));
  
      }
  
      return chave;
  
  }
  
  static String TxtDecifrado(String texto, String chave){ 
  
      String textoD = " ";
  
      for (int i = 0; i < texto.length(); i++){
  
          int letra =  (texto.charAt(i) - chave.charAt(i) + 26) %26 + 'A';
  
          textoD += (char) letra;
  
      }
  
      return textoD;
  
  }
  
  public static void main(String[] args){
  
      String texto = "QKGGLNIOEERBQRQGDEULQGDNSNNFDPQZLSTZQREEORHZMCTRQBOZSRSZOGSEQRFMYRCZCAMGUBED";
  
      String Palavra = "QZAMZN";
  
    
  
      String chave = tChave(texto, Palavra);
  
      String textoD = TxtDecifrado(texto, chave);
  
    
  
      System.out.println("Texto cifrado: " + texto + "\n");
  
      System.out.println("Texto decifrado: "  + textoD + "\n");
  
      }
  
    }