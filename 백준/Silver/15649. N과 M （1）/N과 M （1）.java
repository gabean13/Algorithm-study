import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] arr;
	static boolean[] used;
	public static void main(String... args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		used = new boolean[n+1];
		backtraking(0);
		System.out.println(sb);
	}
	
	public static void backtraking(int k) {
		if(k == m) {
			for(int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			if(!used[i]) {
				arr[k] = i;
				used[i] = true;
				backtraking(k+1);
				used[i] = false;
			}
		}
	}
}