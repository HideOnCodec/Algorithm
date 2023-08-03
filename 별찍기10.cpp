/*
백준 2447번 별찍기10

계속해서 시간초과가 날 괴롭히던 문제..
별을 먼저 다 찍고 구멍을 뚫는 방식으로 진행했다.

이 문제는 각 패턴의 시작점(기준점)을 구하는 것이 중요하다.
예를 들어 27인 경우 처음 27 : 0,0 -> 9 : 0,0 0,9 ....9,0...18,18..
*틀린 방식*
처음에는 구멍을 먼저 초기부분에 뚫어놓고 num/3한 값을 넣은 채
이중 for문을 이용하여 기준점을 바꿔가면서 star함수를 재귀적으로 호출했다.
재귀문을 이중for문 안에 넣고 돌렸더니 시간 초과가 난 거 같다.

*바꾼 방식*
이중 for문 안에 구멍을 뚫는 함수를 호출한다. 각 기준점을 바꿔가면서 구멍을 뚫는다.
구멍 뚫기가 끝나면 star(num/3)을 한번 재귀호출한다. 이러면 처음 27에서 다음 9, 그 다음 3까지의 패턴으로
재귀적으로 반복되면서 구멍을 뚫을 수 있다.
*/

#include<iostream>
#include<vector>
using namespace std;

char map[6561][6561]; // 3의 8승 
int N;
void blank(int num,int x, int y){ // 빈칸 뚫기
    for(int i=y+num/3; i<y+num/3*2; i++)
        for(int j=x+num/3; j<x+num/3*2; j++)
            map[i][j]=' ';
}
void star(int num){ // 시작점 옮기기
    if(num<3)
        return;
    for(int i=0; i<N; i+=num)
        for(int j=0; j<N; j+=num)
            blank(num,j,i);
    star(num/3);
}
int main(){
    cin >> N;
    for(int i=0; i<N; i++)
        for(int j=0; j<N; j++)
            map[i][j]='*';

    star(N); //별찍기
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++)
            cout << map[i][j];
        cout << '\n';
    }

}
