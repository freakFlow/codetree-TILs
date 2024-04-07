import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int MAX = 15;

    static int N, M;
    static boolean[][] ladder;
    static Line[] lines;
    static int[] initState;
    static int[] temp;
    static int[] lineNum;
    static int minLine;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ladder = new boolean[MAX][N];
        lines = new Line[M];
        initState = new int[N];
        temp = new int[N];
        lineNum = new int[M];
        minLine = M;

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            lines[m] = new Line(a, b);
        }

        // 초기 상태 사다리 타기
        for(int m=0; m<M; m++){
            lineNum[m] = m;
        }
        setLines();
        simulate(initState);

        // 모든 경우의 수 탐색
        for(int m=0; m<M-1; m++){
            lineNum = new int[m];
            combination(0, 0);

            if(minLine < M) break;
        }

        sb.append(minLine);

        System.out.print(sb);
    }

    static void combination(int idx, int start){
        if(idx == lineNum.length){
            setLines();
            simulate(temp);

            for(int n=0; n<N; n++){
                if(temp[n] != initState[n]) return;
            }

            minLine = lineNum.length;
            return;
        }

        for(int i=start; i<M; i++){
            lineNum[idx] = i;
            combination(idx+1, i+1);
        }
    }

    static void simulate(int[] arr){
        for(int startCol=0; startCol<N; startCol++){
            int currentCol = startCol;
            for(int r=0; r<MAX; r++){
                if(!ladder[r][currentCol]) continue;

                int left = 0;
                for(int c=currentCol-1; c>=0; c--){
                    if(ladder[r][c]) left++;
                    else break;
                }

                if(left % 2 == 1) currentCol--;
                else currentCol++;
            }

            arr[startCol] = currentCol;
        }
    }

    static void setLines(){
        for(int r=0; r<MAX; r++){
            for(int c=0; c<N; c++){
                ladder[r][c] = false;
            }
        }

        for(int i=0; i<lineNum.length; i++){
            Line line = lines[lineNum[i]];

            ladder[line.r][line.c1] = true;
            ladder[line.r][line.c2] = true;
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<MAX && c>=0 && c<N;
    }

    static class Line{
        int c1, c2;
        int r;

        Line(int a, int b){
            c1 = a;
            c2 = a + 1;
            r = b;
        }
    }
}