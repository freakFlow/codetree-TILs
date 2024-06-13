import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int STONE = 1;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N, M, K;
    static List<Info> stones;
    static Info[] starts;
    static int count, ans;

    static int[] stoneIdx;
    static boolean[][] visited;
    static Queue<Info> q;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        stones = new ArrayList<>();
        starts = new Info[K];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                int num = Integer.parseInt(st.nextToken());
                if(num == STONE) stones.add(new Info(r, c));
            }
        }

        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            starts[k] = new Info(r, c);
        }

        stoneIdx = new int[stones.size() - M];
        q = new ArrayDeque<>();
        setStone(0, 0);

        sb.append(ans);

        System.out.print(sb);
    }

    static void setStone(int idx, int start){
        if(idx == stoneIdx.length){
            visited = new boolean[N][N];
            for(int i=0; i<idx; i++){
                Info stone = stones.get(stoneIdx[i]);
                visited[stone.r][stone.c] = true;
            }

            count = 0;
            for(int k=0; k<K; k++){
                Info point = starts[k];
                if(visited[point.r][point.c]) continue;
                
                visited[point.r][point.c] = true;
                q.add(point);
                count++;
                bfs();
            }

            ans = Math.max(ans, count);

            return;
        }

        for(int i=start; i<stones.size(); i++){
            stoneIdx[idx] = i;
            setStone(idx + 1, i + 1);
        }
    }

    static void bfs(){
        while(!q.isEmpty()){
            Info curr = q.poll();
            int r = curr.r;
            int c = curr.c;

            for(int d=0; d<dr.length; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(isIn(nr, nc) && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.add(new Info(nr, nc));
                    count++;
                }
            }
        }
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