#include <iostream>
using namespace std;

class A {
};

class B {
	public:
		B() {};
		~B() {};
};

class C {
	public:
		C() {};
		virtual ~C() {}
};

int main() {
	cout << sizeof(A) << endl;
	cout << sizeof(B) << endl;
	cout << sizeof(C) << endl;
	char c_array[] = {'a', 'b', '\0'};
	char* c_point = c_array;
	cout << sizeof(c_array) << " " << strlen(c_array) << endl;
	cout << sizeof(c_point) << " " << strlen(c_point) << endl;
}
