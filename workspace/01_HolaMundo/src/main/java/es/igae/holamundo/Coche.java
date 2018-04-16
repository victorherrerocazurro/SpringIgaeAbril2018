package es.igae.holamundo;

public class Coche {
	//Dependencias = Atributos de clase
	private Conductor conductor;
	
	//Favorecemos la Inyeccion de depedencias
	public Coche(Conductor conductor) {
		this.conductor = conductor;
	}
	
	public String getNombreDeConductor() {
		return this.conductor.getNombre();
	}
}
