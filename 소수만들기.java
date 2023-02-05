class Solution {
    boolean prime(int sum){
        for(int i=2; i<sum; i++){
            if(sum%i==0)
                return false;
        }
        return true;
    } 
    public int solution(int[] nums) {
        int count=0;
        Solution st = new Solution();
        
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int c=j+1; c<nums.length; c++){
                    int sum=nums[i]+nums[j]+nums[c];
                    if(st.prime(sum))
                        count++;
                }
            }
        }

        return count;
    }
}
