class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        //노란색 격자를 찾으면
        //2 1, 2 => 3, 4 - 2 
        // 1 1 =>  3 3 - 1 
        //1 24, 2 12, 3 8, 4 6 => 3 27 4 14 5 10 6 8  
        //갈색 격자를 계산
        for(int i = yellow; i >= 1; i--) {
            if(yellow % i != 0) continue;
            int bWidth = i + 2;
            int bHeight = (yellow / i) + 2;
            if(bWidth*bHeight - yellow == brown) {
                answer[0] = bWidth;
                answer[1] = bHeight;
                break;
            }
        }
        return answer;
    }
}