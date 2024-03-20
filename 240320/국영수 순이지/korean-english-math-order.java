import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Student[] students;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        students = new Student[N];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            students[n] = new Student(name, kor, eng, math);
        }

        Arrays.sort(students, new Comparator<Student>(){
            public int compare(Student s1, Student s2){
                if(s1.kor == s2.kor){
                    if(s1.eng == s2.eng){
                        return Integer.compare(s2.math, s1.math);
                    }
                    return Integer.compare(s2.eng, s1.eng);
                }
                return Integer.compare(s2.kor, s1.kor);
            }
        });

        for(int n=0; n<N; n++){
            sb.append(students[n].name).append(' ')
            .append(students[n].kor).append(' ')
            .append(students[n].eng).append(' ')
            .append(students[n].math).append('\n');
        }

        System.out.print(sb);
    }

    static class Student{
        String name;
        int kor;
        int eng;
        int math;

        Student(String name, int kor, int eng, int math){
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }
}