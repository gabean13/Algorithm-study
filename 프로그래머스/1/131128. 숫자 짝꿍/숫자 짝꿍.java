import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        
        int[] xArr = new int[10];
        int[] yArr = new int[10];
        char[] x = X.toCharArray();
        char[] y = Y.toCharArray();
        
        for(char ch : x) {
            int num = (int)(ch-'0');
            xArr[num] += 1;
        }
        
        for(char ch : y) {
            int num = (int)(ch-'0');
            yArr[num] += 1;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--) {
            if(xArr[i] == 0 || yArr[i] == 0) continue;
            int repeat = xArr[i] > yArr[i] ? yArr[i] : xArr[i];
            sb.append(Integer.toString(i).repeat(repeat));
        }
        
        String answer = sb.toString();
        if(answer.length() == 0) {
            return "-1";
        } else if(answer.replace("0", "").length() == 0) {
            return "0";
        }
        return answer;
    }
}