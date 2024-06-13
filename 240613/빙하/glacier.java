import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int WATER = 0, ICE = 1;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N, M;
    static int[][] arr;
    static int time, count, last;

    static Queue<Info> q;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        q = new ArrayDeque<>();
        while(true){
            visited = new boolean[N][M];

            visited[0][0] = true;
            q.add(new Info(0, 0));
            count = 0;
            bfs();

            if(count == 0) break;

            time++;
            last = count;
        }

        sb.append(time).append(' ').append(last);

        System.out.print(sb);
    }

    static void bfs(){
        while(!q.isEmpty()){
            Info curr = q.poll();
            int r = curr.r;
            int c = curr.c;

            for(int d=0; d<dr.length; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(isIn(nr, nc) && !visited[nr][nc]){
                    visited[nr][nc] = true;

                    if(arr[nr][nc] == ICE){
                        arr[nr][nc] = WATER;
                        count++;
                    }else{
                        q.add(new Info(nr, nc));
                    }
                }
            }
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<M;
    }

    static class Info{
        int r, c;

        Info(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}