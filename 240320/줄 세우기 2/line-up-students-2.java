import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Info[] info;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        info = new Info[N];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            info[n] = new Info(h, w, n + 1);
        }

        Arrays.sort(info);

        for(Info i : info){
            sb.append(i.h).append(' ')
            .append(i.w).append(' ')
            .append(i.num).append('\n');
        }

        System.out.print(sb);
    }

    static class Info implements Comparable<Info>{
        int h, w, num;

        Info(int h, int w, int num){
            this.h = h;
            this.w = w;
            this.num = num;
        }

        public int compareTo(Info i){
            if(this.h == i.h){
                return Integer.compare(i.w, this.w);
            }
            return Integer.compare(this.h, i.h);
        }
    }
}