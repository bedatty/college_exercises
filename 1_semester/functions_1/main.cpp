#include <iostream>


float calcular_massa(float a, float b){
	const float mA=321.43;
	const float mB=150.72;
	
	printf("\n 1,2 : 1,0 \t: = %f", (1,2*mA+1*mB));
	printf("\n 1,4 : 1,0 \t: = %f", (1,4*mA+1*mB));
	printf("\n 1,0 : 1,6 \t: = %f", (1*mA+6*mB));
	
	return (a*mA) + (b*mB);
}


int main(int argc, char** argv) {
	float a=0, b=0, result=0;
	
	printf("\n Qual as massas do elemento A: ");
	scanf("%f", &a);
	printf("\n E do elemento B: ");
	scanf("%f", &b);
	
	result = calcular_massa(a,b);
	printf("\n Resultado: %f", result);
	return 0;
}
