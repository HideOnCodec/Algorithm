/*
백준 6236번 용돈관리

이분탐색을 이용한 문제이다.
중요한 것은 처음 right 값을 1~10000이 아닌 전체 돈을 합친 sum값으로 해야한다.(내가 실수한 점)
그리고 인출값보다 하루 쓰는 돈이 많으면 그것 또한 성립이 안되므로 따져줘야한다.
*/

#include<iostream>
#include<vector>

using namespace std;
int N,M; // N일, M번까지 인출 가능
vector<int> money;

bool search(int withdraw){
    int cnt=1;
    int remain = withdraw;
    for(int i=0; i<N; i++){
        if(money[i]>withdraw){
            return false;
        }
        else if(money[i]>remain){
            cnt++;
            remain=withdraw-money[i];
        }
        else{
            remain-=money[i];
        }
    }
    return ((cnt>M) ? false : true);
}

int main(){
    cin >> N >> M;
    for(int i=0; i<N; i++){
        int n;
        cin >> n;
        money.push_back(n);
    }
    int sum=0;
    for(int i=0; i<N; i++)
        sum+=money[i];

    int left = 1;
    int right = sum;
    int mid = (left+right)/2;
    int result=0;
    while(left<=right){
        if(!search(mid)){ // 인출횟수가 많거나 인출금액보다 하루 금액이 크면
            left=mid+1; // 인출 금액을 늘려줌
            mid=(left+right)/2;
        }
        else{// 인출 횟수가 적으면
            right=mid-1;
            result=mid;
            mid=(left+right)/2;
        }
    }

    cout << result;

}
