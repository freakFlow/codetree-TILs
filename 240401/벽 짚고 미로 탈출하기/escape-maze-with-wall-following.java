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

            // 미로 탈출
            if(!isIn(nr, nc)){
                time++;
                break;
            }

            
            if(maze[nr][nc] == WALL){// 다음 이동할 곳이 벽인 경우
                d = (d - 1 + 4) % 4;
            }else{// 다음 이동할 곳이 비어있는 경우
                r = nr;
                c = nc;
                time++;
                
                // 오른쪽 벽 체크해서 비어있으면 시계방향 회전
                nr = r + dr[(d + 1) % 4];
                nc = c + dc[(d + 1) % 4];
                if(!isIn(nr, nc) || maze[nr][nc] != WALL) d = (d + 1) % 4;
            }

            // 최종적으로 움직인 위치가 시작 위치와 같을 경우 탈출 불가
            if(r == sr && c == sc && d == sd){
                time = -1;
                break;
            }
        }

        sb.append(time);

        System.out.print(sb);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}