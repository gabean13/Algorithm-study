import java.io.*;

public class Main {
    public static void main(String... args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N! 에서 0이 아닌 수가 나오기 전까지의 숫자 개수
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            int num = i;
            while(num % 5 == 0) {
                answer++;
                num /= 5;
            }
        }

        System.out.println(answer);
    }
}
