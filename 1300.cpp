/*
백준 1300번 K번째 수

이진탐색을 이용하는 문제이다.
임의의 수 x보다 작은 수의 갯수가 K라면 x는 자연스레 K번째 수가 된다는 것을 이용한다.
단, x는 여러 개가 존재할 수 있음을 유의하자.
*/

#include<iostream>
using namespace std;
using ll = long long;

ll N, k;
ll same = 0;
ll smallerNumCount(ll n){
    ll before = n/N;
    if(n%N == 0)
        before--;

    ll result1 = before * N;
    ll after;
    ll result2 = 0;
    for(ll i=before+1; i<=N; i++){
        if(n/i==0)
            break;
        if(n%i==0){ 
            after=n/i-1;
            same++;
         }
         else
            after=n/i;
        result2+=after;
    }
    return result1+result2;
}

int main(){
    cin >> N;
    cin >> k;

    ll left = 1;
    ll right = 10000000000;
    ll mid = (left+right)/2;
    while(left<=right){
        same=0;
        ll cnt = smallerNumCount(mid); //mid보다 작은 수들이 갯수
        if(cnt<k && k<=cnt+same)
            break;
        else if(cnt>k-1)
            right = mid-1;
        else if(cnt+same<k)
            left=mid+1;
        
        mid = (left+right)/2;
    }

    cout << mid;
}
