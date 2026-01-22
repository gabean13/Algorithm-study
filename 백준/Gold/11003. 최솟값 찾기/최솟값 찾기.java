import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int L = Integer.parseInt(st.nextToken());

	    List<Node> list = new ArrayList<>();
	    st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < N; i++) {
	      int value = Integer.parseInt(st.nextToken());
	      Node node = new Node(i, value);
	      list.add(node);
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    Deque<Node> deque = new LinkedList<>();
	    for(int i = 0; i < N; i++) {
	      Node current = list.get(i);
	      while(!deque.isEmpty() && deque.getLast().value > current.value) {
	        deque.removeLast();
	      }
	      deque.addLast(current);
	      
	      if(deque.getFirst().idx <= i - L) {
	        deque.removeFirst();
	      }
	      
	      sb.append(deque.getFirst().value).append(" ");
	    }
	    
	    System.out.println(sb.toString());
	}
}

class Node{
  int idx;
  int value;
  
  public Node(int idx, int value) {
    this.idx = idx;
    this.value = value;
  }
}