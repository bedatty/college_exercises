#include <iostream>
#include <windows.h>

int main(int argc, char** argv) {
	SetConsoleOutputCP(1252);
	
	float sal, inss, ir, sal_liq;
	
	printf("Qual o seu salário bruto?\n");
	scanf("%f", &sal);
	
	if(sal <= 1693.72){
		inss = sal * 0.08;
	}
	else if(sal >= 1693.73 && sal <= 2822.90){
		inss = sal * 0.09;
		if (sal >=1903.99 && sal <= 2822.90){
			ir = sal * 0.075;
		}
	}
	else if(sal >= 2822.91 && sal <= 5646.80){
		inss = sal * 0.11;
		
		if(sal >= 2822.91 && sal <= 2826.65){
			ir = sal * 0.075;
		}
		else if (sal >= 2826.66 && sal <= 3751.05){
			ir = sal * 0.15;
		}
		else if (sal >= 3751.05 && sal <= 4664.68){
			ir = sal * 0.225;
		}
		else if (sal >= 4665.69){
			ir = sal * 0.275;
		}
	}
	else if (sal >= 5646.81){
		inss = 612.04;
	}
	
	sal_liq = sal - ir - inss;
	printf ("\n Salário líquido será: R$%2.2f", sal_liq);
	return 0;
}
