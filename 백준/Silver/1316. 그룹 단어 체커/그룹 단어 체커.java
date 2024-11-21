import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i = 0; i < n; i++) {
			char[] words = br.readLine().toCharArray();
			boolean isGroupWord = true;
			boolean[] used = new boolean[26];
			char before = '1';
			for(char ch : words) {
				//before이랑같거나 사용했으면 pass
				if(before == ch || !used[ch-'a']) {
					before = ch;
					used[ch-'a'] = true;
					continue;
				}
				isGroupWord = false;
				break;
			}
			if(isGroupWord) answer++;
		}
		
		System.out.println(answer);
	}
}