class Solution {
    public int[] solution(String s) {
        
        int round = 0;
        int removeZeroCnt = 0;
        while(!s.equals("1")) {
            int cLength = s.length();
            s = s.replaceAll("0", "");
            int nLength = s.length();            
            s = Integer.toBinaryString(nLength);
            round++;
            removeZeroCnt += (cLength-nLength);
        }
        
        return new int[]{round, removeZeroCnt};
    }
}