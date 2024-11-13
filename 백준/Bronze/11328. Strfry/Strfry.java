import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int testCases = Integer.parseInt(br.readLine());
		for(int i = 0; i < testCases; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean answer = isStrfryPossible(st.nextToken(), st.nextToken());
			sb.append(answer ? "Possible\n" : "Impossible\n");
		}
		
		System.out.println(sb);
	}
	
	static boolean isStrfryPossible(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false;
		}
		
		int[] s1Arr = new int[27];
		for(int i = 0; i < s1.length(); i++) {
			s1Arr[s1.charAt(i) - 'a']++;
		}
		
		for(int i = 0; i < s2.length(); i++) {
			s1Arr[s2.charAt(i) - 'a']--;
		}
		
		for(int i = 0; i < 27; i++) {
			if(s1Arr[i] != 0) {
				return false;
			}
		}
		
		return true;
	}
}