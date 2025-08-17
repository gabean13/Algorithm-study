class Solution {
    public boolean solution(String s) {
        // 길이 충족 X 시 return false
        if(s.length() != 4 && s.length() != 6) {
            return false;
        }
        
        // 숫자가 아니면 return false
        char[] charArray = s.toCharArray();
        for(char ch : charArray) {
            if(!(ch >= '0' && ch <= '9')) {
                return false;
            }
        }
        
        return true;
    }
}