import java.io.*;
import java.util.*;

class Main {
	static public void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int [] numCnt = new int[10];
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int multiple = A*B*C;

        while(multiple > 0){
            numCnt[multiple%10]++;
            multiple /= 10;
        }

        for(int cnt : numCnt){
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}