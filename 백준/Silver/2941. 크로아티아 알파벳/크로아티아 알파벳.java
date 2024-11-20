import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int answer = 0;
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(i == str.length() - 1) {
				answer++;
				break;
			} else if(ch == 'd') {
				String input = str.substring(i, i+2);
				if(input.equals("d-")) {
					answer++;
					i++;
					continue;
				}
				if(i < str.length() - 2) {
					input = str.substring(i, i+3);
					if(input.equals("dz=")) {
						answer++;
						i+=2;
						continue;
					}
				}
				answer++;
			} else {
				String input = str.substring(i, i+2);
				if(input.equals("c=") || input.equals("c-") || input.equals("lj")
						|| input.equals("nj") || input.equals("s=") || input.equals("z=")) {
					answer++;
					i++;
				} else {
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}
}