import java.util.*;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[1001];
        dp[0] = 1;
        dp[1] = 1;

        System.out.println(fibonacci(dp, n));

    }

    static int fibonacci(int[] dp, int n){
        if(dp[n] != 0){
            return dp[n];
        }else{
            if(n == 0 || n == 1){
                return 1;
            }else{
                dp[n] = (fibonacci(dp, n -1) + fibonacci(dp, n -2)) % 10007;
            }
            return dp[n];
        }
    }
}
