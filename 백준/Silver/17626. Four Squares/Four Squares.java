import java.io.*;
import java.util.*;

public class Main {
	static List<Integer> fruits;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] dp = new int[num + 1];
		
		dp[1] = 1;
		for(int i = 2; i < num+1; i++) {
			int min = 5;
			for(int j = 1; j*j <= i; j++) {
				min = Math.min(min, dp[i-j*j]);
			}
			dp[i] = min + 1;
		}
		
		System.out.println(dp[num]);
	}
}