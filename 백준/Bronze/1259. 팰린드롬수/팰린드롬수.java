import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        String str = st.nextToken();

        while(!str.equals("0")){
            System.out.println(isPalindrom(str) ? "yes" : "no");
            st = new StringTokenizer(bf.readLine());
            str = st.nextToken();
        }
    }

    public static boolean isPalindrom(String str){
        int left = 0;
        int right = str.length()-1;

        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}