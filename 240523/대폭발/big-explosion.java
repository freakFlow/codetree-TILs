import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    
    static int N, M, r, c;
    static boolean[][] arr;
    static List<Info> list;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        arr = new boolean[N][N];
        list = new ArrayList<>();

        // 초기 상태 설정
        arr[r][c] = true;
        list.add(new Info(r, c));

        for(int m=1; m<=M; m++){
            int size = list.size();
            for(int i=0; i<size; i++){
                Info bomb = list.get(i);
                for(int d=0; d<dr.length; d++){
                    int nr = bomb.r + dr[d] * m;
                    int nc = bomb.c + dc[d] * m;

                    if(isIn(nr, nc) && !arr[nr][nc]){
                        arr[nr][nc] = true;
                        list.add(new Info(nr, nc));
                    }
                }
            }
        }

        sb.append(list.size());

        System.out.print(sb);
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