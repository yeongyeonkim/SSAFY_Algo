package array1;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class Counting {
	public static void main(String[] args) {
		int[] a = {10,4,6,7,2,9,3,1,8,5};
		int[] c = new int[11];
		int[] s = new int[a.length];
		
		for(int i=0; i<a.length-1; i++) {
			
			c[a[i]]--;
			s[c[a[i]]] = a[i];
		}
	}
}