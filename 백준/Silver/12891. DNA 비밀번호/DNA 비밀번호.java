import java.util.*;
import java.io.*;

public class Main {
  
  static int aIdx = 0;
	static int cIdx = 1;
	static int gIdx = 2;
	static int tIdx = 3;
	static int[] current = new int[4];
	static int[] wanted = new int[4];
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int pwLength = Integer.parseInt(st.nextToken());
	    String[] strArr = br.readLine().split("");
	    
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < 4; i++) {
	      wanted[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    // 초기 값 할당
	    int answer = 0;
	    for(int i = 0; i < pwLength; i++) {
	      add(strArr[i]);
	    }
	    if(checkPw()) {
	      answer++;
	    }
	   
	    for(int i = pwLength; i < N; i++) {
         add(strArr[i]);
         remove(strArr[i-pwLength]);
         if(checkPw()) {
           answer++;
         }
	    }
	    
	    System.out.println(answer);
	}
	
	private static boolean checkPw() {
	  for(int i = 0; i < 4; i++) {
	    if(wanted[i] > current[i]) {
	      return false;
	    }
	  }
	  return true;
	}
	
	private static void add(String str) {
	   if(str.equals("A")) {
	        current[aIdx]++;
	      } else if(str.equals("C")) {
	        current[cIdx]++;
	      } else if(str.equals("G")) {
	        current[gIdx]++;
	      } else if(str.equals("T")) {
	        current[tIdx]++;
	      }
	}
	
	private static void remove(String str) {
	   if(str.equals("A")) {
	        current[aIdx]--;
	      } else if(str.equals("C")) {
	        current[cIdx]--;
	      } else if(str.equals("G")) {
	        current[gIdx]--;
	      } else if(str.equals("T")) {
	        current[tIdx]--;
	      }
	}
}