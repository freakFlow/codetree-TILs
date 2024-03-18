import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static Prediction ans;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            Prediction temp = new Prediction(st.nextToken(), st.nextToken(), st.nextToken());
            if(!temp.weather.equals("Rain")) continue;
            if(ans == null || compareDate(temp)) ans = temp;
        }

        sb.append(ans.year).append('-').append(ans.month).append('-').append(ans.day)
        .append(' ').append(ans.week).append(' ').append(ans.weather);

        System.out.print(sb);
    }

    static boolean compareDate(Prediction prediction){
        int year1 = Integer.parseInt(prediction.year);
        int year2 = Integer.parseInt(ans.year);
        int month1 = Integer.parseInt(prediction.month);
        int month2 = Integer.parseInt(ans.month);
        int day1 = Integer.parseInt(prediction.day);
        int day2 = Integer.parseInt(ans.day);
        if(year1 == year2){
            if(month1 == month2){
                return day1 < day2 ? true : false;
            }
            return month1 < month2 ? true : false;
        }
        return year1 < year2 ? true : false;
    }

    static class Prediction{
        String year;
        String month;
        String day;
        String week;
        String weather;

        Prediction(String date, String week, String weather){
            StringTokenizer temp = new StringTokenizer(date, "-");
            this.year = temp.nextToken();
            this.month = temp.nextToken();
            this.day = temp.nextToken();
            this.week = week;
            this.weather = weather;
        }
    }
}