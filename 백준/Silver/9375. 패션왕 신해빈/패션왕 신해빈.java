import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception{
		int testCases = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < testCases; i++) {
			sb.append(getPairingNum()).append("\n");
		}
		
		System.out.println(sb);
	}

	static int getPairingNum() throws Exception {
		int clothesNum = Integer.parseInt(br.readLine());
		if(clothesNum == 0) return 0;
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < clothesNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			String type = st.nextToken();
			map.put(type, map.getOrDefault(type, 1) + 1);
		}
		
		int answer = 1;
		for(Integer num : map.values()) {
			answer *= num;
		}
		
		return answer-1;
	}
}