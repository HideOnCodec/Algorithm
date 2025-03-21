import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays){
        Map<String, List<Integer>> map = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            map.computeIfAbsent(genres[i], k -> new ArrayList<>());
            map.get(genres[i]).add(i);
            count.put(genres[i], count.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 장르 정렬
        List<String> kind = new ArrayList<>(count.keySet());
        Collections.sort(kind, (s1, s2) -> count.get(s2) - count.get(s1));
        
        // 장르 속 음악 정렬
        for(List<Integer> musicList : map.values()){
            Collections.sort(musicList, (n1, n2) ->{
                if(plays[n1] == plays[n2]){
                    return n1 - n2;
                }
                else{
                    return plays[n2] - plays[n1];
                }
            });
        }
        
        // 베스트 앨범 생성
        List<Integer> best = new ArrayList<>();
        for(String genre : kind){
            best.add(map.get(genre).get(0));
            if(map.get(genre).size() > 1){
                best.add(map.get(genre).get(1));
            }
        }
        
        return best.stream().mapToInt(Integer::intValue).toArray();
    }
}
