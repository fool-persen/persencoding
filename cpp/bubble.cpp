#include <iostream>
using namespace std;
void swap(int& a, int& b) {
	int tmp;
	tmp = a;
	a = b;
	b = tmp;
}
void bubble(int array[], int lenth) {
	for(int i=0; i<lenth; i++) {
		for(int j=0; j<lenth-1-i; j++) {
			if(array[j] < array[j+1]) {
				swap(array[j], array[j+1]);
			}
		}
	}
}

int main()
{
	int array[] = {5, 6, 3, 2, 1};
	for(int i=0; i<5; i++) {
		cout << array[i] << " " ;
	}
	cout << endl;
	bubble(array, 5);
	for(int i=0; i<5; i++) {
		cout << array[i] << " " ;
	}
	cout << endl;

}
