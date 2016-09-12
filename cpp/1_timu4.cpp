#include <iostream>
#include <cstdio>

using namespace std;

class A { 
private:
	int m_value; 
public:
	A(int value) {
		m_value = value; 
	}
	void Print1() {
		printf("hello world"); 
	}
	virtual void Print2() {
		printf("hello world"); 
	}
};

int main(int argc, char* argv[]) {
	A* pA = NULL; 
	pA->Print1(); 
	pA->Print2();
	return 0; 
}