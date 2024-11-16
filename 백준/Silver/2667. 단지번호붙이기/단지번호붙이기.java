import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//입력
		int size = Integer.parseInt(br.readLine());
		
		int[][] matrix = new int[size][size];
		for(int y = 0; y < size; y++) {
			String[] str = br.readLine().split("");
			for(int x = 0; x < size; x++) {
				if(str[x].equals("0")) {
					matrix[y][x] = 0;
				} else {
					matrix[y][x] = 1;
				}
			}
		}
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		//계산
		int total = 0;
		List<Integer> list = new ArrayList<>(); 
		Queue<Node> queue = new LinkedList<>();
		boolean[][] visited = new boolean[size][size];
		for(int y = 0; y < size; y++) {
			for(int x = 0; x < size; x++) {
				//단지 발견
				if(matrix[y][x] == 1 && !visited[y][x]) {
					queue.add(new Node(x, y));
					visited[y][x] = true;
					total++;
				}
				
				int houseNum = 0;
				while(!queue.isEmpty()) {
					Node node = queue.poll();
					int cx = node.x;
					int cy = node.y;
					houseNum++;
					for(int i = 0; i < 4; i++) {
						int nx = cx + dx[i];
						int ny = cy + dy[i];
						if(ny < 0 || nx < 0 || nx >= size || ny >= size) continue;
						if(matrix[ny][nx] == 1 && !visited[ny][nx]) {
							queue.add(new Node(nx, ny));
							visited[ny][nx] = true;
						}
					}
				}
				if(houseNum != 0) {
					list.add(houseNum);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(total);
		for(int num : list) {
			System.out.println(num);
		}
	}
	
	static class Node {
		int x, y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}