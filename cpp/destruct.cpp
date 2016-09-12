#include <iostream>

using namespace std;

class Base {
	public:
		Base() {
			cout << "Base construct" << endl;
		}
		virtual ~Base() {
			cout << "Base destruct" << endl;
		}
		void doSomething() {
			cout << "Base do something" << endl;
		}
};

class Derived : public Base {
	public:
		Derived() {
			cout << "Derived construct" << endl;
		}
		~Derived() {
			cout << "Derived destruct" << endl;
		}
		void doSomething() {
			cout << "Derived do something" << endl;
		}
};

int main() {
	Base* base = new Derived();
	base->doSomething();
	delete base;
}
