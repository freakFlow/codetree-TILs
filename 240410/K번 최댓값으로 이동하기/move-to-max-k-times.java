import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    static int N, K;
    static int[][] arr;
    static int sr, sc, num;

    static boolean[][] visited;
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        q = new ArrayDeque<>();

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;
        num = arr[sr][sc];

        for(int k=0; k<K; k++){
            // 1. num보다 큰 곳 이동 불가 처리
            visited = new boolean[N][N];
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if(arr[r][c] >= num) visited[r][c] = true;
                }
            }

            // 2. bfs로 우선순위에 맞는 다음 위치 찾기
            visited[sr][sc] = true;
            q.add(new int[]{sr, sc});
            bfs();

            // 3. 다음 위치의 값으로 기준값 변경
            num = arr[sr][sc];
        }

        sb.append(sr + 1).append(' ').append(sc + 1);

        System.out.print(sb);
    }

    static void bfs(){
        int max = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int d=0; d<dr.length; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(isIn(nr, nc) && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});

                    if(arr[nr][nc] > max){
                        max = arr[nr][nc];
                        sr = nr;
                        sc = nc;
                    }else if(arr[nr][nc] == max){
                        if((nr < sr) || (nr == sr && nc < sc)){
                            sr = nr;
                            sc = nc;
                        }
                    }
                }
            }
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}