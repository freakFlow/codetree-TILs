import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    static int N, M, T, K;
    static List<Marble> marble;
    static List<Marble>[][] count;
    static int ans;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        marble = new ArrayList<>();
        count = new List[N][N];

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = toDir(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            marble.add(new Marble(r, c, d, v, m));
        }

        for(int t=0; t<T; t++){
            // 0. count 배열 초기화
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    count[r][c] = new ArrayList<>();
                }
            }

            // 1. 살아남은 구슬 움직이고 cnt에 저장
            for(int m=0; m<M; m++){
                Marble mb = marble.get(m);
                if(!mb.isSurvive) continue;

                mb.move();
                count[mb.r][mb.c].add(mb);
            }

            // 2. K개 이상의 구슬 우선순위에 따라 처리
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if(count[r][c].size() <= K) continue;

                    Collections.sort(count[r][c]);

                    for(int i=0; i<count[r][c].size(); i++){
                        if(i >= K) count[r][c].get(i).isSurvive = false;
                    }
                }
            }
        }

        for(int m=0; m<M; m++){
            if(marble.get(m).isSurvive) ans++;
        }

        sb.append(ans);

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

    static class Marble implements Comparable<Marble>{
        int r, c, d, v;
        int index;
        boolean isSurvive;

        Marble(int r, int c, int d, int v, int index){
            this.r = r;
            this.c = c;
            this.d = d;
            this.v = v;
            this.index = index;
            this.isSurvive = true;
        }

        void move(){
            for(int i=0; i<v; i++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(!isIn(nr, nc)){
                    d = changeDir();
                    i--;
                    continue;
                }

                r = nr;
                c = nc;
            }
        }

        int changeDir(){
            if(d % 2 == 0) return 2 - d;
            else return 4 - d;
        }

        public int compareTo(Marble m){
            if(this.v == m.v){
                return Integer.compare(m.index, this.index);
            }
            return Integer.compare(m.v, this.v);
        }
    }
}