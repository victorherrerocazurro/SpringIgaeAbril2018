package es.igae.holamundo;

import java.util.logging.Logger;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AplicacionSpringXml {

	private static Logger logger = Logger.getLogger(AplicacionSpringXml.class.getName());
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		Coche coche = context.getBean("coche", Coche.class);
		
		logger.warning(coche.getNombreDeConductor());

	}

}
