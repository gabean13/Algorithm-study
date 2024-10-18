import java.io.*;
import java.util.*;

public class Main {

	public static void main(String...args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	//의견의 개수
		
		//제거할 인원 계산
		int removeCnt = (int)(n * 0.15 + 0.5);
		
		//의견 입력
		int[] arr = new int[31];
		for(int i = 0; i < n; i++) {
			int index = Integer.parseInt(br.readLine());
			arr[index] += 1;
		}
		
		//제외되는 사람 앞 부분 제거
		int idx = 1;
		int removed = 0;
		while(removed < removeCnt) {
			if (arr[idx] == 0) {
				idx++;
				continue;
			} 
			arr[idx]--;
			removed++;
		}
		
		//제외되는 사람  부분 제거
		idx = 30;
		removed = 0;
		while(removed < removeCnt) {
			if (arr[idx] == 0) {
				idx--;
				continue;
			} 
			arr[idx]--;
			removed++;
		}
		
		//의견 합 계산
		double difficultySum = 0;
		for(int i = 1; i < 31; i++) {
			difficultySum += (arr[i] * i);
		}
		
		//의견 결과 계산
		int answer = (int)(difficultySum / (n - removeCnt*2) + 0.5);
		
		System.out.println(answer);
	}
}