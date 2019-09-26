package graph;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
public class DfsLinked {
    public static class Node{
        int data;
        Node link;
    }
    public static int V; //정점의 개수 
    public static int E; //간선의 개수
    public static Node[] graph;
    public static boolean[] visited; 
    public static Stack<Node> stack; 
    public static void dfsr(int node) { //재귀. 가지치기하기엔 좋으나 overflow.. 
        visited[node] = true;
        System.out.print(node + " ");
        Node t = graph[node];       
        while(t.link!=null) {
            if(visited[t.data] == false) {
                dfsr(t.data);
            }
            t = t.link;
        }
        if(visited[t.data] == false) {
            dfsr(t.data);
        }
    }
    public static void dfs(int node) { //반복 ;
        visited = new boolean[V];
        Node n = new Node();
        n.data = node;
        stack.push(n);
        while(!stack.empty()) {
            Node cur = stack.pop(); //0
            if(visited[cur.data] == false) {// 방문 안했다면 
                visited[cur.data] = true; 
                System.out.print(cur.data + " ");
                
                Node t = graph[cur.data];
                while(t.link != null) {
                    if(visited[t.data] == false) {
                        stack.push(t);
                    }
                    t=t.link;
                }
                if(visited[t.data] == false) {
                    stack.push(t);
                }
            }           
        }
    }
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        System.setIn(new FileInputStream("res/input_dfs.txt"));
        Scanner in = new Scanner(System.in);
        V = in.nextInt(); //7개
        E = in.nextInt(); //8개
        graph = new Node[V]; //선언해놓고 안에서 생성 
        visited = new boolean[V];
        stack = new Stack<Node>(); //default
        
        for(int i=0; i<E; i++) { //간선의 수보다 작을 때 까지
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            Node n1 = new Node();
            n1.data = v2;
            if(graph[v1] == null ) {//아무것도 없는 상태 
                n1.link = graph[v1];
                graph[v1] = n1;
            }else {
                Node t = graph[v1];
                while(t.link!=null) t=t.link;
                n1.link = t.link;
                t.link=n1;
            }
            Node n2 = new Node();
            n2.data = v1;
            if(graph[v2] == null ) {//아무것도 없는 상태 
                n2.link = graph[v2];
                graph[v2] = n2;
            }else {
                Node t = graph[v2];
                while(t.link!=null) t=t.link;
                n2.link = t.link;
                t.link=n2;
            }
        }
        
        for(int i=0; i<V; i++) {
            System.out.print(i+":");
            if(graph[i] != null) {
                Node t = graph[i];
                while(t.link != null) {
                    System.out.print(t.data + "->");
                    t = t.link;
                }
                System.out.println(t.data);
            }
        }
        dfs(0); //0번 노드부터 반복 
        System.out.println();
//      visited = new boolean[V];
//      dfsr(0);
    }
}