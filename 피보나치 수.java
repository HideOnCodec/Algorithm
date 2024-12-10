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