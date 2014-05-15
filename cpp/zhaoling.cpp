/*
 *找零钱
 *100块找成1 2 5 10面值的零钱
 *这里使用递归方法，找出所有组合
 */
#include <iostream>

using namespace std;

#define MAX_VALUE 20

int array[] = {1, 2, 5, 10, MAX_VALUE};
int next[MAX_VALUE] = {0};

void SegNum(int nSum, int pData[], int nDepth)
{
    if(nSum < 0)
        return;
    if(nSum == 0)
    {
        for(int i=0; i<nDepth; i++)
        {
            cout << pData[i] << " ";
        }
        cout << endl;
        return;
    }
    int i = (nDepth==0 ? next[0] : pData[nDepth-1]);
    for(; i<MAX_VALUE;)//i的取值不超过边界
    {
        pData[nDepth++] = i;
        SegNum(nSum-i, pData, nDepth);
        nDepth--;
        i = next[i];//取得下一个数
    }
}

void showResult(int array[], int nLen)
{
//获得下一跳数组，即下一个数应该取哪个？
//1 2 5 0 0 10 0 0 0 0 20 0 0 0 0 0 0 0 0 0
    next[0] = array[0];
    int i = 0;
    for(; i<nLen-1; i++)
        next[array[i]] = array[i+1];

    int* pData = new int[MAX_VALUE];
    SegNum(MAX_VALUE, pData, 0);
    delete[] pData;
}

int main()
{
    showResult(array, sizeof(array)/sizeof(int));
    return 0;
}
