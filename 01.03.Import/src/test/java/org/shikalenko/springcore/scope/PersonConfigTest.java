package org.shikalenko.springcore.scope;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonConfigTest {

	private static final String NAME = "John Smith";
	private static final String CONTEXT_LOCATION = "scopes.xml";
	
	@Test
	public void givenAnnotationContextSingletonScope_whenSetName_thenEqualNames() {
		AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersonConfig.class);
		Person personA = (Person) applicationContext.getBean("person");
	    Person personB = (Person) applicationContext.getBean("person");
	    personA.setName(NAME);
	    assertEquals(NAME, personB.getName());
		applicationContext.close();
	}

	@Test
	public void givenXMLContextSingletonScope_whenSetName_thenEqualNames() {
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(CONTEXT_LOCATION);
		Person personA = (Person) applicationContext.getBean("person");
	    Person personB = (Person) applicationContext.getBean("person");
	    personA.setName(NAME);
	    assertEquals(NAME, personB.getName());
		applicationContext.close();
	}
}
