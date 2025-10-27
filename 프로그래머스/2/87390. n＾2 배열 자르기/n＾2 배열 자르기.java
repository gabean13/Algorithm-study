class Solution {
    public int[] solution(int n, long left, long right) {
        int answerSize = (int) (right - left + 1);
        int[] answer = new int[answerSize];
        for(int i = 0; i < answerSize; i++) {
            long index = left + i;
            int height = (int) (index / n);
            int width = (int) (index % n);
            answer[i] = Math.max(height, width) + 1;
        }
        return answer;
    }
}