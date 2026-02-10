import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int sx = Integer.parseInt(st.nextToken());
	    int dongx = Integer.parseInt(st.nextToken());
      
	    int[] dist = new int[100001];
	    LinkedList<Integer> q = new LinkedList<>();
	    q.add(sx);
	    dist[sx] = 1;
	    
	    int answer = 0;
	    while(!q.isEmpty()) {
	      int c = q.poll();
	      if(c == dongx) {
	        answer = dist[c];
	        break;
	      }
	   
	      int nx = c + 1;
	      if(nx >= 0 && nx <= 100000 && dist[nx] == 0) {
	        q.add(nx);
	        dist[nx] = dist[c] + 1;
	      }
	      
	      nx = c - 1;
	      if(nx >= 0 && nx <= 100000 && dist[nx] == 0) {
	        q.add(nx);
	        dist[nx] = dist[c] + 1;
	      }
	      
	      nx = c * 2;
	      if(nx >= 0 && nx <= 100000 && dist[nx] == 0) {
	        q.add(nx);
	        dist[nx] = dist[c] + 1;
	      }
	    }
	    
	    System.out.println(answer - 1);
  }
}