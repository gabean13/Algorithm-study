import java.io.*;

import java.util.*;

public class Main {

	public static void main(String...args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sLength = Integer.parseInt(br.readLine());
		char[] sArr = br.readLine().toCharArray();

	
		int answer = 0;
		for(int i = 0; i < sArr.length - 2; i++) {
			int ioiCnt = 0;
			if(sArr[i] == 'O') {
				continue;
			} else {
				while(i + 2 < sArr.length && sArr[i + 1] == 'O' && sArr[i + 2] == 'I') {
					ioiCnt++;
					if(ioiCnt == n) {
						ioiCnt--;
						answer++;
					}
					i+=2;
				}
				ioiCnt = 0;
			}
		}

		System.out.println(answer);		
	}
}