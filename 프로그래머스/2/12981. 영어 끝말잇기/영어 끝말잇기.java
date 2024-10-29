import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        Set<String> wordSet = new HashSet<>();

        wordSet.add(words[0]);
        int round = 1;
        int personNum = 2;
        for(int i = 1; i < words.length; i++) {
            char last = words[i-1].charAt(words[i-1].length()-1);
            if(wordSet.contains(words[i]) || last != words[i].charAt(0)) {
                answer[0] = ( personNum == 0 ) ? n : personNum;
                answer[1] = round;
                return answer;
            }
            
            wordSet.add(words[i]);
            personNum = (personNum + 1) % n;
            if(personNum == 1) {
                round++;
            }
        }
        
        return answer;
    }
}