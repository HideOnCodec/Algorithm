/* 
백준 11689번 GCD(n,k) = 1 

오일러 피 함수를 이용하는 문제.
*/

#include<iostream>
#include<vector>

using namespace std;
long long MAX_VALUE = 1000000;

int main(){
    long long n;
    cin >> n;
    // 소인수 찾기
    vector<long long> factors;
    long long tmp = n;
    for(long long i=2; i<=MAX_VALUE; i++){
        if(tmp%i==0){
            factors.push_back(i);
            while(tmp%i==0){
                tmp/=i;
            }
        }
    } 
    if(tmp!=1)
        factors.push_back(tmp);
    //오일러 피 함수
    long long result = n;
    for(int i=0; i<factors.size(); i++){
        result-=result/factors[i];
    }
    cout << result;
}
