import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int strLength = Integer.parseInt(st.nextToken());
	    int pwLength = Integer.parseInt(st.nextToken());
	    
	    String[] strArr = br.readLine().split("");
	    
	    st = new StringTokenizer(br.readLine());
	    int[] validateCountArr = new int[4];
	    validateCountArr[0] = Integer.parseInt(st.nextToken());
	    validateCountArr[1] = Integer.parseInt(st.nextToken());
	    validateCountArr[2] = Integer.parseInt(st.nextToken());
	    validateCountArr[3] = Integer.parseInt(st.nextToken());

	    int[] countArr = new int[4];
	    for(int i = 0; i < pwLength; i++) {
	      int index = getIndex(strArr[i]);
	      countArr[index]++;
	    }
	    
	    int answer = 0;
      int start = 0;
      int end = pwLength-1;
      while(end < strLength) {
        if(isValidate(countArr, validateCountArr)) {
          answer++;
        }
        int startIndex = getIndex(strArr[start]);
        countArr[startIndex]--;
        start++;
        end++;
        if(end == strLength) break;
        int newIndex = getIndex(strArr[end]);
        countArr[newIndex]++;
      }
      
      System.out.println(answer);
	}
	
	private static int getIndex(String str) {
	  if(str.equals("A")) {
	    return 0;
	  } 
	  if(str.equals("C")) {
	    return 1;
	  } 
	  if(str.equals("G")) {
	    return 2;
	  } 
	  return 3;
	}
	
	private static boolean isValidate(int[] countArr, int[] validateCountArr) {
	  for(int i = 0;i < 4; i++) {
	    if(countArr[i] < validateCountArr[i]) {
	      return false;
	    }
	  }
	  return true;
	}
}