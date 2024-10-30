import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[n];
		for(int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine()); 
		}
		
		int coinCnt = 0;
		int idx = n -1;
		while(goal != 0) {
			if(goal < coins[idx]) {
				idx--;
				continue;
			}
			goal -= coins[idx];
			coinCnt++;
		}
		
		System.out.println(coinCnt);
	}
}