def decifrar(texto, chave):
    textoB = bytes.fromhex(texto)
    chaveB = bytes.fromhex(chave)

    resultadoB = bytes(x ^ y for x, y in zip(textoB, chaveB))
    resultado = resultadoB.decode('iso8859-1')

    return resultado

texto = "F897320BE34A6CABEF7F2576CF9E199A00133892EC908B1292064619E29EF7BF96FD7B3025D63DAD9E0F9F83EE7CCEB0A41255D0ABD7394A6AFB225447D545"
chave = "A9E2572B8C394CD88A0A5656BCF177F26F6018E689B0E777E4632B3992FF85DEB692155440F6528DED6AEAA38D13BCD143F13AF0D8B2532B4A9D47382EAF6B"
resultado = decifrar(texto, chave)

print("Texto Cifrado: ", texto)
print("Mensagem decifrada:", resultado)
