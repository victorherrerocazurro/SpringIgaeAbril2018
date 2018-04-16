package es.igae.holamundo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContext {

	@Bean
	@Autowired
	public Coche coche(Conductor conductor) {
		return new Coche(conductor);
	}
	
	@Bean
	@Autowired
	public Coche coche2(Conductor conductor) {
		return new Coche(conductor);
	}
	
	@Bean
	public Conductor conductor() {
		return new ConductorFernandoAlonso();
	}
	
}
