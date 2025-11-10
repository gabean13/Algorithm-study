import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        Queue<Node> queue = new LinkedList<>();
        
        int height = maps.length;
        int width = maps[0].length;
        boolean[][] visited = new boolean[height][width];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        queue.add(new Node(0, 0, 1));
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int cx = node.x;
            int cy = node.y;
            int cdist = node.dist;
            if(cx == (width - 1) && cy == (height - 1)) {
                return cdist;
            }
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
                if(visited[ny][nx] || maps[ny][nx] == 0) continue;
                queue.add(new Node(nx, ny, cdist+1));
                visited[ny][nx] = true;
            }
        }
        
        return -1;
    }
    
    class Node {
        int x;
        int y;
        int dist;
        
        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}