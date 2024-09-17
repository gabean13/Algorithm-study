import java.io.*;
import java.util.*;

class Main {
	static public void main(String []args) throws IOException {
        //1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //세로 가로 입력
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //2. 계산
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Queue<Node> queue = new LinkedList<>();

        int pictureCnt = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int pictureSize = 0;
                //방문하지 않은 그림의 시작점인지 검사
                if(matrix[i][j] == 1 && visited[i][j] == false) {
                    queue.add(new Node(i, j));
                    visited[i][j] = true;
                    pictureCnt++;
                    pictureSize++;
                }
                //그림 검사 시작
                while(!queue.isEmpty()) {
                    Node node = queue.poll();
                    for(int dir = 0; dir < 4; dir++){
                        int nx = node.x + dx[dir];
                        int ny = node.y + dy[dir];
                        if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                            if(matrix[nx][ny] == 1 && visited[nx][ny] == false) {
                                queue.add(new Node(nx, ny));
                                visited[nx][ny] = true;
                                pictureSize++;
                            }
                        }
                    }
                }

                if(pictureSize > max) {
                    max = pictureSize;
                }
            }
        }
        System.out.println(pictureCnt);
        System.out.println(max);
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