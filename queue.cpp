/*
백준 10845번 큐

문자열을 입력받아서 c++의 큐를 이용하여 구현하면 된다.
이 때 문자열을 분리하여 받기 위해서 sstream을 include하고
getline(cin,s) , stringstream ss(s) 를 선언하여 while문을 이용한다.
이를 통해 한 줄의 입력된 공백이 포함된 문자열을 분리할 수 있다.(c++ 방법)
*/

#include<iostream>
#include<sstream>
#include<string>
#include<queue>
#include<vector>
using namespace std;
int main(){
    int N;
    cin >> N;
    cin.ignore(); // 버퍼비우기 
    queue<int> queue;    
    for(int i=0; i<N; i++){
        string s,tmp;
        getline(cin,s);
        stringstream ss(s);

        vector<string> word; 
        while(getline(ss,tmp,' '))
            word.push_back(tmp);
        
        if(word[0].compare("push")==0)
            queue.push(stoi(word[1]));
        else if(word[0].compare("pop")==0){
            if(queue.empty())
                cout << -1 << "\n";
            else{
                cout << queue.front() << '\n';
                queue.pop();
            }
        }
        else if(word[0].compare("size")==0)
            cout << queue.size() << '\n';
        else if(word[0].compare("empty")==0){
            if(queue.empty())
                cout << 1 << '\n';
            else
                cout << 0 << '\n';
        }
        else if(word[0].compare("front")==0){
            if(queue.empty())
                cout << -1 << '\n';
            else 
                cout << queue.front() << '\n';
        }
        else if(word[0].compare("back")==0){
            if(queue.empty())
                cout << -1 << '\n';
            else 
                cout << queue.back() << '\n';
        }
    }
}
