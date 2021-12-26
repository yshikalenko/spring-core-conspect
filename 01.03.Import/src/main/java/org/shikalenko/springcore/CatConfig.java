package org.shikalenko.springcore;

import org.shikalenko.springcore.animal.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatConfig {

	@Bean
	Cat cat() {
		return new Cat();
	}
}
