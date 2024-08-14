import java.util.*;
import java.io.*;

class Main {
    static int[] stack = new int[100000];
    static int top = -1;
    static int MAX = 99999;

	static public void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long answer = 0;

        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                stack[top--] = 0;
                continue;
            }
            stack[++top] = num;
        }

        for(int i = 0; i <= top; i++){
            answer += stack[i];
        }

        System.out.println(answer);
    }
}