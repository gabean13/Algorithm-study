
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String...args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int round = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < round; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			char[][] matrix = new char[height][width];
			Queue<Node> queue = new LinkedList<>();
			int[][] fireDist = new int[height][width];
			int[][] sangDist = new int[height][width];
			int sx = 0, sy = 0;
			for(int j = 0; j < height; j++) {
				char[] input = br.readLine().toCharArray();
				for(int k = 0; k < width; k++) {
					matrix[j][k] = input[k];
					if(matrix[j][k] == '@') {
						sangDist[j][k] = 1;
						sx = k;
						sy = j;
					}
					else if(matrix[j][k] == '*') {
						queue.add(new Node(k, j));
						fireDist[j][k] = 1; 
					}
				}
			}
			int result = bfs(width, height, matrix, fireDist, sx, sy, sangDist, queue);
			sb.append(result == 1000001 ? "IMPOSSIBLE" : result).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static int bfs(int width, int height, char[][] matrix, int[][] fireDist, int sx, int sy, int[][] sangDist, Queue<Node> queue) {
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		//불 번짐
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int cx = node.x;
			int cy = node.y;
			for(int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
				if(fireDist[ny][nx] == 0 && matrix[ny][nx] != '#') {
					queue.add(new Node(nx, ny));
					fireDist[ny][nx] = fireDist[cy][cx] + 1;
				}
			}
		}
		
		//상근이 이동
		queue.add(new Node(sx, sy));
		int min = 1000001;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int cx = node.x;
			int cy = node.y;
			if(cx == 0 || cy == 0 || cx == width - 1 || cy == height - 1) {
				if(sangDist[cy][cx] < min) {
					min = sangDist[cy][cx];
				}
			}
			for(int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
				if(sangDist[ny][nx] == 0 && matrix[ny][nx] == '.') {
					if((fireDist[ny][nx] > sangDist[cy][cx] + 1) || fireDist[ny][nx] == 0) {
						queue.add(new Node(nx, ny));
						sangDist[ny][nx] = sangDist[cy][cx] + 1;
					}
				}
			}		
		}
		return min;
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