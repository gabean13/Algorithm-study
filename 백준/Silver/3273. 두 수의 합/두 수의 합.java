import java.io.*;
import java.util.*;

class Main {
	static public void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int[] arr = new int[1000001];

        //입력 처리
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[Integer.parseInt(st.nextToken())] = 1;
        }

        int x = Integer.parseInt(br.readLine());

        //구현
        for(int i = 1; i < (x > 1000001 ? 1000001 : x); i++){
            int xTargetIdx = x - i;
            if(arr[i] == 1 && xTargetIdx <= 1000000 && arr[xTargetIdx] == 1){
                answer++;
            }
        }

        System.out.println(answer/2);
    }
}