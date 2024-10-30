import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int poketmonNum = Integer.parseInt(st.nextToken());
		int problemNum = Integer.parseInt(st.nextToken());
		
		String[] searchByNum = new String[poketmonNum + 1];
		Map<String, Integer> searchByName = new HashMap<>();
		for(int i = 1; i <= poketmonNum; i++) {
			String name = br.readLine();
			searchByName.put(name, i);
			searchByNum[i] = name;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < problemNum; i++) {
			String input = br.readLine();
			try {
				int num = Integer.parseInt(input);
				sb.append(searchByNum[num]).append("\n");
			} catch(NumberFormatException ex) {
				sb.append(searchByName.get(input)).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}