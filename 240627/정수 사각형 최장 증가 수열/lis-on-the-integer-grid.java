import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N;
    static int[][] arr;
    static PriorityQueue<Info> pq;
    static int[][] max;
    static int ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        pq = new PriorityQueue<>();
        max = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
                pq.add(new Info(r, c, arr[r][c]));
            }
        }

        while(!pq.isEmpty()){
            Info curr = pq.poll();
            int r = curr.r;
            int c = curr.c;
            int n = curr.n;

            for(int d=0; d<dr.length; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(isIn(nr, nc) && arr[nr][nc] > n){
                    max[nr][nc] = Math.max(max[nr][nc], max[r][c] + 1);
                }
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                ans = Math.max(ans, max[r][c]);
            }
        }

        sb.append(ans + 1);

        System.out.print(sb);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    static class Info implements Comparable<Info>{
        int r, c, n;

        Info(int r, int c, int n){
            this.r = r;
            this.c = c;
            this.n = n;
        }

        public int compareTo(Info i){
            return Integer.compare(this.n, i.n);
        }
    }
}