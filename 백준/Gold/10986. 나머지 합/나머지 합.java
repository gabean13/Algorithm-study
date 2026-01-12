import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    // N, M 입력
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    // long 배열 입력 이때 (합 + 입력 % M) % M으로 나머지의 합 저장
	    st = new StringTokenizer(br.readLine());
	    long[] sums = new long[N];
	    sums[0] = Long.parseLong(st.nextToken()) % M;
	    for(int i = 1; i < N; i++) {
	      sums[i] = (Long.parseLong(st.nextToken()) % M + sums[i-1]) % M;
	    }
	    
	    long[] c = new long[M];
	    long answer = 0;
	    for(int i = 0; i < N; i++) {
	      int remainder = (int) (sums[i] % M);
	      if(remainder == 0) answer++;
	      c[remainder]++;
	    }
	    
	    for(int i = 0; i < M; i++) {
	      if(c[i] > 1) {
	        answer += (c[i] * (c[i] - 1) / 2);
	      }
	    }
	    
	    System.out.println(answer);
	}
}