import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> heights = new ArrayList<>();
        
        //9명의 난쟁이 입력
        int total = 0;
        for(int i = 0; i < 9; i++) {
            int height = Integer.parseInt(br.readLine());
            total += height;
            heights.add(height);
        }

        int extraHeight = total - 100;
        boolean stop = false;
        for(int i = 0; i < 8; i++) {
            for(int j = i + 1; j < 9; j++) {
                if (heights.get(i) + heights.get(j) == extraHeight) {
                    heights.remove(j);
                    heights.remove(i);
                    stop = true;
                    break;
                }
            }
            if(stop) {
                break;
            }
        }
        
        //일곱 난쟁이의 키를 오름차순으로 출력
        heights.sort(Integer::compareTo);

        for(int h : heights) {
            System.out.println(h);
        }
    }
}