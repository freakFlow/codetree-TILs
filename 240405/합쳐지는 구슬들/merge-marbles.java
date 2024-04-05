import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    static int N, M, T;
    static Marble[] marble;
    static List<Integer>[][] arr;
    static int count, max;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        marble = new Marble[M];
        arr = new List[N][N];
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                arr[r][c] = new ArrayList<>();
            }
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = toDir(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            marble[m] = new Marble(r, c, d, w);
        }

        for(int t=0; t<T; t++){
            // 1. 활성화된 구슬 이동 및 위치 기록
            for(int m=0; m<M; m++){
                Marble mb = marble[m];
                if(!mb.activate) continue;

                mb.move();
                arr[mb.r][mb.c].add(m);
            }

            // 2. 중복된 구슬 처리
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    List<Integer> list = arr[r][c];

                    if(list.size() > 1){
                        int sum = 0;
                        for(int i=0; i<list.size() - 1; i++){
                            int idx = list.get(i);
                            sum += marble[idx].w;
                            marble[idx].activate = false;
                        }

                        int lastIdx = list.get(list.size() - 1);
                        marble[lastIdx].w += sum;
                    }

                    list.clear();
                }
            }
        }

        for(int m=0; m<M; m++){
            if(!marble[m].activate) continue;

            count++;
            max = Math.max(max, marble[m].w);
        }

        sb.append(count).append(' ').append(max);

        System.out.print(sb);
    }

    static int toDir(String str){
        switch(str){
            case "R": return 0;
            case "D": return 1;
            case "L": return 2;
            case "U": return 3;
        }

        return -1;
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    static class Marble{
        int r, c, d, w;
        boolean activate;

        Marble(int r, int c, int d, int w){
            this.r = r;
            this.c = c;
            this.d = d;
            this.w = w;
            this.activate = true;
        }

        void move(){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(isIn(nr, nc)){
                r = nr;
                c = nc;
            }else if(d % 2 == 0){
                d = 2 - d;
            }else{
                d = 4 - d;
            }
        }
    }
}