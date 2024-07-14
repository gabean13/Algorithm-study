import java.util.*;
import java.io.*;

class main {
	static public void main(String []args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[1001];
        dp[0] = 1;
        dp[1] = 1;

        System.out.println(fibo(dp, n));
    }

    static int fibo (int[] dp, int n){
        if(dp[n] != 0){
            return dp[n];
        }
        else{
            dp[n] = (fibo(dp, n - 2) * 2 + fibo(dp, n -1)) % 10007;
            return dp[n];
        }
    }
}
