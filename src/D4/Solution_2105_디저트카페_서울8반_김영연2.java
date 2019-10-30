package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_2105_디저트카페_서울8반_김영연2 {
 
    static int n, max, start_x, start_y;
    static int[][] map;
    static boolean[] number;
    // dir은 1,2,3,4
    static int[] dx = { 0, 1, 1, -1, -1 };
    static int[] dy = { 0, -1, 1, 1, -1 };
     
    public static boolean check(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n)
            return false;
        else if (!number[map[x][y]] || (x == start_x && y == start_y))
            return true;
        else
            return false;
    }
 
    public static void dfs(int x, int y, int d, int count) {
    	number[map[x][y]] = true;
        if(x == start_x && y == start_y && d != 0) {
            max = Math.max(count, max);
            return;
        }
        if (d == 0) { // 방향이 처음지점이라서 설정이 안되어있다면
            if (!check(x + dx[1], y + dy[1])) return;
            dfs(x + dx[1], y + dy[1], 1, count + 1);
        } else {
            for (int i = d; i <= d + 1; i++) {
                if (i == 5 || !check(x + dx[i], y + dy[i])) continue;
                dfs(x + dx[i], y + dy[i], i, count + 1);
            }
        }
        number[map[x][y]] = false;
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }
            // n-1개가 뻗어나갈 수 있는 최대한의 거리
            max = -1;
            for (int i = 0; i < n-2; i++) {
                for (int j = 1; j < n - 1; j++) {
                    number = new boolean[101];
                    start_x = i;
                    start_y = j;
                    dfs(i, j, 0, 0);
                }
            }
            System.out.println("#" + t + " " + max);
        }
    }
 
}