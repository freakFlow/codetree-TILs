import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, C;
    static int[][] arr;
    static int r1, c1, r2, c2;
    static int ans;

    public static void main(String[] args) throws IOException {
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

        for(r1=0; r1<N; r1++){
            for(c1=0; c1<N-M; c1++){
                for(r2=r1; r2<N; r2++){
                    for(c2=0; c2<N-M; c2++){
                        if(isOverlapped()) continue;

                        ans = Math.max(ans, getValue(r1, c1) + getValue(r2, c2));
                    }
                }
            }
        }

        sb.append(ans);

        System.out.print(sb);
    }


    static int[] temp;
    static int value;
    static int getValue(int r, int c){
        value = 0;

        for(int i=M; i>0; i--){
            temp = new int[i];
            combination(0, 0, r, c);
            if(value > 0) break;
        }

        return value;
    }

    static void combination(int idx, int start, int r, int c){
        if(idx == temp.length){
            int sum = 0;
            int v = 0;
            for(int i=0; i<temp.length; i++){
                int num = arr[r][c+temp[i]];
                sum += num;
                v += num * num;
            }

            if(sum <= C) value = Math.max(value, v);
            return;
        }

        for(int i=start; i<M; i++){
            temp[idx] = i;
            combination(idx+1, i+1, r, c);
        }
    }

    static boolean isOverlapped(){
        return r1 == r2 && c1 + M > c2;
    }
}