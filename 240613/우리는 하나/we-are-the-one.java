import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N, K, U, D;
    static int[][] arr;
    static int count, ans;

    static int[] selected;

    static Queue<Info> q;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        selected = new int[K];
        q = new ArrayDeque<>();
        selectCities(0, 0);

        sb.append(ans);

        System.out.print(sb);
    }

    static void selectCities(int idx, int start){
        if(idx == K){
            visited = new boolean[N][N];
            count = 0;

            for(int i=0; i<K; i++){
                int r = selected[i] / N;
                int c = selected[i] % N;
                
                if(visited[r][c]) continue;

                visited[r][c] = true;
                q.add(new Info(r, c));
                count++;
                bfs();
            }

            ans = Math.max(ans, count);
            return;
        }

        for(int i=start; i<N * N; i++){
            selected[idx] = i;
            selectCities(idx + 1, i + 1);
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

                if(isIn(nr, nc) && !visited[nr][nc]){
                    int diff = Math.abs(arr[r][c] - arr[nr][nc]);
                    if(diff >= U && diff <= D){
                        visited[nr][nc] = true;
                        q.add(new Info(nr, nc));
                        count++;
                    }
                }
            }
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    static class Info{
        int r, c;

        Info(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}