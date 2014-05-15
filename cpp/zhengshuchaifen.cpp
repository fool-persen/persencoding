/*
  把一个整数拆分成指定个数的数字组合
  ex：6拆分成3个数的组合 114、 123、 222
 */
#include <iostream>
#include <cstdlib>

using namespace std;

/*
  采用递归方式
  nNum 待拆分整数
  num 拆分的个数
  pData 存储拆分结果的数组
  nDepth 整数拆分的深度
  把整数nNum拆分为num个数，可以把问题拆分为把nNum-i拆分为num-1个数，从而是使用递归，此处的i取值为1--nNum/num（为了不重复，拆分第一个数子最大为nNum/num即可）
  nDepth++,num--;num+nDepth=拆分总数
 */
void SegNum(int nNum, int num, int pData[], int nDepth)
{
    if(num == 1)
    {
        pData[nDepth] = nNum; 
        for(int i=0; i<num+nDepth; i++)
            cout << pData[i] << " ";
        cout << endl;
    }
    else
    {
        int i = (nDepth == 0) ? 1 : pData[nDepth-1];//i为拆分的结果，nDepth=0时i=1，否则nDepth取数组中的分层的前一个值，这样可以保证不重复，不会出现213这种情况
        for(; i<=nNum/num; i++)
        {
            pData[nDepth++] = i;
            SegNum(nNum-i, num-1, pData, nDepth);
            nDepth--;
        }
    }
}

int main(int argc, char *argv[])
{
    cout << "整数拆分，参数为整数和拆分个数（6， 3）" << endl;
    int nNum, num;
    nNum = atoi(argv[1]);
    num = atoi(argv[2]);
    int* pData = new int[num];
    SegNum(nNum, num, pData, 0);
    delete [] pData;
    return 0;
}
