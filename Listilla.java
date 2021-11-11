package practica_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import practica_4.Empleado;

public class Listilla {
	File ficheroVuelos;
	File ficheroHoteles;
	File ficheroPaquetes;

	ArrayList<Vuelo> listaVuelos;
	ArrayList<Hotel> listaHoteles;
	ArrayList<Paquete> listaPaquetes;

	// CONTRUCTOR
	Listilla() {
		this.ficheroVuelos = new File("src/Vuelos.txt");
		this.ficheroHoteles = new File("src/Hoteles.txt");
		this.ficheroPaquetes = new File("src/Paquetes.txt");
		this.listaVuelos = new ArrayList<>();
		this.listaHoteles = new ArrayList<>();
		this.listaPaquetes = new ArrayList<>();
	}

	// GETTERS & SETTERS
	public File getFicheroVuelos() {
		return ficheroVuelos;
	}

	public void setFicheroVuelos(File ficheroVuelos) {
		this.ficheroVuelos = ficheroVuelos;
	}

	public File getFicheroHoteles() {
		return ficheroHoteles;
	}

	public void setFicheroHoteles(File ficheroHoteles) {
		this.ficheroHoteles = ficheroHoteles;
	}

	public File getFicheroPaquetes() {
		return ficheroPaquetes;
	}

	public void setFicheroPaquetes(File ficheroPaquetes) {
		this.ficheroPaquetes = ficheroPaquetes;
	}

	public ArrayList<Vuelo> getListaVuelos() {
		return listaVuelos;
	}

	public void setListaVuelos(ArrayList<Vuelo> listaVuelos) {
		this.listaVuelos = listaVuelos;
	}

	public ArrayList<Hotel> getListaHoteles() {
		return listaHoteles;
	}

	public void setListaHoteles(ArrayList<Hotel> listaHoteles) {
		this.listaHoteles = listaHoteles;
	}

	public ArrayList<Paquete> getListaPaquetes() {
		return listaPaquetes;
	}

	public void setListaPaquetes(ArrayList<Paquete> listaPaquetes) {
		this.listaPaquetes = listaPaquetes;
	}

	// METODOS IMPLEMENTADOS

