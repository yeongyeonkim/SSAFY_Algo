package stack2;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
public class MazeDfs3 {
        public static int[][] maze ;
        public static int[] di = {0, 0, -1, 1}; //좌우상하
        public static int[] dj = {-1, 1, 0, 0};
        public static int[][] visit; //원본은 그대로 visit배열을 새로 만듦 
        public static int N = 100;
        public static Stack<int[]> stack; 
        
        public static void main(String[] args) throws Exception{
            System.setIn(new FileInputStream("res/maze2.txt"));
            Scanner sc = new Scanner(System.in);
            for(int tc = 1; tc<=10; tc++) {
            stack = new Stack<int[]>();
            visit = new int[N][N];
            maze = new int[N][N];
            
            int T = sc.nextInt();
            for(int i=0; i<N; i++) {
                String s = sc.next();
                for(int j=0; j<N; j++) {
                    maze[i][j] = s.charAt(j) - '0';
                }
            }
            System.out.println("#"+tc+" "+dfsr(1, 1, 0));
            }
    }
        public static int dfsr(int i, int j, int cnt) { //map에서 방향전환 할때마다 cnt증가 
        	visit[i][j] = 1;
        	if(maze[i][j] == 3) { //종점에 도착했으면 리턴 
        		System.out.println("i="+i+", "+"j="+j+"cnt=" + cnt);
        		return 1;
        	}
        	
        	for(int d=0; d<di.length; d++) { //인접한 방향 다 보기 
        		int ni = i + di[d];
        		int nj = j + dj[d];
        		if(0 <= ni && ni < N && 0<=nj && nj < N && maze[ni][nj] != 1 && visit[ni][nj] == 0) { //범위 체크 먼저 한 다음 값이랑 방문체크 
        			if(dfsr(ni, nj, cnt+1) == 1) return 1;
        		}
        	}
//        	visit[i][j] = 0; 중복검사
        	return 0;
        }
        
//      public static void dfsr(int i, int j) {  //재귀호출 
//          visit[i][j] = 1;
//          if(i == N-1 && j == N-1) {
//              System.out.println("i="+i+", "+"j="+j);
//              return;
//          }
//          System.out.println();
//          for(int[] a : maze) System.out.println(Arrays.toString(a));
//          
//          for(int d=0; d<di.length; d++) {
//              int ni = i + di[d];
//              int nj = j + dj[d];
//              if(0 <= ni && ni < N && 0<=nj && nj < N && maze[ni][nj] == 0 && visit[ni][nj] == 0) {
//                  dfsr(ni, nj);
//              }
//          }
//      }
        
//      public static void dfs(int i, int j, int cnt) {
//          stack.push(new int[] {i, j, cnt});
//          while(!stack.empty()) {
//              int[] cur = stack.pop(); //0
//              i = cur[0];
//              j = cur[1];
//              cnt = cur[2];
//              if(visit[i][j] != 1) {
//                  visit[i][j] =1;
//                  if(i == N-1 && j  == N-1) {
//                      System.out.println("i="+i+", j="+j + "cnt="+cnt);
//                      return;
//                  }
//              
//                  for(int d=0; d<di.length; d++) {
//                      int ni = i + di[d];
//                      int nj = j + dj[d];
//                      if(0 <= ni && ni < N && 0<=nj && nj < N && maze[ni][nj] == 0 && visit[ni][nj] == 0) {
//                          stack.push(new int[] {ni, nj, cnt+1});
//                      }
//              }
//              
//          }
//          
//      }
//  }
}