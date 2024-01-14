def chave(texto, chave):

    chave = list(chave)

    if len(texto) == len(chave):

        return(chave) 

    else: 

        for i in range(len(texto) - len(chave)): 

            chave.append(chave[i % len(chave)])

    return("" . join(chave))

     

def decifrador(texto, chave):

    decifrado = []

    for i in range(len(texto)): 

        x = (ord(texto[i]) - ord(chave[i])) % 26 

        x += ord('A')

        decifrado.append(chr(x))

    return("" . join(decifrado)) 

     

texto = "NWFWDWDTAFDNOPSZVDVPDOOUPNKAIAFDNOPSHZXDDZS"

p_chave = "AWRLVKV"

chave = chave(texto, p_chave)

decifrado = decifrador(texto,chave)



print("Texto cifrado: ", texto)

print("Texto decifrado: ", decifrado)
