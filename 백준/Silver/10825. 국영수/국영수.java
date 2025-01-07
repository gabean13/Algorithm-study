import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int studentNum = Integer.parseInt(br.readLine());
		
		List<Score> list = new ArrayList<>();
		for(int i = 0; i < studentNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Score(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list, new Comparator<Score>() {
			@Override
			public int compare(Score s1, Score s2) {
				if(s1.kor - s2.kor != 0) {
					return s2.kor - s1.kor;
				}
				if(s1.eng - s2.eng != 0) {
					return s1.eng - s2.eng;
				}
				if(s1.math - s2.math != 0) {
					return s2.math - s1.math;
				}
				return s1.name.compareTo(s2.name);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(Score s : list) {
			sb.append(s.name).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static class Score {
		String name;
		int kor;
		int eng;
		int math;
		
		public Score (String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
	}
}