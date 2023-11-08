#include <iostream>
#include <windows.h>

int main(int argc, char** argv) {
	SetConsoleOutputCP(1252);
	int val;
	
	printf("Informe quanto você quer contabilizar: ");
	scanf("%d", &val);
	
	for (val; val >=1; val--){
		printf("%d\n", val);
	}
	
	return 0;
}
