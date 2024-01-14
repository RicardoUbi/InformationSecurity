# ação realizada
ESCONDER = 1
REVELAR = 0
# Numeração do alfabeto para trocar
def decifrador(texto, chave, ação):
  alfabeto = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
  ntxt = ''
  for c in texto:
    posi_letra = alfabeto.find(c)
    if posi_letra == -1:
      ntxt += c
    else:
      n_base = posi_letra + chave if ação == ESCONDER else posi_letra - chave
      n_base = n_base % len(alfabeto)
      ntxt += alfabeto[n_base:n_base+1]
  return ntxt
#entrada
original = 'BDLNBBXNQVJRBOANZDNWCNVNWCNJULJWLJMXYXAJZDNUNBZDNWJXBJKNVZDNXOAJLJBBXNQRWNERCJENU'
chave = int(-9)
cifrado = decifrador(original, chave, ESCONDER)
decifrado = decifrador(cifrado, chave, REVELAR)


print('Frase cifrada: ', original)
print('Chave; ', chave)
print('Texto decifrado: ', cifrado)
