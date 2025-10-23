import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {    
        int answer = 0;
        
        Map<String, Integer> window = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            window.put(want[i], number[i]);
        }
        
        // 초기 윈도우 세팅
        for(int i = 0; i < 10; i++) {
            if(window.containsKey(discount[i])) {
                window.put(discount[i], window.get(discount[i]) - 1);   
            }
        }
        
        // 슬라이딩 윈도우
        for(int left = 0, right = 10; right < discount.length; left++, right++) {
            if(isAllWantDays(window)) {
                answer++;
            }
            
            if(window.containsKey(discount[left])) {
                window.put(discount[left], window.get(discount[left]) + 1);
            }
            
            
            if(window.containsKey(discount[right])) {
                window.put(discount[right], window.get(discount[right]) - 1);
            }
        }
        
        if (isAllWantDays(window)) answer++; // 마지막 윈도우 확인        
        return answer;
    }
    
    public boolean isAllWantDays(Map<String, Integer> map) {
        for(Integer value : map.values()) {
            if(value != 0) {
                return false;
            }
        }
        return true;
    }
}