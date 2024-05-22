import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int BOMB = 0;
    
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N;
    static int[][] arr;
    static int[][] copied;
    static int ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        copied = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                copy();
                bomb(r, c);
                gravity();
                count();
            }
        }

        sb.append(ans);

        System.out.print(sb);
    }

    static void copy(){
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                copied[r][c] = arr[r][c];
            }
        }
    }

    static void bomb(int r, int c){
        int bombSize = copied[r][c];
        copied[r][c] = BOMB;

        for(int b=1; b<bombSize; b++){
            for(int d=0; d<dr.length; d++){
                int nr = r + dr[d] * b;
                int nc = c + dc[d] * b;

                if(isIn(nr, nc)) copied[nr][nc] = BOMB;
            }
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    static void gravity(){
        int[][] temp = new int[N][N];

        for(int c=0; c<N; c++){
            int tr = N-1;
            for(int r=N-1; r>=0; r--){
                if(copied[r][c] == BOMB) continue;
                temp[tr--][c] = copied[r][c];
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                copied[r][c] = temp[r][c];
            }
        }
    }

    static void count(){
        int pair = 0;

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(copied[r][c] == BOMB) continue;

                for(int d=0; d<2; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if(isIn(nr, nc) && copied[r][c] == copied[nr][nc]) pair++;
                }
            }
        }
        
        ans = Math.max(ans, pair);
    }
}