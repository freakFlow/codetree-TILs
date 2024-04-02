import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    static int N, M;
    static int sr, sc;
    static int distance;
    static List<int[]> bombs;
    static boolean[][] existBomb;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());
        distance = 1;
        bombs = new ArrayList<>();
        existBomb = new boolean[N+1][N+1];

        // 초기 폭탄 설정
        bombs.add(new int[]{sr, sc});
        existBomb[sr][sc] = true;

        // m초간 폭발 진행
        for(int m=0; m<M; m++){
            int size = bombs.size();
            for(int i=0; i<size; i++){
                int[] bomb = bombs.get(i);
                int r = bomb[0];
                int c = bomb[1];

                for(int d=0; d<dr.length; d++){
                    int nr = r + dr[d] * distance;
                    int nc = c + dc[d] * distance;

                    if(isIn(nr, nc) && !existBomb[nr][nc]){
                        bombs.add(new int[]{nr, nc});
                        existBomb[nr][nc] = true;
                    }
                }
            }
            
            distance *= 2;
        }

        sb.append(bombs.size());

        System.out.print(sb);
    }

    static boolean isIn(int r, int c){
        return r>0 && r<=N && c>0 && c<=N;
    }
}