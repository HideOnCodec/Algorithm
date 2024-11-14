class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            int offset = Character.isUpperCase(arr[i]) ? 'A' : 'a';
            int position = arr[i] - offset;
            if(arr[i]==' ') 
                sb.append(' ');
            else
                sb.append((char)((position+n)%26+offset));
        }
        return sb.toString();
    }
}