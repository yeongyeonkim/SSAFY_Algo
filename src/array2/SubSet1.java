package array2;

public class SubSet1 {

	public static String[] data = { "A", "B", "C", "D" };

	public static void main(String[] args) {
		for (int i = 0; i < (1 << data.length); i++) {
			String sum = "";
			for (int j = 0; j < data.length; j++) {
				if ((i & (1 << j)) > 0) {
					System.out.print(data[j] + " ");
					sum = sum + data[j];
				}
			}
			System.out.println(" sum= " + sum + " / " + i);
		}
	}
}