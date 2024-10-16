import java.io.*;
import java.util.*;
public class Main {
	static int SLength;
	static String[] sArr;
	static int N;
	static String Pn;
	static int PnLength;
	public static void main(String...args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		SLength = Integer.parseInt(br.readLine());
		sArr = br.readLine().split("");
		
		StringBuilder sb = new StringBuilder();
		sb.append("I");
		for(int i = 0; i < N; i++) {
			sb.append("OI");
		}
		
		Pn = sb.toString();
		PnLength = Pn.length();
	
		int answer = 0;
		for(int i = 0; i <= SLength - PnLength; i++) {
			if(sArr[i].equals("I")) {
				answer += dp(i, 1);
			}	
		}

		System.out.println(answer);		
	}
	
	public static int dp(int index, int stackSize) {
		if(stackSize == PnLength) {
			if(sArr[index].equals("I")) {
				return 1;
			} else {				
				return 0;
			}
		}

		if(index >= SLength - 1) return 0;
		if (sArr[index + 1].equals("O") && stackSize % 2 == 1) { //I다음 O일때
			return dp(index + 1, stackSize + 1);
		} else if(sArr[index + 1].equals("I") && stackSize % 2 == 0) { //O다음 I일
			return dp(index + 1, stackSize + 1);
		}
		
		return 0;
	}
}