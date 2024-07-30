import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. 자신보다 덩치가 큰 사람 수 + 1 = 자신의 등수
        //2. 덩치가 큰 기준 : 키 > 자신의 키 && 몸무게 > 자신의 몸무게
        int N = Integer.parseInt(br.readLine());
        
        int[][] matrix = new int[N][N];
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[N];
        for(int i = 0; i < N; i++){
            answer[i] = 1;
            int cw = matrix[i][0];
            int ch = matrix[i][1];
            for(int j = 0; j < N; j++){
                if(cw < matrix[j][0] && ch < matrix[j][1]){
                    answer[i]++;
                }
            }
        }

        for(int a : answer){
            System.out.print(a + " ");
        }
    }
}