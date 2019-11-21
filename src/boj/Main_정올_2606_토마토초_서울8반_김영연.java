package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Main_정올_2606_토마토초_서울8반_김영연{

	static int n, m, h, total, cnt;
    static Queue<int[]> q = new LinkedList<>();
 
    public static void BFS(int[][][] map) {
        int[] dx = {1, 0,-1, 0, 0, 0}; 
        int[] dy = {0, 1, 0,-1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1,-1};
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            for(int i=0; i<6; i++) { //상하좌우
                int nz = tmp[0] + dz[i];
                int nx = tmp[1] + dx[i];
                int ny = tmp[2] + dy[i];
                if(0<=nx&&0<=ny&&0<=nz&&nx<n&&ny<m&&nz<h&&map[nz][nx][ny] == 0) {
                    map[nz][nx][ny] = 1;
                    q.add(new int[] {nz, nx, ny, tmp[3] + 1 } );
                    total--;
                }
            }
            cnt = tmp[3];
        }
    }
     
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();
        total = 0;
        cnt = 0;
        int[][][] map = new int[h][n][m];
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int num = sc.nextInt();
                    map[k][i][j] = num;
                    if(num == 0) total++;
                    else if(num == 1) q.add(new int[] { k, i, j, 0 } );
                }
            }
        }
        BFS(map);
        if(total != 0) System.out.println("-1");
        else System.out.println(cnt);
    }
}