	// ANADIR METODOS
	public void introVuelo() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("AÑADIR VUELO");
		System.out.print("Introduce el id: ");
		int id = entrada.nextInt();
		if (!existeVuelo(id)) {
			System.out.print("Introduce la compañia: ");
			String compañia = entrada.next();
			System.out.print("Introduce el origen: ");
			String origen = entrada.next();
			System.out.print("Introduce el destino: ");
			String destino = entrada.next();
			System.out.print("introduce el precio: ");
			float precio = entrada.nextFloat();
			Vuelo aux = new Vuelo(id, compañia, origen, destino, precio);
			anadirVuelo(aux);
		} else {
			System.out.println("Ya existe el vuelo que nos dice.");
		}
	}
	public void introHotel() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("AÑADIR HOTELES");
		System.out.println("Introduce el nombre: ");
		String nombre = entrada.next();
		if (!existeHotel(nombre)) {
			System.out.println("Introduce la descripcion: ");
			String descripcion = entrada.next();
			System.out.println("Introduce la ciudad: ");
			String ciudad = entrada.next();
			System.out.println("Introduce el precio: ");
			float precio = entrada.nextFloat();
			Hotel aux = new Hotel(nombre, descripcion, ciudad, precio);
			anadirHotel(aux);
		} else {
			System.out.println("Ya existe el hotel que nos dice.");
		}
	}
	public void introPaquete() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("AÑADIR PAQUETE");
		System.out.print("Introduce el nombre: ");
		String nombre = entrada.next();
		if (!existePaquete(nombre)) {
			System.out.println("Introduce fecha de ida: ");
			String fechaIda = entrada.next();
			System.out.println("Introduce fecha de vuelta: ");
			String fechaVuelta = entrada.next();
			System.out.println("Introduce el codigo del vuelo de ida: ");
			int codigoIda = entrada.nextInt();
			if (existeVuelo(codigoIda)) {
				System.out.println("Introduce el codigo del vuelo de vuelta: ");
				int codigoVuelta = entrada.nextInt();
				if (existeVuelo(codigoVuelta)) {

					System.out.println("Introduce el hotel: ");
					String nombreHotel = entrada.next();
					if (existeHotel(nombreHotel)) {
						Paquete aux = null;
						try {
							aux = new Paquete(nombre, fechaIda, fechaVuelta,
									buscaVuelo(codigoIda),
									buscaVuelo(codigoVuelta),
									buscaHotel(nombreHotel));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						anadirPaquete(aux);
					} else {
						System.out.println("No existe ese hotel. ");
					}
				} else {
					System.out.println("No existe ese vuelo de vuelta.");
				}
			} else {
				System.out.println("No existe ese vuelo de ida.");
			}
		} else {

			System.out.println("Ya existe el vuelo que nos dice.");
		}
	}

	// EXISTENCIA
	public boolean existeVuelo(int id) {
		boolean aux = false;
		for (int i = 0; i < this.listaVuelos.size(); i++) {
			if (id == this.listaVuelos.get(i).id) {
				aux = true;
			}
		}
		return aux;
	}

	public boolean existeHotel(String nombre) {
		boolean aux = false;
		for (int i = 0; i < this.listaHoteles.size(); i++) {
			if (nombre.equals(this.listaHoteles.get(i).nombre)) {
				aux = true;
			}
		}
		return aux;
	}

	public boolean existePaquete(String nombre) {
		boolean aux = false;
		for (int i = 0; i < this.listaPaquetes.size(); i++) {
			if (nombre.equals(this.listaPaquetes.get(i).nombre)) {
				aux = true;
			}
		}
		return aux;
	}

	// BUSCAR
	public Vuelo buscaVuelo(int id) {
		Vuelo aux = new Vuelo();
		for (int i = 0; i < this.listaVuelos.size(); i++) {
			if (id == this.listaVuelos.get(i).id) {
				aux = this.listaVuelos.get(i);
			}
		}
		return aux;
	}

	public Hotel buscaHotel(String nombre) {
		Hotel aux = new Hotel();
		for (int i = 0; i < this.listaHoteles.size(); i++) {
			if (nombre.equals(this.listaHoteles.get(i).nombre)) {
				aux = this.listaHoteles.get(i);
			}
		}
		return aux;
	}
	// ANADIR A LOS ARRAYLIST
	public void anadirVuelo(Vuelo vuelo) {
		listaVuelos.add(vuelo);
		try {
			escribirVuelo();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void anadirHotel(Hotel hotel) {
		listaHoteles.add(hotel);
		try {
			escribirHotel();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void anadirPaquete(Paquete paquete) {
		listaPaquetes.add(paquete);
		try {
			escribirPaquete();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ESCRIBIR EN FICHERO LA LISTA (IMPRIMIR)
	public void escribirVuelo() throws IOException {
		try {
			FileWriter fr = new FileWriter(ficheroVuelos);
			BufferedWriter escribir = new BufferedWriter(fr);
			for (int i = 0; i < listaVuelos.size(); i++) {
				escribir.write(listaVuelos.get(i).toString());
				escribir.newLine();
			}
			escribir.close();
		} catch (FileNotFoundException e) {
			System.err.println("Error");
		}
	}

	public void escribirHotel() throws IOException {
		try {
			FileWriter fr = new FileWriter(ficheroHoteles);
			BufferedWriter escribir = new BufferedWriter(fr);
			for (int i = 0; i < listaHoteles.size(); i++) {
				escribir.write(listaHoteles.get(i).toString());
				escribir.newLine();
			}
			escribir.close();
		} catch (FileNotFoundException e) {
			System.err.println("Error");
		}
	}

	public void escribirPaquete() throws IOException {
		try {
			FileWriter fr = new FileWriter(ficheroPaquetes);

			BufferedWriter escribir = new BufferedWriter(fr);
			for (int i = 0; i < listaPaquetes.size(); i++) {
				escribir.write(listaPaquetes.get(i).toString());
				escribir.newLine();
			}
			escribir.close();
		} catch (FileNotFoundException e) {
			System.err.println("Error");
		}
	}

	// LISTAR CADA UNO DE LOS ARRAYS
	public void listarVuelos() throws IOException {
		String todo = "";
		try (BufferedReader br = new BufferedReader(
				new FileReader(this.ficheroVuelos))) {
			String linea;
			while ((linea = br.readLine()) != null)
				todo = todo + linea + "\n";
		}
		System.out.println(todo);
	}

	public void listarHoteles() throws IOException {
		String todo = "";
		try (BufferedReader br = new BufferedReader(
				new FileReader(this.ficheroHoteles))) {
			String linea;
			while ((linea = br.readLine()) != null)
				todo = todo + linea + "\n";
		}
		System.out.println(todo);
	}

	public void listarPaquetes() throws IOException {
		String todo = "";
		try (BufferedReader br = new BufferedReader(
				new FileReader(this.ficheroPaquetes))) {
			String linea;
			while ((linea = br.readLine()) != null)
				todo = todo + linea + "\n";
		}
		System.out.println(todo);
	}

	// ELIMINACIONES
	public void eliminarVuelo() {

		Scanner entrada = new Scanner(System.in);
		System.out.print(
				"Has seleccionado ELIMINAR VUELO, introduce el CODIGO del VUELO que desee modificar: ");
		int codigo = entrada.nextInt();

		try {
			if (existeVuelo(codigo) == true) {
				eliminacionV(codigo);
			} else {
				System.err.println("No existe el vuelo con codigo: " + codigo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void eliminarHotel() {
		Scanner entrada = new Scanner(System.in);
		System.out.print(
				"Has seleccionado ELIMINAR HOTEL, introduce el NOMBRE del HOTEL que desee modificar: ");
		String nombre = entrada.next();

		try {
			if (existeHotel(nombre) == true) {
				eliminacionH(nombre);
			} else {
				System.err.println("No existe el hotel: " + nombre);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void eliminarPaquete() {
		Scanner entrada = new Scanner(System.in);
		System.out.print(
				"Has seleccionado ELIMINAR PAQUETE, introduce el NOMBRE del PAQUETE que desee modificar: ");
		String nombre = entrada.next();

		try {
			if (existePaquete(nombre) == true) {
				eliminacionP(nombre);
			} else {
				System.err.println("No existe el paquete: " + nombre);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void eliminacionV(int codigo) throws IOException {

		if (existeVuelo(codigo)) {
			ArrayList<Vuelo> lista_flies = new ArrayList<Vuelo>();
			Scanner scanner;
			Scanner entrada = new Scanner(System.in);
			try {
				scanner = new Scanner(ficheroVuelos);
				int conta = -1;
				for (int i = 0; i < listaVuelos.size()
						&& scanner.hasNextLine(); i++) {
					conta++;
					String linea = scanner.next();
					Scanner delimitar = new Scanner(linea);
					int id;
					String compania, origen, destino;
					float precio;
					delimitar.useDelimiter("\s*:\s*");
					id = Integer.parseInt(scanner.next());
					scanner.next();
					compania = scanner.next();
					scanner.next();
					origen = scanner.next();
					scanner.next();
					destino = scanner.next();
					scanner.next();
					precio = Float.parseFloat(scanner.next());
					Vuelo f = new Vuelo();
					f.setId(id);
					f.setCompania(compania);
					f.setOrigen(origen);
					f.setDestino(destino);
					f.setPrecio(precio);
					lista_flies.add(f);
					if (f.getId() == codigo) {
						System.err.println(
								"Vamos a eliminar el vuelo: \n" + f.toString());
						listaVuelos.remove(conta);
						escribirVuelo();
					}
				}
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("El vuelo con ID " + codigo
					+ " no aparece en nuestra lista.");
		}
	}
	
	public void eliminacionH(String nombre) throws IOException {

		if (existeHotel(nombre)) {
			ArrayList<Hotel> lista_hotels = new ArrayList<Hotel>();
			Scanner scanner;
			Scanner entrada = new Scanner(System.in);
			try {
				scanner = new Scanner(ficheroHoteles);
				int conta = -1;
				for (int i = 0; i < listaHoteles.size()
						&& scanner.hasNextLine(); i++) {
					conta++;
					String linea = scanner.next();
					Scanner delimitar = new Scanner(linea);
					String nombreH, descrp, ciudad;
					float precio;
					delimitar.useDelimiter("\s*:\s*");
					nombreH = scanner.next();
					scanner.next();
					descrp = scanner.next();
					scanner.next();
					ciudad = scanner.next();
					scanner.next();
					precio = Float.parseFloat(scanner.next());
					Hotel ho = new Hotel();
					ho.setNombre(nombreH);
					ho.setDescrp(descrp);
					ho.setCiudad(ciudad);
					ho.setPrecio(precio);
					lista_hotels.add(ho);
					if (ho.getNombre() == nombre) {
						System.err.println(
								"Vamos a eliminar el hotel: \n" + ho.toString());
						listaHoteles.remove(conta);
						escribirHotel();
					}
				}
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("El hotel " + nombre
					+ " no aparece en nuestra lista.");
		}
	}
	
	public void eliminacionP(String nombre) throws IOException {

		if (existePaquete(nombre)) {
			ArrayList<Paquete> lista_paquetes = new ArrayList<Paquete>();
			Scanner scanner;
			Scanner entrada = new Scanner(System.in);
			try {
				scanner = new Scanner(ficheroPaquetes);
				int conta = -1;
				for (int i = 0; i < listaPaquetes.size()
						&& scanner.hasNextLine(); i++) {
					conta++;
					String linea = scanner.next();
					Scanner delimitar = new Scanner(linea);
					String nombreP, fechaInicio, fechaFin, estancia;
					int ida, vuelta;
					delimitar.useDelimiter("\s*:\s*");
					nombreP = scanner.next();
					scanner.next();
					fechaInicio = scanner.next();
					scanner.next();
					fechaFin = scanner.next();
					scanner.next();
					estancia = scanner.next();
					scanner.next();
					ida = Integer.parseInt(scanner.next());
					scanner.next();
					vuelta = Integer.parseInt(scanner.next());
					Paquete pa = new Paquete();
					pa.setNombre(nombreP);
					pa.setFechaInicio(fechaInicio);
					pa.setFechaFin(fechaFin);
					pa.setEstancia(estancia);
					pa.setIda(ida);
					pa.setVuelta(vuelta);
					lista_paquetes.add(pa);
					if (pa.getNombre() == nombre) {
						System.err.println(
								"Vamos a eliminar el paquete: \n" + pa.toString());
						listaPaquetes.remove(conta);
						escribirPaquete();
					}
				}
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("El paquete " + nombre
					+ " no aparece en nuestra lista.");
		}
	}

	// MODIFCACIONES
	public void modificarVuelo() {

		Scanner entrada = new Scanner(System.in);
		System.out.print(
				"Has seleccionado MODIFICAR VUELO, introduce el CODIGO del VUELO que desee modificar: ");
		int codigo = entrada.nextInt();

		try {
			if (existeVuelo(codigo) == true) {
				cambiarVuelo(codigo);
			} else {
				System.err.println("No existe el vuelo con codigo: " + codigo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void modificarHotel() {
		Scanner entrada = new Scanner(System.in);
		System.out.print(
				"Has seleccionado MODIFICAR HOTEL, introduce el NOMBRE del HOTEL que desee modificar: ");
		String nombre = entrada.next();

		try {
			if (existeHotel(nombre) == true) {
				cambiarHotel(nombre);
			} else {
				System.err.println("No existe el hotel: " + nombre);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void modificarPaquete() {
		Scanner entrada = new Scanner(System.in);
		System.out.print(
				"Has seleccionado MODIFICAR PAQUETE, introduce el NOMBRE del PAQUETE que desee modificar: ");
		String nombre = entrada.next();

		try {
			if (existePaquete(nombre) == true) {
				cambiarPaquete(nombre);
			} else {
				System.err.println("No existe el paquete: " + nombre);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void cambiarVuelo(int codigo) throws IOException {
		if (existeVuelo(codigo)) {
			ArrayList<Vuelo> lista_flies = new ArrayList<Vuelo>();
			Scanner scanner;
			Scanner entrada = new Scanner(System.in);
			try {
				scanner = new Scanner(ficheroVuelos);
				int conta = -1;
				for (int i = 0; i < listaVuelos.size()
						&& scanner.hasNextLine(); i++) {
					conta++;
					String linea = scanner.next();
					Scanner delimitar = new Scanner(linea);
					int id;
					String compania, origen, destino;
					float precio;
					delimitar.useDelimiter("\s*:\s*");
					id = Integer.parseInt(scanner.next());
					scanner.next();
					compania = scanner.next();
					scanner.next();
					origen = scanner.next();
					scanner.next();
					destino = scanner.next();
					scanner.next();
					precio = Float.parseFloat(scanner.next());
					Vuelo f = new Vuelo();
					f.setId(id);
					f.setCompania(compania);
					f.setOrigen(origen);
					f.setDestino(destino);
					f.setPrecio(precio);
					lista_flies.add(f);
					if (f.getId() == codigo) {
						System.err.println("Vamos a modificar el vuelo: \n"
								+ f.toString());
						System.out.print("A cuanto aumenta su precio: ");
						float price = entrada.nextFloat();
						f.setPrecio(price);
						listaVuelos.get(conta).setPrecio(price);
						escribirVuelo();
					}
				}
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("El vuelo con ID " + codigo
					+ " no aparece en nuestra lista.");
		}
	}
	public void cambiarHotel(String nombre) throws IOException {

		if (existeHotel(nombre)) {
			ArrayList<Hotel> lista_hotels = new ArrayList<Hotel>();
			Scanner scanner;
			Scanner entrada = new Scanner(System.in);
			try {
				scanner = new Scanner(ficheroHoteles);
				int conta = -1;
				for (int i = 0; i < listaHoteles.size()
						&& scanner.hasNextLine(); i++) {
					conta++;
					String linea = scanner.next();
					Scanner delimitar = new Scanner(linea);
					String nombreH, descrp, ciudad;
					float precio;
					delimitar.useDelimiter("\s*:\s*");
					nombreH = scanner.next();
					scanner.next();
					descrp = scanner.next();
					scanner.next();
					ciudad = scanner.next();
					scanner.next();
					precio = Float.parseFloat(scanner.next());
					Hotel ho = new Hotel();
					ho.setNombre(nombreH);
					ho.setDescrp(descrp);
					ho.setCiudad(ciudad);
					ho.setPrecio(precio);
					lista_hotels.add(ho);
					if (ho.getNombre() == nombre) {
						System.err.println("Vamos a modificar el hotel: \n"
								+ ho.toString());
						System.out.print("A cuanto aumenta su precio: ");
						float price = entrada.nextFloat();
						ho.setPrecio(price);
						listaHoteles.get(conta).setPrecio(price);
						escribirHotel();
					}
				}
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("El hotel " + nombre
					+ " no aparece en nuestra lista.");
		}
	}
	
	public void cambiarPaquete(String nombre) throws IOException {

		if (existePaquete(nombre)) {
			ArrayList<Paquete> lista_paquetes = new ArrayList<Paquete>();
			Scanner scanner;
			Scanner entrada = new Scanner(System.in);
			try {
				scanner = new Scanner(ficheroPaquetes);
				int conta = -1;
				for (int i = 0; i < listaPaquetes.size()
						&& scanner.hasNextLine(); i++) {
					conta++;
					String linea = scanner.next();
					Scanner delimitar = new Scanner(linea);
					String nombreP, fechaInicio, fechaFin, estancia;
					int ida, vuelta;
					delimitar.useDelimiter("\s*:\s*");
					nombreP = scanner.next();
					scanner.next();
					fechaInicio = scanner.next();
					scanner.next();
					fechaFin = scanner.next();
					scanner.next();
					estancia = scanner.next();
					scanner.next();
					ida = Integer.parseInt(scanner.next());
					scanner.next();
					vuelta = Integer.parseInt(scanner.next());
					Paquete pa = new Paquete();
					pa.setNombre(nombreP);
					pa.setFechaInicio(fechaInicio);
					pa.setFechaFin(fechaFin);
					pa.setEstancia(estancia);
					pa.setIda(ida);
					pa.setVuelta(vuelta);
					lista_paquetes.add(pa);
					if (pa.getNombre() == nombre) {
						System.err.println("Vamos a modificar el paquete: \n"
								+ pa.toString());
						System.out.print("A cuanto cambia la fecha de inicio: ");
						String fechita = entrada.next();
						pa.setFechaInicio(fechaInicio);;
						listaPaquetes.get(conta).setFechaInicio(fechita);
						escribirPaquete();
					}
				}
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("El paquete " + nombre
					+ " no aparece en nuestra lista.");
		}
	}
}