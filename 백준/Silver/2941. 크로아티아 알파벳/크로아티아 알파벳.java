import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> croatian = new HashSet<>(Arrays.asList(
				"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="
		));
		//입력
		String str = br.readLine();
		
		//계산
		int answer = 0;
		int i = 0;
		while(i < str.length()) {
			boolean found = false;
			if(i < str.length() - 2) {
				String three = str.substring(i, i + 3);
				if(croatian.contains(three)) {
					found = true;
					i += 3;
				}
			}
			
			if(!found && i < str.length() - 1) {
				String two = str.substring(i, i + 2);
				if(croatian.contains(two)) {
					found = true;
					i += 2;
				}
			}
			
			if(!found) {
				i++;
			}
			
			answer++;
		}
	
		
		System.out.println(answer);
	}
}