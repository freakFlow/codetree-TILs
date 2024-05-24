import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int BLANK = 0, SNAKE = 1, APPLE = 2;
    static final int RIGHT = 0, DOWN = 1, LEFT = 2, UP = 3;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N, M, K;
    static int[][] arr;
    static Deque<Info> snake;
    static int time;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        snake = new ArrayDeque<>();

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            arr[r][c] = APPLE;
        }

        snake.add(new Info(0, 0));
        arr[0][0] = SNAKE;

        boolean isEnd = false;
        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int dir = getDir(st.nextToken());
            int iter = Integer.parseInt(st.nextToken());

            for(int i=0; i<iter; i++){
                Info head = snake.peekFirst();
                int nr = head.r + dr[dir];
                int nc = head.c + dc[dir];

                time++;

                if(!isIn(nr, nc)){
                    isEnd = true;
                    break;
                }

                if(arr[nr][nc] != APPLE){
                    Info tail = snake.pollLast();
                    arr[tail.r][tail.c] = BLANK;
                }

                snake.addFirst(new Info(nr, nc));
                if(arr[nr][nc] == SNAKE){
                    isEnd = true;
                    break;
                }
                arr[nr][nc] = SNAKE;
            }

            if(isEnd) break;
        }

        sb.append(time);

        System.out.print(sb);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    static int getDir(String str){
        switch(str){
            case "R": return RIGHT;
            case "D": return DOWN;
            case "L": return LEFT;
            case "U": return UP;
            default: return -1;
        }
    }

    static class Info{
        int r, c;

        Info(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}