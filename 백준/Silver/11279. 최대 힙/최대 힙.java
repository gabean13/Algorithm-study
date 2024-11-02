import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < testCases; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(queue.isEmpty()) {
					sb.append("0 \n");
				} else {
					sb.append(queue.poll()).append("\n");
				}
			} else {
				queue.add(num);
			}
		}
		
		System.out.println(sb);
	}
}