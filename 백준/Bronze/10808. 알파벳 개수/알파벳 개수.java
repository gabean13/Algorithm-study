import java.io.*;
import java.util.*;

class Main {
	static public void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int [] arr = new int[26];
        String str = br.readLine();
        char[] chArr = str.toCharArray();

        for(int i = 0; i < chArr.length; i++){
            arr[(int)(chArr[i]-'a')] += 1;
        }

        for(int i = 0; i < 26; i++){
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}