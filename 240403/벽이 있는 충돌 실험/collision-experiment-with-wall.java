import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    static int T;
    static int N, M;
    static List<Marble> marble;
    static int[][] temp;
    static int x, y, d;

    public static void main(String[] args) throws IOException{
        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            marble = new ArrayList<>();
            temp = new int[N][N];
            
            // 초기 구슬 위치 설정
            for(int m=0; m<M; m++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken()) - 1;
                y = Integer.parseInt(st.nextToken()) - 1;
                d = toDir(st.nextToken());

                marble.add(new Marble(x, y, d));
            }

            // 구슬 이동: 2 * N번 이동 후에도 충돌이 없으면 끝
            int time = 0;
            while(time <= 2 * N){
                // 1. 구슬 이동
                for(int i=0; i<marble.size(); i++){
                    marble.get(i).move();
                }
                time++;

                // 2. 이동한 구슬 위치 저장
                for(Marble mb : marble){
                    temp[mb.r][mb.c]++;
                }

                // 3. 충돌된 구슬 삭제
                boolean init = false;
                for(int i=0; i<marble.size(); i++){
                    Marble mb = marble.get(i);
                    if(temp[mb.r][mb.c] > 1){
                        init = true;
                        marble.remove(i);
                        i--;
                    }
                }

                // 4. temp 및 time 초기화
                if(init) time = 0;

                for(int r=0; r<N; r++){
                    for(int c=0; c<N; c++){
                        temp[r][c] = 0;
                    }
                }
            }

            // 남은 구슬 기록
            sb.append(marble.size()).append('\n');
        }

        System.out.print(sb);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    static int toDir(String str){
        switch(str){
            case "R": return 0;
            case "D": return 1;
            case "L": return 2;
            case "U": return 3;
        }

        return 0;
    }

    static class Marble{
        int r, c, dir;

        Marble(int r, int c, int dir){
            this.r = r;
            this.c = c;
            this.dir = dir;
        }

        void move(){
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(isIn(nr, nc)){
                r = nr;
                c = nc;
            }else if(dir % 2 == 0){
                dir = 2 - dir;
            }else{
                dir = 4 - dir;
            }
        }
    }
}