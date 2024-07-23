import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = 1234567891;

        String str = br.readLine();
        char[] charArr = str.toCharArray();

        int hash = 0;
        for(int i = 0; i < charArr.length; i++){
            int a = (int)charArr[i] - 96;
            hash = (hash + a * (int)Math.pow(31, i)) % M;
        }

        System.out.println(hash);
    }
}