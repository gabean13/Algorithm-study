import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    // N 입력
	    int N = Integer.parseInt(br.readLine());
	    
	    // answer = 1 선언
	    int answer = 1;
	    int l = 1;
	    int r = 1;
	    long sum = 1;
	    while(r < N) {
	      if(sum > N) {
	        sum -= l;
	        l++;
	      }
	      
	      if(sum < N) {
	        r++;
	        sum += r;
	      }
	      
	      if(sum == N) {
	        answer++;
	        r++;
	        sum = sum + r;
	      }
	    }
	    
	    System.out.println(answer);
	}
}