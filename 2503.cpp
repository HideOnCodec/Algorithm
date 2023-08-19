/*
백준 2503번 숫자 야구

브루트포스를 이용한 문제.
해당하는 숫자를 일일히 추가할 생각하지 말고
안되는 숫자를 전체에서 뺄 생각을 하자.
이 숫자가 주어진 숫자와 비교했을 때 strike,ball이 몇 개가 되는지를 세면 됨.
*/

#include<iostream>
#include<vector>
#include<string>

using namespace std;

int N;
vector<int> possible(1000,0);

void init(){ // 0이 들어가거나 같은 숫자가 있는 수를 제외
    for(int i=123; i<1000; i++){
        string str = to_string(i);
        if(str[0]=='0'||str[1]=='0'||str[2]=='0')
            possible[i]=-1;
        if(str[0]==str[1]||str[1]==str[2]||str[0]==str[2])
            possible[i]=-1;
    }
}

void baseball(string answer, int strike, int ball){
    // 각 수마다 질문에 나온 수와 비교했을 때의 strike, ball을 계산하여 다르면 제외시킴 
    for(int i=123; i<1000; i++){ 
        int s=0;
        int b=0;
        if(possible[i]!=-1){
            string str=to_string(i);
            for(int j=0; j<3; j++){
                if(str[j]==answer[j])
                    s++;
                else if(str[j]!=answer[j]&&answer.find(str[j])!=string::npos)
                    b++;
            }
            if(strike!=s||ball!=b)
                possible[i]=-1;
        }
    }
}

int main(){
    string answer;
    int strike, ball;
    init();
    cin >> N;
    for(int i=0; i<N; i++){
        cin >> answer >> strike >> ball;
        baseball(answer,strike,ball);
    }
    
    int cnt=0;
    for(int i=123; i<1000; i++){
        if(possible[i]!=-1)
            cnt++;
    }

    cout << cnt;
}
