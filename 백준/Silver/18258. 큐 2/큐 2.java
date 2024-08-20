import java.io.*;
import java.util.*;

class Main {
    static int[] queue = new int[2000001];
    static int front = 0;
    static int rear = 0;

	static public void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            switch(order) {
                case("push") : {
                    push(Integer.parseInt(st.nextToken()));
                    break;
                }
                case("pop") : {
                    sb.append(pop()).append("\n");
                    break;
                }
                case("size") : {
                    sb.append(size()).append("\n");
                    break;
                }
                case("empty") : {
                    sb.append(empty() ? 1 : 0).append("\n");
                    break;
                }
                case("front") : {
                    sb.append(front()).append("\n");
                    break;
                }
                case("back") : {
                    sb.append(back()).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }

    static void push(int X){
        queue[rear++] = X;
    }

    static int pop() {
        if(empty()){
            return -1;
        }

        return queue[front++];
    }

    static int size() {
        return rear-front;
    }

    static boolean empty() {
        if(size()==0){
            return true;
        }
        
        return false;
    }

    static int front() {
        if(empty()){
            return -1;
        }

        return queue[front];
    }

    static int back() {
        if(empty()){
            return -1;
        }

        return queue[rear-1];
    }
}