import java.util.*;

class Solution {
    public String solution(String s) {
        List<Character> cl = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            cl.add(s.charAt(i));
        }
        
        cl.sort(Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(Character c : cl) {
            sb.append(c);
        }

        return sb.toString();
    }
}