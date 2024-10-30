import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int pwNum = Integer.parseInt(st.nextToken());
		int searchNum = Integer.parseInt(st.nextToken());
		
		Map<String, String> pwWithSite = new HashMap<>();
		for(int i = 0; i < pwNum; i++) {
			st = new StringTokenizer(br.readLine());
			pwWithSite.put(st.nextToken(), st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < searchNum; i++) {
			sb.append(pwWithSite.get(br.readLine())).append("\n");
		}
		
		System.out.println(sb);
	}
}