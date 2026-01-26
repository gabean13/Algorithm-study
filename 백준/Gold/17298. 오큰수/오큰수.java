import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int[] arr = new int[n];
	    for(int i = 0; i < n; i++) {
	      arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    
	    int[] answer = new int[n];
	    Stack<Integer> stack = new Stack<>();
	    stack.push(arr[n-1]);
	    answer[n-1] = -1;
	    for(int i = n - 2; i >= 0; i--) {
	      int current = arr[i];
	      while(!stack.isEmpty() && stack.peek() <= current){
	        stack.pop();
	      }
	      if (stack.isEmpty() || stack.peek() <= current) {
	        answer[i] = -1;
	      } else {
	        answer[i] = stack.peek();
	      }
	      stack.push(current);
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0;i < n; i++) {
	      sb.append(answer[i]).append(" ");
	    }
	    System.out.println(sb.toString());
	}
}