package act4;

import java.util.Hashtable;
import java.util.Scanner;

public class Act4 {

	
	/*
	 * Auth Adria Queralt 
	 * */
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String, String> htable = new Hashtable<String, String>();
		htable = shopStock(htable);
		accederConsola(htable);
		
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
	
	public static void accederConsola(Hashtable<String, String> htable) {
		String scaner = "";
		int control = 0;
		while(control != 4) {//bucle para repetir la actividad de pedir que hacer
			do {
				scaner = ScanString("__________________________________\n"
						+ "|Añadir producto\t pulsa 'A'|\n"
						+ "|Consultar datos\t pulsa 'C'|\n"
						+ "|Ver todo\t \t pulsa 'V'|\n"
						+ "|Modificar precio \t pulsa 'M'|\n"
						+ "|Borrar producto\t pulsa 'B'|\n"
						+ "|Salir \t \t\t pulsa 'S'|\n"
						+ "|_________________________________|\n"
						+ "Que desea hacer:\n\n");
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
					case 5:
						htable = upgrade(htable);
						break;
					case 6:
						htable = delete(htable);
						break;
				}
			}
		System.out.println("Adios");
	
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
		case "M":
			control = 5;
			break;
		case "B":
			control = 6;
			break;
		default:
			control = 0;
			break;
		}
		return control;
	}
	
	public static Hashtable<String, String> upgrade(Hashtable<String, String> htable){//modificar el precio de un producto existente
		showKeyValue(htable);		
		String sc = ScanString("De que producto quieres modificar el precio:");
		String newPrice= ScanString("Que precio quieres introducir:");

		for (String i : htable.keySet()) {
			if(i.equals(sc)) {
				htable.replace(sc, htable.get(i), newPrice);
				System.out.println("----Item update----");
				return htable;
			}
		}
		return htable;
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
		System.out.println("");
	}
	
	public static void showKeyValue(Hashtable<String, String> htable) {// mostrar en una unica fila el valor
		for (String i: htable.keySet()) {
			System.out.print(i+", ");
		}
		System.out.println();
	}
	
	public static Hashtable<String, String> delete(Hashtable<String, String> htable) {//borrar producto
		showKeyValue(htable);
		String valueSc = ScanString("Introduce que producto quieres borrar: ");
		for (String i : htable.keySet()) {
			//System.out.println("estoy recorriendo"+i);
			if(valueSc.toUpperCase().equals(i.toUpperCase())) {
				htable.remove(i);
				System.out.println("-----"+i+" Deleted-----");
				return htable;
				
			}
		}
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
