package act3;

import java.util.Hashtable;
import java.util.Scanner;

public class Act3 {

	public static void main(String[] args) {

		Hashtable<String, String> htable = new Hashtable<String, String>();
		htable = shopStock(htable);
		
		accederConsola(htable);
	}

	public static void accederConsola(Hashtable<String, String> htable) {
		String scaner = "";
		int control = 0;
		while(control != 4) {//bucle para repetir la actividad de pedir que hacer
			do {
				scaner = ScanString("Que desea hacer:\n\nAñadir producto\t pulsa 'A'\nConsultar datos\t pulsa 'C'\nVer todo\t pulsa 'V'\nSalir \t \t pulsa 'S'");
				control = controlAccion(scaner);
			} while (control == 0);
			
				switch (control) {
					case 1:
						htable = addNewItem(htable);
						break;
					case 2:
						itemInfo(htable);
						break;
					case 3:
						showAll(htable);
						break;
				}
			}
		System.out.println("Adios");
	
	}
	public static Hashtable<String, String> addNewItem(Hashtable<String, String> htable) {//añadir
		String newItem = ScanString("Introduce el nombre del nuevo producto: ");
		String newPrice = ScanString("Introduce el precio del nuevo producto: ");
		htable.put(newItem, newPrice);
		System.out.println("Nuevo producto "+ newItem+" con precio "+newPrice+" añadido correctamente!\n");
		
		return htable;
	}
	public static void  itemInfo(Hashtable<String, String> htable) {//mostrar el item buscado
		String itemSelect = "";
		boolean itemExist = false;
		for (String i : htable.keySet()) {//printa todos keys de la htable
			System.out.print(i+ " ");
		}
		System.out.println("\n");		
		do {//repite si el objeto no existe
			itemSelect = ScanString("De que item quieres ver su precio");
			for(String i : htable.keySet()) {
				if(itemSelect.equals(i)) {//encontro el objeto
					itemExist = true;
					System.out.println(i + " tiene "+ htable.get(i));
				}
			}			
		}while(!itemExist);
		
	}
	public static void showAll(Hashtable<String, String> htable) {//mostrar todo
		for (String i : htable.keySet()) {
			System.out.println(i + " precio "+ htable.get(i));
		}
		System.out.println("\n");
	}

	public static int controlAccion(String text) {//miramos que quiere ejecutar el usuario
		int control = 0;
		switch (text.toUpperCase()) {
		case "A":
			control = 1;
			break;
		case "C":
			control = 2;
			break;
		case "V":
			control = 3;
			break;
		case "S":
			control = 4;
			break;
		default:
			control = 0;
			break;
		}
		return control;
	}

	public static Hashtable<String, String> shopStock(Hashtable<String, String> htable) { // crear inventario de tienda

		htable.put("Caja1", "1.5");
		htable.put("Caja2", "2.5");
		htable.put("Caja3", "3.5");
		htable.put("Caja4", "4.5");
		htable.put("Caja5", "5.5");
		htable.put("Caja6", "6.5");
		htable.put("Caja7", "7.5");
		htable.put("Caja8", "8.5");
		htable.put("Caja9", "9.5");
		htable.put("Caja10", "10.5");

		return htable;
	}

	public static String ScanString(String text) {
		Scanner scan = new Scanner(System.in);
		System.out.println(text);
		String value = "";
		value = scan.next();
		return value;
	}

	public static double ScanDouble(String text) {
		Scanner scan1 = new Scanner(System.in);
		System.out.println(text);
		Double value = 0.0;
		value = scan1.nextDouble();
		return value;
	}
}
