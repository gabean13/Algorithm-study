import java.util.*;
import java.io.*;

class Main {
    static int max = 10000;
    static int[] deque = new int[2*max + 1];
    static int head = max;
    static int tail = max;

	static public void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case("push_front") : {
                    pushFront(Integer.parseInt(st.nextToken()));
                    break;
                } 
                case("push_back") : {
                    pushBack(Integer.parseInt(st.nextToken()));
                    break;
                }
                case("pop_front") : {
                    sb.append(popFront()).append("\n");
                    break;
                }
                case("pop_back") : {
                    sb.append(popBack()).append("\n");
                    break;
                }
                case("size") : {
                    sb.append(size()).append("\n");
                    break;
                }
                case("empty") : {
                    sb.append(empty()).append("\n");
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

    static void pushFront(int X){
        deque[--head] = X;
    }

    static void pushBack(int X) {
        deque[tail++] = X;
    }

    static int popFront() {
        if(empty() == 1) {
            return -1;
        }
        return deque[head++];
    }

    static int popBack() {
        if(empty() == 1) {
            return -1;
        }
        return deque[--tail];
    }

    static int size() {
        return tail - head;
    }

    static int empty() {
        if(size() == 0) {
            return 1;
        }
        return 0;
    }

    static int front() {
        if(empty() == 1) {
            return -1;
        }
        return deque[head];
    }

    static int back() {
        if(empty() == 1) {
            return -1;
        }
        return deque[tail - 1];
    }
}