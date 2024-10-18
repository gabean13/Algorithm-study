import java.io.*;
import java.util.*;

public class Main {

	public static void main(String...args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	//의견의 개수
		
		//제거할 인원 계산
		int removeCnt = (int)(n * 0.15 + 0.5);
		
		//의견 입력
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//의견 정렬
		Arrays.sort(arr);
		
		//의견 계산
		double difficultySum = 0;
		for(int i = removeCnt; i < n - removeCnt; i++) {
			difficultySum += arr[i];
		}
		int answer = (int)(difficultySum / (n - removeCnt*2) + 0.5);
		
		System.out.println(answer);
		
	}
}