import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Info[] coins = new Info[10];
    static boolean[] existCoinNum = new boolean[10];
    static Info start, end;
    static int[] coinIdx = new int[3];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        for(int r=0; r<N; r++){
            String str = br.readLine();
            for(int c=0; c<N; c++){
                char ch = str.charAt(c);
                if(ch == '.') continue;

                if(ch == 'S') start = new Info(r, c);
                else if(ch == 'E') end = new Info(r, c);
                else{
                    int num = ch - '0';
                    coins[num] = new Info(r, c);
                    existCoinNum[num] = true;
                }
            }
        }

        if(!isPossible()){
            min = -1;
        }else{
            combination(0, 1);
        }

        sb.append(min);

        System.out.print(sb);
    }

    static void combination(int idx, int base){
        if(idx == coinIdx.length){
            int moveNum = move();
            min = Math.min(min, moveNum);

            return;
        }

        for(int i=base; i<coins.length; i++){
            if(!existCoinNum[i]) continue;
            coinIdx[idx] = i;
            combination(idx + 1, i + 1);
        }
    }

    static int move(){
        int result = 0;
        Info current = start;

        for(int i=0; i<coinIdx.length; i++){
            result += getDistance(current, coins[coinIdx[i]]);
            current = coins[coinIdx[i]];
        }

        result += getDistance(current, end);

        return result;
    }

    static int getDistance(Info i1, Info i2){
        return Math.abs(i1.r - i2.r) + Math.abs(i1.c - i2.c);
    }

    static boolean isPossible(){
        int count = 0;
        for(int i=1; i<existCoinNum.length; i++){
            if(existCoinNum[i]) count++;
        }

        return count >= 3;
    }

    static class Info{
        int r, c;

        Info(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}