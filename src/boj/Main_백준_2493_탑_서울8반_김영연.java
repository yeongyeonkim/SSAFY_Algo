	package boj;
	
	import java.io.BufferedReader;
	import java.io.FileInputStream;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;
	
	public class Main_백준_2493_탑_서울8반_김영연 {
	    public static void main(String[] args) throws Exception{
	        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	        int N=Integer.parseInt(br.readLine());
	        
	        StringTokenizer st=new StringTokenizer(br.readLine());
	        int[] arr=new int[N+1];
	        arr[0]=Integer.MAX_VALUE;
	        for(int i=1; i<N+1; i++)
	            arr[i]=Integer.parseInt(st.nextToken());
	        for(int i=N; i>0; i--) {
	            for(int j=i-1; j>=0; j--) {
	                if(arr[i] <= arr[j]) {
	                    arr[i]=j;
	                    break;
	                }
	            }
	        }
	        System.out.print(arr[1]);
	        for(int i=2; i<arr.length; i++)
	            System.out.print(" " + arr[i]);
	        System.out.println();
	    }
	}