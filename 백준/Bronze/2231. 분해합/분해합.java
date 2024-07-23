import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //분해합 = 245 + 2 + 4 + 5
        //245의 분해합 256, 245는 256의 생성자
        //N에서 가장 작은 생성자를 구하기  

        int answer = 0;
        //검사
        for(int i = 1; i < N; i++){
            //각 자리수 합
            int curr = i;
            int sum = 0;
            while(curr > 0){
                sum += (curr % 10);
                curr /= 10;
            }
            if(sum + i == N){
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}