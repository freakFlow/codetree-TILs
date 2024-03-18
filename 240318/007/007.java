import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        Info info = new Info(st.nextToken(), st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));

        sb.append("secret code : ").append(info.secretCode).append('\n')
        .append("meeting point : ").append(info.meetingPoint).append('\n')
        .append("time : ").append(info.time);

        System.out.print(sb);
    }

    static class Info{
        String secretCode;
        char meetingPoint;
        int time;

        Info(String secretCode, char meetingPoint, int time){
            this.secretCode = secretCode;
            this.meetingPoint = meetingPoint;
            this.time = time;
        }
    }
}