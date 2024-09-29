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
			int k = Integer.parseInt(st.nextToken());
			
			int[][] matrix = new int[height][width];
			for(int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				matrix[y][x] = 1;
			}
			sb.append(returnAnswer(width, height, matrix)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static int returnAnswer(int width, int height, int[][] matrix) throws IOException {
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		int[][] visited = new int[height][width];
		int answer = 0;
		Queue<Node> queue = new LinkedList<>();
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				if(visited[y][x] == 0 && matrix[y][x] == 1) {
					queue.add(new Node(x, y));
					visited[y][x] = 1;
					answer++;
				}
				
				while(!queue.isEmpty()) {
					Node node = queue.poll();
					int cx = node.x;
					int cy = node.y;
					for(int dir = 0; dir < 4; dir++) {
						int nx = cx + dx[dir];
						int ny = cy + dy[dir];
						if(nx < 0 || nx >= width || ny < 0 || ny >= height) {
							continue;
						}					
						if(matrix[ny][nx] == 1 && visited[ny][nx] == 0) {
							queue.add(new Node(nx, ny));
							visited[ny][nx] = 1;
						}
					}
				}
			}
		}
		return answer;
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