import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static Info[] points;
    static int ans;

    static Info[] selected4M;
    static int distance;
    static Info[] selected42;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        points = new Info[N];
        ans = Integer.MAX_VALUE;
        selected4M = new Info[M];
        selected42 = new Info[2];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[n] = new Info(x, y);
        }

        selectM(0, 0);

        sb.append(ans);

        System.out.print(sb);
    }

    static void selectM(int idx, int start){
        if(idx == M){
            distance = 0;
            select2(0, 0);
            ans = Math.min(ans, distance);
            return;
        }

        for(int i=start; i<N; i++){
            selected4M[idx] = points[i];
            selectM(idx + 1, i + 1);
        }
    }

    static void select2(int idx, int start){
        if(idx == 2){
            distance = Math.max(distance, getDistance());
            return;
        }

        for(int i=start; i<M; i++){
            selected42[idx] = selected4M[i];
            select2(idx + 1, i + 1);
        }
    }

    static int getDistance(){
        return (int)(Math.pow(selected42[0].x - selected42[1].x, 2) + Math.pow(selected42[0].y - selected42[1].y, 2));
    }

    static class Info{
        int x, y;

        Info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}