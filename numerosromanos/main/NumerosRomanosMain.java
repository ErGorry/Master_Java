package numerosromanos.main;

import java.util.Arrays;

/**
 * El objetivo de esta clase sera crear un metodo que convierta un numero desde
 * 1 a 3999 en su version de numeros romanos
 * 
 * @author Admin 18-04-2024
 *
 */
public class NumerosRomanosMain {

	public static void main(String[] args) {

		System.out.println(conversion(1999));
		System.out.println(conversion(34));
		System.out.println(conversion(68));
		System.out.println(conversion(80));
		System.out.println(conversion(444));
		System.out.println(conversion(3788));
		System.out.println(conversion(1631));
		System.out.println(conversion(3993));
		System.out.println(conversion(334));
	}

	private static String conversion(int i) {
		if (i > 3999 || i < 1) {
			return "El numero introducido esta fuera del rango de trabajo 1-3999";
		}
		StringBuilder cadena = new StringBuilder();
		do {
			if (i >= 1000) {
				i -= 1000;
				cadena.append("M");
			} else if (i >= 900) {
				i -= 900;
				cadena.append("CM");
			} else if (i >= 500) {
				i -= 500;
				cadena.append("D");
			} else if (i >= 400) {
				i -= 400;
				cadena.append("CD");
			} else if (i >= 100) {
				i -= 100;
				cadena.append("C");
			} else if (i >= 90) {
				i -= 90;
				cadena.append("XC");
			} else if (i >= 50) {
				i -= 50;
				cadena.append("L");
			} else if (i >= 40) {
				i -= 40;
				cadena.append("XL");
			} else if (i >= 10) {
				i -= 10;
				cadena.append("X");
			} else if (i >= 9) {
				i -= 9;
				cadena.append("IX");
			} else if (i >= 5) {
				i -= 5;
				cadena.append("V");
			} else if (i >= 4) {
				i -= 4;
				cadena.append("IV");
			} else if (i >= 1) {
				i -= 1;
				cadena.append("I");
			}

		} while (i > 0);

		return cadena.toString();

	}

}
