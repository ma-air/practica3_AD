package practica_3;
public class Vuelo {
	int id;
	String compania, origen, destino;
	float precio;

	Vuelo() {
		this.id = (int) (500 + Math.random()*1000);
		this.precio = 0;
	}

	Vuelo(int id, String compania, String origen, String destino, float precio) {
		
		this.id = id;
		this.compania = compania;
		this.origen = origen;
		this.destino = destino;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}


	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	
	public void setId(int i) {
		this.id = i;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String toString() {
		return "ID: " + id + "\n\tCompania: " + compania + "\n\tOrigen: " + origen + "\n\tDestino: " + destino + "\n\tPrecio: "
				+ precio +"\n";
	}

}
