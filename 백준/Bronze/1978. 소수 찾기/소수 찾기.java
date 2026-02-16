import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    
	    int answer = 0;
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < n; i++) {
	      int num = Integer.parseInt(st.nextToken());
	      if(isPrime(num)) {
	        answer++;
	      }
	    }
	    
	    System.out.println(answer);
	}
	
	static boolean isPrime(int num) {
	  if(num == 1) return false;
	  for(int i = 2; i * i <= num; i++) {
	    if(num % i == 0) {
	      return false;
	    }
	  }
	  return true;
	}
}