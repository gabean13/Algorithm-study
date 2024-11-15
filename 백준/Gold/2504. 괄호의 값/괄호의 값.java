import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] input = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		int answer = 0;
		int multiply = 1;
		for(int i = 0; i < input.length; i++) {
			char ch = input[i];
			switch(ch) {
			case('(') : {
				stack.push(ch);
				multiply *= 2;
				break;
			}
			case('[') : {
				stack.push(ch);
				multiply *= 3;
				break;
			}
			case(')') : {
				if(stack.isEmpty() || stack.peek() != '(') {
					System.out.println("0");
					return;
				}
				if(input[i-1] == '(') answer += multiply;
				stack.pop();
				multiply /= 2;
				break;
			}
			case(']') : {
				if(stack.isEmpty() || stack.peek() != '[') {
					System.out.println("0");
					return;
				}
				if(input[i-1] == '[') answer += multiply;
				stack.pop();
				multiply /= 3;
				break;
			}
			}
		}
		
		
		if(stack.isEmpty()) {
			System.out.println(answer);	
		} else {
			System.out.println("0");
		}
	}
}