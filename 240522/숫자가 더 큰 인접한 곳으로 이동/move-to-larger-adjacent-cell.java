import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int N;
    static int curr_r, curr_c;
    static int[][] arr;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        curr_r = Integer.parseInt(st.nextToken()) - 1;
        curr_c = Integer.parseInt(st.nextToken()) - 1;
        arr = new int[N][N];
        list = new ArrayList<>();

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        list.add(arr[curr_r][curr_c]);
        while(true){
            int next_r = curr_r;
            int next_c = curr_c;

            for(int d=0; d<dr.length; d++){
                int nr = curr_r + dr[d];
                int nc = curr_c + dc[d];

                if(isIn(nr, nc) && arr[nr][nc] > arr[curr_r][curr_c]){
                    next_r = nr;
                    next_c = nc;
                    break;
                }
            }

            if(next_r == curr_r && next_c == curr_c) break;

            list.add(arr[next_r][next_c]);
            curr_r = next_r;
            curr_c = next_c;
        }

        for(int num : list){
            sb.append(num).append(' ');
        }

        System.out.print(sb);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}