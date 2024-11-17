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
import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String...strings) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for(int i = 1; i <= 10; i++)
		{	//입력
			br.readLine();
			int[][] matrix = new int[100][100];
			for(int y = 0; y < 100; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int x = 0; x < 100; x++) {
					matrix[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			//첫번째 대각선의 합
			int sum = 0;
			for(int y = 0; y < 100; y++) {
				sum += matrix[y][y];
			}
			max = Math.max(max, sum);
			//두번째 대각선의 합
			sum = 0;
			for(int y = 0; y < 100; y++) {
				sum += matrix[99-y][y];
			}
			max = Math.max(max, sum);
			//가로의 합
			for(int y = 0; y < 100; y++) {
				sum = 0;
				for(int x = 0; x < 100; x++) {
					sum += matrix[y][x];
				}
				max = Math.max(max, sum);
			}
			//세로의 합
			for(int x = 0; x < 100; x++) {
				sum = 0;
				for(int y = 0; y < 100; y++) {
					sum += matrix[y][x];
				}
				max = Math.max(max, sum);
			}
			
			sb.append("#").append(i).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb);
	}
}