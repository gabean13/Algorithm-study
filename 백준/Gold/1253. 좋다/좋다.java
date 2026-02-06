import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    
	    long[] arr = new long[n];
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 0;i < n; i++) {
	      arr[i] = Long.parseLong(st.nextToken());
	    }
	    
	    Arrays.sort(arr);
	    
	    int answer = 0;
	    for(int i = 0; i < n; i++) {
	      long current = arr[i];
	      int start = 0;
	      int end = n-1;
	      while(start < end) {
	        if(start == i) {
	          start++;
	          continue;
	        }
	        if(end == i) {
	          end--;
	          continue;
	        }
	        long sum = arr[start] + arr[end];
	        if(sum == current) {
	          answer++;
	          break;
	        } else if(sum < current) {
	          start++;
	        } else if(sum > current) {
	          end--;
	        }
	      }
	    }
	    
	    System.out.println(answer);
	}
}