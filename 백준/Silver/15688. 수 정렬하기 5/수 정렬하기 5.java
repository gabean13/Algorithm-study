import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int standard = 1_000_000;
		//입력
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[2000001];
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine()) + standard;
			arr[num] += 1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 2000001; i++) {
			if(arr[i] == 0) continue;
			int realValue = i - standard;
			while(arr[i] != 0) {
				sb.append(realValue).append("\n");
				arr[i]--;
			}
		}
		
		System.out.println(sb);
	}
}