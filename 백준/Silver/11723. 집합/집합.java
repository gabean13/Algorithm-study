import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int round = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < round; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			switch(input) {
			case("add") : {
				int x = Integer.parseInt(st.nextToken());
				set.add(x);
				break;
			}
			case("remove") : {
				int x = Integer.parseInt(st.nextToken());
				if(set.contains(x)) set.remove(x);
				break;
			}
			case("check") : {
				int x = Integer.parseInt(st.nextToken());
				if(set.contains(x)) sb.append("1").append("\n");
				else sb.append("0").append("\n");
				break;
			}
			case("toggle") : {
				int x = Integer.parseInt(st.nextToken());
				if(set.contains(x)) set.remove(x);
				else set.add(x);
				break;
			}
			case("all") : {
				set = new HashSet<>();
				for(int idx = 1; idx <= 20; idx++) {
					set.add(idx);
				}
				break;
			}
			case("empty") : {
				set = new HashSet<>();
			}
			}
		}
		System.out.println(sb);
	}
}