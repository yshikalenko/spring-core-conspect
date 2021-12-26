package org.shikalenko.springcore;

import org.shikalenko.springcore.animal.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DogConfig {

	@Bean
	Dog dog() {
		return new Dog();
	}
}
