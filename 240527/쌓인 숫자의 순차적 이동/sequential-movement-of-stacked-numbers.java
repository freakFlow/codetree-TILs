import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};

    static int N, M;
    static Info[] position;
    static Stack<Integer>[][] arr;
    static int[][] maxArr;
    static Stack<Integer> temp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        position = new Info[N * N + 1];
        arr = new Stack[N][N];
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                arr[r][c] = new Stack<>();
            }
        }
        maxArr = new int[N][N];
        temp = new Stack<>();

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                int num = Integer.parseInt(st.nextToken());
                arr[r][c].push(num);
                maxArr[r][c] = num;
                position[num] = new Info(r, c);
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int m=0; m<M; m++){
            int num = Integer.parseInt(st.nextToken());
            int r = position[num].r;
            int c = position[num].c;

            int max=0, mr=0, mc=0;
            for(int d=0; d<dr.length; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(isIn(nr, nc) && maxArr[nr][nc] > max){
                    max = maxArr[nr][nc];
                    mr = nr;
                    mc = nc;
                }
            }

            if(max == 0) continue;

            while(true){
                int top = arr[r][c].pop();
                temp.push(top);
                if(top == num) break;
            }

            while(!temp.isEmpty()){
                int top = temp.pop();
                arr[mr][mc].push(top);
                position[top] = new Info(mr, mc);
                maxArr[mr][mc] = Math.max(maxArr[mr][mc], top);
            }

            maxArr[r][c] = 0;
            while(!arr[r][c].isEmpty()){
                int top = arr[r][c].pop();
                temp.push(top);
                maxArr[r][c] = Math.max(maxArr[r][c], top);
            }

            while(!temp.isEmpty()){
                arr[r][c].push(temp.pop());
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(arr[r][c].isEmpty()){
                    sb.append("None\n");
                    continue;
                }

                while(!arr[r][c].isEmpty()){
                    sb.append(arr[r][c].pop()).append(' ');
                }
                sb.append('\n');
            }
        }

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