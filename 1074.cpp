/*
백준 1074번 Z

재귀를 이용한 문제. 배열을 이용하려고 하면 2의15승으로 최대 배열 크기를 초과하여 에러가 발생함.(int 배열 최대 100000 정도)
그냥 좌표 값으로 구하며 사분면을 생각하는 것이 중요하다.
처음에 그냥 재귀를 돌렸더니 시간초과가 발생한다. 구하려는 행,렬이 재귀 호출시의 해당하는 사분면 안에 있냐 없냐를 따져서
사분면 안에 존재하는 경우만 재귀를 호출함으로써 시간을 줄일 수 있다.
*/

#include<iostream>
#include<cmath>
using namespace std;
int N,r,c;

void recur(int n, int num, int row, int col){
    if(row==r&&col==c){
        cout << num << endl;
        return;
    }
    if(n<1)
        return;

    int plus = int(pow(4,n-1)); // 4등분 했을 때 각 기준점 (4의 n-1승)씩 늘어남
    if(row<=r&&r<row+int(pow(2,n)) && col<=c&&c<col+int(pow(2,n))){
        // 해당 사분면 안에 있을 때만 실행
        recur(n-1,num,row,col);
        recur(n-1,num+plus,row,col+int(pow(2,n-1)));
        recur(n-1,num+plus*2,row+int(pow(2,n-1)),col);
        recur(n-1,num+plus*3,row+int(pow(2,n-1)),col+int(pow(2,n-1)));
    }    
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> N >> r >> c;

    recur(N,0,0,0);
}
