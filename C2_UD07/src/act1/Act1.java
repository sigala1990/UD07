package act1;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Act1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hashtable<String, String> contador = new Hashtable<String, String>();
		Hashtable<String, String> contadorfinal = new Hashtable<String, String>();
		Scanner sc = new Scanner(System.in);

		System.out.println("Muestra cuantos examenes tendran los alumnos");
		int scValue = sc.nextInt(); // cantidad de examenes por alumno

		System.out.println("Indica cuantos alumnos tenemos");
		int scQuantityStudent = sc.nextInt(); // cantidad alumnos
		
		for (int i = 0; i < scQuantityStudent; i++) {
			contador = addStudent(scValue);
			for (String keyValue : contador.keySet()){ // la "o" es la key de cada posicion y al especificar dentro del contador la key te devuelve el valor
				System.out.println(keyValue + " " + contador.get(keyValue));
				contadorfinal.put(keyValue, contador.get(keyValue));
			}
		}
		 
		//System.out.println("contador "+contador);
		System.out.println("Contadorfinal "+contadorfinal);
		
		//contadorfinal = addAvgStudent(contadorfinal, contador, scQuantityStudent);
		//System.out.println(contadorfinal);
	}

	public static Hashtable addAvgStudent( Hashtable hashtableFinal, Hashtable hashtableStudent, int quantityStudents) {
		Hashtable<String, String> contadorfinal = new Hashtable<String, String>();
		return hashtableFinal;
	}
	public static Hashtable addStudent(int numExam) {
		Hashtable<String, String> contador = new Hashtable<String, String>();

		String scValue1 = "";
		Double scValue2 = 0.0;
		Double avgValue = 0.0;
		scValue1 = stringScan("Introduce el nombre :");

			for (int i = 0; i < numExam; i++) {
				scValue2 = doubleScan("Introduce la nota");
				avgValue = avgValue + scValue2;
			}contador.put(scValue1 + " ", String.valueOf(avgValue/numExam));
		return contador;
	}

	public static String stringScan(String text) {
		Scanner scan = new Scanner(System.in);
		System.out.println(text);
		String value = "";
		value = scan.next();
		return value;
	}

	public static double doubleScan(String text) {
		Scanner scan1 = new Scanner(System.in);
		System.out.println(text);
		Double value =  0.0;
		value = scan1.nextDouble();
		return value;
	}
}
