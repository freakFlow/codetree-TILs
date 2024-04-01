import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static char WALL = '#';
    static int N;
    static int sr, sc, sd;
    static char[][] maze;
    static int time;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;
        maze = new char[N][N];

        for(int r=0; r<N; r++){
            String row = br.readLine();
            for(int c=0; c<N; c++){
                maze[r][c] = row.charAt(c);
            }
        }

        int r = sr;
        int c = sc;
        int d = sd;
        while(true){
            int nr = r + dr[d];
            int nc = c + dc[d];
            time++;

            if(!isIn(nr, nc)) break;

            if(maze[nr][nc] == WALL){
                time--;
                if(hasLoop(r, c)){
                    time = -1;
                    break;
                }else{
                    d = (d - 1 + 4) % 4;
                    continue;
                }
            }

            r = nr;
            c = nc;

            if(r == sr && c == sc && d == sd){
                time = -1;
                break;
            }

            int nd = (d + 1) % 4;
            nr = r + dr[nd];
            nc = c + dc[nd];
            if(!isIn(nr, nc) || maze[nr][nc] != WALL) d = (d + 1) % 4;
        }

        sb.append(time);

        System.out.print(sb);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    static boolean hasLoop(int r, int c){
        for(int d=0; d<dr.length; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(!isIn(nr, nc) || maze[nr][nc] != WALL) return false;
        }

        return true;
    }
}