import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int num = Integer.parseInt(br.readLine());
      
      int[] dist = new int[num+1];
      for(int i = 2; i <= num; i++) {
        int min = dist[i-1];
        if(i%3 == 0) {
          min = Math.min(min, dist[i/3]);
        }
        if(i%2 == 0) {
          min = Math.min(min, dist[i/2]);
        }
        dist[i] = min + 1;
      }
      
      System.out.println(dist[num]);
	}
}