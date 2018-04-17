package es.igae.services;

import org.springframework.stereotype.Service;

@Service
public class ServicioImpl implements Servicio {

	@Override
	public String getSaludo(String nombre) {
		return getPrefijo() + nombre + getSufijo();
	}

	private String getPrefijo() {
		return "Hola ";
	}

	private String getSufijo() {
		return " !!!";
	}

}
