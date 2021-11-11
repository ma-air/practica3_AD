package practica_3;

public class Hotel {

	String nombre, descrp, ciudad;
	float precio;

	Hotel() {
		this.precio = 0;
	}

	Hotel(String nombre, String descrp, String ciudad, float precio) {
		this.nombre = nombre;
		this.descrp = descrp;
		this.ciudad = ciudad;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescrp() {
		return descrp;
	}

	public void setDescrp(String descrp) {
		this.descrp = descrp;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String toString() {
		return "\nNombre: " + nombre + "\n\tdescrp: " + descrp + "\n\tciudad: "
				+ ciudad + "\n\tprecio: " + precio + "\n";
	}

}
