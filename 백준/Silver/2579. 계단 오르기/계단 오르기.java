import java.io.*;
import java.util.*;

public class Main {
	static int[] stairs;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int stairsNum = Integer.parseInt(br.readLine());
		
		stairs = new int[stairsNum+1];
		dp = new int[stairsNum+1][3]; //1칸 올라왓을 때, 2칸 연속 올라왔을 때
		for(int i = 1; i <= stairsNum; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		if(stairsNum >= 1) {
			dp[1][1] = stairs[1];
			dp[1][2] = stairs[1];
		}
		
		if(stairsNum >= 2) {
			dp[2][1] = stairs[2];
			dp[2][2] = stairs[1] + stairs[2];
		}
	
		for(int i = 3; i <= stairsNum; i++) {
			dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + stairs[i];
			dp[i][2] = dp[i-1][1] + stairs[i];
		}
		
		int answer = Math.max(dp[stairsNum][1], dp[stairsNum][2]);
		System.out.println(answer);	
	}
}