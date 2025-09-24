import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    int n = Integer.parseInt(st.nextToken());
	    int k = Integer.parseInt(st.nextToken());
	    
	    List<Integer> list = new ArrayList<>();
	    for(int i = 0; i < n; i++) {
	      list.add(i + 1);
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    int idx = 0;
	    while(n > 0) {
	      idx = (idx + k - 1) % n;
	      sb.append(list.remove(idx)).append(", ");
	      n--;
	    }
	    
	    int length = sb.toString().length();
	    System.out.println("<" + sb.toString().substring(0, length-2) + ">");
	}
}