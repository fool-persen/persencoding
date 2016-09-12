#include <iostream>
#include <cstdio>

using namespace std;

class A { 
public:
	A() {
		Print(); 
	}
	virtual void Print() {
		printf("A is constructed.\n"); 
	}
};

class B: public A {
public:
	B() {
		Print(); 
	}
	virtual void Print() {
		printf("B is constructed.\n"); 
	}
};
int main(int argc, char* argv[]) {
	A* pA = new B();
	delete pA; 
	return 0;
}