import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
      int[] answer = new int[n+1];
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    Stack<Top> topStack = new Stack<>();
	    for(int i = 1; i <= n; i++) {
	      topStack.push(new Top(Integer.parseInt(st.nextToken()), i));
	    }
	    
	    Stack<Top> tempStack = new Stack<>();
	    while(topStack.size() >= 2) {
	      Top current = topStack.pop();
	      Top left = topStack.peek();
	      while(!tempStack.isEmpty() && current.number >= tempStack.peek().number) {
	        Top temp = tempStack.pop();
	        answer[temp.position] = current.position;
	      }
	      
	      if(left.number >= current.number) {
	        answer[current.position] = left.position;
	        continue;
	      }
	      // 사라지지 않은 top은 tempStack에 넣는다
	      tempStack.push(current);
	    }
	    
	    Top first = topStack.pop();
	    while(!tempStack.isEmpty() && first.number >= tempStack.peek().number) {
	        Top temp = tempStack.pop();
	        answer[temp.position] = first.position;
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    for(int i = 1; i <= n; i++) {
	      sb.append(answer[i]).append(" ");
	    }
	    
	    System.out.println(sb.toString());
	}
}

class Top {
	  public int number;
	  public int position;
	  
	  public Top(int number, int position) {
	    this.number = number;
	    this.position = position;
	  }
}