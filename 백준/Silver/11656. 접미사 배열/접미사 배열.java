import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		String[] array = new String[input.length()];
		for(int i = 0; i < input.length(); i++) {
			array[i] = input.substring(i);
		}
		
		Arrays.sort(array);
		
		StringBuffer sb = new StringBuffer();
		for(String str : array) {
			sb.append(str).append("\n");
		}
		
		System.out.println(sb);
	}
}