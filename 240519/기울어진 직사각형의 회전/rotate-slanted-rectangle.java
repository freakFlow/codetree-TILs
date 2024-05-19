import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] dr = {-1, -1, 1, 1};
    static int[] dc = {1, -1, -1, 1};

    static int N;
    static int[][] arr;
    static int sr, sc, dir;
    static int size;
    static int[] weight;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        weight = new int[4];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken())-1;
        sc = Integer.parseInt(st.nextToken())-1;
        for(int i=0; i<weight.length; i++){
            weight[i] = Integer.parseInt(st.nextToken());
            size += weight[i];
        }
        dir = Integer.parseInt(st.nextToken());

        rotate();

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                sb.append(arr[r][c]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void rotate(){
        int[] temp = new int[size];
        int r = sr;
        int c = sc;
        int tIdx = 0;

        for(int w=0; w<weight.length; w++){
            for(int i=0; i<weight[w]; i++){
                r += dr[w];
                c += dc[w];
                temp[tIdx++] = arr[r][c];
            }
        }

        if(dir == 0){
            int num = temp[size-1];
            for(int i=size-1; i>0; i--){
                temp[i] = temp[i - 1];
            }
            temp[0] = num;
        }else{
            int num = temp[0];
            for(int i=0; i<size-1; i++){
                temp[i] = temp[i + 1];
            }
            temp[size-1] = num;
        }

        r = sr;
        c = sc;
        tIdx = 0;

        for(int w=0; w<weight.length; w++){
            for(int i=0; i<weight[w]; i++){
                r += dr[w];
                c += dc[w];
                arr[r][c] = temp[tIdx++];
            }
        }
    }
}