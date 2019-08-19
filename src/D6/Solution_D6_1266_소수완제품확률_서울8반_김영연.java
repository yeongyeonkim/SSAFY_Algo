package D6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution_D6_1266_소수완제품확률_서울8반_김영연 {
    public static double nCr(int n, int r) {
        if (r == 0)
            return 1.0;
        return 1.0 * n / r * nCr(n - 1, r - 1);
    }
    public static void main(String args[]) throws Exception {
        int[] dec = { 2, 3, 5, 7, 11, 13, 17 };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testcase; t++) {
            String[] info = br.readLine().split(" ");
            double a = Double.parseDouble(info[0]);
            double b = Double.parseDouble(info[1]);
            double result_a = 0.0;
            double result_b = 0.0;
            for (int i = 0; i < 7; i++) {
                result_a += nCr(18, dec[i]) * Math.pow(a / 100, dec[i]) * Math.pow(1 - a / 100, 18 - dec[i]);
                result_b += nCr(18, dec[i]) * Math.pow(b / 100, dec[i]) * Math.pow(1 - b / 100, 18 - dec[i]);
            }
            System.out.printf("#%d %f\n", t, result_a + result_b - result_a * result_b);
        }
    }
}