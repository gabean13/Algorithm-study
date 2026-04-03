import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n= Integer.parseInt(br.readLine());
	    
	    int[] d = new int[n+1];
	    if(n == 1) {
	      System.out.println(1);
	      return;
	    }
	    if(n == 2) {
	      System.out.println(2);
	      return;
	    }
	    
	    d[1] = 1;
	    d[2] = 2;
	    for(int i = 3; i <= n; i++) {
	      d[i] = (d[i-1] + d[i-2]) % 10007;
	    }
	    
	    System.out.println(d[n]);
	}
}