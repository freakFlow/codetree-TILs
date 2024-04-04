import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int[] dr = {0, 1, 0, -1, 1, 1, -1, -1};
    static final int[] dc = {1, 0, -1, 0, 1, -1, 1, -1};

    static int N, M;
    static ArrayDeque<Integer>[][] arr;
    static int[][] max;
    static Pos[] position;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayDeque[N][N];
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                arr[r][c] = new ArrayDeque<>();
            }
        }
        max = new int[N][N];
        position = new Pos[N * N + 1];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                int num = Integer.parseInt(st.nextToken());
                arr[r][c].push(num);
                max[r][c] = num;
                position[num] = new Pos(r, c);
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int m=0; m<M; m++){
            int num = Integer.parseInt(st.nextToken());

            // 1. 현재 num이 있는 위치 찾기
            int r = position[num].r;
            int c = position[num].c;

            // 2. num이 이동할 위치 찾기
            int maxR, maxC, maxValue;
            maxR = maxC = maxValue = 0;
            for(int d=0; d<dr.length; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(isIn(nr, nc) && max[nr][nc] > maxValue){
                    maxValue = max[nr][nc];
                    maxR = nr;
                    maxC = nc;
                }
            }

            // 만약 인접 방향이 모두 비어있는 경우 다음 num 진행
            if(maxValue == 0) continue;

            // 3. num가 그 위에 있는 숫자 움직이며 위치 갱신
            move(r, c, maxR, maxC, num);

            // 4. 이전 위치와 움직인 위치의 max 값 갱신
            updateMax(r, c);
            updateMax(maxR, maxC); 
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(arr[r][c].size() == 0) sb.append("None");
                else{
                    while(!arr[r][c].isEmpty()){
                        sb.append(arr[r][c].pop()).append(' ');
                    }
                }
                sb.append('\n');
            }
        }

        System.out.print(sb);
    }

    static void updateMax(int r, int c){
        ArrayDeque<Integer> temp = new ArrayDeque<>();
        int maxValue = 0;

        while(!arr[r][c].isEmpty()){
            int num = arr[r][c].pop();
            if(num > maxValue) maxValue = num;
            temp.push(num);
        }

        max[r][c] = maxValue;

        while(!temp.isEmpty()){
            arr[r][c].push(temp.pop());
        }
    }

    static void move(int r, int c, int toR, int toC, int target){
        ArrayDeque<Integer> temp = new ArrayDeque<>();

        while(!arr[r][c].isEmpty()){
            int num = arr[r][c].pop();
            temp.push(num);
            position[num] = new Pos(toR, toC);
            if(num == target) break;
        }

        while(!temp.isEmpty()){
            arr[toR][toC].push(temp.pop());
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    static class Pos{
        int r, c;

        Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}