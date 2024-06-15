import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N, K;
    static List<Info> walls;
    static int sr, sc, er, ec;
    static int ans;

    static boolean[][] blocked;
    static boolean[][] visited;
    static Queue<Info> q;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        walls = new ArrayList<>();
        ans = Integer.MAX_VALUE;

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                if(st.nextToken().equals("1")) walls.add(new Info(r, c, 0));
            }
        }

        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        er = Integer.parseInt(st.nextToken()) - 1;
        ec = Integer.parseInt(st.nextToken()) - 1;

        blocked = new boolean[N][N];
        setWall(0, 0);

        sb.append(ans == Integer.MAX_VALUE ? -1 : ans);

        System.out.print(sb);
    }

    static void setWall(int idx, int start){
        if(idx == walls.size() - K){
            visited = new boolean[N][N];
            q = new ArrayDeque<>();

            visited[sr][sc] = true;
            q.add(new Info(sr, sc, 0));
            bfs();
            return;
        }

        for(int i=start; i<walls.size(); i++){
            Info wall = walls.get(i);
            if(blocked[wall.r][wall.c]) continue;
            blocked[wall.r][wall.c] = true;
            setWall(idx + 1, i + 1);
            blocked[wall.r][wall.c] = false;
        }
    }

    static void bfs(){
        while(!q.isEmpty()){
            Info curr = q.poll();
            int r = curr.r;
            int c = curr.c;
            int w = curr.w;

            if(r == er && c == ec){
                ans = Math.min(ans, w);
                return;
            }

            for(int d=0; d<dr.length; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(isIn(nr, nc) && !visited[nr][nc] && !blocked[nr][nc]){
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

        Info(int r, int c, int w){
            this.r = r;
            this.c = c;
            this.w = w;
        }
    }
}