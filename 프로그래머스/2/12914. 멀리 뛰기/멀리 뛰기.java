import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n) {
        long[] arr = new long[2001];
        int cur = 0;
        arr[0] = 1;
        arr[1] = 1;
        while(cur < n) {
            if(cur + 2 <= n) {
                arr[cur+2] = (arr[cur] + arr[cur+1]) % 1234567;
            }
            cur++;
        }
        
        return arr[n];
    }
}