import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int num = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] waiting = new int[num];
		int[] totalTime = new int[num];
		for(int i = 0; i < num; i++) {
			waiting[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(waiting);
		totalTime[0] = waiting[0];
		for(int i = 1; i < num; i++) {
			totalTime[i] = totalTime[i-1] + waiting[i];
		}
		
		int answer = Arrays.stream(totalTime).sum();
		System.out.println(answer);
	}
}