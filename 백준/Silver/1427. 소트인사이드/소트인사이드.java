import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    char[] numChArr = br.readLine().toCharArray();
	    int[] numArr = new int[numChArr.length];
	    for(int i = 0; i < numChArr.length; i++) {
	      numArr[i] = numChArr[i] - '0';
	    }
	    
	    for(int i = 0; i < numArr.length - 1; i++) {
	      int max = numArr[i];
	      int maxIdx = i;
	      for(int j = i; j < numArr.length; j++) {
	        if(max < numArr[j]) {
	          maxIdx = j;
	          max = numArr[j];
	        }
	      }
	      int temp = numArr[i];
	      numArr[i] = max;
	      numArr[maxIdx] = temp;
	    }
	    
	    for(int i = 0; i < numChArr.length; i++) {
	      System.out.print(numArr[i]);
	    }
	}
}