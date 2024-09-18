import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class Main {
	static public void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int noListenCnt = Integer.parseInt(st.nextToken());
        int noLWatchCnt = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new TreeMap<>();
        for(int i = 0; i < noListenCnt; i++) {
            map.put(br.readLine(), 0);
        }

        for(int i = 0; i < noLWatchCnt ; i++) {
            String name = br.readLine();
            if(map.containsKey(name)) {
                map.put(name, map.get(name)+1);
            }
        }
        
        int noListenWatchCnt = 0;
        StringBuffer sb = new StringBuffer();

         for (Entry<String, Integer> entrySet : map.entrySet()) {
            if(entrySet.getValue() != 0) {
                sb.append(entrySet.getKey()).append("\n");
                noListenWatchCnt++;
            }
        }

        System.out.println(noListenWatchCnt);
        System.out.println(sb);
    }
}