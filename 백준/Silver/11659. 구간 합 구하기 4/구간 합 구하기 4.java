import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int caseNum = Integer.parseInt(st.nextToken());
	    
	    long[] sum = new long[n+1];
	    st = new StringTokenizer(br.readLine());
	    for(int i = 1; i <= n; i++) {
	      long num = Integer.parseInt(st.nextToken());
	      sum[i] = sum[i-1] + num;
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < caseNum; i++) {
	      st = new StringTokenizer(br.readLine());
	      int f = Integer.parseInt(st.nextToken());
	      int r = Integer.parseInt(st.nextToken());
	      sb.append(sum[r] - sum[f-1]).append("\n");
	    }
	    
	    System.out.println(sb.toString());
	}
}