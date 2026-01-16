import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    int aIdx = 0;
	    int cIdx = 1;
	    int gIdx = 2;
	    int tIdx = 3;
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int pwLength = Integer.parseInt(st.nextToken());
	    String[] strArr = br.readLine().split("");
	    
	    int[] wanted = new int[4];
	    st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < 4; i++) {
	      wanted[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    // 초기 값 할당
	    int[] current = new int[4];
	    for(int i = 0; i < pwLength; i++) {
	      String str = strArr[i];
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
	    
	    int answer = 0;
	    for(int i = 0; i <= N - pwLength; i++) {
	      boolean isPass = true;
	      for(int j = 0; j < 4; j++) {
	        if(current[j] < wanted[j]) {
	          isPass = false;
	          break;
	        }
	      }
	      if(isPass) {
	       answer++;
	      }
	      
	      String startStr = strArr[i];
	      if(i + pwLength >= N) {
	        break;
	      }
	      String newStartStr = strArr[i + pwLength];
	      if(startStr.equals("A")) {
	        current[aIdx]--;
	      } else if(startStr.equals("C")) {
	        current[cIdx]--;
	      } else if(startStr.equals("G")) {
	        current[gIdx]--;
	      } else if(startStr.equals("T")) {
	        current[tIdx]--;
	      }
	      
	      if(newStartStr.equals("A")) {
	        current[aIdx]++;
	      } else if(newStartStr.equals("C")) {
	        current[cIdx]++;
	      } else if(newStartStr.equals("G")) {
	        current[gIdx]++;
	      } else if(newStartStr.equals("T")) {
	        current[tIdx]++;
	      }
	    }
	    
	    System.out.println(answer);
	}
	
	
}