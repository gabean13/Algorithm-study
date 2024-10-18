import java.io.*;
import java.util.*;

public class Main {
	public static void main(String... args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		System.out.println(recurv(n, y, x));
	}
	
	public static long recurv (double n, int y, int x) {
		//몇번째 영역인지 구한다
		double N = Math.pow(2, n) / 2;
		int boundary = (int)(N-1);
		int section;
		
		if(y <= boundary && x <= boundary) {
			section = 0;
		} else if(y <= boundary && x > boundary) {
			section = 1;
		} else if(y > boundary && x <= boundary) {
			section = 2;
		} else {
			section = 3;
		}
		
		//n=1이면 조건
		if(n == 1) {
			return section;
		}	
		
		switch (section) {
			case(1) : {
				x -= N;
				break;
			}
			case(2) : {
				y -= N;
				break;
			}
			case(3) : {
				x -= N;
				y -= N;
				break;
			}
		}
		
		return (long)(N*N*section) + recurv(n-1 , y, x);		
	}
}