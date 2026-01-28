import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    /*
	    문제: 버블 정렬을 할 때, 정렬을 하기 위해서 몇 번 for문을 돌려야하냐
	    
	    버블정렬의 특징, for문을 돌 때 index 옆칸이랑만 바꿀 수 있음
	    그래서 이 문제를 풀기 위해서는 정렬 후 인덱스가 가장 많이 움직인 애를 보면 for문이 몇번 돌앗는지 알 수 있다.
	    */
	    int n = Integer.parseInt(br.readLine());
	    Data[] arr = new Data[n];
	    for(int i = 0; i < n; i++) {
	      arr[i] = new Data(i, Integer.parseInt(br.readLine()));
	    }
	    Arrays.sort(arr);
	    
	    int max = 0;
	    for(int i = 0; i < n; i++) {
	      Data data = arr[i];
	      int current = data.index - i;
	      if(max < current) {
	        max = current;
	      }
	    }
	    System.out.println(max+1);
	}
}

class Data implements Comparable<Data>{
  
  int index;
  int value;
  
  public Data(int index, int value) {
    this.index = index;
    this.value = value;
  }
  
  @Override
  public int compareTo(Data o){
    return this.value - o.value;
  }
}