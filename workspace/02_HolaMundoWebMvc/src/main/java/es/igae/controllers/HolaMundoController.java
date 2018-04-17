package es.igae.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.igae.services.Servicio;

//Bean de Spring
@Controller
//PArte del filtro, comun a todos los metodos del controlador
@RequestMapping(path = "/Saludo")
public class HolaMundoController {

	//Esta anotacion indica a Spring que busque un Bean de tipo View
	//@Autowired
	//Y el Bean de tipo View debe tener como Id viewSaludo 
	//@Qualifier("viewSaludo")
	//private View viewSaludo;
	
	@Autowired
	private Servicio servicio;
	
	// Aqui tenemos que establecer el filtro para llegar a acceder este codigo
	
	//Variables del Path
	//http://localhost:8080/miApp/Saludo/Victor
	//@RequestMapping(path="/{nombre}", method = RequestMethod.GET)
	//public View saludo(Model modelo, @PathVariable String nombre) {
	
	//Parametros de la request
	//http://localhost:8080/miApp/Saludo?name=Victor&apellido=Herrero
	@RequestMapping(method = RequestMethod.GET)
	//public View saludo(Model modelo, @RequestParam(name="name") String nombre) {
	public String saludo(Map<String, Object> modelo, @RequestParam(name="name") String nombre) {
		
		//Invocamos la logica e negocio
		String saludo = servicio.getSaludo(nombre);
		
		//Vamos a crear el Modelo
		//modelo.addAttribute("saludo", saludo);
		modelo.put("saludo", saludo);
		
		//Retorno para cuando empleamos View
		//return viewSaludo;
		
		//Retorno para cuando empleamos String
		return "saludo";
	}

	// Aqui tenemos que establecer el filtro para llegar a acceder este codigo
	@RequestMapping(method = RequestMethod.POST)
	public void saludoPost() {

	}

}
