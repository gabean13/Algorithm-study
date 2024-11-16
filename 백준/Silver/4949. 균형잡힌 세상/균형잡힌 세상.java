import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			char[] input = br.readLine().toCharArray();
			if(input[0] == '.' && input.length == 1) {
				break;
			}
			boolean answer = true;
			Stack<Character> stack = new Stack<>();
			for(char ch : input) {
				if(ch == '(' || ch == '[') {
					stack.push(ch);
				} else if(ch == ')') {
					if(stack.isEmpty() || stack.peek() != '(') {
						answer = false;
						break;
					} 
					stack.pop();
				} else if(ch == ']') {
					if(stack.isEmpty() || stack.peek() != '[') {
						answer = false;
						break;
					} 
					stack.pop();
				} else {
					continue;
				}
			}
			
			if(stack.isEmpty() && answer) sb.append("yes\n");
			else sb.append("no\n");
		}
		System.out.println(sb);
	}
}