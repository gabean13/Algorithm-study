import java.util.*;
import java.io.*;

class main {
	static public void main(String []args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());   //테스트 케이스의 개수

        int[] dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(bf.readLine());
            System.out.println(fibo(dp, Integer.parseInt(st.nextToken())));
        }
    }

    static int fibo(int[] dp, int n){
        if(dp[n] != 0){
            return dp[n];
        }else{
            dp[n] = fibo(dp, n-3) + fibo(dp, n-2) + fibo(dp, n-1);
            return dp[n];
        }
    }
}
