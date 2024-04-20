import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] dr = {-1, -1, 1, 1};
    static int[] dc = {1, -1, -1, 1};

    static int N;
    static int[][] arr;
    static int sr, sc;
    static int max;

    static Queue<Info> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                sr = r + 1;
                sc = c - 1;
                if(!isIn(sr, sc)) continue;
                q.add(new Info(r, c, 0, arr[sr][sc]));
                bfs();
            }
        }

        sb.append(max);

        System.out.print(sb);
    }

    static void bfs(){
        while(!q.isEmpty()){
            Info curr = q.poll();
            int r = curr.r;
            int c = curr.c;
            int dir = curr.dir;
            int sum = curr.sum;

            if(r == sr && c == sc && dir == 3){
                max = Math.max(max, sum);
            }

            // 진행된 방향으로 계산하기
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if(isIn(nr, nc)){
                q.add(new Info(nr, nc, dir, sum+arr[nr][nc]));
            }

            if(dir == 3) continue;
            // 다른 방향으로 회전하기
            nr = r + dr[dir + 1];
            nc = c + dc[dir + 1];
            if(isIn(nr, nc)){
                q.add(new Info(nr, nc, dir+1, sum+arr[nr][nc]));
            }
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    static class Info{
        int r, c, dir, sum;

        Info(int r, int c, int dir, int sum){
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.sum = sum;
        }
    }
}