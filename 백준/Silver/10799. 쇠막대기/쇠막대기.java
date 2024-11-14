import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] input = br.readLine().replace("()", "x").toCharArray();
		
		//내가 열릴 때부터 닫힐 때까지 () 개수 + 1
		Stack<Node> stack = new Stack<>();
		int lazer = 0;
		int answer = 0;
		for(int i = 0; i < input.length; i++) {
			char cch = input[i];
			if(cch == 'x') {
				lazer++;
				continue;
			}
			if(cch == ')') {
				Node node = stack.pop();
				answer = answer + lazer - node.lazer + 1;
				continue;
			}
			stack.push(new Node(lazer, cch));
		}
		
		System.out.println(answer);
	}
	
	static class Node {
		int lazer ;
		char ch;
		Node(int lazer, char ch) {
			this.lazer = lazer;
			this.ch = ch;
		}
	}
}