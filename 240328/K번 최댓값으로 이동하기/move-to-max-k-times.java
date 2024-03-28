import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int N, K;
    static int[][] arr;
    static Queue<int[]> q;
    static boolean[][] visited;
    static int sr, sc, sw;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        q = new ArrayDeque<>();

        for(int r=1; r<=N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=1; c<=N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());
        sw = arr[sr][sc];

        for(int k=0; k<K; k++){
            visited = new boolean[N+1][N+1];
            visited[sr][sc] = true;
            q.add(new int[]{sr, sc});
            bfs();
        }

        sb.append(sr).append(' ').append(sc);

        System.out.print(sb);
    }

    static void bfs(){
        int tr = 0, tc = 0, tw = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int w = arr[r][c];
            
            for(int d=0; d<dr.length; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(!isIn(nr, nc) || visited[nr][nc] || arr[nr][nc] >= sw) continue;
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
                
                int nw = arr[nr][nc];
                if(nw > tw){
                    tw = nw;
                    tr = nr;
                    tc = nc;
                }else if(nw == tw){
                    if(nr < tr){
                        tw = nw;
                        tr = nr;
                        tc = nc;
                    }else if(nr == tr){
                        if(nc < tc){
                            tw = nw;
                            tr = nr; 
                            tc = nc;
                        }
                    }
                }
            }
        }

        sr = tr;
        sc = tc;
        sw = tw;
    }

    static boolean isIn(int r, int c){
        return r>0 && r<=N && c>0 && c<=N;
    }
}