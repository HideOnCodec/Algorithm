/**
 * 백준 14226번 이모티콘
 * BFS 알고리즘
 * BFS를 풀 때 노드 클래스를 살펴보면 이모티콘 수 뿐만 아니라 클립보드의 수를 따진다.
 * 따라서 visited 배열을 단순히 이모티콘 수의 방문만을 체크하는 것이 아니라
 * 클립보드의 수도 동시에 체크해야됨을 잊지 말아야한다.
 * 단, 여기서 time은 그래프에서의 거리를 세는 것이므로 방문 체크는 필요없다.
 */

import java.util.*;
import java.io.*;

class Node{
    int node;
    int clipboard;
    int time;

    public Node(int node, int clipboard, int time){
        this.node = node;
        this.clipboard = clipboard;
        this.time = time;
    }
}

public class Main {
    static int[][] visited = new int[1001][1001]; // 0 : node, 1 : clipboard
    static int s;
    static void bfs(){
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(1,0,0));
        visited[1][0]=1;

        while(!deque.isEmpty()){
            Node now = deque.poll();

            if(now.node==s){
                System.out.println(now.time);
                return;
            }
            // 1
            if(visited[now.node][now.node]==0){
                deque.add(new Node(now.node,now.node,now.time+1));
                visited[now.node][now.node]=1;
            }
            // 2
            int next = now.node+now.clipboard;
            if(now.clipboard!=0 && next <= s && visited[next][now.clipboard]==0){
                deque.add(new Node(next,now.clipboard, now.time+1));
                visited[next][now.clipboard]=1;
            }
            //3
            next = now.node-1;
            if(0<=next&&visited[next][now.clipboard]==0){
                deque.add(new Node(next,now.clipboard,now.time+1));
                visited[next][now.clipboard]=1;
            }

        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(br.readLine());

        bfs();
    }
}
 
