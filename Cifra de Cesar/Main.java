class Main {

    public static void main(String[] args) {
    
        StringBuilder textoDecifrado = new StringBuilder();
    
        String texto = "BDLNBBXNQVJRBOANZDNWCNVNWCNJULJWLJMXYXAJZDNUNBZDNWJXBJKNVZDNXOAJLJBBXNQRWNERCJENU"; 
    
        int chave = 9; 
    
        while (chave >= 26) { //CORREÇÃO DA CHAVE, CASO SEJA MAIOR QUE O ALFABETO.
    
            chave = 26 - chave;
    
        }
    
        for (int i = 0; i < texto.length(); i++) { //CONTAGEM DE CARACTERES DEFININDO POSIÇÃO
    
          int novaL = (char) (texto.charAt(i) - chave);//POSIÇÃO COM O DESLOCAMENTO
    
          while (novaL < 65) {// NOVA POSIÇÃO A SER OCUPADA
    
            novaL += 90;
    
            novaL -= 64;
    
          }
    
          textoDecifrado.append((char) novaL);      
    
          }
    
        System.out.println("Texto Cifrado: " + texto +"\n");
    
        System.out.println("Chave de Deslocamento: "+ chave +"\n");
    
        System.out.println("Texto Decifrado: " + textoDecifrado +"\n");
    
    
      }
    
    } 
    