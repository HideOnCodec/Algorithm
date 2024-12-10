/**
 * 연산의 오류를 방지하기 위해 중간에 나머지 연산을 계속 해서 저장하는 방식
 * (a + b) % T == (a % T + b % T)
 */
class Solution {
    public int solution(int n) {
        int mem[] = new int[n+1];
        mem[0] = 0;
        mem[1] = 1;
        
        for(int i = 2; i <= n; i++){
            mem[i] = (mem[i - 1] + mem[i - 2]) % 1234567;
        }

        return mem[n];
    }
}