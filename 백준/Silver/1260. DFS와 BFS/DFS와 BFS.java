import java.io.*;
import java.util.*;

public class Main {
	static int[][] matrix;
	static int n;
	static int startPoint;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		startPoint = Integer.parseInt(st.nextToken());
		
		matrix = new int[n+1][n+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			matrix[a][b] = 1;
			matrix[b][a] = 1;
		}
		
		boolean[] visited = new boolean[n+1]; 
		dfs(startPoint, visited);
		sb.append("\n");
		bfs();
		System.out.println(sb);
	}
	
	static void dfs(int start, boolean[] visited) {
		visited[start] = true;
		sb.append(start).append(" ");
		
		for(int i = 1; i <= n; i++) {
			if(matrix[start][i] == 1 && !visited[i]) {
				dfs(i, visited);
			}
		}
	}
	
	static void bfs() {
		boolean[] visited = new boolean[n+1]; 
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startPoint);
		visited[startPoint] = true;
		
		while(!queue.isEmpty()) {
			int cx = queue.poll();
			sb.append(cx).append(" ");
			for(int i = 1; i <= n; i++) {
				if(matrix[cx][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
		sb.append("\n");
	}
}