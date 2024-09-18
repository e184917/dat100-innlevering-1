/*
 * Lag et program som leser inn en poengsum (heltall) som en student har 
 * oppnådd på en prøve, og finn og skriv ut den karakteren A-F dette tilsvarer. 
 * Grenser for de ulike karakterene skal være:
 * 
 * A: 100-90
 * B: 89-80
 * C: 79-60
 * D: 59-50
 * E: 49-40
 * F: 39-0
 * 
 * Utvid programmet i pkt. a) slik at det kan lese inn poengsummer fra 10 studenter 
 * og skrive ut karakteren (eller feilmelding) etter hver innlesing. HINT: hvordan 
 * kan du bruke en for-løkke til dette.
 */

package no.hvl.dat100;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.*;


public class O2 {

	public static void main(String[] args) {
		
		int student = 10;
		
		for (int i = 0; i < student; i++) {
			
			final char grunnChar = 74;
			
			while (true) {
				int poengsum = parseInt(showInputDialog("Poengsum:"));
				
				if (poengsum < 0 || poengsum > 100) {
					System.out.println("Ugyldig poengsum.");
				}
				else {
					
					poengsum = poengsum / 10;
					
					if (poengsum == 10) {
						poengsum = poengsum - 1;
					}
					
					if (poengsum < 6) {
						poengsum = poengsum + 1;
					}
					
					if (poengsum < 4) {
						poengsum = 4;
					}
					
					char nyChar = (char)(grunnChar - poengsum);
					
					System.out.println("Student " + (i+1) + ": " + nyChar + " Poengsum: " + poengsum + " Karakter: " + nyChar);
					
					break;

				}

			}

		}
		
	}

}