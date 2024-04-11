import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N, K, U, D;
    static int[][] arr;
    static int maxCity;

    static int[] cityIdx;

    static boolean[][] visited;
    static Queue<Info> q;
    static int city;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        cityIdx = new int[K];
        q = new ArrayDeque<>();

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0);

        sb.append(maxCity);

        System.out.print(sb);
    }

    static void combination(int idx, int start){
        if(idx == K){
            city = 0;
            visited = new boolean[N][N];

            for(int i : cityIdx){
                int r = i / N;
                int c = i % N;

                if(visited[r][c]) continue;
                
                visited[r][c] = true;
                q.add(new Info(r, c));
                city++;
                bfs();
            }

            maxCity = Math.max(maxCity, city);
            return;
        }

        for(int i=start; i<N*N; i++){
            cityIdx[idx] = i;
            combination(idx + 1, i + 1);
        }
    }

    static void bfs(){
        while(!q.isEmpty()){
            Info curr = q.poll();
            int r = curr.r;
            int c = curr.c;

            for(int d=0; d<dr.length; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(isIn(nr, nc) && !visited[nr][nc] && canGo(r, c, nr, nc)){
                    visited[nr][nc] = true;
                    q.add(new Info(nr, nc));
                    city++;
                }
            }
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    static boolean canGo(int r, int c, int nr, int nc){
        int diff = Math.abs(arr[r][c] - arr[nr][nc]);
        return U<=diff && diff<=D;
    }

    static class Info{
        int r, c;

        Info(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}