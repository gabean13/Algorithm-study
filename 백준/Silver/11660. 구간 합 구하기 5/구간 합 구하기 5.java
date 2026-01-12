import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    // N 입력, M 입력
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    // N 저장하면서 S도 같이 구한다
	    int[][] sums = new int[N+1][N+1];
	    for(int x = 1; x <= N; x++) {
	      st = new StringTokenizer(br.readLine());
	      for(int y = 1; y <= N; y++) {
	        int num = Integer.parseInt(st.nextToken());
	        sums[x][y] = num + sums[x][y-1] + sums[x-1][y] - sums[x-1][y-1];
	      }
	    }
	    
	    // M번 반복
	    //  x1, y1 / x2, y2 입력
	    //  결과 저장
	    StringBuilder sb = new StringBuilder();
	    for(int run = 0; run < M; run++) {
	      st = new StringTokenizer(br.readLine());
	      int x1 = Integer.parseInt(st.nextToken());
	      int y1 = Integer.parseInt(st.nextToken());
	      int x2 = Integer.parseInt(st.nextToken());
	      int y2 = Integer.parseInt(st.nextToken());
	      int sum = sums[x2][y2] - sums[x1-1][y2] - sums[x2][y1-1] + sums[x1-1][y1-1];
	      sb.append(sum).append("\n");
	    }
	    
	    // 결과 출력
	    System.out.println(sb.toString());
	}
}