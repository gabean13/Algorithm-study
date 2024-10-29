import java.io.*;
import java.util.*;

public class Main {
	static int[][] matrix;
	static int minusOneCnt = 0;
	static int zeroCnt = 0;
	static int plusOneCnt = 0;
	public static void main(String... args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		matrix = new int[n][n];
		
		for(int y = 0; y < n; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x = 0; x < n; x++) {
				matrix[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		recurv(new Node(0,0), new Node(n-1, n-1));
		System.out.println(minusOneCnt);
		System.out.println(zeroCnt);
		System.out.println(plusOneCnt);
		
	}	

	static void recurv(Node startNode, Node endNode) {
		if(allSameValue(startNode, endNode)) {
			int value = startNode.getMatrixValue();
			if(value == -1) {
				minusOneCnt++;
			} else if(value == 1) {
				plusOneCnt++;
			} else {
				zeroCnt++;
			}
			return;
		}
		
		int dis = (endNode.x - startNode.x + 1) / 3;
		for(int y = startNode.y; y <= endNode.y; y += dis) {
			for(int x = startNode.x; x <= endNode.x; x += dis) {
				recurv(new Node(y, x), new Node(y + dis - 1, x + dis - 1));
			}
		}
	}
	
	static boolean allSameValue(Node startNode, Node endNode) {
		int value = startNode.getMatrixValue();
		
		
		for(int y = startNode.y; y <= endNode.y; y++) {
			for(int x = startNode.x; x <= endNode.x; x++) {
				if(value != matrix[y][x]) {
					return false;
				}
			}
		}
		return true;
	}

	static class Node {
		int x;
		int y;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
		public boolean isSameNode(Node n) {
			if(this.x == n.x && this.y == n.y) {
				return true;
			}
			return false;
		}
		
		public int getMatrixValue() {
			return matrix[y][x];
		}
		
		public int getSize(Node n) {
			int width = n.y - this.y;
			return (width + 1) * (width + 1);
		}
	}
}