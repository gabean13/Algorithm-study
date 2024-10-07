import java.io.*;
import java.util.*;

public class Main {
	public static void main(String...args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Long num = Long.parseLong(st.nextToken());
		Long cnt = Long.parseLong(st.nextToken());
		Long mod = Long.parseLong(st.nextToken());
		
		System.out.println(mod(num, cnt, mod));
	}
	
	static long mod(long num, long cnt, long mod) {
		//base condition
		if(cnt == 1) {
			return num % mod;
		}
		
		long temp = mod(num, cnt / 2, mod);
		
		
		if(cnt % 2 == 1) {
			return ((temp % mod) * (temp % mod) % mod) * num % mod;
		} else {
			return ((temp % mod) * (temp % mod)) % mod;
		}	
	}
}