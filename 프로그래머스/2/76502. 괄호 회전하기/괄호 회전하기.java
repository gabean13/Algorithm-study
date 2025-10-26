import java.util.*;

class Solution {
    public int solution(String s) {
        /*
        [](){}
        ](){}[
        1. 큐로 제일 앞에껄 뒤에다가 넣는다
        2. 검사한다.
        3. 실패하면 pass
        */
        String[] strArr = s.split("");
        LinkedList<String> strList = new LinkedList<>();
        for(String str : strArr) {
            strList.add(str);
        }
        
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            LinkedList<String> strCopy = new LinkedList<>(strList);
            if(isCorrectStr(strCopy)) {
                answer++;
            }
            strList.add(strList.removeFirst());
        }
        
        return answer;
    }
    
    private boolean isCorrectStr(LinkedList<String> strList) {
        Stack<String> stack = new Stack<>();
        while(strList.size() != 0) {
            String str = strList.removeFirst();
            if(str.equals("{") || str.equals("[") || str.equals("(")) {
                stack.push(str);
                continue;
            }
            
            // 그 외의 경우는 닫는 괄호
            if(stack.isEmpty()) return false;
            if(str.equals("}") && !stack.pop().equals("{")) {
                return false;
            }
            if(str.equals("]") && !stack.pop().equals("[")) {
                return false;
            }
            if(str.equals(")") && !stack.pop().equals("(")) {
                return false;
            }
        }
        
        if(stack.size() > 0) {
            return false;
        }
        return true;
    }
}