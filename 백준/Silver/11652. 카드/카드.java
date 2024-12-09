import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<BigInteger, Integer> map = new TreeMap<>();
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			BigInteger key = new BigInteger(br.readLine());
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		int max = 0;
		BigInteger answer = new BigInteger("0");
		for(BigInteger key : map.keySet()) {
			if(map.get(key) > max) {
				max = map.get(key);
				answer = key;
			}
		}
		
		System.out.println(answer);
	}
}