import java.util.*;

class Solution {
    public String solution(String s) {
        char[] charArray = s.toCharArray();
        
        Arrays.sort(charArray);
        
        StringBuilder sb = new StringBuilder();
        for(char ch : charArray) {
            sb.append(ch);
        }
        
        return sb.reverse().toString();
    }
}