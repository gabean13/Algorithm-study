import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        
        char[] xArr = X.toCharArray();
        Map<Integer, Integer> xMap = new TreeMap<>();
        for(char ch : xArr) {
            int num = (int)(ch-'0');
            xMap.put(num, xMap.getOrDefault(num, 1) + 1);
        }
        
        char[] yArr = Y.toCharArray();
        List<Integer> list = new ArrayList<>();
        for(char ch : yArr) {
            int num = (int)(ch-'0');
            if(xMap.containsKey(num) && xMap.get(num) > 1) {
                xMap.put(num, xMap.get(num)-1);
                list.add(num);
            }
        }
        
        list.sort(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        
        for(int num : list) {
            sb.append(num);    
        }
        
        String answer = sb.toString();
        if(sb.length() == 0) {
            return "-1";
        } else if(answer.replace("0", "").length() == 0) {
            return "0";
        }
        
        return sb.toString();
    }
}