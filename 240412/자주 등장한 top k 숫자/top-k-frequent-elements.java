import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static HashMap<Integer, Integer> hm;
    static List<Info> list;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        hm = new HashMap<>();
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            int num = Integer.parseInt(st.nextToken());
            int count = hm.getOrDefault(num, 0);
            if(count == 0) list.add(new Info(num));
            hm.put(num, count + 1);
        }

        for(int i=0; i<list.size(); i++){
            Info info = list.get(i);
            info.count = hm.get(info.num);
        }

        Collections.sort(list);

        for(int k=0; k<K; k++){
            sb.append(list.get(k).num).append(' ');
        }

        System.out.print(sb);
    }

    static class Info implements Comparable<Info>{
        int num, count;

        Info(int num){
            this.num = num;
            this.count = 0;
        }

        public int compareTo(Info i){
            if(this.count == i.count){
                return Integer.compare(i.num, this.num);
            }
            return Integer.compare(i.count, this.count);
        }
    }
}