import java.util.*;

class Node{
    int x;
    int y;
    int cnt;
    
    Node (int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

class Solution {
    public int solution(int[][] maps) {
        //1. 최단 경로 + 격자 => BFS
        int answer = -1;
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        //2. 출발점 할당
        Node node = new Node(0, 0, 1);
        queue.add(node);
        visited[0][0] = true;
        
        //3. 방향별 dx, dy (상, 하, 좌, 우)
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
    
        while(!queue.isEmpty()){
            Node cn = queue.remove();
            if((cn.x == maps[0].length-1) && (cn.y == maps.length-1)){
                answer = cn.cnt;
            }
            for(int i = 0; i < 4; i++){
                int nx = cn.x + dx[i];
                int ny = cn.y + dy[i];
                
                //해당 방향에 격자가 존재하고
                if(0 <= nx && nx < maps[0].length && 0 <= ny && ny < maps.length){
                    //방문하지 않았고
                    if(!visited[ny][nx]){
                        //0이 아니고
                        if(maps[ny][nx] != 0){
                            Node newNode = new Node(nx, ny, cn.cnt+1);
                            queue.add(newNode);
                            visited[ny][nx] = true;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}

