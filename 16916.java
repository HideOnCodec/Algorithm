/**
 * 백준 16916번 부분 문자열
 * KMP 알고리즘
 */

import java.util.*;
import java.io.*;

public class Main {
    static int pi[] = new int[1000001];

    static void makePi(String p){
        int index = 0;
        for(int i=1; i<p.length(); i++){
            while(index > 0 && p.charAt(i)!=p.charAt(index)){
                index = pi[index - 1];
            }

            if(p.charAt(index) == p.charAt(i)){
                pi[i] = ++index;
            }
        }
    }
    
    static Boolean kmp(String s, String p){
        int index = 0;
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            while(index > 0 && s.charAt(i) != p.charAt(index)){
                index = pi[index-1];
            }
            if(s.charAt(i)==p.charAt(index)){
                if(index == p.length()-1){
                    cnt++;
                    index = pi[index];
                }
                else
                    index++;
            }
        }
        return cnt > 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();

        makePi(p);
        System.out.println(kmp(s,p) ? 1 : 0);
    }
}
