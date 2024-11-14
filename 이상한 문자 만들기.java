class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        int index = 0;
        for(int i=0; i<arr.length; i++){
            if(Character.isAlphabetic(arr[i])){
                sb.append(index%2==0 ? Character.toUpperCase(arr[i]) 
                                 : Character.toLowerCase(arr[i]));
                index++;
            }
            else{
                sb.append(arr[i]);
                index=0;
            }
        }
        return sb.toString();
    }
}