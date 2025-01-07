import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		List<String> list = new ArrayList<>();
		for(int i = 0; i < input.length(); i++) {
			list.add(input.substring(i));
		}
		
		Collections.sort(list);
		
		StringBuffer sb = new StringBuffer();
		for(String str : list) {
			sb.append(str).append("\n");
		}
		
		System.out.println(sb);
	}
}