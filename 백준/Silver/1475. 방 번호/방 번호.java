import java.io.*;
import java.util.*;

class Main {
	static public void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] roomNumberArr = br.readLine().toCharArray();
        int []arr = new int[10];

        for(char ch : roomNumberArr){
            int roonNum = (int)ch-'0';
            if(roonNum == 9 || roonNum == 6){
                arr[(arr[9] > arr[6] ? 6 : 9)]++;
            }else{
                arr[roonNum]++;
            }
        }

        Arrays.sort(arr);

        System.out.println(arr[9]);
    }
}