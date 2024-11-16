import java.io.*;
import java.util.*;

public class Main {
	static int width;
	static int height; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		
		int[][] matrix = new int[height][width];
		int[][] dist = new int[height][width];
		Queue<Node> queue = new LinkedList<>();
		for(int y = 0; y < height; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x = 0; x < width; x++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					queue.add(new Node(x, y));
					dist[y][x] = 1;
				} 
				matrix[y][x] = num;
			}
		}
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int cx = node.x;
			int cy = node.y;
			for(int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
				if(dist[ny][nx] == 0 && matrix[ny][nx] == 0) {
					queue.add(new Node(nx, ny));
					dist[ny][nx] = dist[cy][cx] + 1;
					matrix[ny][nx] = 1;
				}
			}
		}

		int max = 0;
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				if(matrix[y][x] == 0) {
					System.out.println("-1");
					return;
				}
				if(max < dist[y][x]) {
					max = dist[y][x];
				}
			}
		}
		
		System.out.println(max-1);
	}
	
	static class Node {
		int x, y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}