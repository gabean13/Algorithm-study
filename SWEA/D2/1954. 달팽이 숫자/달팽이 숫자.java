/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCases = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= testCases; i++)
		{	
			int num = Integer.parseInt(br.readLine());
			int[][] matrix = new int[num][num];
			boolean[][] visited = new boolean[num][num];
			int[] dx = {1, 0, -1, 0};
			int[] dy = {0, 1, 0, -1};
			int x = 0, y = 0;
			int idx = 2;
			int dir = 0;
			matrix[0][0] = 1;
			visited[0][0] = true;
			while(true) {
				if(idx > num*num) break; 
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if(nx < 0 || ny < 0 || nx >= num || ny >= num || visited[ny][nx]) {
					dir++;
					if(dir > 3) {
						dir = 0;
					}
					continue;
				}
				matrix[ny][nx] = idx++;
				visited[ny][nx] = true;
				x = nx;
				y = ny;
			}
			
			//출력
			sb.append("#").append(i).append("\n");
			for(int py = 0; py < num; py++) {
				for(int px = 0; px < num; px++) {
					sb.append(matrix[py][px]).append(" ");
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}
}