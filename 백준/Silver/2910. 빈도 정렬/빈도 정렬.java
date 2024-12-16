import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		int maxValue = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for(int i = 0; i < num; i++) {
			int key = Integer.parseInt(st.nextToken());
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
		entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
		    @Override
		    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
		    	return o2.getValue() - o1.getValue();
		    }
		});
		StringBuilder sb = new StringBuilder();
		
		for(Map.Entry<Integer, Integer> entry : entryList){
			int key = entry.getKey();
			for(int i = 0; i < entry.getValue(); i++) {
				sb.append(key).append(" ");
			}
		}
		
		System.out.println(sb);
	}
}