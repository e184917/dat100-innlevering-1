/* Lag et program som leser inn et heltall n > 0, beregner verdien n! (n fakultet)
 * og skriver verdien til n! ut på skjermen, der n! = 1*2*3*...*(n-1)*n
 */

package no.hvl.dat100;

import static javax.swing.JOptionPane.showInputDialog;

public class O3 {

	public static void main(String[] args) {
		long n = Long.parseLong(showInputDialog("Tall til beregning:"));
		long x = 1;
		
		for (int i = 1; i <= n; i++) {
			x = x * i;
		}
		System.out.println(n + "!" + " = " + x);
	}
}