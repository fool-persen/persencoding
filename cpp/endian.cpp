#include <iostream>

using namespace std;

union data {
	int ll;
	char cc[4];
};

int main() {
	union data uu;
	uu.ll = 1;
	for(int i=0; i<4; i++) {
		printf("%x\n", uu.cc[i]);
	}
	printf("%x\n", uu.cc[0]);
	return 0;
}
