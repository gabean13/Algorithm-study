import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      // 수의 개수 int N, run 개수 int M 입력
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      
      // 숫자들의 합 long[] sNums 계산
      long[] sNums = new long[N+1];
      st = new StringTokenizer(br.readLine());
      for(int i = 1; i <= N; i++) {
        int num = Integer.parseInt(st.nextToken());
        sNums[i] = num + sNums[i-1];
      }
      
      // for(M만큼) {
      //   int start, int end 입력
      //   sNums[end] - sNums[start-1] 출력
      // }
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        sb.append(sNums[end] - sNums[start-1]).append("\n");
      }
      System.out.println(sb.toString());
	} 
}