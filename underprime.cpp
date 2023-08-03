/*
백준 1124번 언더프라임

재귀를 이용한 문제.
소수 판단하는 방법은 다음과 같다.

1. 1과 자신을 제외한 숫자로 나누어지면 소수가 아니다. 이 때 n-1까지 반복문을 반복하지 않고
루트 n까지만 반복해도 판단할 수 있다. (어차피 루트 n 이상의 숫자로는 소인수분해될 수 없다)
2. 소수는 미리 100000까지 소수인지 아닌지 판단하는 배열 primeList를 만들어 놓고 사용하면 편하다.
3. 만약 해당 숫자가 초기 i 2로 나누어지면 cnt를 늘리고 숫자를 2로 나눈 값을 넣어 재귀로 호출한다.
만약 2로 나눠지지 않으면, 이 숫자가 자체가 소수일 경우 cnt를 하나 늘리고 함수를 종료한다.
소수가 아닌 경우는, 2가 아닌 더 큰 소수로 나누어질 수 있을 때까지 찾아서 나눈 값을 넣어 재귀호출한다.
*/

#include<iostream>
#include<algorithm>
using namespace std;

bool primeList[100000]={false};

bool prime(int num){ // 소수인지 판단
    if(num==1)
        return false;
    for(int i=2; i*i<=num; i++){
        if(num%i==0)
            return false;
    }
    return true;
}

int underprime(int num,int cnt,int i){
    if(num==1)
        return cnt;
    if(num%i==0)
        cnt=underprime(num/i,cnt+1,i);
    else{
        if(primeList[num])
            return cnt+1;
        else{
            while(true){
                i+=1;
                if(primeList[i]&&num%i==0)
                    break;
            }
            cnt=underprime(num/i,cnt+1,i);
        }
    }
    return cnt;
}
int main(){
    int A,B;
    cin >> A >> B;

    int sum=0;
    for(int i=1; i<100000; i++)
        primeList[i]=prime(i);

    for(int i=A; i<=B; i++){
        int cnt=0;
        cnt = underprime(i,cnt,2);
        if(primeList[cnt])
            sum+=1;
    }
    cout << sum;
}
