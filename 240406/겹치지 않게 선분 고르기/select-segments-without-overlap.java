import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Line[] line;
    static int[] arr;
    static int maxLine;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        line = new Line[N];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            line[n] = new Line(x1, x2);
        }

        for(int n=1; n<=N; n++){
            arr = new int[n];
            int before = maxLine;
            combination(0, 0);

            if(before == maxLine) break;
        }

        sb.append(maxLine);

        System.out.print(sb);
    }

    static boolean overlap(int i, int j){
        int a = line[i].x1, b = line[i].x2;
        int c = line[j].x1, d = line[j].x2;

        return (a<=c && c<=b) || (a<=d && d<=b) || (c<=a && a<=d) || (c<=b && b<=d);
    }

    static void check(){
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(overlap(arr[i], arr[j])) return;
            }
        }

        maxLine = arr.length;
    }

    static void combination(int idx, int start){
        if(idx == arr.length){
            check();
            return;
        }

        for(int i=start; i<N; i++){
            arr[idx] = i;
            combination(idx + 1, i + 1);
        }
    }

    static class Line{
        int x1, x2;

        Line(int x1, int x2){
            this.x1 = x1;
            this.x2 = x2;
        }
    }
}