/* Lag et program som leser inn bruttoinntekt, beregner og skriver ut trinnskatten 
 * dvs. det beløpet som personen skal betale i trinnskatt.
 */

package no.hvl.dat100;

import static javax.swing.JOptionPane.showInputDialog;

public class O1 {

	public static void main(String[] args) {
		
		// Steg 1: Gitte verdier, inndata og oppjusteringer for presisjon (double til long)
		long[] skatteGrenser = {0, 208051, 292851, 670001, 937901, 1350001};
		double[] trinn = {0.0, 0.017, 0.04, 0.136, 0.166, 0.176};
		
		// Oppjustering for skatteGrenser
		for (int i = 0; i < skatteGrenser.length; i++) {
			skatteGrenser[i] = skatteGrenser[i] * 1000;
		}
		
		// Oppjustering og typeendring for trinn
		long[] trinnLong = new long[6];
		
		for (int i = 0; i < trinn.length; i++) {
			trinnLong[i] = (long)(trinn[i] * 1000);
		}
		
		// Inndata og oppjustering for bruttolønn
		double bruttoInntekt = Double.parseDouble(showInputDialog("Bruttolønn:"));
		long bruttoInntektLong = (long)(bruttoInntekt * 1000);
		
		// Identifisering av skattetrinn
		int skatteTrinn = 0;
		for (int i = 0; i < skatteGrenser.length; i++) {
			if (bruttoInntektLong > skatteGrenser[i]) {
				skatteTrinn = i;
			}
		}
		
		// Steg 2: Skatteberegninger 
		long[] trinnSkattLong = new long[6];
		
		long tilBeregning = bruttoInntektLong;
		
		for (int i = skatteTrinn; i > 0; i--) {
			trinnSkattLong[i] = (tilBeregning - skatteGrenser[i]) * trinnLong[i];
			tilBeregning = skatteGrenser[i];	
		}
		
		// Nedjustere skatt og endre type til double
		double[] trinnSkatt = new double[6];
		double totalSkatt = 0;
		
		for (int i = 0; i < trinnSkatt.length; i++) {
			trinnSkatt[i] = (double)(trinnSkattLong[i]/(1000.0*1000.0));
			totalSkatt = totalSkatt + trinnSkatt[i];
		}
		
		// Oppjustere prosenter for å unngå formateringsfeil
		for (int i = 0; i < trinnLong.length; i++) {
			trinn[i] = trinnLong[i] / 10.0;
		}
		
		// Formatere og printe løsningen i konsoll
		enRekkeStreker(1);
		for (int i = 0; i < trinnSkatt.length; i++) {
			System.out.println("Trinn " + i + " " + (trinn[i]) + "%: " + trinnSkatt[i]);
		}
		
		enRekkeStreker(1);
		System.out.println("kr " + totalSkatt);
		enRekkeStreker(2);

	}

	private static void enRekkeStreker(int antall) {
		for (int i = 0; i < antall; i++) {
			System.out.println("--------------------------------------");			
		}
	}

}
