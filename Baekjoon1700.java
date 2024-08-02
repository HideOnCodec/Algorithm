/** 
백준 1700번 멀티탭 스케줄링
그리디 알고리즘
멀티탭이 모두 찬 경우 뒤의 순서까지를 따져야 함.
**/

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // 멀티탭 구멍 개수
        int k = Integer.parseInt(st.nextToken()); // 전기용품 사용 횟수
        int[] seq = new int[k]; // 전기용품 사용 순서

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < k; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> plugged = new HashSet<>(); // 현재 멀티탭에 꽂혀있는 전기용품
        int cnt = 0; // 플러그를 뽑는 횟수

        for (int i = 0; i < k; i++) {
            int current = seq[i];

            // 이미 꽂혀 있는 경우
            if (plugged.contains(current)) {
                continue;
            }

            // 멀티탭에 여유가 있는 경우
            if (plugged.size() < n) {
                plugged.add(current);
                continue;
            }

            // 멀티탭에 꽂혀있고, 뒤의 사용 목록에 없는 경우를 제거
            int maxIdx = -1;
            int deviceToRemove = -1;

            for (int pluggedDevice : plugged) {
                int nextUseIdx = Integer.MAX_VALUE;

                for (int j = i + 1; j < k; j++) {
                    if (seq[j] == pluggedDevice) {
                        nextUseIdx = j;
                        break;
                    }
                }

                if (nextUseIdx == Integer.MAX_VALUE) {
                    // 뒤에 사용되지 않는 경우
                    deviceToRemove = pluggedDevice;
                    break;
                } else if (nextUseIdx > maxIdx) {
                    maxIdx = nextUseIdx;
                    deviceToRemove = pluggedDevice;
                }
            }

            plugged.remove(deviceToRemove);
            plugged.add(current);
            cnt++;
        }

        System.out.println(cnt);
    }
}
