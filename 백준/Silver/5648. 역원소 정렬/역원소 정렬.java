import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		long[] arr = new long[n];
		
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while(i < n) {
			if(!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
				continue;
			}
			sb.append(st.nextToken()).reverse();
			arr[i++] = Long.parseLong(sb.toString());
			sb.setLength(0);
		}
		
		Arrays.sort(arr);
		
		for(long num : arr) {
			sb.append(num).append("\n");
		}
		
		System.out.println(sb);
	}
}