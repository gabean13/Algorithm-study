import java.util.*;
import java.io.*;
import java.util.Collections;

class Main {
    static class Matrix implements Comparable<Matrix>{
        int x;
        int y;

        public Matrix(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Matrix matrix){
            if(matrix.y == y){
                return x - matrix.x;
            }else{
                return y - matrix.y;
            }
        }

        @Override
        public String toString(){
            return x + " " + y + "\n";
        }
    }
	static public void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    

        List<Matrix> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Matrix(x, y));
            
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(Matrix matrix : list){
            sb.append(matrix);
        }

        System.out.println(sb);
    }
}