import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            list.add(Integer.toString(numbers[i]));
        }
        
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(String str : list) {
            sb.append(str);
        }
        
        String answer = sb.toString();
        if(answer.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}