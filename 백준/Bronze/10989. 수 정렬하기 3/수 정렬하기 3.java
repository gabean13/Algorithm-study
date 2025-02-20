import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];

        for(int i = 0; i < N; i++){
            arr[Integer.parseInt(br.readLine())]++;
        }

        for(int i = 1; i < 10001; i++){
            while(arr[i] > 0){
		        sb.append(i).append("\n");
                arr[i]--;
            }
        }

        System.out.println(sb);
    }
}