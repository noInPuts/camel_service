package cphbusiness.noInPuts.apache_camel;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApacheCamelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApacheCamelApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(CachingConnectionFactory cf) {
		return args -> cf.createConnection().close();
	}
}
