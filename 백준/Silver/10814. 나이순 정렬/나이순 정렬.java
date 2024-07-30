import java.util.*;
import java.io.*;
import java.util.Collections;

class Main {
	static public void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    

        StringBuilder[] sbArr = new StringBuilder[201];

        for(int i = 0; i < 201; i++){
            sbArr[i] = new StringBuilder();
        }

        //1. 나이순정렬 나이가 큰 애들만 정렬 같은 애들은 정렬X
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            sbArr[age].append(age).append(" ").append(name).append("\n");
        }

        for(StringBuilder str : sbArr){
            if(str != null){
                System.out.print(str);
            }
        }
    }
}