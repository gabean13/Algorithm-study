import java.util.*;
import java.io.*;

public class Main {
  
  static int answer = 0;
  
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    long[] arr = new long[N];
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < N; i++) {
	      arr[i] = Long.parseLong(st.nextToken());
	    }
	    Arrays.sort(arr);
	    
	    for(int i = 0; i < N; i++) {
	      checkGoodNumber(N, arr, i);
	    }
	    
	    System.out.println(answer);
	}
	
	private static void checkGoodNumber(int N, long[] arr, int targetIdx) {
	  int l = 0;
	  int r = N-1;
	  
	  while(l < r) {
	    long current = arr[l] + arr[r];
	    if (targetIdx == r) {
	      r--;
	    } else if(targetIdx == l) {
	      l++;
	    } else if(current == arr[targetIdx]) {
	      answer++;
	      return;
	    } else if(current > arr[targetIdx]) {
	      r--;
	    } else if(current < arr[targetIdx]) {
	      l++;
	    } 
	  }
	}
}