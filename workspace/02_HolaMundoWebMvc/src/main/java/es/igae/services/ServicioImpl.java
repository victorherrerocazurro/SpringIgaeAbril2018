package es.igae.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.igae.entities.Cliente;
import es.igae.persistence.ClienteDao;

@Service
public class ServicioImpl implements Servicio {

	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	public String getSaludo(String nombre) {
		
		clienteDao.insertar(new Cliente(1, "Victor", "Herrero", "123456789"));
		
		return getPrefijo() + nombre + getSufijo();
	}

	private String getPrefijo() {
		return "Hola ";
	}

	private String getSufijo() {
		return " !!!";
	}

}
