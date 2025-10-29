import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int inputSize = Integer.parseInt(br.readLine());
	    int[] numbers = new int[inputSize];
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 0; i < inputSize; i++) {
	      numbers[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int answer = 0;
	    int sum = Integer.parseInt(br.readLine());
	    boolean[] exists = new boolean[1000001];
	    for(int current : numbers) {
	      int complement = sum - current;
	      if(complement > 0 && complement < 1000001) {
	        if(exists[complement]) {
	          answer++;
	        }
	        exists[current] = true;
	      }
	    }
	    
	    System.out.println(answer);
	}
}