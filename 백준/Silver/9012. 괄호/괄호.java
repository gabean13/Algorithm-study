import java.io.*;
import java.util.*;

class Main {
	static public void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            sb.append(solve(input)).append("\n");
        }

        System.out.println(sb);
    }

    static public String solve(String input) {
        Stack<Character> stack = new Stack<>();

        if(input.length() % 2 != 0) {
            return "NO";
        }
        
        stack.push(input.charAt(0));
        for(int i = 1; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(ch == ')') {
                if(stack.empty()) {
                    return "NO";
                } else if(stack.peek() != '(') {
                    return "NO";
                } else {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }

        if(stack.empty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}