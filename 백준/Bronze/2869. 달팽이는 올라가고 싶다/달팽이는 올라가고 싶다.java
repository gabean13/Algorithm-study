import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int targetHeight = V-A;
        int day = (targetHeight % (A-B) != 0) ? targetHeight / (A-B) + 1: targetHeight / (A-B);
        System.out.println(day+1);

    }
}