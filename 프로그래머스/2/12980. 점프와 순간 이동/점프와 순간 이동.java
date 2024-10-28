import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        while(n >= 2) {
            if(n % 2 != 0) {
                answer += 1;
            }
            n /= 2;
            
        }
        
        return answer + n;
    }
}