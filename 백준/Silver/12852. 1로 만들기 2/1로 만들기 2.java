import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n+1];
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + 1;
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
			}
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
			}
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append(dp[n]).append("\n");
		
		while(n >= 1) {
			sb.append(n).append(" ");
			int cv = dp[n];
			if(n % 3 == 0 && dp[n/3] == cv - 1) {
				n /= 3;
				continue;
			}
			if(n % 2 == 0 && dp[n/2] == cv - 1) {
				n /= 2;
				continue;
			}
			n--;
		}
		
		System.out.println(sb);
	}
}