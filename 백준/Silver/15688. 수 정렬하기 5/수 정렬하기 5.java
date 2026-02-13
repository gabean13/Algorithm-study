import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int[] arr = new int[2000001];
	    int num = 1000000;
	    int n = Integer.parseInt(br.readLine());
	    for(int i = 0; i < n; i++) {
	      int idx = Integer.parseInt(br.readLine()) + num;
	      arr[idx]++;
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < 2000001; i++) {
	      while(arr[i] > 0) {
	        arr[i]--;
	        sb.append(i - num).append("\n");
	      }
	    }
	    
	    System.out.println(sb.toString());
	}
}