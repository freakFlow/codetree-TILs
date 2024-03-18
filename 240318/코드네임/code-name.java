import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        Agent[] agents = new Agent[5];
        for(int i=0; i<5; i++){
            agents[i] = new Agent();
        }

        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            agents[i].name = st.nextToken();
            agents[i].score = Integer.parseInt(st.nextToken());
        }
        
        String target = "";
        int min = 101;

        for(int i=0; i<5; i++){
            if(agents[i].score < min){
                target = agents[i].name;
                min = agents[i].score;
            }
        }

        sb.append(target).append(' ').append(min);

        System.out.print(sb);
    }

    static class Agent{
        String name;
        int score;

        Agent(){}
    }
}