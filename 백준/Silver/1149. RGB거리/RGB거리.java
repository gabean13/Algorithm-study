import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n= Integer.parseInt(br.readLine());
	    
	    int[][] s = new int[n][3];
	    
	    for(int i = 0; i < n; i++) {
	      StringTokenizer st = new StringTokenizer(br.readLine());
	      s[i][0] = Integer.parseInt(st.nextToken());
	      s[i][1] = Integer.parseInt(st.nextToken());
	      s[i][2] = Integer.parseInt(st.nextToken());
	    }
	    
	    int[][] d = new int[n][3];
	    d[0][0] = s[0][0];
	    d[0][1] = s[0][1];
	    d[0][2] = s[0][2];
	    
	    for(int i = 1; i < n; i++) {
	      d[i][0] = s[i][0] + Math.min(d[i-1][1], d[i-1][2]);
	      d[i][1] = s[i][1] + Math.min(d[i-1][0], d[i-1][2]);
	      d[i][2] = s[i][2] + Math.min(d[i-1][0], d[i-1][1]);
	    }
	    
	    int answer = Math.min(Math.min(d[n-1][0], d[n-1][1]), d[n-1][2]);
	    System.out.println(answer);
	}
}