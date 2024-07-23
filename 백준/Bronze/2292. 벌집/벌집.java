import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 1;
        int max = 1;
        while(N > max){
            max += cnt*6;
            cnt++;
        }

        System.out.println(cnt);
    }
}