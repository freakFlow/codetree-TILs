import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    
    static final int MAX = 4000;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, -1, 0, 1};

    static int T;
    static int N;
    static boolean[][] arr;
    static PriorityQueue<Info> pq;
    static int ans;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            arr = new boolean[MAX+1][MAX+1];
            pq = new PriorityQueue<>();
            ans = -1;

            for(int n=0; n<N; n++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken()) * 2 + MAX / 2;
                int c = Integer.parseInt(st.nextToken()) * 2 + MAX / 2;
                int w = Integer.parseInt(st.nextToken());
                int d = getDir(st.nextToken());

                pq.add(new Info(n, r, c, w, d));
            }

            Queue<Info> q = new ArrayDeque<>();
            int time = 0;

            while(true){
                time++;

                while(!pq.isEmpty()){
                    Info curr = pq.poll();
                    curr.r += dr[curr.d];
                    curr.c += dc[curr.d];

                    if(!isIn(curr.r, curr.c))continue;

                    if(arr[curr.r][curr.c]){
                        ans = time;
                        continue;
                    }

                    arr[curr.r][curr.c] = true;
                    q.add(curr);
                }

                if(q.isEmpty()) break;

                while(!q.isEmpty()){
                    Info curr = q.poll();
                    arr[curr.r][curr.c] = false;
                    pq.add(curr);
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }

    static int getDir(String str){
        switch(str){
            case "R": return 0;
            case "D": return 1;
            case "L": return 2;
            case "U": return 3;
        }

        return -1;
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<=MAX && c>=0 && c<=MAX;
    }

    static class Info implements Comparable<Info>{
        int idx, r, c, w, d;

        Info(int idx, int r, int c, int w, int d){
            this.idx = idx;
            this.r = r;
            this.c = c;
            this.w = w;
            this.d = d;
        }

        public int compareTo(Info i){
            if(this.w == i.w){
                return Integer.compare(i.idx, this.idx);
            }

            return Integer.compare(i.w, this.w);
        }
    }
}