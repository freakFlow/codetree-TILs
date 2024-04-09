import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static Point[] points;
    static int[] arrOfM;
    static int[] arrOf2;
    static int min = Integer.MAX_VALUE;
    static int max;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        points = new Point[N];
        arrOfM = new int[M];
        arrOf2 = new int[2];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[n] = new Point(x, y);
        }

        combinationOfM(0, 0);

        sb.append(min);

        System.out.print(sb);
    }

    static void combinationOfM(int idx, int start){
        if(idx == arrOfM.length){
            max = 0;
            combinationOf2(0, 0);
            min = Math.min(min, max);
            return;
        }

        for(int i=start; i<N; i++){
            arrOfM[idx] = i;
            combinationOfM(idx + 1, i + 1);
        }
    }

    static void combinationOf2(int idx, int start){
        if(idx == arrOf2.length){
            max = Math.max(max, getDistance());
            return;
        }

        for(int i=start; i<M; i++){
            arrOf2[idx] = i;
            combinationOf2(idx + 1, i + 1);
        }
    }

    static int getDistance(){
        int diffx = points[arrOfM[arrOf2[0]]].x - points[arrOfM[arrOf2[1]]].x;
        int diffy = points[arrOfM[arrOf2[0]]].y - points[arrOfM[arrOf2[1]]].y;
        return diffx * diffx + diffy * diffy;
    }

    static class Point{
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}