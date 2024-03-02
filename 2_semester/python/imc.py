def calcular_imc(peso, altura):
    return peso / altura ** 2

def classificar_imc(imc):
    if imc < 18.5:
        return "Abaixo do peso"
    elif imc < 25:
        return "Peso normal"
    elif imc < 30:
        return "Sobrepeso"
    else:
        return "Obeso"

peso = float(input("Digite o peso em quilogramas: "))
altura = float(input("Digite a altura em metros: "))

imc = calcular_imc(peso, altura)

classificacao = classificar_imc(imc)

print(f"Seu IMC é: {imc:.2f}")
print(f"Classificação: {classificacao}")