package org.shikalenko.springcore;

import org.shikalenko.springcore.animal.Bird;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BirdConfig {

	@Bean
	Bird bird() {
		return new Bird();
	}
}
