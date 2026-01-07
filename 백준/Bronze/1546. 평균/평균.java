import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int examCount = Integer.parseInt(br.readLine());
	    
	    int maxScore = 0;
	    int total = 0;

      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i = 0; i < examCount; i++) {
        int examScore = Integer.parseInt(st.nextToken());
        total += examScore;
        if(maxScore < examScore) {
          maxScore = examScore;
        }
      }
      
      double average = (double) total / maxScore / examCount * 100;
      
      System.out.println(average);
	}
}