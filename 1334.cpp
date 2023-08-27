/*
백준 1334번 다음 팰린드롬 수

단순 조건문을 이용한 구현 문제이다.

1. 실수한 점
처음에 숫자를 하나씩 늘려서 팰린드롬인지 아닌지 판단하는 방식으로 구현했다.
N의 자릿 수가 50이므로 int나 longlong으로 구현하지 못하기 때문에 직접 문자열로 1씩 숫자를 늘리는 함수를 구현했었다.
하지만 시간초과가 발생했다. 어쩌면 당연한게 처음부터 자릿 수를 50이나 준 걸 보면 일일히 1씩 늘려서 구하는 방식은 잘못된 것이 뻔했다.

2. 중요한 점
이 문제에서 중요한 것은 현재 수보다 '큰' 바로 다음 펠린드롬을 어떻게 구하냐는 것이다.
펠린드롬은 안쪽부터 바깥쪽까지 쌍을 이루며 같은 숫자이다. 일의 자리 수를 늘린다는 것은 가장 큰 자리의 수를 동시에 늘리게 된다.
예를 들어 1221이라는 숫자가 있으면 1의 값을 2로 늘리는 순간 맨 처음 자리 수인 1또한 같이 늘어나고 2222가 된다.
결국 현재 수 보다 큰 수 중에서 최소의 펠린드롬이 되려면 가장 가운데 숫자부터 늘려야한다. 즉 1221을 2222로 늘리는 것이 아니라 1331로 늘려야한다.
*/

#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

bool smaller(string N,string str){
    int mid=N.size()/2;
    for(int i=mid; i<N.size(); i++){
        if(N[i]>str[i])
            return true;
        else if(N[i]<str[i])
            return false;
    }
    return true;
}

int main(){
    string N;
    cin >> N;

    int mid=N.size()/2;
    string str=N;
    for(int i=0; i<mid; i++){
        if(str[i]!=str[str.size()-1-i]) // 양쪽 끝부터 비교
            str[str.size()-1-i]=str[i];
    } 
    if(smaller(N,str)){ //더 작은 숫자가 되면
        if(str.size()%2==0){ // 짝수 길이면 가운데 두 개 1 증가
            if(str[mid-1]=='9'){ // 9일 경우 자릿수 증가
                int start=mid-1, end = mid;
                while(0<=start&&mid<str.size()){
                    str[start]='0',str[end]='0';
                    if(start==0&&end==str.size()-1){
                        str[end]='1';
                        str="1"+str;
                        break;
                    }
                    else{
                        if(str[start-1]!='9'){
                            str[start-1]++, str[end+1]++;
                            break;
                        }
                    }
                    start--, end++;
                }
            }
            else{
                str[mid-1]++;
                str[mid]++;
            }
        }
        else{ // 홀수 길이면 가운데 1 증가
            if(str[mid]=='9'){ // 9일 경우 자릿수 증가
                int start=mid,end=mid;
                while(0<=start&&end<str.size()){
                    str[start]='0',str[end]='0';
                    if(start==0){
                        str[end]='1';
                        str="1"+str;
                        break;
                    }
                    else{
                        if(str[start-1]!='9'){
                            str[start-1]++, str[end+1]++;
                            break;
                        }
                    }
                    start--, end++;
                }
            }
            else
                str[mid]++;
        }
    }
    
    cout << str;
}
