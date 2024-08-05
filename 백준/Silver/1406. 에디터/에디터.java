import java.io.*;
import java.util.*;

class Main {
	static public void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] input = br.readLine().toCharArray();
        int orderCnt = Integer.parseInt(br.readLine());
        Stack <Character> leftStack = new Stack<>();
        Stack <Character> rightStack = new Stack<>();

        for(char ch : input){
            leftStack.push(ch);
        }

        for(int i = 0; i < orderCnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            switch (order) {
                case("L") : {
                    if(leftStack.size() == 0){
                        break;
                    }
                    rightStack.push(leftStack.pop());
                    break;
                }
                case("D") : {
                    if(rightStack.size() == 0){
                        break;
                    }
                    leftStack.push(rightStack.pop());
                    break;
                }
                case("B") : {
                    if(leftStack.size() == 0){
                        break;
                    }
                    leftStack.pop();
                    break;
                }
                case("P") : {
                    char addChar = st.nextToken().charAt(0);
                    leftStack.push(addChar);
                }
            }
        }

        
        while(!leftStack.isEmpty()){
            rightStack.push(leftStack.pop());
        }
        while(!rightStack.isEmpty()){
            sb.append(rightStack.pop());
        }

        System.out.println(sb);
    }
}