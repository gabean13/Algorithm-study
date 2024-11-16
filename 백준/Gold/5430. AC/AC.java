import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//입력
		int testCases = Integer.parseInt(br.readLine());
		for(int i = 0; i < testCases; i++) {
			char[] orders = br.readLine().toCharArray();
			int size = Integer.parseInt(br.readLine());
			ArrayDeque<Integer> deque = new ArrayDeque<>();
			String numberString = br.readLine();
			String[] numberArr = numberString.substring(1, numberString.length() - 1).split(",");
			for(int j = 0; j < size; j++) {
				deque.add(Integer.parseInt(numberArr[j]));
			}
			boolean isReversed = false;  // 뒤집혔는지 여부만 저장
            boolean isError = false;
            
            for(char order : orders) {
                if(order == 'R') {
                    isReversed = !isReversed;  // 실제로 뒤집지 않고 방향만 전환
                }
                else if(order == 'D') {
                    if(deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if(isReversed) {
                        deque.removeLast();  // 뒤집힌 상태면 뒤에서 제거
                    } else {
                        deque.removeFirst();  // 안 뒤집힌 상태면 앞에서 제거
                    }
                }
            }
            
            if(isError) {
                sb.append("error\n");
            } else {
                sb.append("[");
                int dequeSize = deque.size();
                if(isReversed) {
                    // 뒤집힌 상태면 뒤에서부터 출력
                    for(int j = 0; j < dequeSize; j++) {
                        sb.append(deque.removeLast());
                        if(j != dequeSize-1) sb.append(",");
                    }
                } else {
                    // 안 뒤집힌 상태면 앞에서부터 출력
                    for(int j = 0; j < dequeSize; j++) {
                        sb.append(deque.removeFirst());
                        if(j != dequeSize-1) sb.append(",");
                    }
                }
                sb.append("]\n");
            }
		}
		
		System.out.println(sb);
	}
}