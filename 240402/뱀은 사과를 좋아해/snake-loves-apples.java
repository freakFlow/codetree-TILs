import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};
    static final int R = 0, D = 1, L = 2, U = 3;
    static final int BLANK = 0, APPLE = 1, SNAKE = 2;

    static int N, M, K;
    static List<int[]> snake;
    static int[][] arr;
    static int time;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        snake = new ArrayList<>();
        arr = new int[N][N];

        // 사과 위치 설정
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            arr[x][y] = APPLE;
        }

        // 초기 위치 설정
        snake.add(new int[]{0, 0});
        arr[0][0] = SNAKE;
        
        boolean isEnd = false;
        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int dir = toDir(st.nextToken());
            int iter = Integer.parseInt(st.nextToken());

            for(int i=0; i<iter; i++){
                boolean eatApple = false;

                // 1. 이동할 위치 체크
                int[] head = snake.get(0);
                int nr = head[0] + dr[dir];
                int nc = head[1] + dc[dir];

                // 이동하려는 위치가 격자를 벗어난 경우 종료
                if(!isIn(nr, nc)) isEnd = true;
                else{
                    // 이동하려는 위치에 사과가 있는지 체크
                    if(arr[nr][nc] == APPLE) eatApple = true;

                    // 2. 꼬리 이동
                    if(!eatApple){
                        int tailIdx = snake.size() - 1;
                        int[] tail = snake.get(tailIdx);
                        
                        arr[tail[0]][tail[1]] = BLANK;
                        snake.remove(tailIdx);
                    }

                    // 3. 머리 이동
                    snake.add(0, new int[]{nr, nc});
                    // 몸이 꼬인 경우 종료
                    if(arr[nr][nc] == SNAKE) isEnd = true;
                    arr[nr][nc] = SNAKE;
                }
                time++;
                if(isEnd) break;
            }
            if(isEnd) break;
        }

        sb.append(time);

        System.out.print(sb);
    }

    static int toDir(String str){
        switch(str){
            case "L": return L;
            case "R": return R;
            case "U": return U;
            case "D": return D;
        }

        return 0;
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}