import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N, M, T, K;
    static Queue<Info> marbles;
    static PriorityQueue<Info>[][] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        marbles = new ArrayDeque<>();
        arr = new PriorityQueue[N][N];
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                arr[r][c] = new PriorityQueue<>();
            }
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = getDir(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            marbles.add(new Info(m, r, c, d, v));
        }

        for(int t=0; t<T; t++){
            // 1. 남아있는 구슬 움직이기
            while(!marbles.isEmpty()){
                Info curr = marbles.poll();
                int r = curr.r;
                int c = curr.c;
                int d = curr.d;
                int v = curr.v;

                while(v > 0){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(!isIn(nr, nc)){
                        d = (d + 2) % 4;
                        continue;
                    }

                    r = nr;
                    c = nc;
                    v--;
                }

                curr.r = r;
                curr.c = c;
                curr.d = d;

                arr[r][c].add(curr);
            }

            // 2. 충돌된 구슬 판정
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    int k=K;
                    while(!arr[r][c].isEmpty() && k>0){
                        marbles.add(arr[r][c].poll());
                        k--;
                    }

                    while(!arr[r][c].isEmpty()) arr[r][c].poll();
                }
            }
        }

        sb.append(marbles.size());

        System.out.print(sb);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    static int getDir(String str){
        switch(str){
            case "R": return 0;
            case "D": return 1;
            case "L": return 2;
            case "U": return 3;
        }

        return -1;
    }

    static class Info implements Comparable<Info>{
        int idx, r, c, d, v;

        Info(int idx, int r, int c, int d, int v){
            this.idx = idx;
            this.r = r;
            this.c = c;
            this.d = d;
            this.v = v;
        }

        public int compareTo(Info i){
            if(this.v == i.v){
                return Integer.compare(i.idx, this.idx);
            }
            return Integer.compare(i.v, this.v);
        }
    }
}