import java.io.*;
import java.util.*;

public class Main {
	static int[][] matrix;
	static int n;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		matrix = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int edge1 = Integer.parseInt(st.nextToken());
			int edge2 = Integer.parseInt(st.nextToken());
			matrix[edge1][edge2] = 1;
			matrix[edge2][edge1] = 1;
		}
		
		int group = 0;
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				dfs(i);
				group++;
			}
		}
		
		System.out.println(group);
	}
	
	static void dfs(int cx) {
		visited[cx] = true;
		
		for(int j = 1; j <= n; j++) {
			if(matrix[cx][j] == 1 && !visited[j]) {
				dfs(j);
			}
		}
	}
}