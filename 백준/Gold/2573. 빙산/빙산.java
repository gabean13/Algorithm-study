import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String...args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		int[][] matrix = new int[height][width];
		for(int y = 0; y < height; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x = 0; x < width; x++ ) {
				matrix[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		Queue<Node> queue = new LinkedList<>();
		int year = 0;
		
		while(true) {
			boolean[][] visited = new boolean[height][width];
			int icebergCnt = 0;
			boolean hasIce = false;
			
			for(int y = 0; y < height; y++) {
				for(int x = 0; x < width; x++) {
					if(matrix[y][x] > 0 && !visited[y][x]) {
						hasIce = true;
						queue.add(new Node(y,x));
						visited[y][x] = true;
						icebergCnt++;
						//종료조건 1 
						if(icebergCnt >= 2) {
							System.out.println(year);
							return;
						}
					}
					
					//빙산 개수 세기 및 녹이기
					while(!queue.isEmpty()) {
						Node node = queue.poll();
						int cx = node.x;
						int cy = node.y;
						int meltCnt = 0;
						
						for(int i = 0; i < 4; i++) {
							int nx = cx + dx[i];
							int ny = cy + dy[i];
							if(matrix[ny][nx] != 0 && !visited[ny][nx]) {
								queue.add(new Node(ny, nx));
								visited[ny][nx] = true;
							} else if (matrix[ny][nx] == 0 && !visited[ny][nx]) {
								meltCnt++;
							}
						}
						matrix[cy][cx] = Math.max(0, matrix[cy][cx] - meltCnt);
					}
				}
			}
			//종료 조건 2
			if(!hasIce) {
				System.out.println("0");
				return;
			}
			
			year++;
		}
	}
	
	static class Node {
		int y;
		int x;
		int side = 0;
		public Node (int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}