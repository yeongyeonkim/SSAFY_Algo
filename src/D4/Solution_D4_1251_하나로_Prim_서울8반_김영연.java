package D4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D4_1251_하나로_Prim_서울8반_김영연 {
	static int[][] island;
    static double[][] a;
    static double INF = Double.MAX_VALUE/2;
    static double e;
    static int N;
    static double[] w; 
 
    public static double prim() {
        Arrays.fill(w, -1);
        w[0] = 0;
        for(int k=1; k<N; k++) {
            double minWeight = INF;
            int minVertex = 0;
            for(int i=0; i<N; i++) {
                if(w[i] < 0) continue;
                for(int j=0; j<N; j++) {
                    if(w[j] >= 0) continue;
                    if(a[i][j] < minWeight) {
                        minWeight = a[i][j];
                        minVertex = j;
                    }
                }
            }
            w[minVertex] = minWeight;
        }
         
         
        double sum = 0.0;   
        for(int i=0; i<N; i++) sum += w[i];
        return sum;
    }
 
    public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/D4_1251.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testcase; t++) {
            N = Integer.parseInt(br.readLine());
            island = new int[N][N];
            a = new double[N][N];
            String[] info = br.readLine().split(" ");
            for (int i = 0; i < N; i++)
                island[i][0] = Integer.parseInt(info[i]); // x좌표입력
            info = br.readLine().split(" ");
            for (int i = 0; i < N; i++)
                island[i][1] = Integer.parseInt(info[i]);
            e = Double.parseDouble(br.readLine());
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(i == j) {
                        a[i][j] = 0;
                        continue;
                    }
                    a[i][j] = a[j][i] = e * ((Math.pow(island[i][0] - island[j][0], 2)
                            + (Math.pow(island[i][1] - island[j][1],2))));
                }
            }
            w = new double[N];
            System.out.println("#" + t + " " + Math.round(prim()));
        }
    }
}