import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < testCases; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int aNum = Integer.parseInt(st.nextToken());
			int bNum = Integer.parseInt(st.nextToken());
			int[] aArr = new int[aNum];
			int[] bArr = new int[bNum];
			st = new StringTokenizer(br.readLine());
			for(int a = 0; a < aNum; a++) {
				aArr[a] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int b = 0; b < bNum; b++) {
				bArr[b] = Integer.parseInt(st.nextToken());
			}
			
			//계산
			Arrays.sort(aArr);
			Arrays.sort(bArr);
			//1 1 3 7 8
			//1 3 6
			int answer = 0;
			int bIdx = bNum-1;
			for(int a = aNum-1; a >= 0; a--) {
				int ca = aArr[a];
				while(bIdx >= 0 && bArr[bIdx] >= ca) {
					bIdx--;
				}
				if(a == 0 && bIdx == 0 && aArr[a] == bArr[bIdx]) break;
				answer += (bIdx + 1);
			}
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
}