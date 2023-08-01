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
