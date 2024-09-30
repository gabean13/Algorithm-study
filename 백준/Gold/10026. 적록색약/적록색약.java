import java.io.*;
import java.util.*;

public class Main {
	public static void main(String...args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		char[][] matrix = new char[n][n];
		for(int y = 0; y < n; y++) {
			char[] input = br.readLine().toCharArray();
			for(int x = 0; x < n; x++) {
				matrix[y][x] = input[x];
			}
		}
		
		//로직
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		int[][] visited = new int[n][n];
		int normal = 0;
		//정상 
		Queue<Node> queue = new LinkedList<>();
		for(int y = 0; y < n; y++) {
			for(int x = 0; x < n ; x++) {
				if(visited[y][x] == 0) {
					queue.add(new Node(x, y));
					visited[y][x] = 1;
					normal++;
				}
				
				while(!queue.isEmpty()) {
					Node node = queue.poll();
					for(int dir = 0; dir < 4; dir++) {
						int nx = dx[dir] + node.x;
						int ny = dy[dir] + node.y;
						if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
							continue;
						}
						if(matrix[ny][nx] == matrix[node.y][node.x] && visited[ny][nx] == 0) {
							queue.add(new Node(nx, ny));
							visited[ny][nx] = 1;
						}
					}
				}
			}
		}
		
		//적록색맹 눈
		int notNormal = 0;
		visited = new int[n][n];
		for(int y = 0; y < n; y++) {
			for(int x = 0; x < n ; x++) {
				if(visited[y][x] == 0) {
					queue.add(new Node(x, y));
					visited[y][x] = 1;
					notNormal++;
				}
				
				while(!queue.isEmpty()) {
					Node node = queue.poll();
					for(int dir = 0; dir < 4; dir++) {
						int nx = dx[dir] + node.x;
						int ny = dy[dir] + node.y;
						if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
							continue;
						}
						if(visited[ny][nx] == 0) {
							if(matrix[ny][nx] == matrix[node.y][node.x]) {
								queue.add(new Node(nx, ny));
								visited[ny][nx] = 1;
							} else if(matrix[ny][nx] == 'R' && matrix[node.y][node.x] == 'G') {
								queue.add(new Node(nx, ny));
								visited[ny][nx] = 1;
							} else if(matrix[ny][nx] == 'G' && matrix[node.y][node.x] == 'R') {
								queue.add(new Node(nx, ny));
								visited[ny][nx] = 1;
							}
						}
					}
				}
			}
		}
		
		System.out.println(normal + " " + notNormal);
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