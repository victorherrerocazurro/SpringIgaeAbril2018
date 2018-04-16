package es.igae.holamundo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AplicacionSpringAnotaciones {

	private static Logger logger = Logger.getLogger(AplicacionSpringAnotaciones.class.getName());
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContext.class);
		
		Coche coche = context.getBean("coche", Coche.class);
		
		logger.warning(coche.getNombreDeConductor());

	}

}
