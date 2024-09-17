import java.io.*;
import java.util.*;

class Main {
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m;
	static public void main(String []args) throws IOException {
        //1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //2. 계산
        int pictureCnt = 0;
        int maxSize = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int pictureSize = 0;
                //방문하지 않은 그림의 시작점인지 검사
                if(matrix[i][j] == 1 && !visited[i][j]) {
                    int currentSize = bfs(i, j);
                    pictureCnt++;
                    maxSize = Math.max(maxSize, currentSize);
                }
            }
        }

        System.out.println(pictureCnt);
        System.out.println(maxSize);
    }

    private static int bfs(int startX, int startY) {
        int pictureSize = 1;
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(startX, startY));
        visited[startX][startY] = true;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for(int dir = 0; dir < 4; dir++){
                int nx = node.x + dx[dir];
                int ny = node.y + dy[dir];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m){ // 범위 체크
                    if(matrix[nx][ny] == 1 && visited[nx][ny] == false) {
                        queue.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                        pictureSize++;
                    }
                }
            }
        }

        return pictureSize;
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}