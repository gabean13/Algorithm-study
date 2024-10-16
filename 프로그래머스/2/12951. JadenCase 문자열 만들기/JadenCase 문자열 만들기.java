import java.util.*;

class Solution {
    public String solution(String s) {  
        //공백, 숫자, 문자  
        String[] arr = s.toLowerCase().split("");
        StringBuilder sb = new StringBuilder();
        
        boolean flag = true;
        
        for(String str : arr) {
            sb.append(flag ? str.toUpperCase() : str);
            flag = str.equals(" ") ? true : false;
        }
         
        return sb.toString();
    }
}