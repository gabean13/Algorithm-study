import java.util.*;
import java.io.*;

public class Main {
  
  static final String IMPOSSIBLE = "Impossible\n";
	static final String POSSILBLE = "Possible\n";
	  
	public static void main(String[] args) throws IOException {
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  int testCaseCount = Integer.parseInt(br.readLine());
	  
	  StringBuilder sb = new StringBuilder();
	  for(int i = 0; i < testCaseCount; i++) {
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    String actual = st.nextToken();
	    String want = st.nextToken();
	    sb.append(canStrfry(actual, want));
	  }
	  
	  System.out.println(sb.toString());
	}
	
  static String canStrfry(String actual, String want) {
    if(actual.length() != want.length()) return IMPOSSIBLE;
    
    int[] actualArr = new int[26]; 
    for(char actualCh : actual.toCharArray()) {
      actualArr[actualCh-'a']++;
    }
    
    for(char wantCh : want.toCharArray()) {
      actualArr[wantCh-'a']--;
    }
    
    for(int count : actualArr) {
      if(count != 0) return IMPOSSIBLE;
    }
    return POSSILBLE;
  }
}