import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int WATER = 0, ICE = 1;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N, M;
    static int[][] arr;
    static int sr, sc;
    static int time, lastCount;

    static boolean[][] visited;
    static List<Info> melted;
    static Queue<Info> q;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        melted = new ArrayList<>();
        q = new ArrayDeque<>();

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 시작 위치 찾기
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(isEdge(r, c) && arr[r][c] == WATER){
                    sr = r;
                    sc = c;
                }
            }
        }

        while(true){
            // 1. 시작 위치부터 bfs를 돌며 녹일 빙하 위치 및 개수 저장
            melted.clear();
            visited = new boolean[N][M];
            visited[sr][sc] = true;
            q.add(new Info(sr, sc));
            bfs();

            // 더 이상 빙하가 남아있지 않다면 종료
            if(melted.size() == 0) break;

            // 2. 빙하 녹이기
            for(Info i : melted){
                arr[i.r][i.c] = WATER;
            }

            time++;
            lastCount = melted.size();
        }

        sb.append(time).append(' ').append(lastCount);

        System.out.print(sb);
    }

    static boolean isEdge(int r, int c){
        return r==0 || r==N-1 || c==0 || c==M-1;
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

                    if(arr[nr][nc] == WATER){
                        q.add(new Info(nr, nc));
                    }else{
                        melted.add(new Info(nr, nc));
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