class Solution {
    public int solution(int n) {
        //n -> n+1순환
        //n+1 2진수로 변환
        //2진수 0제거 1의 개수 count
        //같으면 종료
        int oneCnt = Integer.bitCount(n);
        
        int answer = n +1;
        while(!(Integer.bitCount(answer) == oneCnt)) {
            answer++;
        }
        return answer;
    }
}