import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static Point[] points;
    static int[] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        points = new Point[N];
        arr = new int[2];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[n] = new Point(x, y);
        }

        combination(0, 0);

        sb.append(min);

        System.out.print(sb);
    }

    static void combination(int idx, int start){
        if(idx == arr.length){
            min = Math.min(min, getDistance());
            return;
        }

        for(int i=start; i<N; i++){
            arr[idx] = i;
            combination(idx + 1, i + 1);
        }
    }

    static int getDistance(){
        int diffx = points[arr[0]].x - points[arr[1]].x;
        int diffy = points[arr[0]].y - points[arr[1]].y;
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