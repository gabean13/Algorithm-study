import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  LinkedList<Character> left = new LinkedList<>();
	  LinkedList<Character> right = new LinkedList<>();
	  
    for(char ch : br.readLine().toCharArray()) {
      left.add(ch);
    }
    
    int orderCount = Integer.parseInt(br.readLine());
    for(int i = 0; i < orderCount; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      switch(st.nextToken()) {
        case("L") : {
          if(left.isEmpty()) break;
          right.addFirst(left.removeLast());
          break;
        }
        case("D") : {
          if(right.isEmpty()) break;
          left.addLast(right.removeFirst());
          break;
        }
        case("B") : {
          if(left.isEmpty()) break;
          left.removeLast();
          break;
        }
        case("P") : {
          char addStr = st.nextToken().charAt(0);
          left.addLast(addStr);
          break;
        }
      }
    }
    
    StringBuilder sb = new StringBuilder();
    for(char str : left) {
      sb.append(str);
    }
    for(char str : right) {
      sb.append(str);
    }
    
    System.out.println(sb.toString());
	}
}
