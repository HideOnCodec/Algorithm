/** 
백준 1062번 : 가르침 
완전 탐색(DFS,백트래킹 이용)

모든 조합을 탐색해야함(단어 내에서 서로 비교하는 것으로는 문제를 풀 수 없다 -> 예시 3번의 경우)
방문 처리 후 dfs 호출, 다시 방문을 초기화 해야함!
**/



import java.util.*;
import java.util.regex.Pattern;
import java.io.*;

public class Main {
    static int k;
    static int n;
    static String word[] = new String[51];
    static int visited[] = new int[26];
    static int max=0;

    static void dfs(int cur, int learn){
        if(learn==k-5){
            int cnt = 0;
            for(int i=0; i<n; i++){
                Boolean flag = true;
                for(int j=0; j<word[i].length(); j++){
                    if(visited[word[i].charAt(j)-97]==0){
                        flag=false;
                        break;
                    }
                }
                if(flag) cnt++;
            }
            max = Math.max(max,cnt);
            return;
        }

        for(int i=cur; i<26; i++){
            if(visited[i]!=1){
                visited[i]=1;
                dfs(i,learn+1);
                visited[i]=0;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        // 기본 a,n,t,i,c
        if(k<5){
            System.out.println(0);
            return;
        }
        visited['a'-97]=1;
        visited['n'-97]=1;
        visited['t'-97]=1;
        visited['i'-97]=1;
        visited['c'-97]=1;

        for(int i=0; i<n; i++){
            String s = br.readLine();
            word[i]=s.substring(4,s.length()-4);
        }

        dfs(0,0);
        System.out.println(max);
    }
}

