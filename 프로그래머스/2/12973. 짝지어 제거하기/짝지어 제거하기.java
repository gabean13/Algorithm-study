import java.util.*;

class Solution {
    public int solution(String s) {
        if(s.length() % 2 != 0) {
            return 0;
        }
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s .charAt(i);
            if(stack.size() >= 1) {             
                char top = stack.peek();
                if(ch == top) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(ch);
        }
        
        if(stack.isEmpty()) {
            return 1;
        }
        
        return 0;
    }
}