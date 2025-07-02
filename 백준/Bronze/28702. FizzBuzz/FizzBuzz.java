import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int startNum = 0;
        for(int i = 0; i < 3; i++) {
            String str = br.readLine();
            if(str.equals("FizzBuzz")) {
                continue;
            }
            if(str.equals("Fizz")) {
                continue;
            }
            if(str.equals("Buzz")) {
                continue;
            }
            startNum = Integer.parseInt(str) - i;
            break;
        }
        
        System.out.println(getAnswer(startNum+3));
    }
    
    private static String getAnswer(int startNum) {
        if(startNum % 3 == 0 && startNum % 5 == 0) {
            return "FizzBuzz";
        }
        if(startNum % 3 == 0) {
            return "Fizz";
        }
        if(startNum % 5 == 0) {
            return "Buzz";
        }
        return Integer.toString(startNum);
    }
}