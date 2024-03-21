import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[][] arr;
    static int max;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        max = Integer.MIN_VALUE;

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        for(int sr1=0; sr1<N; sr1++){
            for(int sc1=0; sc1<M; sc1++){
                for(int er1=sr1; er1<N; er1++){
                    for(int ec1=sc1; ec1<M; ec1++){
                        for(int sr2=0; sr2<N; sr2++){
                            for(int sc2=0; sc2<M; sc2++){
                                for(int er2=sr2; er2<N; er2++){
                                    for(int ec2=sc2; ec2<M; ec2++){
                                        if(check(sr1, sc1, er1, ec1, sr2, sc2, er2, ec2)) continue;
                                        int sum1 = getAreaSum(sr1, sc1, er1, ec1);
                                        int sum2 = getAreaSum(sr2, sc2, er2, ec2);
                                        max = Math.max(max, sum1 + sum2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        sb.append(max);

        System.out.print(sb);
    }

    static boolean check(int sr1, int sc1, int er1, int ec1, int sr2, int sc2, int er2, int ec2){
        for(int r=sr1; r<=er1; r++){
            for(int c=sc1; c<=ec1; c++){
                if(r>=sr2 && r<=er2 && c>=sc2 && c<=ec2) return true;
            }
        }

        return false;
    }

    static int getAreaSum(int sr, int sc, int er, int ec){
        int sum = 0;
        for(int r=sr; r<=er; r++){
            for(int c=sc; c<=ec; c++){
                sum += arr[r][c];
            }
        }

        return sum;
    }
}