import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // banna 3개 apple 2개 rice 2개 pork 2개 pot 1개 
        // discount i ~ i + 10 까지의 수량이 banna 3개 ~ pot 1개 인 경우의 수를 구하라
        // 완탐ㄱㄱㅋㅋ        
        int answer = 0;
        Map<String, Integer> wantCounts = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            wantCounts.put(want[i], number[i]);
        }
        
        for(int startIdx = 0; startIdx <= discount.length-10; startIdx++) {
            Map<String, Integer> wantCountCopy = new HashMap<>(wantCounts);
            for(int i = startIdx; i < startIdx + 10; i++) {
                if(wantCountCopy.containsKey(discount[i])) {
                    wantCountCopy.put(discount[i], wantCountCopy.get(discount[i]) - 1);
                    if(wantCountCopy.get(discount[i]) == 0) {
                        wantCountCopy.remove(discount[i]);
                    }
                }                
            }
            if(wantCountCopy.size() == 0) {
                answer++;
            }
        }
        return answer;
    }
}