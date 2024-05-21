import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int BOMB = 0;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N, M;
    static int[][] arr;
    static int col;

    public static void main(String[] args) throws IOException {
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

        for(int m=0; m<M; m++){
            col = Integer.parseInt(br.readLine());

            // 1. 폭탄 위치 찾기
            int bomb_r=-1, bomb_c = col - 1;
            for(int r=0; r<N; r++){
                if(arr[r][bomb_c] == 0) continue;

                bomb_r = r;
                break;
            }

            // 폭탄이 없는지 확인
            if(bomb_r == -1) continue;

            // 2. 폭탄 터트리기
            int bomb = arr[bomb_r][bomb_c];
            arr[bomb_r][bomb_c] = BOMB;

            for(int b=1; b<bomb; b++){
                for(int d=0; d<dr.length; d++){
                    int nr = bomb_r + dr[d] * b;
                    int nc = bomb_c + dc[d] * b;

                    if(isIn(nr, nc)) arr[nr][nc] = BOMB;
                }
            }

            // 3. 중력
            int[][] temp = new int[N][N];
            for(int c=0; c<N; c++){
                int tr = N-1;
                for(int r=N-1; r>=0; r--){
                    if(arr[r][c] == BOMB) continue;
                    temp[tr--][c] = arr[r][c];
                }

                for(int r=0; r<N; r++){
                    arr[r][c] = temp[r][c];
                }
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                sb.append(arr[r][c]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}