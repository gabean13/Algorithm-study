import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    char[] firstArr = br.readLine().toCharArray();
	    char[] secondArr = br.readLine().toCharArray();
	    int[] countArr = new int[26];
	    
	    // 첫번째껄 센다
	    for(char ch : firstArr) {
	      int idx = ch - 'a';
	      countArr[idx]++;
	    }
	     
	    // 두번째껄 센다
	    for(char ch : secondArr) {
	      int idx = ch - 'a';
	      countArr[idx]--;
	    }
	    
	    // 0이 아닌 숫자들을 찾는다
	    int answer = 0;
	    for(int num : countArr) {
	      answer += Math.abs(num);
	    }
      System.out.println(answer);
	}
}