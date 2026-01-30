import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int[] arr = new int[n];
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 0; i < n; i++) {
	      arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    for(int i = 1; i < n; i++) {
	      int insertionValue = arr[i];
	      int insertionIdx = i;
	      for(int j = 0; j < i; j++) {
	        if(insertionValue < arr[j]) {
	          insertionIdx = j;
	          break;
	        }
	      }
	      
	      for(int j = i; j > insertionIdx; j--) {
	        int temp = arr[j-1];
	        arr[j-1] = arr[j];
	        arr[j] = temp;
	      }
	      arr[insertionIdx] = insertionValue;
	    }
	    
	    long answer = 0;
	    for(int i = 0; i < n; i++) {
	      answer += (arr[i] * (n-i));
	    }
	    
	    System.out.println(answer);
	}
}