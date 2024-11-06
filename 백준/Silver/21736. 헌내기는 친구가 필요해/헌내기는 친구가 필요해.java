import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		int[][] matrix = new int[height][width];
		int dox = 0, doy = 0;
		for(int y = 0; y < height; y++) {
			String[] input = br.readLine().split("");
			for(int x = 0; x < width; x++) {
				if(input[x].equals("O")) {
					matrix[y][x] = 0;
				} else if(input[x].equals("I")) {
					matrix[y][x] = 2;
					dox = x;
					doy = y;
				} else if(input[x].equals("X")){
					matrix[y][x] = -1;
				} else {
					matrix[y][x] = 1;
				}
			}
		}
		
		//0 통과 가능, -1 벽 1 친구
		boolean[][] visited = new boolean[height][width];
		Queue<Node> queue = new LinkedList<>();
		
		int answer = 0;
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		queue.add(new Node(dox, doy));
		visited[doy][dox] = true;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int cx = node.x;
			int cy = node.y;
			if(matrix[cy][cx] == 1) {
				answer++;
			}
			for(int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
				if(matrix[ny][nx] != -1 && !visited[ny][nx]) {
					queue.add(new Node(nx, ny));
					visited[ny][nx] = true;
				}
			}
		}
		
		System.out.println(answer == 0 ? "TT" : answer);
	}
	
	static class Node {
		int x, y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}