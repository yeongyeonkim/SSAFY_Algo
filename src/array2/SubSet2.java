package array2;

public class SubSet2 {

	public static int[] data= {1,2,3,4};
	public static int[] bit = new int[4];
	public static void main(String[] args) {
		for(int i=0; i<2; i++) {
			bit[0]=(i%2==0)? 0:1;
			for(int j=0; j<2; j++) {
				bit[1] = (j%2==0)? 0:1;
				for(int k=0; k<2; k++) {
					bit[2] = (k%2 == 0 )? 0:1;
					for(int l=0; l<2; l++) {
						bit[3]=(l%2==0)? 0:1;
						System.out.print((bit[0]==1)? data[0]+",":"");
						System.out.print((bit[1]==1)? data[1]+",":"");
						System.out.print((bit[2]==1)? data[2]+",":"");
						System.out.print((bit[3]==1)? data[3]+",":"");
						System.out.println();
					}
				}
			}
		}
	}

}
