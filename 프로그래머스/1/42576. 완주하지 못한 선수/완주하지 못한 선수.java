import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participants = new HashMap<>();
        for(String name : participant) {
            participants.put(name, participants.getOrDefault(name, 0) + 1);
        }
        
        for(String name: completion) {
            participants.put(name, participants.get(name)-1);
            if(participants.get(name) == 0) {
                participants.remove(name);
            }
        }
        
        for(String name : participants.keySet()) {
            return name;
        }
        return "";
    }
}