import java.util.*;
import java.io.*;

class Solution {
    static int height, width;
    static char[][] matrix;
    public int[] solution(String[] park, String[] routes) {
        height = park.length;
        width = park[0].length();
        
        //1. park 입력
        int cx = 0, cy = 0;
        matrix = new char[height][width];
        for(int y = 0; y < height; y++) {
            char[] input = park[y].toCharArray();
            for(int x = 0; x < width; x++) {
                matrix[y][x] = input[x];
                if(input[x] == 'S') {
                    cx = x;
                    cy = y;
                }
            }
        }
    
        //2. 이동
        for(String order : routes) {
            StringTokenizer st = new StringTokenizer(order);
            String dir = st.nextToken();
            int move = Integer.parseInt(st.nextToken());
            //명령어에 맞는 이동 수행
            switch(dir) {
                case ("N") : {
                    int[] xy = moveDog(cx, cy, move, 0);
                    if(xy[0] == -1) break;
                    cx = xy[0];
                    cy = xy[1];
                    break;
                }
                case ("S") : {
                    int[] xy = moveDog(cx, cy, move, 1);
                    if(xy[0] == -1) break;
                    cx = xy[0];
                    cy = xy[1];
                    break;
                }
                case ("W") : {
                    int[] xy = moveDog(cx, cy, move, 2);
                    if(xy[0] == -1) break;
                    cx = xy[0];
                    cy = xy[1];
                    break;
                }
                case ("E") : {
                    int[] xy = moveDog(cx, cy, move, 3);
                    if(xy[0] == -1) break;
                    cx = xy[0];
                    cy = xy[1];
                    break;
                }
            }
        }
        
        int[] answer = {cy, cx};
        return answer;
    }
    
    static int[] moveDog(int cx, int cy, int move, int dir) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        int[] answer = {-1, -1};
        for(int i = 0; i < move; i++) {
            int ny = cy + dy[dir];
            int nx = cx + dx[dir];
            if(ny < 0 || nx < 0 || ny >= height || nx >= width) return answer;
            if(matrix[ny][nx] == 'X') return answer;
            cy = ny;
            cx = nx;
        }
        
        answer[0] = cx;
        answer[1] = cy;
        
        return answer;
    }
}