import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    
	    long answer = 0;
	    long[] sumArr = new long[n];
	    st = new StringTokenizer(br.readLine());
	    sumArr[0] = Long.parseLong(st.nextToken()) % m;
	    for(int i = 1; i < n; i++) {
	      long num = Long.parseLong(st.nextToken()) % m;
	      sumArr[i] = (sumArr[i-1] + num) % m;
	    }
	    
	    long[] countArr = new long[m];
	    for(int i = 0; i < n; i++) {
	      int count = (int) sumArr[i];
	      countArr[count]++;
	    }
	    
	    for(int i = 0; i < m; i++) {
	      if(countArr[i] > 1) {
	        answer += countArr[i] * (countArr[i] - 1) / 2;
	      }
	    }
	    
	    System.out.println(answer + countArr[0]);
	}
}