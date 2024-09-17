import java.io.*;
import java.util.*;

class Main {
	static public void main(String []args) throws IOException {
        //1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] dx = {1, 0, -1, 0};
        int[] dy  ={0, 1, 0, -1};

        int[][] box = new int[n][m];
        int[][] dist = new int[n][m];

        Queue<Node> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1) {
                    queue.add(new Node(i, j));
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = -1;
                }
            } 
        }

        //2. 계산
        int days = 0;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >=m) {
                    continue;
                }
                if(box[nx][ny] == 0 && dist[nx][ny] == -1) {
                    queue.add(new Node(nx, ny));
                    box[nx][ny] = 1;
                    dist[nx][ny] = dist[node.x][node.y] + 1;
                }
            }
        }

        boolean isAvailable = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(box[i][j] == 0){
                    isAvailable = false;
                    break;
                }

                if(dist[i][j] > days){
                    days = dist[i][j];
                }
            }
        }

        days = isAvailable ? days : -1;
        System.out.println(days);
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}