import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      // N 입력
      int N = Integer.parseInt(br.readLine());
      
      // M 입력
      int M = Integer.parseInt(br.readLine());
      
      // 배열 arr [N] 입력
      int[] arr = new int[N];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i = 0; i < N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }
      
      // 배열 정렬
      Arrays.sort(arr);
      
      int l = 0;
      int r = N-1;
      int answer = 0;
      while(l < r) {
        long sum = arr[l] + arr[r];
        if(sum == M) {
          answer++;
          l++;
        } else if(sum > M) {
          r--;
        } else if(sum < M) {
          l++;
        }
      }
      System.out.println(answer);
	}
}