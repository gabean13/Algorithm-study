import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    String sNum = br.readLine();
	    char[] cNums = sNum.toCharArray();
	    int answer = 0;
	    for(char cNum : cNums) {
	      answer += (cNum - '0');
	    }
	    System.out.println(answer);
	}
}