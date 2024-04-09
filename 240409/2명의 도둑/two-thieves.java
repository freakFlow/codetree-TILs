import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, C;
    static int[][] arr;
    static int subMax;
    static int max;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r1=0; r1<N; r1++){
            for(int c1=0; c1<=N-M; c1++){
                int value1 = cal(r1, c1);
                for(int r2=r1; r2<N; r2++){
                    for(int c2=0; c2<=N-M; c2++){
                        if(overlapped(r1, c1, r2, c2)) continue;
                        int value2 = cal(r2, c2);
                        max = Math.max(max, value1 + value2);
                    }
                }
            }
        }

        sb.append(max);

        System.out.print(sb);
    }

    static int cal(int r, int c){
        int[] temp;
        subMax = 0;

        for(int m=M; m>0; m--){
            temp = new int[m];
            combination(0, 0, temp, r, c);
        }

        return subMax;
    }

    static void combination(int idx, int start, int[] temp, int r, int c){
        if(idx == temp.length){
            int sum = 0;
            int value = 0;
            for(int i=0; i<temp.length; i++){
                int num = arr[r][c + temp[i]];
                sum += num;
                value += num * num;
            }

            if(sum <= C) subMax = Math.max(subMax, value);
            return;
        }

        for(int i=start; i<M; i++){
            temp[idx] = i;
            combination(idx + 1, i + 1, temp, r, c);
        }
    }

    static boolean overlapped(int r1, int c1, int r2, int c2){
        return r1 == r2 && c2 < c1 + M;
    }
}