import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        //입력
        Map<String, Integer> idMap = new HashMap<>();
        int num = id_list.length;
        for(int i = 0; i < id_list.length; i++) {
            idMap.put(id_list[i], i);
        }
        
        //처리
        int[][] reportArr = new int[num][num];
        int[] criminalArr = new int[num];
        for(String input : report) {
            StringTokenizer st = new StringTokenizer(input);
            int reporterIdx = idMap.get(st.nextToken());
            int criminalIdx = idMap.get(st.nextToken());
            if(reportArr[reporterIdx][criminalIdx] == 0) {
                reportArr[reporterIdx][criminalIdx] = 1;       
                criminalArr[criminalIdx] += 1;
            }           
        }
        
        int[] answer = new int[num];
        for(int i = 0 ;i < num;i++){
            if(criminalArr[i] >= k) {
                for(int j = 0; j < num; j++) {
                    if(reportArr[j][i] == 1) {
                        answer[j]++;
                    }
                }
            }
        }
        
        return answer;
    }
}