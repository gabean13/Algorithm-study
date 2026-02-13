import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
	    int n = Integer.parseInt(br.readLine());
	    long[] arr = new long[n];
	    for(int i = 0; i < n; i++) {
	      long num = Long.parseLong(br.readLine());
	      arr[i] = num;
	    }
	    
	    Arrays.sort(arr);
	    int maxCount = 1;
	    long maxValue = arr[0];
	    int currentCount = 1;
	    for(int i = 1; i < n; i++) {
	      if(arr[i] == arr[i-1]) {
	        currentCount++;
	      } else {
	        currentCount = 1;
	      }
	      if(currentCount > maxCount) {
	        maxCount = currentCount;
	        maxValue = arr[i];
	      }
	    }
	    System.out.println(maxValue);
	}
}