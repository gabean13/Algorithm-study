import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. 입력
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sizeCnt = new int[6];
        for(int i = 0; i < 6; i++){
            sizeCnt[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int tGroup = Integer.parseInt(st.nextToken());
        int pGroup = Integer.parseInt(st.nextToken());


        //2. 필요한 티셔츠 묶음 수 계산
        int tanswer = 0;
        for(int cnt : sizeCnt){
            tanswer += (cnt / tGroup);
            if(cnt % tGroup != 0){
                tanswer++;
            }
        }


        //3. 필요한 펜 묶음 수 계산
        int panswer = N / pGroup;

        //4. 필요한 펜 한자루 수 계산
        int onepanswer = N - panswer * pGroup;

        System.out.println(tanswer);
        System.out.println(panswer + " " + onepanswer);
    }
}