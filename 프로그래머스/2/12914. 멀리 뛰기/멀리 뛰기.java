import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n) {
        long answer = 0;
        //1. 효진이는 1칸 아니면 2칸 뛰기 가능
        //2. n번째에 도달하면 종료
        //3. 총 몇가지 방법으로 도달할 수 있는지 세기
        //4. 근데 그걸 1234567로 나눠야함
        long[] arr = new long[2001];
        //1 2 3 4 5 6 7 8 9 10
        //1 2 3 5 
        int cur = 0;
        arr[0] = 1;
        arr[1] = 1;
        while(true) {
            if(cur == n) {
                break;
            }
            if(cur + 2 <= n) {
                arr[cur+2] = (arr[cur] + arr[cur+1]) % 1234567;
            }
            cur++;
        }
        
        return arr[n];
    }
}