#include <iostream>
#include <cstdio>

using namespace std;

struct Point3D {
	int x; 
	int y; 
	int z;
};
int main(int argc, char* argv[])
{
	Point3D* pPoint = NULL;
	int offset = (int)(&pPoint);
	printf("%d", offset);
	return 0; 
}