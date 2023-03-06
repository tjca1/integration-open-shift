package br.com.integration.open.shift;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Thiago Araujo
 *
 */
@SpringBootApplication
@PropertySource("classpath:/config.properties")
@ComponentScan({ "br.com.integration" })
public class Application {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.setWebApplicationType(WebApplicationType.SERVLET);
		app.setRegisterShutdownHook(false);
		app.run(args);
	}
}
