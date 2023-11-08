#include <iostream>

int main(int argc, char** argv) {
	int i;
	
	do{
		printf("\n Escolha o sabor:\n");
		printf("\n\t (1)...Flocos \n");
		printf("\t (2)...Morango \n");
		printf("\t (3)...Baunilha \n");
		printf("\nDigite sua escolha: ");
		scanf("%d", &i);
	}while((i<1) || (i>3));
	
	switch(i){
		case 1:
			printf("\nEstamos preparando o sorvete de floicos...");
		break;
		case 2:
			printf("\nEstamos preparando o sorvete de Morango...");
		break;
		case 3:
			printf("\nEstamos preparando o sorvete de Baunilha...");
		break;
		
	}
	return 0;
}
