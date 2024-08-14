import java.util.*;
import java.io.*;

class Main {
    static int[] stack;
    static int top = -1;
    static StringBuilder sb = new StringBuilder();

	static public void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        // 입력
        int n = Integer.parseInt(br.readLine());
        int[] wantedArr = new int[n];
        stack = new int[n];

        for(int i = 0; i < n; i++) {
            wantedArr[i] = Integer.parseInt(br.readLine());
        }

        push(1);
        int stackValue = 2;

        for(int arrNum : wantedArr) {
            if(top() == arrNum) {
                pop();
            } else {
                for(int i = stackValue; i <= arrNum; i++) {
                    push(i);
                }
                stackValue = arrNum + 1;
                pop();
            }
        }

        if(!empty()) {
            sb.setLength(0);
            sb.append("NO");
        }

        System.out.println(sb);
    }

    static void push(int x){
        stack[++top] = x;
        sb.append("+").append("\n");
    }

    static int pop(){
        if(empty()){
            return -1;
        }

        int value = stack[top--];
        sb.append("-").append("\n");
        return value;
    }

    static int top() {
        if(empty()) {
            return -1;
        }

        return stack[top];
    }

    static boolean empty() {
        if(top == -1){
            return true;
        }
        return false;
    }
}