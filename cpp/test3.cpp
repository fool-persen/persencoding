#include <iostream>
#include <cstdio>
using namespace std;

void exchg(int &x, int &y)
{
int tmp=x; x=y; y=tmp;
printf("x=%d,y=%d\n",x,y);}
int main() {
int a=4;
int b=6;
exchg(a,b); printf("a=%d,b=%d\n", a, b);
return 0;
}