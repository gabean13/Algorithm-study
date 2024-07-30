import java.util.*;
import java.io.*;
import java.util.Collections;

class Main {
	static public void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    

        int [][] matrix = new int[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            matrix[i][0] = x;
            matrix[i][1] = y;
        }

        Arrays.sort(matrix, (e1, e2) -> {
            if(e1[0] == e2[0]){
                return e1[1] - e2[1];
            }else{
                return e1[0] - e2[0];
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int[] arr : matrix){
            sb.append(arr[0]).append(" ").append(arr[1]).append("\n");
        }

        System.out.println(sb);
    }
}