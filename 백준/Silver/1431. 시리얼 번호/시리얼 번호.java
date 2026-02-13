import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    List<Guitar> list = new ArrayList<>();
	    for(int i = 0; i < n; i++) {
	      list.add(new Guitar(br.readLine()));
	    }
	    
	    Collections.sort(list);
	    for(Guitar g : list) {
	      System.out.println(g.serial);
	    }
	}
}

class Guitar implements Comparable<Guitar>{
  String serial;
  int countSum;
  
  public Guitar(String serial) {
    this.serial = serial;
    this.countSum = 0;
    for(char str: serial.toCharArray()) {
      if(str >= '0' && str <= '9') {
        countSum += (int)(str - '0');
      }
    }
  }
  
  @Override
  public int compareTo(Guitar o1) {
    String o1s = o1.serial;
    if(serial.length() != o1s.length()) return serial.length() - o1s.length();
    if(countSum != o1.countSum) return countSum - o1.countSum;
    return serial.compareTo(o1s);
  }
}