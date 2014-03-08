package br.com.gtmf;

import java.text.DecimalFormat;

/**
 * TESTES com a API GeodeticCalculator
 */
public class AppTest {
	
	public static void main(String[] args) {
		try {
			double number = 1788999999.1890;
			
			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(2);
			String formatted = df.format(number);
			System.out.println(formatted);
			
			// iguatemi -> unifor
			int iguatemi2unifor = SimInterfaceImpl.calcDistance(-3.755747,-38.490859, -3.766068,-38.478348);

			// iguatemi -> via sul
			int iguatemi2viasul = SimInterfaceImpl.calcDistance(-3.755747,-38.490859, -3.792746,-38.479528);

			// iguatemi -> casa jose de alencar
			int iguatemi2josealencar = SimInterfaceImpl.calcDistance(-3.755747,-38.490859, -3.810474,-38.478842);

			// iguatemi -> aquiraz
			int iguatemi2aquiraz = SimInterfaceImpl.calcDistance(-3.755747,-38.490859, -3.924882,-38.38829);

			// iguatemi -> iguape
			int iguatemi2iguape = SimInterfaceImpl.calcDistance(-3.755747,-38.490859, -3.962987,-38.362284);

			System.out.println("iguatemi -> unifor: " + iguatemi2unifor + " metros"); // Google Maps: 1,7 km
			System.out.println("iguatemi -> via sul: " + iguatemi2viasul + " metros"); // Google Maps: 4,7 km
			System.out.println("iguatemi -> casa jose de alencar: " + iguatemi2josealencar + " metros"); // Google Maps: 6,4 km
			System.out.println("iguatemi -> aquiraz: " + iguatemi2aquiraz + " metros"); // Google Maps: 26,1 km
			System.out.println("iguatemi -> iguape: " + iguatemi2iguape + " metros"); // Google Maps: 31,9 km
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
