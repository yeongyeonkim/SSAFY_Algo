package array2;

import java.util.Arrays;
import java.util.Scanner;
public class test {
    static int ctop, ntop,len;
    static int[] num;
    static char[] c;
    static void init() {
        ctop = -1; ntop = -1;
        num = new int[len/2+1];
        c = new char[len/2];
    }
    static void pushn(int x) {
        num[++ntop] = x;
    }
    static void pushc(char de) {
        c[++ctop] = de;
    }
    static int popn() {
        return num[ntop--];
    }
    static char peekc() {
        return c[ctop];
    }
    static char popc() {
        return c[ctop--];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            len = sc.nextInt();
            char[] data = new char[len];
            String s = sc.next();
            for (int i = 0; i < len; i++)
                data[i] = s.charAt(i);
 
            init();
 
            for (int i = 0; i < len; i++) {
                if (data[i] == '(') {
                    pushc(data[i]);
                } 
                
                else if (data[i] == '*') {
                    pushc(data[i]);
                } 
                
                else if (data[i] == '+') {
                    if (peekc() != '*')
                        pushc(data[i]);
                    else {
                        while (peekc() == '*') {
                            popc();
                            pushn(popn() *popn());
                        }
                        pushc(data[i]);
                    }
                }
                
                else if (data[i] == ')') {
                    while (peekc() != '(') {
                        if (peekc() == '+')
                            pushn(popn() + popn());
                        else
                            pushn(popn() * popn());
                        popc();
                    }
                    popc();
                } 
                
                else
                    pushn(data[i] - '0');
            }
            System.out.println("#" + tc + " " + popn());
        }
    }
}