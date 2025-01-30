import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int round = 1;

        //a가 항상 더 작게 한다
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        while(true) {
            if(a % 2 != 0 && (a+1) == b) break;
            if(a % 2 != 0) {
                a = (a + 1) / 2;
            } else {
                a /= 2;
            }
            
            if(b % 2 != 0) {
                b = (b + 1) / 2;
            } else {
                b /= 2;
            }
            
            round++;
        }
        
        return round;
    }
}