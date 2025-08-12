class Solution {
    public int[] solution(int[] arr) {
        //1. 가장 작은 수의 idx를 찾는다.
        int minIdx = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < min) {
                minIdx = i;
                min = arr[i];
            }
        }
        
        //2. 복사한다.
        int[] answer = new int[arr.length - 1];
        for(int i = 0; i < minIdx; i++) {
            answer[i] = arr[i];
        }
        for(int i = minIdx + 1; i < arr.length; i++) {
            answer[i-1] = arr[i];
        }
        
        if(answer.length == 0) {
            return new int[]{-1};
        }
        return answer;
    }
}