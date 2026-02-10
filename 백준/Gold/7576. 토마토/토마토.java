import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int width = Integer.parseInt(st.nextToken());
	    int height = Integer.parseInt(st.nextToken());
	    
	    int[][] matrix = new int[height][width];
	    boolean[][] visited = new boolean[height][width];
	    LinkedList<Node> queue = new LinkedList<>();
	    
	    // 시작 값들을 큐에 넣기, 방문하고시작
	    for(int y = 0; y < height; y++) {
	      st = new StringTokenizer(br.readLine());
	      for(int x = 0; x < width; x++) {
	        matrix[y][x] = Integer.parseInt(st.nextToken());
	        if(matrix[y][x] == 1) {
	          queue.add(new Node(x, y, 0));
	          visited[y][x] = true;
	        }
	      }
	    }
	    
	    int max = 0;
	    int[] dx = {1, -1, 0, 0};
	    int[] dy = {0, 0, 1, -1};
	    while(!queue.isEmpty()) {
	      Node c = queue.poll();
	      if(c.count > max) max = c.count;
	      for(int i = 0; i < 4; i++) {
	        int nx = c.x + dx[i];
	        int ny = c.y + dy[i];
	        if(nx < 0 || nx >= width || ny < 0 || ny >= height) continue;
	        if(matrix[ny][nx] != 0 || visited[ny][nx]) continue;
	        queue.add(new Node(nx, ny, c.count + 1));
	        visited[ny][nx] = true;
	        matrix[ny][nx] = 1;
	      }
	    }
	    
	    // max 값을 구한다 / 만약 0인 값이 있으면 실패 
	   for(int y = 0; y < height; y++) {
	     for(int x = 0; x < width; x++) {
	       if(matrix[y][x] == 0) {
	         System.out.println(-1);
	         return;
	       }
	     }
	   }
	   
	   System.out.println(max);
	}
}

class Node{
	  int x;
	  int y;
	  int count;
	  
	  public Node(int x, int y, int count) {
	    this.x = x;
	    this.y = y;
	    this.count = count;
	  }
	}