class Solution {
    static int cnt=0;
    public static void dfs(int sum, int index, int numbers[],int target){
        if(index==numbers.length){
            if(sum==target)
                cnt++;
            return;
        }
        
        dfs(sum+numbers[index]*(-1),index+1,numbers,target);
        dfs(sum+numbers[index],index+1,numbers,target);
    }
    public int solution(int[] numbers, int target) {
        dfs(0,0,numbers,target);
        return cnt;
    }
}
