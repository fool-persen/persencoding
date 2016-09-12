#include <iostream>
#include <cstdio>
#include <cstdlib>
using namespace std;

int main() {
	char *serviceIa = new char[12];
	char * topFlag = new char[2];
	char * seriNbr = new char[10];
	topFlag = "1";
	seriNbr = "123";
	sprintf(serviceIa,"%02ld%010ld",atol(topFlag),atol(seriNbr));
	cout << serviceIa << endl;
}
