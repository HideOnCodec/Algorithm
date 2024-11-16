import java.io.*;
import java.util.*;

public class Main{
    static class Lecture{
        int start, end;
        public Lecture(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        List<Lecture> lectures = new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] lecture = br.readLine().split(" ");
            lectures.add(new Lecture(Integer.parseInt(lecture[1]),Integer.parseInt(lecture[2])));
        }

        Collections.sort(lectures,(l1,l2)->{
            if(l1.start == l2.start) return l1.end - l2.end;
            else return l1.start-l2.start;
        });

        PriorityQueue<Integer> lectureRoom = new PriorityQueue<>();
        for(Lecture lecture : lectures){
            if(!lectureRoom.isEmpty() && lectureRoom.peek()<=lecture.start)
                lectureRoom.poll();
            lectureRoom.add(lecture.end);
        }
        System.out.println(lectureRoom.size());
     
    }
}

/**
 1. 강의 시작 시간대로 오름차순 정렬(시작 시간이 같으면 종료 시간 비교)
 2. 최소 종료 시간을 우선 순위 큐에 저장
    a. 큐 최소 종료 시간보다 현재 강의가 늦게 시작하면 q.poll 
3. 매 순환마다 cnt 최대값 갱신
 */

 
