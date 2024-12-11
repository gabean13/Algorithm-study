import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        List <String> al = new ArrayList<>();

        //1. 입력
        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine());
            al.add(st.nextToken());
        }

        //2. 중복제거
        Set<String> hs = new HashSet<>(al);
        al = new ArrayList<>(hs);
        
        //3. 정렬
        Collections.sort(al, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                if(o1.length() > o2.length()){
                    return 1;
                }else if(o1.length() < o2.length()){
                    return -1;
                }else{
                    return o1.compareTo(o2);
                }
            }
        });

        for(String str : al){
            System.out.println(str);
        }
    }
}
