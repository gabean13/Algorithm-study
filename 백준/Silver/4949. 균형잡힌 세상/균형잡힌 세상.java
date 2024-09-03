import java.io.*;
import java.util.*;

class Main {
	static public void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        while(true) {
            String[] input = br.readLine().split("");
            Stack<String> stack = new Stack<>();
            
            if(input[0].equals(".") && input.length == 1) {
                break;
            
            }
            for(String str : input) {
                if(str.equals("(") || str.equals("[")) {
                    stack.push(str);
                } else if (str.equals(")")) {
                    if(stack.isEmpty()) {
                        sb.append("no").append("\n");
                        break;
                    } else if (!stack.peek().equals("(")) {
                        sb.append("no").append("\n");
                        break;
                    } else {
                        stack.pop();
                    }
                } else if (str.equals("]")) {
                    if(stack.isEmpty()) {
                        sb.append("no").append("\n");
                        break;
                    } else if (!stack.peek().equals("[")) {
                        sb.append("no").append("\n");
                        break;
                    } else {
                        stack.pop();
                    }
                } else if (str.equals(".")) {
                    if(stack.isEmpty()) {
                        sb.append("yes").append("\n");
                    } else {
                        sb.append("no").append("\n");
                    }
                }
            }
        }
        
        System.out.println(sb);
    }
}