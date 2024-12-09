import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Long, Integer> map = new TreeMap<>();
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			Long key = Long.parseLong(br.readLine());
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		int max = 0;
		Long answer = 0L;
		for(Long key : map.keySet()) {
			if(map.get(key) > max) {
				max = map.get(key);
				answer = key;
			}
		}
		
		System.out.println(answer);
	}
}