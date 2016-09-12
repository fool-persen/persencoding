#include <iostream>
#include <cstdio>

using namespace std;

class A {
};
class B { public:
B() {}
~B() {} };
class C { public:
C() {}
virtual ~C() {} };
int main(int argc, char* argv[]) {
printf("%d, %d, %d\n", sizeof(A), sizeof(B), sizeof(C));
return 0; }