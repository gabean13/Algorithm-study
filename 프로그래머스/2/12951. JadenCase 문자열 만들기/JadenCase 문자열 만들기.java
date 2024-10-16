import java.util.*;

class Solution {
    public String solution(String s) {
   
        //공백, 숫자, 문자
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        
        //첫번째 문자 대문자 처리
        if(arr[0] >= 'a' && arr[0] <= 'z') {
            arr[0] = Character.toUpperCase(arr[0]);
        }
        sb.append(arr[0]);
        
        for(int i = 1; i < arr.length; i++) {
            if(arr[i-1] == ' ' && arr[i] >= 'a' && arr[0] <= 'z') {
                arr[i] = Character.toUpperCase(arr[i]);
            }
            else if (arr[i-1] != ' ' && arr[i] >= 'A' && arr[0] <= 'Z') {
                arr[i] = Character.toLowerCase(arr[i]);
            }
            sb.append(arr[i]);
        }
        
         
        return sb.toString();
    }
}