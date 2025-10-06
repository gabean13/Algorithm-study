import java.util.*;
import java.io.*;

public class Main {
  
  static int n;
  static int answer = 0;
  static boolean[][] queens;
  
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());
      queens = new boolean[n][n];
    
      function(0);
      System.out.println(answer);
	}
	
	static void function(int k) {
	  // 종료 조건
	  // 끝에 줄까지 도달했으면 해당 턴 종료
	  if(k == n) {
	    answer++;
	    return;
	  }
	 
	  // 탐색
	  // 여왕을 놓을 수 없는지 있는지 판단한다
	  // 놓을 수 없다면 다음 칸으로 간다
	  // 놓을 수 있다면 놓고 다음 줄로 간다.
	  for(int y = 0; y < n; y++) {
	    if(isPossiblePoint(k,y)) {
	      queens[k][y]=true;
	      function(k+1);
	      queens[k][y]=false;
	    }
	  }
	}
	
	// 여왕의 경우 : 같은 x 칸/ y칸/ x-i y-i / x+i y+i /x-i y+i/ x+i y-i칸에 여왕이 있으면 그 칸은 사용 불가
	static boolean isPossiblePoint(int cx, int cy) {
	  // 같은 x 칸
	  for(int y = 0; y < n; y++) {
	    if(queens[cx][y]) {
	      return false;
	    }
	  }
	  // 같은 y칸
	  for(int x = 0; x < n; x++) {
	    if(queens[x][cy]) {
	      return false;
	    }
	  }
	  
	  // x-i y-i
	  for(int i = 0; i < n; i++) {
	    if(cx-i >= 0 && cy - i >= 0) {
	      if(queens[cx-i][cy-i]) {
	        return false;
	      }
	    }
	  }
	  
	  // x+i y+i 
	  for(int i = 0; i < n; i++) {
	    if(cx+i < n && cy + i < n) {
	      if(queens[cx+i][cy+i]) {
	        return false;
	      }
	    }
	  }
	  
	  // x-i y+i
	  for(int i = 0; i < n; i++) {
	    if(cx-i >= 0 && cy + i < n) {
	      if(queens[cx-i][cy+i]) {
	        return false;
	      }
	    }
	  }
	  
	  // x+i y-i
	  for(int i = 0; i < n; i++) {
	    if(cx+i < n && cy - i >= 0) {
	      if(queens[cx+i][cy-i]) {
	        return false;
	      }
	    }
	  }
	  
	  return true;
	}
}