algoritmo "Pot�ncia"
// Disciplina  : Algoritmos e Programa��o Estruturada
// Professor(a):
// Descri��o   : Pot�ncia
// Autor(a)    : Lucas Bedatty
// Data atual  : 25/02/2024
var
   base, expoente, resultado: Real
   b: Inteiro

inicio
   resultado <- 1

   Escreva("Informe a base: ")
   Leia(base)

   Escreva("Informe o expoente: ")
   Leia(expoente)

   b <- 1
   Enquanto b <= expoente Faca
      resultado <- resultado * base
      b <- b + 1
   FimEnquanto

   Escreva("O resultado de ", base, " elevado a ", expoente, " �: ", resultado)
fimalgoritmo