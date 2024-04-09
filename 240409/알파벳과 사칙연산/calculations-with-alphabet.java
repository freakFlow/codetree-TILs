import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static String str;
    static int N;
    static int max = Integer.MIN_VALUE;
    static int[] num = new int[6];

    public static void main(String[] args) throws IOException{
        str = br.readLine();
        N = str.length();

        permutation(0);

        sb.append(max);

        System.out.print(sb);
    }

    static void permutation(int idx){
        if(idx == num.length){
            int result = cal();
            max = Math.max(max, result);
            return;
        }

        for(int i=1; i<=4; i++){
            num[idx] = i;
            permutation(idx + 1);
        }
    }

    static int cal(){
        int res = toNum(str.charAt(0));

        for(int n=1; n<N; n+=2){
            char oper = str.charAt(n);
            int num = toNum(str.charAt(n + 1));

            switch(oper){
                case '+':
                    res += num; break;
                case '-':
                    res -= num; break;
                case '*':
                    res *= num; break;
            }
        }

        return res;
    }

    static int toNum(char ch){
        return num[ch - 'a'];
    }
}