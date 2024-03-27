import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int N;
    static boolean[][] visited;
    static List<Integer> towns;
    static int sum;

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
                visited[r][c] = true;
                sum = 1;
                dfs(r, c);
                towns.add(sum);
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
            if(!isIn(nr, nc) || visited[nr][nc]) continue;
            visited[nr][nc] = true;
            sum += 1;
            dfs(nr, nc);
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}