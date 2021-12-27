package org.shikalenko.springcore.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PersonConfig {
	@Bean
	public Person person() {
	    return new Person();
	}	

	@Bean
	@Scope("prototype")
	public Person personPrototype() {
	    return new Person();
	}
}
