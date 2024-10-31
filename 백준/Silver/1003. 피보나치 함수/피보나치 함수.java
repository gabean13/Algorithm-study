import java.io.*;
import java.util.*;

public class Main {
	static long[][] arr = new long[41][2];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr[0][0] = 1;
		arr[0][1] = 0;
		
		arr[1][0] = 0;
		arr[1][1] = 1;
		
		int round = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < round; i++) {
			int num = Integer.parseInt(br.readLine());
			long[] answer = fibo(num);
			sb.append(answer[0] + " " + answer[1]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static long[] fibo (int n) {
		if(n == 1) {
			return arr[1];
		} 
		
		if(n == 0) {
			return arr[0];
		}

 		if(arr[n][0] == 0 && arr[n][1] == 0) {
			arr[n][0] = fibo(n-1)[0] + fibo(n-2)[0]; 
			arr[n][1] = fibo(n-1)[1] + fibo(n-2)[1];
		}
 		
 		return arr[n];
	}
}