package array1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ForTest {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		ArrayList<Integer> array = new ArrayList<>();
		
		for (int tc = 1; tc <= 10; tc++) {

			array.clear();
			
			int num = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < num; i++) {
				array.add(Integer.parseInt(st.nextToken()));
			}

			int order = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < order; i++) {
				
				String choose = st.nextToken();
				int input_pos = Integer.parseInt(st.nextToken());

				if (choose.equals("I")) {
					int input_num = Integer.parseInt(st.nextToken());
					for (int j = 0; j < input_num; j++) {
						array.add(input_pos+j, Integer.parseInt(st.nextToken()));
					}
				}
				else if(choose.equals("D")){
					int input_num = Integer.parseInt(st.nextToken());
					for (int j=0; j<input_num; j++) {
						array.remove(input_pos);
					}
				}
				else if(choose.equals("A")){
					for (int j=0; j<input_pos; j++) {
						array.add(Integer.parseInt(st.nextToken()));
					}
				}
			}

			System.out.println("#" + tc + " " + array.get(0) +" " + array.get(1) + " " + array.get(2) + " " + array.get(3) + " " + array.get(4) + " " + array.get(5) + " " + array.get(6) + " " + array.get(7) + " " + array.get(8) + " " + array.get(9));}
		br.close();
	}
}