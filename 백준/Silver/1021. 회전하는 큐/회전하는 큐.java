import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            list.add(i);
        }
        
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int targetIdx = list.indexOf(target);
            //뒤랑 더 가까움
            if(targetIdx > list.size()/2) {
                while(list.get(0) != target) {
                    int lastValue = list.removeLast();
                    list.addFirst(lastValue);
                    answer++;
                }
            } else {
                while(list.get(0) != target) {
                    int firstValue = list.removeFirst();
                    list.addLast(firstValue);
                    answer++;
                }
            }
            list.removeFirst();
        }

        System.out.println(answer);
    }
}