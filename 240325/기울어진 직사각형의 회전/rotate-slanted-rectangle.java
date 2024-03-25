import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {-1, -1, 1, 1};
    static int[] dc = {1, -1, -1, 1};
    static int N;
    static int r, c, dir;
    static int[] mx;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        mx = new int[4];
        arr = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        for(int i=0; i<mx.length; i++){
            mx[i] = Integer.parseInt(st.nextToken());
        }
        dir = Integer.parseInt(st.nextToken());

        int size = mx[0] * 2 + mx[1] * 2;
        int[] temp = new int[size];
        int tr = r;
        int tc = c;
        int d = 0;
        int idx = 0;
        temp[idx++] = arr[tr][tc];

        for(int i=0; i<mx.length; i++){
            for(int m=0; m<mx[i]; m++){
                if(idx == size) break;
                tr += dr[d];
                tc += dc[d];
                temp[idx++] = arr[tr][tc];
            }
            d = (d + 1) % 4;
        }

        if(dir == 1){
            int start = temp[0];
            for(int i=0; i<size-1; i++){
                temp[i] = temp[i + 1];
            }
            temp[size-1] = start;
        }else{
            int end = temp[size-1];
            for(int i=size-1; i>0; i--){
                temp[i] = temp[i - 1];
            }
            temp[0] = end;
        }

        tr = r;
        tc = c;
        d = 0;
        idx = 0;
        arr[tr][tc] = temp[idx++];

        for(int i=0; i<mx.length; i++){
            for(int m=0; m<mx[i]; m++){
                if(idx == size) break;
                tr += dr[d];
                tc += dc[d];
                arr[tr][tc] = temp[idx++];
            }
            d = (d + 1) % 4;
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                sb.append(arr[r][c]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}