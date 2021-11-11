package practica_3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Paquete {
	String nombre, fechaInicio, fechaFin, estancia;
	int ida, vuelta;
	
	// ATRIBUTOS PARA CONSEGUIR EL NUMERO DE FACTURA
	SimpleDateFormat formato;
	Date fecha;

	Paquete() {
	}

	Paquete(String nombre, String fechaInicio, String fechaFin, Vuelo ida,
			Vuelo vuelta, Hotel estancia) throws ParseException {
		this.nombre = nombre;
		this.formato = new SimpleDateFormat("dd-MM-yyyy");
		this.fechaInicio = formato.format(fechaInicio);
		this.fechaFin = formato.format(fechaFin);
		this.ida = ida.getId();
		this.vuelta = vuelta.getId();
		this.estancia = estancia.getNombre();

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getIda() {
		return ida;
	}

	public void setIda(int ida) {
		this.ida = ida;
	}

	public int getVuelta() {
		return vuelta;
	}

	public void setVuelta(int vuelta) {
		this.vuelta = vuelta;
	}

	public String getEstancia() {
		return estancia;
	}

	public void setEstancia(String estancia) {
		this.estancia = estancia;
	}

	public String toString() {
		return "Paquete: " + nombre + "\n fecha inicio: " + fechaInicio
				+ "\n fecha fin: " + fechaFin + "\n ida: \n\t" + ida
				+ "\n vuelta: \n\t" + vuelta + "\n hotel: \n\t" + estancia
				+ "\n";
	}

}
