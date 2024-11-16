import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		char[][] matrix = new char[height][width];
		
		int[][] fDist = new int[height][width];
		int[][] jDist = new int[height][width];
		Queue<Node> fq = new LinkedList<>();
		Queue<Node> jq = new LinkedList<>();
		for(int y = 0; y < height; y++) {
			char[] input = br.readLine().toCharArray();
			for(int x = 0; x < width; x++) {
				matrix[y][x] = input[x];
				if(matrix[y][x] == 'J') {
					jq.add(new Node(x, y));
					jDist[y][x] = 1;
					if(x == 0 || y == 0 || x == width-1 || y == height-1) {
		                System.out.println(1);
		                return;
		            }
				}
				if(matrix[y][x] == 'F') {
					fq.add(new Node(x, y));
					fDist[y][x] = 1;
				}
			}
		}
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		//불이 난 시간을 fireDist에 저장
		//지훈이는 불이 난 시간이랑 비교해서 그거보다 작아야지만 이동가능
		
		//1. 불 이동을 기록한다
		while(!fq.isEmpty()) {
			Node node = fq.poll();
			int cx = node.x;
			int cy = node.y;
			for(int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
				if(matrix[ny][nx] != '#' && fDist[ny][nx] == 0) {
					fq.add(new Node(nx, ny));
					fDist[ny][nx] = fDist[cy][cx] + 1;
				}
			}
		}
		
		int answer = -1;
		while(!jq.isEmpty()) {
			Node node = jq.poll();
			int cx = node.x;
			int cy = node.y;
			if(cx == 0 || cy == 0 || cx == width-1 || cy == height -1) {
				answer = jDist[cy][cx];
				break;
			}
			for(int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
				if(matrix[ny][nx] != '#' && jDist[ny][nx] == 0) {
					int nextDist = jDist[cy][cx] + 1;
					if(fDist[ny][nx] > nextDist || fDist[ny][nx] == 0) {
						jq.add(new Node(nx, ny));
						jDist[ny][nx] = nextDist;
					}
				}
			}
		}
			
		System.out.println(answer == -1 ? "IMPOSSIBLE" : answer);
	}
	
	static class Node {
		int x, y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}