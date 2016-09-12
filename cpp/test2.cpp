#include <iostream> 
#include <stdio.h>
using namespace std;

//class abc;
class abc {
public:
abc(){ printf("abc\r\n");
}
~abc(){ printf("~abc\r\n");
} };
void del(abc *pobj) {
delete pobj; }

int main(){
abc *pobj = new abc; del(pobj);
return 0; }