import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < n; i++) {
	      StringTokenizer st = new StringTokenizer(br.readLine());
	      int M = Integer.parseInt(st.nextToken());
	      int N = Integer.parseInt(st.nextToken());
	      int x = Integer.parseInt(st.nextToken());
	      int y = Integer.parseInt(st.nextToken());
	      int answer = getYear(M, N, x, y);
	      sb.append(answer).append("\n");
	    }
	    
	    System.out.println(sb.toString());
	}
	
	static int getYear(int M, int N, int x, int y) {
	  int n = lmc(M, N);
	  
	  Set<Integer> xSet = new HashSet<>();
	  
	  int xMin = (x % M == 0) ? M : x%M;
	  for(int i = xMin; i <= n; i += M) {
	    xSet.add(i);
	  }
	  
	  int yMin = y % N;
	  for(int i = yMin; i <= n; i += N) {
	    if(xSet.contains(i)) {
	      return i;
	    }
	  }
	  
	  return -1;
	}
	
	static int lmc(int M, int N) {
	  return M / gdc(M, N) * N;
	}
	
	static int gdc(int a, int b) {
	  if(b == 0) return a;
	  return gdc(b, a%b);
	}
}