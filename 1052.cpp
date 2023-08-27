/*
백준 1052번 물병

물병을 합칠 때 몇 리터씩 증가하는지 잘 지켜보자.
2의 배수로 늘어나는 점이 핵심이다.
즉 비트연산을 이용한다.
*/

#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

long long cnt=0;
vector<int> bit;
int purchase=0;
int N, K;

int main(){
    cin >> N >> K;    
    cnt=N;
    bit.push_back(N);
    int i=0;
    while(cnt>K){
        int s=bit[i]/2;
        if(s<1&&i==0){
            purchase+=2-bit[i];
            bit[i]=2;
            s=1;
        }
        else if(s<1&&i>0){
            i--;
            continue;
        }
        bit[i]%=2;
        if(bit.size()-1==i) bit.push_back(s);
        else bit[i+1]+=s;
        cnt=0;
        for(int j=0; j<bit.size(); j++)
            cnt+=bit[j];
        i++;
    }

    cout << purchase;
}
