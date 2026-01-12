import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N, M 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 누적 합의 나머지 저장
        st = new StringTokenizer(br.readLine());
        long[] prefixMod = new long[N];
        prefixMod[0] = Long.parseLong(st.nextToken()) % M;
        for (int i = 1; i < N; i++) {
            prefixMod[i] = (Long.parseLong(st.nextToken()) % M + prefixMod[i-1]) % M;
        }
        
        // 각 나머지값의 출현 횟수 카운트
        long[] count = new long[M];
        long answer = 0;
        
        for (int i = 0; i < N; i++) {
            int remainder = (int) prefixMod[i];
            
            // 누적합 자체가 M으로 나누어떨어지는 경우 (0부터 i까지)
            if (remainder == 0) answer++;
            
            count[remainder]++;
        }
        
        // 같은 나머지를 가진 누적합 쌍의 개수 = nC2
        // long 타입으로 계산하여 오버플로우 방지
        for (int i = 0; i < M; i++) {
            if (count[i] > 1) {
                answer += (count[i] * (count[i] - 1)) / 2;
            }
        }
        
        System.out.println(answer);
    }
}