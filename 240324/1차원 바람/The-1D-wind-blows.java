import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, Q;
    static int[][] arr;
    static int flag;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        for(int q=0; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            String d = st.nextToken();
            if(r % 2 == 0){
                if(d.equals("L")) flag = 0;
                else flag = 1;
            }else{
                if(d.equals("L")) flag = 1;
                else flag = 0;
            }
            if(d.equals("L")) leftWind(r);
            else rightWind(r);

            int upRow = r - 1;
            int baseRow = r;
            while(upRow >= 0 && checkShift(baseRow, upRow)){
                if(flag == 0){
                    if(upRow % 2 == 0) leftWind(upRow);
                    else rightWind(upRow);
                }else{
                    if(upRow % 2 == 0) rightWind(upRow);
                    else leftWind(upRow);
                }
                upRow--;
                baseRow--;
            }

            int downRow = r + 1;
            baseRow = r;
            while(downRow < N && checkShift(baseRow, downRow)){
                if(flag == 0){
                    if(downRow % 2 == 0) leftWind(downRow);
                    else rightWind(downRow);
                }else{
                    if(downRow % 2 == 0) rightWind(downRow);
                    else leftWind(downRow);
                }
                downRow++;
                baseRow++;
            }
        }

        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){
                sb.append(arr[n][m]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static boolean checkShift(int r1, int r2){
        for(int c=0; c<M; c++){
            if(arr[r1][c] == arr[r2][c]) return true;
        }
        return false;
    }

    static void leftWind(int row){
        int temp = arr[row][M - 1];
        for(int c=M-1; c>0; c--){
            arr[row][c] = arr[row][c-1];
        }
        arr[row][0] = temp;
    }

    static void rightWind(int row){
        int temp = arr[row][0];
        for(int c=0; c<M-1; c++){
            arr[row][c] = arr[row][c + 1];
        }
        arr[row][M-1] = temp;
    }
}