# Criptografia com Código de Autenticação de Mensagem (MAC)

## Descrição da Criptografia

A Criptografia com Código de Autenticação de Mensagem, ou simplesmente MAC (Message Authentication Code), é uma técnica fundamental na segurança da informação. O MAC é uma forma de garantir a autenticidade e integridade de uma mensagem.

E este projeto simula uma autenticação por chave, onde você utilizará informações como senha, sal e algoritmo de geração de chave para gerar uma chave e compará-la com uma chave proposta. As chaves precisam ser iguais para a autenticação ser bem-sucedida.



## Informações

A senha está no formato de string.

O sal está em formato Base64.

Algoritmo: PBKDF2WithHmacSHA512

Iterações: 65536

Tamanho da chave: 512

Senha: R!c@rd0Ub!r@j@r@T&rr&5d05S@nt05F!1h0

Sal: HCzOP4/7VQzv7sfhQcgGEA==

Chave: uf2Us3RpNlwCC7vWY0dA7szAGTZHQYcIdc1OT9cZOV2tl6VYn5LSkR66nLmb88QRkMLZEYgGIzP6IhPuMrEJsw==

## Soluções
Neste projeto temos apenas a solução em java.


## Resposta esperada

```bash
Autenticado
Chave Proposta em array de bytes: [B@61e717c2
Chave Derivada em array de bytes: [B@66cd51c3
Chave Proposta em base 64: uf2Us3RpNlwCC7vWY0dA7szAGTZHQYcIdc1OT9cZOV2tl6VYn5LSkR66nLmb88QRkMLZEYgGIzP6IhPuMrEJsw==
Chave Derivada em base 64: uf2Us3RpNlwCC7vWY0dA7szAGTZHQYcIdc1OT9cZOV2tl6VYn5LSkR66nLmb88QRkMLZEYgGIzP6IhPuMrEJsw==
 ```


