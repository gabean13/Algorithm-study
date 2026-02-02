import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    int answer = 1;
	    
	    int start = 1;
	    int end = 2;
	    long currentSum = start + end;
	    while(end < n) {
	      if(currentSum < n) {
	        end++;
	        currentSum += end;
	      } else if(currentSum > n) {
	        currentSum -= start;
	        start++;
	      } else {
	        answer++;
	        end++;
	        currentSum += end;
	        currentSum -= start;
	        start++;
	      }
	    }
	    
	    System.out.println(answer);
	}
}