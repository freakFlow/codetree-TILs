import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int UP=0, FRONT=1, RIGHT=2;
    
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N, M, dice_r, dice_c;
    static int[] dice;
    static int[][] arr;
    static int ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dice_r = Integer.parseInt(st.nextToken()) - 1;
        dice_c = Integer.parseInt(st.nextToken()) - 1;
        dice = new int[3];
        arr = new int[N][N];

        // 시작 상태 설정
        for(int i=0; i<dice.length; i++){
            dice[i] = i + 1;
        }
        arr[dice_r][dice_c] = 6;

        st = new StringTokenizer(br.readLine());
        for(int m=0; m<M; m++){
            String dir = st.nextToken();
            
            // 1. 주사위 움직이기
            int nd = getDir(dir);
            int nr = dice_r + dr[nd];
            int nc = dice_c + dc[nd];

            if(!isIn(nr, nc)) continue;

            dice_r = nr;
            dice_c = nc;

            // 2. 주사위 방향 바꾸기
            changeDir(dir);

            // 3. 숫자 적기
            arr[dice_r][dice_c] = otherSide(UP);
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                ans += arr[r][c];
            }
        }

        sb.append(ans);

        System.out.print(sb);
    }

    static void changeDir(String dir){
        int temp;
        switch(dir){
            case "L":
                temp = otherSide(UP);
                dice[UP] = dice[RIGHT];
                dice[RIGHT] = temp;
                break;
            case "D":
                temp = otherSide(FRONT);
                dice[FRONT] = dice[UP];
                dice[UP] = temp;
                break;
            case "R":
                temp = otherSide(RIGHT);
                dice[RIGHT] = dice[UP];
                dice[UP] = temp;
                break;
            case "U":
                temp = otherSide(UP);
                dice[UP] = dice[FRONT];
                dice[FRONT] = temp;
        }
    }

    static int getDir(String dir){
        switch(dir){
            case "L": return 2;
            case "D": return 1;
            case "R": return 0;
            case "U": return 3;
            default: return 0;
        }
    }

    static int otherSide(int num){
        return 7 - dice[num];
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}