import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char [][] matrix = new char[R][C];
        int[][] fireDist = new int[R][C];
        int[][] jihoonDist = new int[R][C];
        
        Queue<Node> queue = new LinkedList<>();
        int jx = 0, jy = 0;
        for(int i = 0; i < R; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < C; j++) {
                matrix[i][j] = input[j];
                fireDist[i][j] = -1;
                jihoonDist[i][j] = -1;
                if(input[j] == 'F') {
                	queue.add(new Node(i, j));
                	fireDist[i][j] = 1;
                }
                if(input[j] == 'J') {
                    jx = i;
                    jy = j;
                }
            }
        }
        
        //1. 불 이동 경로를 dist로 표시
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
     
        while(!queue.isEmpty()) {
        	Node node = queue.poll();
        	int cx = node.x;
        	int cy = node.y;
        	for(int i = 0; i < 4; i++) {
        		int nx = cx + dx[i];
        		int ny = cy + dy[i];
        		if(nx < 0 || ny < 0 || nx >= R || ny >= C) {
        			continue;
        		}
        		if(fireDist[nx][ny] == -1 && matrix[nx][ny] != '#') {
        			queue.add(new Node(nx, ny));
        			fireDist[nx][ny] = fireDist[cx][cy] + 1;
        		}
        	}
        }
        

        //2. 지훈이 이동경로
        queue.add(new Node(jx, jy));
        jihoonDist[jx][jy] = 1;
        
        int minDist = 1000001;
        while(!queue.isEmpty()) {
        	Node node = queue.poll();
        	int cx = node.x;
        	int cy = node.y;
        	if(cx == 0 || cy == 0 || cx == R-1 || cy == C-1) {
				if(jihoonDist[cx][cy] < minDist) {
					minDist = jihoonDist[cx][cy];
				}
			}
        	for(int i = 0; i < 4; i++) {
        		int nx = cx + dx[i];
        		int ny = cy + dy[i];
        		if(nx < 0 || ny < 0 || nx >= R || ny >= C) {
        			continue;
        		}
        		if(jihoonDist[nx][ny] == -1 && matrix[nx][ny] != '#' 
        				&& (fireDist[nx][ny] > jihoonDist[cx][cy] + 1 || fireDist[nx][ny] == -1)) {
        			queue.add(new Node(nx, ny));
        			jihoonDist[nx][ny] = jihoonDist[cx][cy] + 1;
        		}
        	}
        }
        
        System.out.println((minDist == 1000001) ? "IMPOSSIBLE" : minDist);
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