import java.util.*;

class Solution {
    int answer = 0;
    int[] numbers;
    int target;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        fun(0, 0);
        return answer;
    }
    
    private void fun(int k, int result) {
        if(k == numbers.length) {
            if(result == target) answer++;
            return;
        }
        
        fun(k+1, result + numbers[k]);
        fun(k+1, result - numbers[k]);
    }
}