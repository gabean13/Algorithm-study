import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        

        String str = br.readLine();
        char[] charArr = str.toCharArray();
        int M = 1234567891;

        long hash = 0;
        long pow = 1;
        for(int i = 0; i < charArr.length; i++){
            hash += (((int)charArr[i] - 96) * pow) % M;
            pow = (pow * 31) % M;
        }

        System.out.println(hash % M);
    }
}