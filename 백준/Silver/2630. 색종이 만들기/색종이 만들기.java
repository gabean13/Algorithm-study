import java.io.*;
import java.util.*;

public class Main {
	static int[][] matrix;
	static int n;
	static int blueCnt = 0, whiteCnt = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		matrix = new int[n][n];
		for(int y = 0; y < n; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x = 0; x < n; x++) {
				matrix[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		recurv(new Node(0, 0), new Node(n-1, n-1));
		System.out.println(whiteCnt);
		System.out.println(blueCnt);
	}
	
	static void recurv(Node start, Node end) {
		if(isAllSame(start, end)) {
			if(start.getValue() == 1) {
				blueCnt++;
			} else {
				whiteCnt++;
			}
			return;
		}
		
		int term = (end.x - start.x + 1) / 2 - 1;
		recurv(start, new Node(start.x + term, start.y + term));
		recurv(new Node(end.x - term, start.y), new Node(end.x, start.y + term));
		recurv(new Node(start.x, end.y - term), new Node(start.x + term, end.y));
		recurv(new Node(end.x - term, end.y - term), end);
	}
	
	static boolean isAllSame(Node start, Node end) {
		int target = start.getValue();
		
		for(int y = start.y; y <= end.y; y++) {
			for(int x = start.x; x <= end.x; x++) {
				if(target != matrix[y][x]) {
					return false;
				}
			}
		}
		return true;
	}
	
	static class Node {
		int x, y;
		Node (int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		int getValue() {
			return matrix[y][x];
		}
	}
}