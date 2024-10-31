import java.io.*;
import java.util.*;

public class Main {
	static long[][] fibonacci = new long[41][2];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		fibonacci[0][0] = 1;
		fibonacci[0][1] = 0;
		
		fibonacci[1][0] = 0;
		fibonacci[1][1] = 1;
		
		int testCases = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < testCases; i++) {
			int num = Integer.parseInt(br.readLine());
			long[] answer = fibo(num);
			sb.append(answer[0] + " " + answer[1]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static long[] fibo (int n) {
		if(n == 1 || n == 0) {
			return fibonacci[n];
		} 
		
		if(fibonacci[n][0] != 0 || fibonacci[n][1] != 0) {
			return fibonacci[n];
		}
		
		fibonacci[n][0] = fibo(n-1)[0] + fibo(n-2)[0]; 
		fibonacci[n][1] = fibo(n-1)[1] + fibo(n-2)[1];
		
 		return fibonacci[n];
	}
}