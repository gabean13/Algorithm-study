import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] origin = new int[n];
		int[] sorted = new int[n];
		Map<Integer, Integer> rankMap = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int value = Integer.parseInt(st.nextToken());
			origin[i] = value;
			sorted[i] = value;
		}
		
		Arrays.sort(sorted);
		
		int rank = 0;
		for(int value : sorted) {
			if(rankMap.containsKey(value)) continue;
			rankMap.put(value, rank++);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int key : origin) {
			sb.append(rankMap.get(key)).append(" ");
		}
		
		System.out.println(sb);
	}
}