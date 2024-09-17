import java.io.*;
import java.util.*;

class Main {
    static int[][] maze;
    static int[][] dis;
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy  ={0, 1, 0, -1};
	static public void main(String []args) throws IOException {
        //1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        dis = new int[n][m];

        for(int i = 0; i < n; i++) {
           char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                maze[i][j] = arr[j]-'0';
                dis[i][j] = -1;
            } 
        }

        //2. 최단거리 계산
        System.out.println(bfs());
    }  
    
    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        dis[0][0] = 1;

        int currentCnt = 1;
        int minCnt = 10000;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(maze[nx][ny] == 1 && dis[nx][ny] == -1) {
                        queue.add(new Node(nx, ny));
                        dis[nx][ny] = dis[node.x][node.y] + 1;
                    }
                }
            }
        }

        return dis[n-1][m-1];
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