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
		
		//한번 돌면서 모든 애들의 동서남북 체크, 0인 수만큼 각 애들에서 빼준다(하나하나처리 하면 안됨)
		//종료 조건 빙산 2개 이상
		
		//0이 아니거나, 방문한 부분은 빼지 않음
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		Queue<Node> queue = new LinkedList<>();
		int year = 0;
		while(true) {
			int iceCnt = 0;
			boolean[][] visited = new boolean[height][width];
			for(int y = 0; y < height; y++) {
				for(int x = 0; x < width; x++) {
					if(matrix[y][x] == 0) continue;
					if(!visited[y][x]) {
						queue.add(new Node(y,x));
						visited[y][x] = true;
						iceCnt++;
						if(iceCnt >= 2) {
							System.out.println(year);
							return;
						}
					}
					
					while(!queue.isEmpty()) {
						Node node = queue.poll();
						int cx = node.x;
						int cy = node.y;
						for(int i = 0; i < 4; i++) {
							int nx = cx + dx[i];
							int ny = cy + dy[i];
							if(matrix[ny][nx] != 0 && !visited[ny][nx]) {
								queue.add(new Node(ny, nx));
								visited[ny][nx] = true;
							} else if (matrix[ny][nx] == 0 && !visited[ny][nx]) {
								if(matrix[cy][cx] > 0) matrix[cy][cx]--;
							}
						}
					}
				}
			}
			year++;
			if(iceCnt == 0) {
				System.out.println("0");
				break;
			}
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