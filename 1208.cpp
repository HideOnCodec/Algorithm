/*
백준 1208번 부분수열의 합2

부분집합의 개수 = 2^n
2^40이 되면 값이 너무 커서 시간초과가 발생하기 때문에 이분탐색을 이용한다.
수열을 반으로 나눠서 왼쪽끼리의 부분수열의 합과 오른쪽끼리의 부분수열의 합을 따로 구한다.(2^20 시간초과x, 비트 연산자 이용)
이때 이미 정답과 같은 합이 나오면 cnt를 늘려준다.
그리고 왼쪽 수열의 합을 기준으로 하나를 선택하여, 오른쪽 부분 수열의 합들을 모두 돌며 둘을 합했을 때 정답 S가 되는지를 판단한다.
이 과정에서 오른쪽 부분 수열의 합들을 모두 돌 때 단순히 for문을 사용하면 시간초과가 발생한다.(2^20 * 2^20)
따라서 이분탐색을 통해 찾는다. 이 때 만약 왼쪽 합이 5, 정답 S가 8이라면 오른쪽에서 3을 찾아야하는데 이분탐색 특성상
3을 찾은 순간 탐색을 종료한다. 이러면 3이 여러 개 있어도 하나라도 찾는 순간 종료되므로 cnt가 제대로 늘어나지 않는다.
따라서 오른쪽 수열의 합들을 구할 때 미리 같은 합끼리의 개수를 undordered_map을 통해 저장해둔다.(hash map이라 속도가 빠르다)
따라서 이분탐색 시 3을 찾은 순간 cnt++이 아닌 cnt에 3에 해당하는 개수를 더해줘야 한다.
*/

#include<iostream>
#include<vector>
#include<algorithm>
#include<unordered_map>
using namespace std;

int N,S;
long long cnt=0;
vector<long long> seq;
vector<long long> L;
vector<long long> R;
vector<long long> subL;
vector<long long> subR;
unordered_map<long long,int> counterR;

// 부분 수열의 합 저장
vector<long long> search(int direction,vector<long long> arr, long long n){
    vector<long long> sub;
    for(int i=0; i<(1<<n); i++){
        int sum=0;
        bool flag=false;
        for(int j=0; j<n; j++){
            if(i&(1<<j)){ // 해당 원소가 1이면
                sum+=arr[j];
                flag=true;
            }
        } 
        if(flag){
            sub.push_back(sum);
            if(S==sum) cnt++;
            if(direction==1) counterR[sum]++;
        }
    }
    return sub;
}

void binarySearch(int diff){ // 오른쪽 부분에서 존재하는지 이분탐색
    int left=0;
    int right=subR.size()-1;
    int mid;
    while(left<=right){
        mid=(left+right)/2;
        if(diff<subR[mid]) right=mid-1;
        else if(subR[mid]<diff) left=mid+1;
        else{
            cnt+= counterR.find(subR[mid])->second;
            return;
        }
    }
}

int main(){

    cin >> N >> S;
    for(int i=0; i<N; i++){
        int n;
        cin >> n;
        seq.push_back(n);
    }

    sort(seq.begin(),seq.end());
    
    int mid=N/2;
    //반으로 나눠서 왼쪽 오른쪽 각각의 합을 저장
    if(N==1){
        if(seq[0]==S)
            cnt++;
    }
    else{
        
        for(int i=0; i<=mid; i++)
            L.push_back(seq[i]);
        for(int i=mid+1; i<N; i++)
            R.push_back(seq[i]);

        subL=search(0,L,L.size()); // left
        subR=search(1,R,R.size()); // right
        sort(subL.begin(),subL.end());
        sort(subR.begin(),subR.end());
        // 왼쪽 합들마다 S와의 차이를 계산해서 이분탐색으로 오른쪽에 나머지 차이가 존재하는지 검색
        for(int i=0; i<subL.size(); i++){
            int diff=S-subL[i];
            binarySearch(diff); 
        }
    }
    
    cout << cnt;

}
