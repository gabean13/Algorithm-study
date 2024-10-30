import java.io.*;
import java.util.*;

public class Main {
	
	static int W, H, K;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = {0, 0, 1, -1}; // 한 칸씩 이동
	static int[] dy = {1, -1, 0, 0}; // 한 칸씩 이동
	static int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1}; // 말 점프
	static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2}; // 말 점프

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = bfs(0, 0, K);
		
		System.out.println(ans);
	}
	
	static int bfs(int x, int y, int k) {
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(new Node(x, y, 0, 0));
		visited[x][y][0] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			int cx = node.x;
			int cy = node.y;
			
			if(cy == H-1 && cx == W-1) { // 목적지에 도착하면 종료
				return node.mCnt;
			}
			// 원숭이처럼 한 칸 씩만 탐색
			for(int t=0; t<4; t++) {
				int nx = cx + dx[t];
				int ny = cy + dy[t];
				
				if(nx < 0 || ny < 0 || ny >= H || nx >= W) continue;
				if(visited[ny][nx][node.hCnt]) continue;
				
				if(map[ny][nx] == 0) {
					visited[ny][nx][node.hCnt] = true;
					queue.add(new Node(nx, ny, node.hCnt, node.mCnt + 1));
				}
			}
			// 말 점프 횟수 남아 있으면 말 점프로 탐색
			if(node.hCnt < k) {
				for(int t=0; t<8; t++) {
					int nx = cx + hx[t];
					int ny = cy + hy[t];
					
					if(nx < 0 || ny < 0 || ny >= H || nx >= W) continue;
					if(visited[ny][nx][node.hCnt + 1]) continue;
					
					if(map[ny][nx] == 0) {
						visited[ny][nx][node.hCnt + 1] = true;
						queue.add(new Node(nx, ny, node.hCnt + 1, node.mCnt + 1));
					}
				}
			}
		}
		
		return -1;
	}
	
	static class Node{
		int x, y;
		int hCnt;//말 점프 횟수
		int mCnt;//움직인 횟수
		
		Node(int x, int y, int hCnt, int mCnt){
			this.x = x;
			this.y = y;
			this.hCnt = hCnt;
			this.mCnt = mCnt;
		}
	}
}