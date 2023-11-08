#include <iostream>
#include <windows.h>


int main(int argc, char** argv) {
	SetConsoleOutputCP(1252);
	
	int linha, coluna;
	int matriz[2][2];
	
	for (linha = 0; linha <= 2; linha++){
		for (coluna = 0; coluna <2; coluna++){
			printf("Digite o valor da matriz para linha %d, coluna %d: ", linha, coluna);
			scanf("%d", &matriz[linha][coluna]);			
		}
	}
	
	for(linha = 0; linha <= 2; linha++){
		for(coluna = 0; coluna < 2; coluna++){
			printf("\%d\t", matriz[linha][coluna]);
		}
		printf("Matriz");
		printf("\n\n");
	}
	system("pause");
	
	return 0;
}
