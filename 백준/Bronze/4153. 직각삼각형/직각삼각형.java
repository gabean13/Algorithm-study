import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];

        while(true){
            for(int i = 0; i < 3; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            if(arr[0] == 0 && arr[1] == 0&& arr[2] == 0){
                break;
            }
            Arrays.sort(arr);
            if(Math.pow(arr[0], 2) + Math.pow(arr[1], 2) == Math.pow(arr[2], 2)){
		        System.out.println("right");
            }else{
        		System.out.println("wrong");
            }
            st = new StringTokenizer(br.readLine());
        }
    }
}