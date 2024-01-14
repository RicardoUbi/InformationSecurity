# Criptografia de Chaves Assimétricas

## Descrição da Criptografia

Este projeto utiliza criptografia assimétrica, um método de criptografia que envolve o uso de um par de chaves: uma chave pública e uma chave privada. A chave pública é compartilhada e usada para criptografar informações, enquanto a chave privada é mantida em segredo e usada para decifrar essas informações.

Na criptografia assimétrica, qualquer pessoa pode usar a chave pública para criptografar dados, mas apenas a entidade que possui a chave privada correspondente pode decifrar esses dados. Isso oferece uma camada adicional de segurança em comparação com a criptografia simétrica, onde a mesma chave é usada tanto para criptografar quanto para decifrar.

No contexto deste projeto, a mensagem foi inicialmente criptografada usando o algoritmo ChaCha20. Em seguida, a chave ChaCha20 foi encriptada usando o algoritmo RSA, utilizando a chave privada do remetente. O destinatário do projeto deve decifrar a chave ChaCha20 usando a chave pública correspondente e, em seguida, usar essa chave para decifrar a mensagem original.

A criptografia assimétrica é amplamente utilizada em ambientes de comunicação segura na internet, garantindo a confidencialidade e autenticidade dos dados trocados entre partes.

## Informações

Mensagem CHACHA20 cifrada: CxCmmXknBA9aCLuEuvqt4UUJ7eALOYiP0Kg4cjZkLF8Hjdq0Mb4qFKBIaHVefhHg2VTjHPG/7Foo5jUMe4+8Nyf7/lWEdZnkd48nQuBOTL5GSg==

Nonce CHACHA20 da mensagem cifrada: k0OcpEDh4sfih9DF

Contador CHACHA20 da mensagem cifrada: 0

Chave CHACHA20 encriptada: IuEz2WfztP5SqgHdupnhmR8x83LMic5Lyeqd6Ihqyk8KkVqLoLGCuk9qVwu6GDmd4Dh8i2z9AJULaObUxsLo1tgsIi/kqGbqowBnFE1Yn+q3lqPHHLZ0pUiinyUxMmyzWmtx2/aGX/Ba6oLoZf16oUv7RP4JW+W500MLRPr/xe7WJ4kHC5NYHF5lSbYhJ5EcMOawcFfCn8X0E9JAhw+msGT1AFCQPmHUNf6sB8fW8JKhJcI8cPCmMDLgKaB4WD4tk+tMSv3YKI5taXwunbwdtArpTGfNmAYKsugbFt03eKD/Q53dP1gTvvPBO3pjFBNEV/NvOqu7bdUBLxJablYwEg==

Chave Publica : public.key

## Soluções
Neste projeto temos apenas a solução em java.


## Resposta esperada

```bash
Mensagem Decifrada: A vida não é um problema a ser resolvido, mas uma realidade a ser experimentada
 ```
