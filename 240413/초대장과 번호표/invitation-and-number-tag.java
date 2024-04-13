import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, G;
    static List<Integer>[] people;
    static HashSet<Integer>[] groups;
    static boolean[] invited;
    static Queue<Integer> q;
    static int ans;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        people = new List[N + 1];
        groups = new HashSet[G];
        invited = new boolean[N + 1];
        q = new ArrayDeque<>();

        for(int n=1; n<=N; n++){
            people[n] = new ArrayList<>();
        }
        for(int g=0; g<G; g++){
            groups[g] = new HashSet<>();
        }

        for(int g=0; g<G; g++){
            st = new StringTokenizer(br.readLine());
            int iter = Integer.parseInt(st.nextToken());
            for(int i=0; i<iter; i++){
                int p = Integer.parseInt(st.nextToken());
                people[p].add(g);
                groups[g].add(p);
            }
        }

        invited[1] = true;
        q.add(1);
        bfs();

        for(int n=1; n<=N; n++){
            if(invited[n]) ans++;
        }

        sb.append(ans);

        System.out.print(sb);
    }

    static void bfs(){
        while(!q.isEmpty()){
            int curr = q.poll();

            for(int g : people[curr]){
                groups[g].remove(curr);
                if(groups[g].size() == 1){
                    for(int n=1; N<=N; n++){
                        if(groups[g].contains(n)){
                            if(!invited[n]){
                                invited[n] = true;
                                q.add(n);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}