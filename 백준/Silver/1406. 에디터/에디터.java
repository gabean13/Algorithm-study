import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//초기 문자열 설정
		char[] init = br.readLine().toCharArray();
		LinkedList<Character> left = new LinkedList<>();
		LinkedList<Character> right = new LinkedList<>();
		for(int i = 0; i < init.length; i++) {
			left.add(init[i]);
		}
		
		int orderNums = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < orderNums; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case ("L") : {
				if(left.size() == 0) break;
				right.addFirst(left.removeLast());
				break;
			}
			case ("D") : {
				if(right.size() == 0) break;
				left.addLast(right.removeFirst());
				break;
			}
			case ("B") : {
				if(left.size() == 0) break;
				left.removeLast();
				break;
			}
			case ("P") : {
				char newStr = st.nextToken().charAt(0);
				left.addLast(newStr);
			}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!left.isEmpty()) {
			sb.append(left.removeFirst());
		}
		while(!right.isEmpty()) {
			sb.append(right.removeFirst());
		}
		
		System.out.println(sb);
	}
}