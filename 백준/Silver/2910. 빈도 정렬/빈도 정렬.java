import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for(int i = 0; i < num; i++) {
			int key = Integer.parseInt(st.nextToken());
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		List<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list, (o1, o2) -> map.get(o2) - map.get(o1));
		
		StringBuilder sb = new StringBuilder();
		for(int key : list) {
			for(int i = 0; i < map.get(key); i++) {
				sb.append(key).append(" ");
			}
		}

		System.out.println(sb);
	}
}