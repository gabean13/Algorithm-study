import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//1. 길이비교
		//2. 길이가 같다면 숫자의 합 비교
		//3. 숫자의 합까지 같다면 사전순 비교
		
		int n = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String serial = br.readLine();
			list.add(serial);
		}
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() != s2.length()) {
					return s1.length() - s2.length();
				} else {
					int s1Num = numberSum(s1);
					int s2Num = numberSum(s2);
					if(s1Num != s2Num) {
						return s1Num - s2Num;
					} else {
						for(int i = 0; i < s1.length(); i++) {
							if(s1.charAt(i) == s2.charAt(i)) continue;
							return s1.compareTo(s2);
						}
						return 0;
					}
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(String str : list) {
			sb.append(str).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int numberSum(String str) {
		int total = 0;
		char[] arr = str.toCharArray();
		for(char s : arr) {
			if(s >= '0' && s <= '9') {
				total += (int)(s - '0');
			}
		}
		
		return total;
	}
}