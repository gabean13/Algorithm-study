import java.io.*;
import java.util.*;

public class Main {
	public static void main(String...args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		char[][] matrix = new char[height][width];
		for(int i = 0; i < height; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j =0; j < width; j++) {
				matrix[i][j] = input[j];
			}
		}
		
		boolean[][] visited = new boolean[height][width];
		boolean[][] breakVisited = new boolean[height][width];
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		int answer = -1;
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0, 1, false));
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int cx = node.x;
			int cy = node.y;
			int cdist = node.dist;
			if(cx == width -1 && cy == height -1) {
				answer = cdist;
				break;
			}
			for(int dir = 0; dir < 4; dir++) {
				int nx = dx[dir] + cx;
				int ny = dy[dir] + cy;
				if(nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
				//벽을 부순 경
				if(node.breakWall) {
					if(!breakVisited[ny][nx] && matrix[ny][nx] == '0') {
						queue.add(new Node(nx, ny, cdist + 1, true));
						breakVisited[ny][nx] = true;
					}
				} else {
					if(!visited[ny][nx] && matrix[ny][nx] == '0') {
						queue.add(new Node(nx, ny, cdist + 1, false));
						visited[ny][nx] = true;
					} else if(matrix[ny][nx] == '1') {
						queue.add(new Node(nx, ny, cdist + 1, true));
						breakVisited[ny][nx] = true;
					}
				}
			}
		}
		
		System.out.println(answer);
		
	}
	
	
	static class Node{
		int x;
		int y;
		int dist;
		boolean breakWall;

		public Node(int x, int y, int dist, boolean breakWall) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.breakWall = breakWall;
		}
	}
}