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

public class Solution {
	static int n;
	static int[] days;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= testCases; i++) {
			n = Integer.parseInt(br.readLine());
			days = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				days[j] = Integer.parseInt(st.nextToken());
			}
			sb.append("#").append(i).append(" ").append(maxBenefit()).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static long maxBenefit() {
		long benefit = 0;
		int maxIdx = n;
		for(int i = 0; i < n; i++) {
			maxIdx = getMaxIdx(i, n);
			for(int j = i; j < maxIdx; j++) {
				benefit += (days[maxIdx] - days[j]);
			}
			i = maxIdx;
		}
		
		return benefit;
	}
	
	static int getMaxIdx(int startIdx, int endIdx) {
		int max = 0;
		int maxIdx = -1;
		for(int i = startIdx; i < endIdx; i++) {
			if(max < days[i]) {
				max = days[i];
				maxIdx = i;
			}
		}
		
		return maxIdx;
	}
}