import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new TreeSet<>();

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;  //dp 초기값 모두 1
        }

        for(int i = 1; i < N; i++){
            int idx = 0;
            while(idx < i){
                if(arr[i] > arr[idx] && dp[idx] + 1 > dp[i]){
                    dp[i]++;
                }
                idx++;
            }
        }
        
        Arrays.sort(dp);

        System.out.println(dp[N-1]);
    }
}