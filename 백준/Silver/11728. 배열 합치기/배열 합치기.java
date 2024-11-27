import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//입력 
		int leftSize = Integer.parseInt(st.nextToken());
		int rightSize = Integer.parseInt(st.nextToken());
		
		int[] leftArr = new int[leftSize];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < leftSize; i++) {
			leftArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] rightArr = new int[rightSize];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < rightSize; i++) {
			rightArr[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		int l = 0;
		int r = 0;
		while(l < leftSize && r < rightSize) {
			if(leftArr[l] < rightArr[r]) {
				sb.append(leftArr[l++]).append(" ");
			} else {
				sb.append(rightArr[r++]).append(" ");
			}
		}
		
		if(l == leftSize) {
			while(r < rightSize) {
				sb.append(rightArr[r++]).append(" ");
			}
		} else {
			while(l < leftSize) {
				sb.append(leftArr[l++]).append(" ");
			}
		}
		
		System.out.println(sb);
	}
}