import java.util.*;
import java.io.*;

public class Main {
  
  static int answer= 0;
  static int s;
  static int n;
  static int[] arr;

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      
      n = Integer.parseInt(st.nextToken());
      s = Integer.parseInt(st.nextToken());
      
      arr = new int[n];
      st = new StringTokenizer(br.readLine(), " ");
      for(int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }
      
      function(0, 0);
      
      // 공집합까지 포함해서 s가 0인 경우 공집합을 제외해주어야한다.
      if(s == 0) answer--;
      System.out.println(answer);
	}

	static void function(int k, int sum) {
	  if(k == n) {
	    if(sum == s) answer++;
	    return;
	  }
	  
	 function(k + 1, sum);
	 function(k + 1, sum + arr[k]);
	}
}