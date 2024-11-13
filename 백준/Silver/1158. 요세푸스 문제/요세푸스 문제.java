import java.io.*;
import java.util.*;

class Main {
	static public void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        
        for(int i = 1; i <= N; i++){
            list.add(i);
        }

        ListIterator <Integer> iter = list.listIterator();
        while(list.size() > 0){
            int target = 0;
            for(int i = 0; i < K; i++){
                if(iter.hasNext()){
                    target = iter.next();
                }else{
                    iter = list.listIterator();
                    target = iter.next();
                }
            }
            sb.append(target).append(", ");
            iter.remove();
        }
        
        sb.setLength(sb.length()-2);
        sb.append(">");
        System.out.println(sb);
    }
}


