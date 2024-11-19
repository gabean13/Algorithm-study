import java.io.*;
import java.util.*;

public class Main {
	static int size;
	static int[][] matrix;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력
		size = Integer.parseInt(br.readLine());
		matrix = new int[size][size];
		for(int y = 0; y < size; y++) {
			char[] inputs = br.readLine().toCharArray();
 			for(int x = 0; x < size; x++) {
				matrix[y][x] = inputs[x] - '0';
			}
		}
		
		//계산
		recurv(new Node(0, 0), new Node(size-1, size-1));
		System.out.println(sb);
	}
	
	static void recurv(Node start, Node end) {
		if(isAllSame(start, end)) {
			sb.append(matrix[start.y][start.x]);
			return;
		}
		
		int nextSize = (end.x - start.x + 1) / 2;
		sb.append("(");
		recurv(start, new Node(start.x + nextSize-1, start.y + nextSize -1));
		recurv(new Node(start.x + nextSize, start.y), new Node(end.x, start.y + nextSize -1));
		recurv(new Node(start.x, start.y + nextSize), new Node(start.x + nextSize-1, end.y));
		recurv(new Node(start.x + nextSize, start.y + nextSize), end);
		sb.append(")");
	}
	
	static boolean isAllSame(Node start, Node end) {
		int value = matrix[start.y][start.x];
		for(int y = start.y; y<= end.y; y++) {
			for(int x = start.x; x <= end.x; x++) {
				if(matrix[y][x] != value) {
					return false;
				}
			}
		}
		return true;
	}

	static class Node{
		int x, y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}