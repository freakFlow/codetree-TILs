import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    static int N;
    static boolean[][] visited;
    static int count;
    static List<Integer> towns;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        towns = new ArrayList<>();

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                if(st.nextToken().equals("0")) visited[r][c] = true;
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(visited[r][c]) continue;

                count = 1;
                visited[r][c] = true;
                dfs(r, c);
                towns.add(count);
            }
        }


        Collections.sort(towns);
        sb.append(towns.size()).append('\n');
        for(int t : towns){
            sb.append(t).append('\n');
        }

        System.out.print(sb);
    }

    static void dfs(int r, int c){
        for(int d=0; d<dr.length; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(isIn(nr, nc) && !visited[nr][nc]){
                count++;
                visited[nr][nc] = true;
                dfs(nr, nc);
            }
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}