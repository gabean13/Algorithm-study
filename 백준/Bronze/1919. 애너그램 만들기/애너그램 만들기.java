import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		int[] str1Arr = new int[26];
		for(char ch : str1.toCharArray()) {
			str1Arr[ch - 'a'] += 1;
		}
		
		int answer = 0;
		for(char ch : str2.toCharArray()) {
			if(str1Arr[ch - 'a'] > 0) {
				str1Arr[ch - 'a']--;
				answer++;
			}
		}
		
		System.out.println(str1.length() + str2.length() -  answer*2);
	}
}