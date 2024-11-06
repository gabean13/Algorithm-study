import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> indexMap = new TreeMap<>();
		Set<Integer> set = new TreeSet<>();
		Map<Integer, Integer> rankMap = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int value = Integer.parseInt(st.nextToken());
			indexMap.put(i, value);
			rankMap.put(value, 0);
			set.add(value);
		}
		
		int rank = 0;
		for(int value : set) {
			rankMap.put(value, rank++);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int key : indexMap.keySet()) {
			sb.append(rankMap.get(indexMap.get(key))).append(" ");
		}
		
		System.out.println(sb);
	}
}