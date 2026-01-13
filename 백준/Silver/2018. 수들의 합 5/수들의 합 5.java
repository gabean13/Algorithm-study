import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    // N 입력
	    int N = Integer.parseInt(br.readLine());
	    
	    // 1 ~ N까지 배열 선언
	    int[] arr = new int[N+1];
	    for(int i = 1; i <= N; i++) {
	      arr[i] = i;
	    }
	    
	    // answer = 1 선언
	    int answer = 1;
	    
	    // while(arr[right] < N)까지 돈다 
	    //  l < r 이어야함
	    int l = 0;
	    int r = 1;
	    long sum = arr[l] + arr[r];
	    while(arr[r] < N && r < N && l <= r) {
	      if(sum > N) {
	        sum -= arr[l];
	        l++;
	      }
	      
	      if(sum < N) {
	        r++;
	        sum += arr[r];
	      }
	      
	      if(sum == N) {
	        answer++;
	        r++;
	        sum = sum + arr[r] - arr[l];
	        l++;
	      }
	    }
	    
	    System.out.println(answer);
	}
}