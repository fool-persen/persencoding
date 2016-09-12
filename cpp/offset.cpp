#include <iostream>
using namespace std;

struct Point3D {
	int x;
	int y;
	int z;
};

int main() {
	Point3D* pPoint = NULL;
	pPoint = new Point3D;
	long offset = (long)(&pPoint);
	long offset1 = (long)(&(pPoint)->z);
	long offset2 = (long)(&(pPoint->z));
	cout << offset1 << " " << offset2 << " " << offset << endl;
}
