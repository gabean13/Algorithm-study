import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int stairNum = Integer.parseInt(br.readLine());
      int[] stair = new int[stairNum + 1];
      for(int i = 1; i <= stairNum; i++) {
        stair[i] = Integer.parseInt(br.readLine());
      }
      
      if(stairNum == 1) {
        System.out.println(stair[1]);
        return;
      }
      
      int[][] d = new int[stairNum + 1][3];
      d[1][1] = stair[1];
      d[1][2] = stair[1];
      d[2][1] = stair[2];
      d[2][2] = stair[1] + stair[2];
      for(int i = 3; i <= stairNum; i++) {
        d[i][1] = Math.max(d[i-2][1], d[i-2][2]) + stair[i];
        d[i][2] = d[i-1][1] + stair[i];
      }
      System.out.println(Math.max(d[stairNum][1], d[stairNum][2]));
	}
}