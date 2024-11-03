import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int treeNum = Integer.parseInt(st.nextToken());
		int wantedHeight = Integer.parseInt(st.nextToken());
		
		Integer[] trees = new Integer[treeNum];
		st = new StringTokenizer(br.readLine());
		int max = 0;
		for(int i = 0; i < treeNum; i++) {
 			trees[i] = Integer.parseInt(st.nextToken()); 
 			if(max < trees[i]) {
 				max = trees[i];
 			}
		}
		
		
		int low = 0, high = max, mid = 0;
		while(low < high) {
			long totalCut = 0;
			mid = (low + high) / 2;
			for(int i = 0; i < treeNum; i++) {
				if(trees[i] - mid > 0) {
					totalCut += (trees[i] - mid);
				}
			}
			if(totalCut < wantedHeight) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		
		System.out.println(low - 1);
	}
}