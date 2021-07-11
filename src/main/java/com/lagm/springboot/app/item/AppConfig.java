package com.lagm.springboot.app.item;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	// Registra el RestTemplate para usarlo mediante Autowired
	@Bean(name = "clienteRest")
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}
}
