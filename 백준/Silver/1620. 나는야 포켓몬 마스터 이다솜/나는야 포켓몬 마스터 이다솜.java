import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int poketmonNum = Integer.parseInt(st.nextToken());
		int problemNum = Integer.parseInt(st.nextToken());
		
		Map<Integer, String> searchByNum = new HashMap<>();
		Map<String, Integer> searchByName = new HashMap<>();
		for(int i = 1; i <= poketmonNum; i++) {
			String name = br.readLine();
			searchByName.put(name, i);
			searchByNum.put(i, name);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < problemNum; i++) {
			String input = br.readLine();
			try {
				int num = Integer.parseInt(input);
				sb.append(searchByNum.get(num)).append("\n");
			} catch(NumberFormatException ex) {
				sb.append(searchByName.get(input)).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}