import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int m = Integer.parseInt(st.nextToken());
	    int n = Integer.parseInt(st.nextToken());
	    
	    boolean[] isComposite = new boolean[n+1];
	    isComposite[1] = true;
	    for(int i = 2; i * i <= n; i++) {
	      if(isComposite[i]) continue;
	      for(int j = i * i; j <= n; j += i) {
	        isComposite[j] = true;
	      }
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    for(int i = m; i <= n; i++) {
	      if(!isComposite[i]) {
	        sb.append(i).append("\n");
	      }
	    }
	    
	    System.out.println(sb.toString());
	}
}