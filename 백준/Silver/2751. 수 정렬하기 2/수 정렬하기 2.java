import java.util.*;
import java.io.*;
import java.util.Collections;

class Main {
	static public void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(int value : list){
            sb.append(value).append("\n");
        }

        System.out.println(sb);
    }
}