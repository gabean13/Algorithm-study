import java.util.*;

public class Main
{
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        toOne(n, 0);
        
        System.out.println(min);
    }
    
    static void toOne(int n, int count){
        //현재 coun 최소값보다 크면 굳이 검사할 필요 X
        if(count > min){
            return;
        }
                
        if(n==1){
            min = Math.min(min, count);
        }
        
        if(n % 3 == 0){
            toOne(n/3, count+1);
        }
        if(n% 2== 0){
            toOne(n/2, count+1);
        }
        toOne(n-1, count+1);
    }
}
