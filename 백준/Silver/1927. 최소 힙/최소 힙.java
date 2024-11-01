import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for(int i = 0; i < testCases; i++) {
			int x = Integer.parseInt(br.readLine());
			switch (x) {
			case(0) : {
				sb.append(minHeap.isEmpty() ? "0" : minHeap.poll()).append("\n");
				break;
			}
			default : {
				minHeap.add(x);
			}
			}
 		}
		
		System.out.println(sb);
	}
}