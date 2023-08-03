/*
백준 1764번 듣보잡

간단하게 set을 이용하여 풀었다.
set의 교집합을 이용하여 해결한다.
*/

#include<iostream>
#include<algorithm>
#include<vector>
#include<string>
using namespace std;


int main()
{
    int N,M;
    cin >> N >> M;
    vector<string> n,m; //듣도 못한 사람, 보도 못한 사람
    vector<string>::iterator iter;
    vector<string> result(N+M);
    for(int i=0; i<N; i++){
        string s;
        cin >> s;
        n.push_back(s);
    }

    for(int i=0; i<M; i++){
        string s;
        cin >> s;
        m.push_back(s);
    }

    sort(n.begin(),n.end());
    sort(m.begin(),m.end());

    iter = set_intersection(n.begin(),n.end(),m.begin(),m.end(),result.begin());
    result.resize(iter-result.begin());

    cout << result.size() << '\n';

    for(int i=0; i<result.size(); i++)
        cout << result[i] << '\n';
}
