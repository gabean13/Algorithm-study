import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int studentNum = Integer.parseInt(st.nextToken());
		int maxNum = Integer.parseInt(st.nextToken());
		
		int[][] students = new int[7][2];
		for(int i = 0; i < studentNum; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			students[grade][sex]++;
		}
		
		int roomNum = 0;
		for(int i = 1; i <= 6; i++) {
			for(int j = 0; j < 2; j++) {
				if(students[i][j] == 0) {
					continue;
				}
				if(students[i][j] % maxNum == 0) {
					roomNum += (students[i][j] / maxNum);
				} else {
					roomNum += (students[i][j] / maxNum + 1);
				}
			}
		}
		
		System.out.println(roomNum);
	}
}