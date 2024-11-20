import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String search = br.readLine();
		str = str.replace(search, "0");
		
		int answer = 0;
		for(int i = 0; i < str.length() ; i++) {
			if(str.charAt(i) == '0') answer++;
		}
		
		System.out.println(answer);
	}
}