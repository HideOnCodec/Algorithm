import java.util.*;

class Solution {
    
    public int[] solution(String[] id_list, String[] report, int k) {
        StringTokenizer st;
        HashMap<String,Integer> id = new HashMap<>();
        HashMap<String,HashSet<String>> reportMeMap = new HashMap<>();
        
        for(int i=0; i<id_list.length; i++){
            reportMeMap.put(id_list[i],new HashSet<>());
            id.put(id_list[i],i);
        }        
        for(int i=0; i<report.length; i++){
            st = new StringTokenizer(report[i]," ");
            String reporting = st.nextToken();
            String reported = st.nextToken();
            reportMeMap.get(reported).add(reporting);
        }
        
        int[] answer = new int[id_list.length];
        for(int i=0; i<answer.length; i++){
          if(reportMeMap.get(id_list[i]).size()>=k){
              for(String value : reportMeMap.get(id_list[i]))
                  answer[id.get(value)]++;
          }
        }
        return answer;
    }
}
