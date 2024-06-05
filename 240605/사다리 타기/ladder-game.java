import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int H = 15;

    static int N, M;
    static int[][] sadari;
    static Info[] lines;
    static int[] result;
    static int ans;

    static int[] selectedLine;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sadari = new int[H + 1][N + 1];
        lines = new Info[M];
        ans = M;

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lines[m] = new Info(a, b);
            lines[m].make();
        }

        result = simulate();       

        for(int m=0; m<M; m++){
            selectedLine = new int[m];

            combination(0, 0);

            if(ans < M) break;
        }

        sb.append(ans);

        System.out.print(sb);
    }

    static void combination(int idx, int start){
        if(idx == selectedLine.length){
            sadari = new int[H+1][N+1];
            for(int i=0; i<selectedLine.length; i++){
                lines[selectedLine[i]].make();
            }

            int[] temp = simulate();

            for(int n=1; n<=N; n++){
                if(temp[n] != result[n]) return;
            }

            ans = selectedLine.length;
            return;
        }

        for(int i=start; i<M; i++){
            selectedLine[idx] = i;
            combination(idx+1, i+1);
        }
    }

    static int[] simulate(){
        int[] temp = new int[N+1];

        for(int c=1; c<=N; c++){
            int start = c;

            for(int r=0; r<=H; r++){
                if(sadari[r][start] == 0) continue;

                start = sadari[r][start];
            }

            temp[c] = start;
        }

        return temp;
    }

    static class Info{
        int a, b;

        Info(int a, int b){
            this.a = a;
            this.b = b;
        }

        void make(){
            sadari[b][a] = a + 1;
            sadari[b][a+1] = a;
        }
    }
}