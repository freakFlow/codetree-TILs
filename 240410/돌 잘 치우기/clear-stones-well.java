import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N, K, M;
    static List<Info> stones;
    static List<Info> sPoints;
    static int count;
    static int max;

    static int[] arr;

    static boolean[][] visited;
    static Queue<Info> q;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        stones = new ArrayList<>();
        sPoints = new ArrayList<>();
        q = new ArrayDeque<>();

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                if(st.nextToken().equals("1")) stones.add(new Info(r, c));
            }
        }

        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            sPoints.add(new Info(r, c));
        }

        arr = new int[stones.size() - M];
        combination(0, 0);

        sb.append(max);

        System.out.print(sb);
    }

    static void combination(int idx, int start){
        if(idx == arr.length){
            simulation();
            return;
        }

        for(int i=start; i<stones.size(); i++){
            arr[idx] = i;
            combination(idx + 1, i + 1);
        }
    }

    static void simulation(){
        visited = new boolean[N][N];

        for(int i=0; i<arr.length; i++){
            Info stone = stones.get(arr[i]);
            visited[stone.r][stone.c] = true;
        }

        count = 0;
        for(Info p : sPoints){
            if(visited[p.r][p.c]) continue;

            visited[p.r][p.c] = true;
            q.add(p);
            count++;

            bfs();
        }

        max = Math.max(max, count);
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