import java.util.*;

class Solution {
    public long solution(long n) {
        String[] input = Long.toString(n).split("");        
        Arrays.sort(input);
        
        StringBuilder sb = new StringBuilder();
        for(String s : input) {
            sb.append(s);
        }
        
  
        return Long.parseLong(sb.reverse().toString());
    }
}