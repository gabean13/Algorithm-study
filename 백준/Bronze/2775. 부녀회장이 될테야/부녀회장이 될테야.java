import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[][] people = new int[15][15];
        for(int i = 1; i < 15; i++){
            people[0][i] = i;
        }

        for(int i = 1; i < 15; i++){
            for(int j = 1; j < 15; j++){
                int sum = 0;
                for(int k = 1; k <= j; k++){
                    sum+=people[i-1][k];
                }
                people[i][j] = sum;
            }
        }

        for(int i = 0; i < T; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(people[k][n]);
        }
    }
}