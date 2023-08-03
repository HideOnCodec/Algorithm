/*
백준 10828번 스택

queue문제와 마찬가지로 sstream을 이용하여 문자열을 분리받고,
stack을 include하여 stack을 구현하면 된다.

* 문자열끼리 비교할 때는 compare함수를 사용해야된다.

*/
#include<iostream>
#include<sstream>
#include<string>
#include<stack>
#include<vector>
using namespace std;
int main(){
    int N;
    cin >> N;
    cin.ignore();
    stack<int> stack;    
    for(int i=0; i<N; i++){
        string s,tmp;
        getline(cin,s);
        stringstream ss(s);

        vector<string> word; 
        while(getline(ss,tmp,' '))
            word.push_back(tmp);
        
        if(word[0].compare("push")==0)
            stack.push(stoi(word[1]));
        else if(word[0].compare("pop")==0){
            if(stack.empty())
                cout << -1 << "\n";
            else{
                cout << stack.top() << '\n';
                stack.pop();
            }
        }
        else if(word[0].compare("size")==0)
            cout << stack.size() << '\n';
        else if(word[0].compare("empty")==0){
            if(stack.empty())
                cout << 1 << '\n';
            else
                cout << 0 << '\n';
        }
        else if(word[0].compare("top")==0){
            if(stack.empty())
                cout << -1 << '\n';
            else 
                cout << stack.top() << '\n';
        }
    }
}
