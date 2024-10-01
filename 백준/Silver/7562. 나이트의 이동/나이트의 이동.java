import java.io.*;
import java.util.*;

public class Main {
	public static void main(String...args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int round = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder()
;		for(int i = 0; i < round; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int gx = Integer.parseInt(st.nextToken());
			int gy = Integer.parseInt(st.nextToken());
			sb.append(bfs(n, x, y, gx, gy)).append("\n");
		}		
		
		System.out.println(sb);
	}
	
	public static int bfs(int n, int x, int y, int gx, int gy) {
		int[][] dist = new int[n][n];

		int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
		int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y));
		dist[y][x] = 1;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int cx = node.x;
			int cy = node.y;
			for(int i = 0; i < 8; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
					continue;
				}
				if(dist[ny][nx] == 0) {
					queue.add(new Node(nx, ny));
					dist[ny][nx] = dist[cy][cx] + 1;
				}
			}
		}
		
		return dist[gy][gx] - 1;
	}
	
	public static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}