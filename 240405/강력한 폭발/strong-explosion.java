import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int[][] dr = {{-2, -1, 1, 2}, {0, 1, 0, -1}, {1, 1, -1, -1}};
    static final int[][] dc = {{0, 0, 0, 0}, {1, 0, -1, 0}, {1, -1, -1, 1}};

    static int N;
    static int bomb;
    static List<int[]> position;
    static int[] arr;
    static int[][] temp;
    static int max;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        position = new ArrayList<>();
        
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                if(st.nextToken().equals("1")){
                    bomb++;
                    position.add(new int[]{r, c});
                }
            }
        }

        arr = new int[bomb];
        setBomb(0);

        sb.append(max);

        System.out.print(sb);
    }

    static void setBomb(int idx){
        if(idx == bomb){
            boom();
            return;
        }

        for(int i=0; i<3; i++){
            arr[idx] = i;
            setBomb(idx + 1);
        }
    }

    static void boom(){
        temp = new int[N][N];

        for(int i=0; i<bomb; i++){
            int bombNum = arr[i];
            int[] bombPos = position.get(i);

            int r = bombPos[0];
            int c = bombPos[1];
            temp[r][c] = 1;

            for(int d=0; d<dr[bombNum].length; d++){
                int nr = r + dr[bombNum][d];
                int nc = c + dc[bombNum][d];
                if(isIn(nr, nc)) temp[nr][nc] = 1;
            }
        }

        int count = 0;
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(temp[r][c] == 1) count++;
            }
        }

        max = Math.max(max, count);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}