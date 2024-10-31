import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		
		for(int i = 3; i < 101; i++) {
			dp[i] = dp[i-2] + dp[i-3];
		}
		
		StringBuilder sb = new StringBuilder();
		int testCases = Integer.parseInt(br.readLine());
		for(int i = 0; i < testCases; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append("\n");
		}
		
		System.out.println(sb);
	}
}