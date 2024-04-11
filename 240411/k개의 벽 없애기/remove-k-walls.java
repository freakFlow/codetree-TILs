import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N, K;
    static List<Info> walls;
    static int sr, sc, er, ec;
    static int minTime = Integer.MAX_VALUE;

    static int[] wallIdx;

    static boolean[][] visited;
    static Queue<Info> q;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        walls = new ArrayList<>();
        q = new ArrayDeque<>();

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                if(st.nextToken().equals("1")) walls.add(new Info(r, c));
            }
        }

        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        er = Integer.parseInt(st.nextToken()) - 1;
        ec = Integer.parseInt(st.nextToken()) - 1;

        wallIdx = new int[walls.size() - K];
        combination(0, 0);

        if(minTime == Integer.MAX_VALUE) minTime = -1;
        sb.append(minTime);

        System.out.print(sb);
    }

    static void combination(int idx, int start){
        if(idx == wallIdx.length){
            visited = new boolean[N][N];
            for(int wIdx : wallIdx){
                Info wall = walls.get(wIdx);
                visited[wall.r][wall.c] = true;
            }

            visited[sr][sc] = true;
            q.add(new Info(sr, sc));
            bfs();

            return;
        }

        for(int i=start; i<walls.size(); i++){
            wallIdx[idx] = i;
            combination(idx + 1, i + 1);
        }
    }

    static void bfs(){
        while(!q.isEmpty()){
            Info curr = q.poll();
            int r = curr.r;
            int c = curr.c;
            int w = curr.w;

            if(r == er && c == ec){
                minTime = Math.min(minTime, w);
                q.clear();
                break;
            }

            for(int d=0; d<dr.length; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(isIn(nr, nc) && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.add(new Info(nr, nc, w + 1));
                }
            }
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    static class Info{
        int r, c, w;

        Info(int r, int c){
            this.r = r;
            this.c = c;
            this.w = 0;
        }

        Info(int r, int c, int w){
            this.r = r;
            this.c = c;
            this.w = w;
        }
    }
}