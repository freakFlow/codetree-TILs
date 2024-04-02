import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};
    static final int R = 0, D = 1, L = 2, U = 3;
    static final int UP = 0, FRONT = 1, RIGHT = 2;

    static int N, M;
    static int r, c;
    static int[][] arr;
    static int[] dice;
    static int sum;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        arr = new int[N][N];
        dice = new int[3];

        // 주사위 초기값 설정
        for(int i=0; i<dice.length; i++){
            dice[i] = i+1;
        }

        // 시작 위치 설정
        arr[r][c] = 6;

        st = new StringTokenizer(br.readLine());
        for(int m=0; m<M; m++){
            int dir = toDir(st.nextToken());

            // dir 방향대로 r, c 이동
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if(!isIn(nr, nc)) continue;

            r = nr;
            c = nc;

            // 주사위 굴리기
            int temp = 0;
            switch(dir){
                case L:
                    temp = reverse(dice[UP]);
                    dice[UP] = dice[RIGHT];
                    dice[RIGHT] = temp;
                    break;
                case R:
                    temp = reverse(dice[RIGHT]);
                    dice[RIGHT] = dice[UP];
                    dice[UP] = temp;
                    break;
                case U:
                    temp = reverse(dice[UP]);
                    dice[UP] = dice[FRONT];
                    dice[FRONT] = temp;
                    break;
                case D:
                    temp = reverse(dice[FRONT]);
                    dice[FRONT] = dice[UP];
                    dice[UP] = temp;
                    break;
            }

            // 최종 위치에 아랫쪽 값 적기
            arr[r][c] = reverse(dice[UP]);
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                sum += arr[r][c];
            }
        }

        sb.append(sum);

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

    static int reverse(int num){
        return 7 - num;
    }
}