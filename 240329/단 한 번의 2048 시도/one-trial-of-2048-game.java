import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int size = 4;
    static int[][] arr;
    static String dir;

    public static void main(String[] args) throws IOException{
        arr = new int[size][size];

        for(int r=0; r<size; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<size; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        dir = br.readLine();

        switch(dir){
            case "L":
                caseL(); break;
            case "R":
                caseR(); break;
            case "U":
                caseU(); break;
            case "D":
                caseD(); break;
        }

        for(int r=0; r<size; r++){
            for(int c=0; c<size; c++){
                sb.append(arr[r][c]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void caseL(){
        for(int r=0; r<size; r++){
            int[] temp = new int[4];
            int idx = 0;
            for(int c=0; c<size; c++){
                if(arr[r][c] == 0) continue;
                temp[idx++] = arr[r][c];
            }
            for(int c=0; c<size; c++){
                arr[r][c] = temp[c];
            }

            for(int c=0; c<size-1; c++){
                if(arr[r][c] == arr[r][c+1]){
                    arr[r][c] *= 2;
                    arr[r][c+1] = 0;
                }
            }

            temp = new int[4];
            idx = 0;
            for(int c=0; c<size; c++){
                if(arr[r][c] == 0) continue;
                temp[idx++] = arr[r][c];
            }
            for(int c=0; c<size; c++){
                arr[r][c] = temp[c];
            }
        }
    }

    static void caseR(){
        for(int r=0; r<size; r++){
            int[] temp = new int[4];
            int idx = size-1;
            for(int c=size-1; c>=0; c--){
                if(arr[r][c] == 0) continue;
                temp[idx--] = arr[r][c];
            }
            for(int c=size-1; c>=0; c--){
                arr[r][c] = temp[c];
            }

            for(int c=size-1; c>0; c--){
                if(arr[r][c] == arr[r][c-1]){
                    arr[r][c] *= 2;
                    arr[r][c-1] = 0;
                }
            }

            temp = new int[4];
            idx = size-1;
            for(int c=size-1; c>=0; c--){
                if(arr[r][c] == 0) continue;
                temp[idx--] = arr[r][c];
            }
            for(int c=size-1; c>=0; c--){
                arr[r][c] = temp[c];
            }
        }
    }

    static void caseU(){
        for(int c=0; c<size; c++){
            int[] temp = new int[4];
            int idx = 0;
            for(int r=0; r<size; r++){
                if(arr[r][c] == 0) continue;
                temp[idx++] = arr[r][c];
            }
            for(int r=0; r<size; r++){
                arr[r][c] = temp[r];
            }

            for(int r=0; r<size-1; r++){
                if(arr[r][c] == arr[r+1][c]){
                    arr[r][c] *= 2;
                    arr[r+1][c] = 0;
                }
            }

            temp = new int[4];
            idx = 0;
            for(int r=0; r<size; r++){
                if(arr[r][c] == 0) continue;
                temp[idx++] = arr[r][c];
            }
            for(int r=0; r<size; r++){
                arr[r][c] = temp[r];
            }
        }
    }

    static void caseD(){
        for(int c=0; c<size; c++){
            int[] temp = new int[4];
            int idx = size-1;
            for(int r=size-1; r>=0; r--){
                if(arr[r][c] == 0) continue;
                temp[idx++] = arr[r][c];
            }
            for(int r=size-1; r>=0; r--){
                arr[r][c] = temp[r];
            }

            for(int r=size-1; r>0; r--){
                if(arr[r][c] == arr[r-1][c]){
                    arr[r][c] *= 2;
                    arr[r-1][c] = 0;
                }
            }

            temp = new int[4];
            idx = size-1;
            for(int r=size-1; r>=0; r--){
                if(arr[r][c] == 0) continue;
                temp[idx++] = arr[r][c];
            }
            for(int r=size-1; r>=0; r--){
                arr[r][c] = temp[r];
            }
        }
    }
}