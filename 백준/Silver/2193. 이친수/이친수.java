import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[91];
        dp[1] = 1;
        dp[2] = 1;

        System.out.println(fibo(dp, N));
    }

    static long fibo(long[] dp, int n){
        if(dp[n] != 0){
            return dp[n];
        }else{
            dp[n] = fibo(dp, n -1) + fibo(dp, n -2);
            return dp[n];
        }
    }
}