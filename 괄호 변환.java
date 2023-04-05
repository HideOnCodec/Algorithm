import java.util.*;
class Solution {
    static boolean judge(String s){
        int left=0;
        if(s.charAt(0)==')') return false;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') left++;
            else{
                left--;
                if(left<0) return false;
            }
        }
        return true;
    }
    static String recur(String s){
        if(s.equals("")||judge(s)) return s;
        int left=0,right=0,i=0;
        for(i=0;i<s.length(); i++){
            if(s.charAt(i)=='(') left++;
            else right++;

            if(left==right) break;
        }
        String u = s.substring(0,i+1);//u
        String v = s.substring(i+1,s.length());//v
        System.out.println("u : "+u+"v : "+v);
        if(judge(u)) //u가 올바른 괄호 문자열
            return u+recur(v); //나머지 v를 1단계부터 다시 수행
        else{ //u가 올바른 괄호 문자열이 아님
            String str ="("+recur(v)+")";
            char[] u2;
            if(u.length()>2) {
                u2 = u.substring(1, u.length()-1).toCharArray();
                for(int j=0; j<u2.length; j++){
                    if(u2[j]=='(')
                        u2[j]=')';
                    else
                        u2[j]='(';
                    str += u2[j];
                }
            }
            return str;
        }
    }
    public String solution(String p) {
        return recur(p);
    }
}
