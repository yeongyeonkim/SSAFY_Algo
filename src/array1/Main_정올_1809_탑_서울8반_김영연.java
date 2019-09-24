	package array1;
	
	import java.io.BufferedReader;
	import java.io.FileInputStream;
	import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
	
	public class Main_정올_1809_탑_서울8반_김영연 {
	    public static void main(String[] args) throws Exception{
	        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);
	        int[] arr = new int[N];
	        
	        Stack<Integer> stack = new Stack<Integer>();
	        
	        String snum = br.readLine();
	        String[] sa = snum.split(" ");
	        
	         for(int i=0; i< N; i++) {
	        	 arr[i] = Integer.parseInt(sa[i]);
	        	 while(!stack.empty() && arr[stack.peek()] < arr[i])
	        		 stack.pop();       	 
	        	 if(stack.empty()) {
	        		 System.out.println("0 ");
	        	 } else {
	        		 System.out.print((stack.peek()+1) + " ");
	        	 }
	        	 stack.push(i);
	         }
	         
	    }
	}