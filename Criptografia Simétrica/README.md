
# Criptografia Simétrica

## Descrição da Criptografia

Este projeto envolve a decifração de uma mensagem cifrada usando o algoritmo ChaCha20. A chave de criptografia dessa mensagem foi também cifrada usando o algoritmo AES/CBC/PKCS5Padding e salva em um arquivo com a extensão `.enc`. O objetivo é carregar o arquivo como um array de bytes, decifrar a chave ChaCha20 e, em seguida, usar essa chave para decifrar a mensagem original.


## Informações

Mensagem CHACHA20 cifrada: 8+iDjAdbjaeK5/6XM3ztV3Qmj7Akj+fsgiQ0q+UNs44WczWOmcKw9MTHplh64bEXw8LWGEmpSNFTOWwyuA==

Nonce CHACHA20 da mensagem cifrada: OpLk4OoQFw9p1Iqa

Contador CHACHA20 da mensagem cifrada: 0

IV AES do arquivo cifrado: X7V+a95m44s+pC7w21Vqyg==

Chave AES do arquivo cifrado: qBGHDVgFdCTOq2QBvdC2rayPWFnjnkeZToGr7BPZ6h0=

Arquivo `.enc`: Arquivo.enc

## Soluções
Neste projeto temos apenas a solução em java.


## Resposta esperada

```bash
Mensagem decifrada: Dias bons trazem felicidade e dias ruins trazem experiência.
 ```

