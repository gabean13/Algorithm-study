import java.io.*;
import java.util.*;

public class Main {
	public static void main(String...args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		Queue<Node> queue = new LinkedList<>();
		int[][][] dist = new int[H][N][M];
		int[][][] matrix = new int[H][N][M];
		for(int z = 0; z < H; z++) {
			for(int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x = 0; x < M; x++) {
					matrix[z][y][x] = Integer.parseInt(st.nextToken());
					if(matrix[z][y][x] == 1) {
						queue.add(new Node(x, y, z));
						dist[z][y][x] = 1;
					}
				}
			}
		}
		
		
		int[] dx = {1, -1, 0, 0, 0, 0};
		int[] dy = {0, 0, 1, -1, 0, 0};
		int[] dz = {0, 0, 0, 0, 1, -1};
		
		int answer = 0;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int cx = node.x;
			int cy = node.y;
			int cz = node.z;
			answer = dist[cz][cy][cx];
			for(int i = 0; i < 6; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				int nz = cz + dz[i];
				if(nx < 0 || ny < 0 || nz < 0 || nx >= M || ny >= N || nz >= H) {
					continue;
				}
				if(dist[nz][ny][nx] == 0 && matrix[nz][ny][nx] != -1) {
					queue.add(new Node(nx, ny, nz));
					matrix[nz][ny][nx] = 1;
					dist[nz][ny][nx] = dist[cz][cy][cx] + 1;
				}
			}
		}
		
		boolean success = true;
		for(int z = 0; z < H; z++) {
			for(int y = 0; y < N; y++) {
				for(int x = 0; x < M; x++) {
					if(matrix[z][y][x] == 0) {
						success = false;
						break;
					}
				}
			}
		}
		
		if(success) {
			System.out.println(answer-1);
		} else {
			System.out.println(-1);
		}
		
	}
	
	public static class Node {
		int x;
		int y;
		int z;
		
		public Node(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

}