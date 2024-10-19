import java.io.*;
import java.util.*;

public class Main {
	public static void main(String... args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int computerCnt = Integer.parseInt(br.readLine());
		int round = Integer.parseInt(br.readLine());
		
		int[][] networkMatrix = new int[computerCnt][computerCnt];
		for(int i = 0; i < round; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			networkMatrix[y][x] = 1;
			networkMatrix[x][y] = 1;
		}
		
		boolean[] virus = new boolean[computerCnt];
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		virus[0] = true;
		int virusCnt = 0;
		while(!queue.isEmpty()) {
			int y = queue.poll();
			for(int x = 0; x < computerCnt; x++) {
				if(networkMatrix[y][x] == 1 && !virus[x]) {
					queue.add(x);
					virus[x] = true;
					virusCnt++;
				}
			}
		}
		
		System.out.println(virusCnt);
	}
}