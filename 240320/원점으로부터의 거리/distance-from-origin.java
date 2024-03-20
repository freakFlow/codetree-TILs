import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Point[] point;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        point = new Point[N];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            point[n] = new Point(n + 1, x, y);
        }

        Arrays.sort(point);

        for(Point p : point){
            sb.append(p.num).append('\n');
        }

        System.out.print(sb);
    }

    static class Point implements Comparable<Point>{
        int num;
        int x, y;

        Point(int num, int x, int y){
            this.num = num;
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point p){
            int d1 = Math.abs(this.x - 0) + Math.abs(this.y - 0);
            int d2 = Math.abs(p.x - 0) + Math.abs(p.y - 0);
            if(d1 == d2) return Integer.compare(this.num, p.num);
            return Integer.compare(d1, d2);
        }
    }
}