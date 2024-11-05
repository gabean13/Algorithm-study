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
		
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1; testCase <= 10; testCase++)
		{	
			br.readLine();
			int[][] matrix = new int[100][100];
			int cx = 0, cy = 0;
			for(int y = 0; y < 100; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int x = 0; x < 100; x++) {
					matrix[y][x] = Integer.parseInt(st.nextToken());
					if(matrix[y][x] == 2) {
						cx = x;
						cy = y;
					}
				}
			}
			sb.append("#" + testCase + " ").append(bfs(matrix, cx, cy)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int bfs(int[][] matrix, int cx, int cy) {
		int dir = 0; //0 세로 이동 -1 왼쪽 이동 1 오른쪽 이동
		
		while(cy != 0) {
			int right = cx + 1;
			int left = cx - 1;
			if(right < 100 && matrix[cy][right] == 1 && dir != -1) {
				dir = 1;
			} else if(left >= 0 && matrix[cy][left] == 1 && dir != 1) {
				dir = -1;
			} else {
				dir = 0;
			}
			
			if(dir == 0) {
				cy -= 1;
			} else {
				cx += dir;
			}
		}
		
		return cx;
	}
}