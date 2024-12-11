import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		long[] arr = new long[n];
		
		int i = 0;
		
		while(i < n) {
			if(!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
				continue;
			}
			arr[i++] = Long.parseLong(new StringBuilder(st.nextToken()).reverse().toString());
		}
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for(long num : arr) {
			sb.append(num).append("\n");
		}
		
		System.out.println(sb);
	}
}