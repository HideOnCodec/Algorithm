import java.util.*;

class Car{
    int w;
    int start;
    public Car(int w, int start){
        this.w = w;
        this.start = start;
    }
}

class Solution {
    static Queue<Integer> wait = new LinkedList<>();
    static Queue<Car> bridge = new LinkedList<>();
    
    static boolean isAvailable(int bridge_length, int bridge_weight, int weight){
        if(wait.peek() + bridge_weight <= weight && bridge.size() < bridge_length){
            return true;
        }
        return false;
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        for(int w : truck_weights){
            wait.offer(w);
        }
        int car = wait.poll();
        bridge.offer(new Car(car, 0));
        
        int time = 1;
        int bridge_weight = car;
        while(!bridge.isEmpty()){
            Car front = bridge.peek();
            // 선두 트럭이 다리를 지날 수 있는지 확인 
            if(time - front.start == bridge_length){
                bridge.poll();
                bridge_weight -= front.w;
            }
            // 다리에 올라갈 수 있는지 확인 
            if(!wait.isEmpty()){
               if(isAvailable(bridge_length, bridge_weight, weight)){
                car = wait.poll();
                bridge.offer(new Car(car, time));
                bridge_weight += car;
               }
            }
            
            time++;
        }
        
        return time; 
    }
}

/**
큐 이용
1. 대기 큐에 truck_weights 삽입
2. 큐가 빌때까지 반복문
- 대기 큐에서 꺼내서 다리 큐에 삽입, 이때 무게와 bridge_length 제한 확인
- 반복문 돌때마다 time 증가
O(10,000 * 10,000) = O(100,000,000)
*/