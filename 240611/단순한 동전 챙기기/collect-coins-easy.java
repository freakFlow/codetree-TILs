import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static Info S, E;
    static Info[] coins;
    static boolean[] isExisted;
    static int ans;

    static int[] coinIdx;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        coins = new Info[9];
        isExisted = new boolean[9];
        ans = Integer.MAX_VALUE;
        coinIdx = new int[3];

        for(int r=0; r<N; r++){
            String row = br.readLine();
            for(int c=0; c<N; c++){
                switch(row.charAt(c)){
                    case 'S':
                        S = new Info(r, c); break;
                    case 'E':
                        E = new Info(r, c); break;
                    case '.':
                        break;
                    default:
                        coins[row.charAt(c) - '1'] = new Info(r, c);
                        isExisted[row.charAt(c) - '1'] = true;
                }
            }
        }

        setMyCoin(0, 0);

        sb.append(ans == Integer.MAX_VALUE ? -1 : ans);

        System.out.print(sb);
    }

    static void setMyCoin(int idx, int start){
        if(idx == coinIdx.length){
            Info current = S;
            int distance = 0;
            for(int i=0; i<idx; i++){
                distance += getDistance(current, coins[coinIdx[i]]);
                current = coins[coinIdx[i]];
            }
            distance += getDistance(current, E);
            ans = Math.min(ans, distance);
            return;
        }

        for(int i=start; i<coins.length; i++){
            if(isExisted[i]){
                coinIdx[idx] = i;
                setMyCoin(idx + 1, i + 1);
            }
        }
    }

    static int getDistance(Info from, Info to){
        return Math.abs(to.r - from.r) + Math.abs(to.c - from.c);
    }

    static class Info{
        int r, c;

        Info(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}