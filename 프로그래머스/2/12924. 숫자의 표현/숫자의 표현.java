class Solution {
    public int solution(int n) {
        int answer = 1;
        for(int i = 1; i <= n/2 + 1; i++) {
            int sum = i;
            int j = i + 1;
            while(sum <= n) {
                sum += j;            
                if(sum == n) {
                    answer++;
                }
                j++;
            }
        }
        
        return answer;
    }
}