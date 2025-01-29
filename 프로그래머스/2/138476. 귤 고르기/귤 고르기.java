import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        //1. 크기별로 개수를 센다음에 -> 개수순으로 정렬 -> 포함되는 크기를 센다
        Map<Integer, Integer> map = new HashMap<>();
        for(int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }
        
        int[] arr = new int[map.size()];
        int idx = 0;
        for(int size : map.keySet()) {
            arr[idx++] = map.get(size);
        }
        
        Arrays.sort(arr);
        int total = 0;
        for(int i = arr.length - 1; i >= 0; i--) {
            total += arr[i];
            answer++;
            if(total >= k) {
                break;
            }
        }
        
        return answer;
    }
}