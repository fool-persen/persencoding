#include <iostream>

using namespace std;

void max_out(int val1,int val2)
{
	cout<<(val1>val2)?val1:val2;
}
/*
int main() {
	int ix=10,jx=20;
	cout<<"The larger of "<<ix;
	cout<<","<<jx<<" is ";
	max_out(ix,jx);
	cout<<endl;
}
*/

int main() {
	char* aa = "abc";
	char* bb = "abc";
	if(aa == bb) {
		cout << "yes" << endl;
	}
}
/*
int main() {
	if(1+3 >= 3) {
		cout << "yes" << endl;
	} else {
		cout << "no" << endl;
	}
	int a=1, b=15, c=0;
	cout << (a>b>c) << endl;
	cout << sizeof("\\0211\"xab") << endl;
}
*/