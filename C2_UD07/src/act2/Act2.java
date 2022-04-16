package act2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class Act2 {

	public static void main(String[] args) {
		// list <-- articulos de compra
		// diccionario <-- producto : precio


		final double IVA = 21;
		double totalCompra = 0;
		
		List<String> listTodosArticulos = new ArrayList<String>();
		List<String> listArticulosSeleccionados = new ArrayList<String>();

		Hashtable<String, String> productosSuper = new Hashtable<String, String>();


		productosSuper = superMercado();
		
		for (String i : productosSuper.keySet()) {//llenar 1 lista, de todos los productos
			listTodosArticulos.add(i);
		}
		
		listArticulosSeleccionados = productosEscogidos(listTodosArticulos);
		System.out.println("Los objetos seleccionados son: "+listArticulosSeleccionados);
		
		if(listArticulosSeleccionados.isEmpty()) {
			System.out.println("La cesta esta vacia, gracias por su visita");
		}else{
			for (String i : listArticulosSeleccionados) {
				totalCompra  = totalCompra + Double.parseDouble(productosSuper.get(i));
			}
		}
		terminarCompra(totalCompra, listArticulosSeleccionados,IVA);
	}

	public static void terminarCompra(double precioTotalCompra, List<String> listaProductosSeleccionados, double IVA) {
		double cambioCliente = 0;
		int count= 0;
		double precioIVA = precioTotalCompra+(precioTotalCompra * IVA/100);
		DecimalFormat df = new DecimalFormat("#.00");
		
		System.out.println("\nPrecio bruto: "+ precioTotalCompra +"\tPrecio mas IVA: "+df.format(precioIVA));
		do {
			count++;
			cambioCliente = doubleScan("Cuanto nos da el cliente?");
			if(count > 1) {
				System.out.println("La cantidad tiene que ser mayor al importe final");
			}
		}
		while(cambioCliente < precioIVA);
		cambioCliente = cambioCliente - precioIVA;
		System.out.println("Total de productos comprado: "+ listaProductosSeleccionados.size());
		
		System.out.println("El cambio sera de: "+df.format(cambioCliente)+"€");
		
		
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
		Double value = 0.0;
		value = scan1.nextDouble();
		return value;
	}
	//muestra los productos en stock y devuelve una lista de los seleccionados 
	public static List<String> productosEscogidos(List<String> list){
		List<String> listArticulosSeleccionados = new ArrayList<String>();
		int control = 0;
		boolean itemNotExist = true;
		String text = "";
		while(control == 0) {
			
			itemNotExist = true;
			while(itemNotExist) {
				System.out.println("Selecciona un producto: "+list);
				text = stringScan("Escribe el producto que deseas, para salir escribre 0.");
				if(productExist(list, text)) {
					itemNotExist = false;
					System.out.println("Producto introducido correctamente al carrito!\n");
					listArticulosSeleccionados.add(text);
				}else {
					
					if(text.equals("0")) {
						control = 1;
						itemNotExist = false;
					}else {
						System.out.println("El producto indicado esta mal escrito\n");
					}
				}					
			}
		}
		return listArticulosSeleccionados;
	}
	
	//comprobar si el string coincide con algo de la lista
	public static boolean productExist(List<String> list, String text) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(text)) {
				return true;
			}
		}return false;
	}
	
	public static Hashtable<String, String> superMercado() {
		Hashtable<String, String> htable = new Hashtable<String, String>();

			
		htable.put("poma", "3.3");
		htable.put("pera", "8.10");
		htable.put("pastanaga", "5.44");
		htable.put("tomate", "2.1");
		htable.put("apio", "5.0");
		htable.put("amfetas", "13.35");
		htable.put("maria", "8.75");
		htable.put("depilady", "2.5");
		htable.put("cremacacahuete", "1.5");
		//System.out.println(htable);
		return htable;
	}

	
	
	
}
