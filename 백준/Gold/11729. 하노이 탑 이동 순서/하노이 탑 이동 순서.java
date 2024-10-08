import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String...args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		System.out.println((long)(Math.pow(2, n)-1));
		hanoi(1, 2, 3, n);
		System.out.println(sb);
	}
	
	static void hanoi(int start, int mid, int to, int n) {
		//base condition
		if(n == 1) {
			sb.append(start + " " + to).append("\n");
			return;
		}
		
		//n-1개가 start -> mid
		hanoi(start, to, mid, n-1);
		//n개가 start -> to
		sb.append(start + " " + to).append("\n");
		//n-1개가 mid -> to
		hanoi(mid, start, to, n-1);
	}
}
