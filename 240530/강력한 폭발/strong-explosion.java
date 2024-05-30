import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[][] dr = {{-2, -1, 1, 2}, {0, 1, 0, -1}, {1, 1, -1, -1}};
    static int[][] dc = {{0, 0, 0, 0}, {1, 0, -1, 0}, {1, -1, -1, 1}};

    static int N;
    static List<Info> list;
    static int bombSize;
    static int[] bombNum;
    static boolean[][] arr;
    static int ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                if(st.nextToken().equals("1")){
                    list.add(new Info(r, c));
                }
            }
        }

        bombSize = list.size();
        bombNum = new int[bombSize];

        simulate(0);

        sb.append(ans);

        System.out.print(sb);
    }

    static void simulate(int idx){
        if(idx == bombSize){
            check();
            return;
        }

        for(int i=0; i<dr.length; i++){
            bombNum[idx] = i;
            simulate(idx + 1);
        }
    }

    static void check(){
        arr = new boolean[N][N];
        int count = 0;

        for(int i=0; i<bombSize; i++){
            Info bomb = list.get(i);
            int r = bomb.r;
            int c = bomb.c;
            int bn = bombNum[i];

            if(!arr[r][c]){
                arr[r][c] = true;
                count++;
            }
            for(int d=0; d<dr[bn].length; d++){
                int nr = r + dr[bn][d];
                int nc = c + dc[bn][d];

                if(isIn(nr, nc) && !arr[nr][nc]) {
                    arr[nr][nc] = true;
                    count++;
                }
            }
        }

        ans = Math.max(ans, count);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    static class Info{
        int r, c;

        Info(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}