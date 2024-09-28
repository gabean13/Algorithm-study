import java.io.*;
import java.util.*;

public class Main {
	public static void main(String...args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int subin = Integer.parseInt(st.nextToken());
		int sister = Integer.parseInt(st.nextToken());
		
		int[] subinCnt = new int[100001];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(subin);
		subinCnt[subin] = 1;
		
		//0이면 방문 안한거
		int answer = 0;
		while(!queue.isEmpty()) {
			int cx = queue.poll();
			if(cx == sister) {
				answer = subinCnt[cx];
				break;
			}
			// +1
			int nx = cx + 1;
			if(nx >= 0 && nx <= 100000 && subinCnt[nx] == 0) {
				queue.add(nx);
				subinCnt[nx] = subinCnt[cx] + 1;
			}
			// -1
			nx = cx - 1;
			if(nx >= 0 && nx <= 100000 && subinCnt[nx] == 0) {
				queue.add(nx);
				subinCnt[nx] = subinCnt[cx] + 1;
			}
			// *2
			nx = cx*2;
			if(nx >= 0 && nx <= 100000 && subinCnt[nx] == 0) {
				queue.add(nx);
				subinCnt[nx] = subinCnt[cx] + 1;
			}
		}
		
		System.out.println(answer-1);
	}
}