import java.io.*;
import java.util.*;

public class Main {
	public static void main(String... args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int subin = Integer.parseInt(st.nextToken());
		int sister = Integer.parseInt(st.nextToken());
		int[] time = new int[100001];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(subin);
		time[subin] = 1;
		
		int[] dir = {-1, 1};
		while(!queue.isEmpty()) {
			int cx = queue.poll();
			if(cx == sister) {
				break;
			}
			if(cx * 2 <= 100000) {
				queue.add(cx*2);
				time[cx*2] = time[cx];
			}
			for(int i = 0; i < 2; i++) {
				int nx = cx + dir[i];
				if(nx < 0 || nx > 100000) {
					continue;
				}
				if(time[nx] == 0) {
					queue.add(nx);
					time[nx] = time[cx] + 1;
				}
			}
		}
		
		System.out.println(time[sister] - 1);
	}
}