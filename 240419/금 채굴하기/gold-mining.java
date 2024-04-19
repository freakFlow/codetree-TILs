import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int GOLD = 1;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N, M;
    static int K, cost;
    static int[][] arr;
    static int maxGold;
    
    static boolean[][] visited;
    static Queue<Info> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(K=0; K<N; K++){
            cost = K * K + (K + 1) * (K + 1);
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    visited = new boolean[N][N];
                    visited[r][c] = true;
                    q.add(new Info(r, c, 0));
                    bfs();
                }
            }
        }

        sb.append(maxGold);

        System.out.print(sb);
    }

    static void bfs(){
        int gold = 0;

        while(!q.isEmpty()){
            Info curr = q.poll();
            int r = curr.r;
            int c = curr.c;
            int depth = curr.depth;

            if(arr[r][c] == GOLD) gold++;

            if(depth >= K) continue;

            for(int d=0; d<dr.length; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(isIn(nr, nc) && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.add(new Info(nr, nc, depth + 1));
                }
            }
        }

        if(gold * M >= cost) maxGold = Math.max(maxGold, gold);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    static class Info{
        int r, c, depth;

        Info(int r, int c, int depth){
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }
}