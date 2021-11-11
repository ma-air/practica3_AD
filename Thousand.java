package practica_3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Thousand {

	public static void main(String[] args) throws IOException {
		ArrayList<Paquete> listaPaquete;
		Listilla agenciaViajes = new Listilla();
		Scanner entrada = new Scanner(System.in);

		// VUELOS
		Vuelo vuelo1 = new Vuelo();
		vuelo1.setCompania("Ryanair");
		vuelo1.setOrigen("Zaragoza");
		vuelo1.setDestino("Palma");
		vuelo1.setPrecio(199);
		agenciaViajes.anadirVuelo(vuelo1);

		Vuelo vuelo2 = new Vuelo();
		vuelo2.setCompania("Ryanair");
		vuelo2.setOrigen("Palma");
		vuelo2.setDestino("Zaragoza");
		vuelo2.setPrecio(204);
		agenciaViajes.anadirVuelo(vuelo2);

		Vuelo vuelo3 = new Vuelo();
		vuelo3.setCompania("Vueling");
		vuelo3.setOrigen("Madrid");
		vuelo3.setDestino("Londres");
		vuelo3.setPrecio(300);
		agenciaViajes.anadirVuelo(vuelo3);

		Vuelo vuelo4 = new Vuelo();
		vuelo4.setCompania("Vueling");
		vuelo4.setOrigen("Londres");
		vuelo4.setDestino("Madrid");
		vuelo4.setPrecio(306);
		agenciaViajes.anadirVuelo(vuelo4);

		// HOTELES
		Hotel hotel1 = new Hotel();
		hotel1.setCiudad("Palma");
		hotel1.setDescrp("SPA");
		hotel1.setNombre("NH");
		hotel1.setPrecio(80);
		agenciaViajes.anadirHotel(hotel1);

		Hotel hotel2 = new Hotel();
		hotel2.setCiudad("Londres");
		hotel2.setDescrp("WIFI");
		hotel2.setNombre("The Z Hotel Victoria");
		hotel2.setPrecio(60);
		agenciaViajes.anadirHotel(hotel2);

		// PAQUETES
		Paquete paquete1 = new Paquete();
		paquete1.setNombre("Diversion");
		paquete1.setFechaInicio("10-10-2021");
		paquete1.setFechaFin("21-10-2021");
		paquete1.setIda(vuelo1.getId());
		paquete1.setVuelta(vuelo2.getId());
		paquete1.setEstancia(hotel1.getNombre());
		agenciaViajes.anadirPaquete(paquete1);

		Paquete paquete2 = new Paquete();
		paquete2.setNombre("Carnet Joven");
		paquete2.setFechaInicio("10-10-2021");
		paquete2.setFechaFin("21-10-2021");
		paquete2.setIda(vuelo3.getId());
		paquete2.setVuelta(vuelo4.getId());
		paquete2.setEstancia(hotel2.getNombre());
		agenciaViajes.anadirPaquete(paquete2);

		boolean salir = false;
		while (!salir) {
			try {

				// FALTA ID Y FECHAS

				System.out.print("\n0. SALIR \n" + "1. Listar vuelos \n"
						+ "2. Introducir vuelo \n" + "3. Modificar vuelo \n"
						+ "4. Borrar vuelo\n" + "5. Listar hoteles \n"
						+ "6. Introducir hotel \n" + "7. Modificar hotel \n"
						+ "8. Borrar Hotel \n" + "9. Listar paquete \n"
						+ "10. Introducir paquete \n"
						+ "11. Modificar paquete \n" + "12. Borrar paquete. \n"
						+ "******ELIGE EL NUMERO DE LA PRACTICA******: ");

				int opcion = entrada.nextInt();
				entrada.nextLine();
				if (opcion == 0) {
					System.out.println("HEMOS SALIDO SATISFACTORIAMENTE");
					salir = true;
				} else if (opcion == 1) { // HECHO
					agenciaViajes.listarVuelos();
				} else if (opcion == 2) { // HECHO
					agenciaViajes.introVuelo();
				} else if (opcion == 3) { //HECHO
					agenciaViajes.modificarVuelo();
				} else if (opcion == 4) { //HECHO
					agenciaViajes.eliminarVuelo();
				} else if (opcion == 5) { // HECHO
					agenciaViajes.listarHoteles();
				} else if (opcion == 6) { // HECHO
					agenciaViajes.introHotel();
				} else if (opcion == 7) {
					agenciaViajes.modificarHotel();
				} else if (opcion == 8) {
					agenciaViajes.eliminarHotel();
				} else if (opcion == 9) { // HECHO
					agenciaViajes.listarPaquetes();
				} else if (opcion == 10) { // HECHO
					agenciaViajes.introPaquete();
				} else if (opcion == 11) {
					agenciaViajes.modificarPaquete();
				} else if (opcion == 12) {
					agenciaViajes.eliminarPaquete();
				} else {
					System.out.println("\nOpcion no contemplada en el menu. ");
				}
			} catch (InputMismatchException e) {
				System.err.println("\nDebes insertar un número\n");
				entrada.next();
			}

		}
		entrada.close();
	}
}
