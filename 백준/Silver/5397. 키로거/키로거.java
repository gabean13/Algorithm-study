import java.io.*;
import java.util.*;

class Main {
	static public void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++){
            char[] input = br.readLine().toCharArray();
            Stack <Character> leftStack = new Stack<>();
            Stack <Character> rightStack = new Stack<>();
            for(char ch : input){
                if(ch == '<'){
                    if(!leftStack.isEmpty()){
                        rightStack.push(leftStack.pop());
                    }
                }else if(ch == '>'){
                    if(!rightStack.isEmpty()){
                        leftStack.push(rightStack.pop());
                    }
                    
                }else if(ch == '-'){
                    if(!leftStack.isEmpty()){
                        leftStack.pop();
                    }
                }else{
                    leftStack.push(ch);
                }
            }
            while(!leftStack.isEmpty()){
                rightStack.push(leftStack.pop());
                }
            while(!rightStack.isEmpty()){
                sb.append(rightStack.pop());
            }
            sb.append("\n");
        }   

        System.out.println(sb);
    }
}