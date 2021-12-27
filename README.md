

<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [Spring Core Training](#spring-core-training)
  - [1 Introduction to Spring](#1-introduction-to-spring)
    - [• Java configuration and the Spring application context](#%E2%80%A2-java-configuration-and-the-spring-application-context)
      - [The *ApplicationContext* Interface](#the-applicationcontext-interface)
        - [The interfaces *[BeanFactory](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/BeanFactory.html)* and *[ApplicationContext](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationContext.html)* **represent the Spring IoC container**.](#the-interfaces-beanfactoryhttpsdocsspringiospring-frameworkdocscurrentjavadoc-apiorgspringframeworkbeansfactorybeanfactoryhtml-and-applicationcontexthttpsdocsspringiospring-frameworkdocscurrentjavadoc-apiorgspringframeworkcontextapplicationcontexthtml-represent-the-spring-ioc-container)
    - [• @Configuration and @Bean annotations](#%E2%80%A2-configuration-and-bean-annotations)
        - [What Is a Spring Bean?](#what-is-a-spring-bean)
        - [Java-Based Configuration](#java-based-configuration)
        - [Annotation-Based Configuration](#annotation-based-configuration)
        - [XML-Based Configuration](#xml-based-configuration)
      - [Types of *ApplicationContext*](#types-of-applicationcontext)
        - [*AnnotationConfigApplicationContext*](#annotationconfigapplicationcontext)
        - [*AnnotationConfigWebApplicationContext*](#annotationconfigwebapplicationcontext)
        - [*XmlWebApplicationContext*](#xmlwebapplicationcontext)
        - [*FileSystemXMLApplicationContext*](#filesystemxmlapplicationcontext)
        - [*ClassPathXmlApplicationContext*](#classpathxmlapplicationcontext)
    - [• @Import: working with multiple configuration files](#%E2%80%A2-import-working-with-multiple-configuration-files)
        - [Configuration and Beans](#configuration-and-beans)
        - [Grouping Configurations with *@Import*](#grouping-configurations-with-import)
        - [*@Import* vs *@ComponentScan*](#import-vs-componentscan)
        - [Conceptual Difference](#conceptual-difference)
        - [Working Together](#working-together)
    - [• Defining bean scopes](#%E2%80%A2-defining-bean-scopes)
        - [**Singleton Scope**](#singleton-scope)
        - [**Prototype Scope**](#prototype-scope)
      - [**Web Aware Scopes**](#web-aware-scopes)
        - [**Request Scope**](#request-scope)
        - [**Session Scope**](#session-scope)
        - [**Application Scope**](#application-scope)
        - [**WebSocket Scope**](#websocket-scope)
    - [•  Launching a Spring Application and obtaining Beans](#%E2%80%A2--launching-a-spring-application-and-obtaining-beans)
  - [2  Spring JAVA Configuration: A Deeper Look](#2--spring-java-configuration-a-deeper-look)
    - [•  External properties & Property sources](#%E2%80%A2--external-properties--property-sources)
        - [**Register a Properties File via Annotations**](#register-a-properties-file-via-annotations)
        - [Defining Multiple Property Locations](#defining-multiple-property-locations)
        - [**Using/Injecting Properties**](#usinginjecting-properties)
        - [**Configuration Using Raw Beans — the *PropertySourcesPlaceholderConfigurer***](#configuration-using-raw-beans--the-propertysourcesplaceholderconfigurer)
        - [**Properties in Parent-Child Contexts**](#properties-in-parent-child-contexts)
    - [•  Environment abstraction](#%E2%80%A2--environment-abstraction)
      - [Spring *Environment*](#spring-environment)
      - [A Quick Example](#a-quick-example)
        - [Implementing *EnvironmentPostProcessor*](#implementing-environmentpostprocessor)
        - [Registration in the *spring.factories*](#registration-in-the-springfactories)
        - [Access the Properties Using *@Value* Annotation](#access-the-properties-using-value-annotation)
        - [Access the Properties in Spring Boot Auto-configuration](#access-the-properties-in-spring-boot-auto-configuration)
        - [Test the Custom Implementation](#test-the-custom-implementation)
    - [•  Using bean profiles](#%E2%80%A2--using-bean-profiles)
      - [Define profile for beans](#define-profile-for-beans)
        - [**Use *@Profile* on a Bean**](#use-profile-on-a-bean)
        - [**Declare Profiles in XML**](#declare-profiles-in-xml)
      - [**Set Profiles**](#set-profiles)
        - [**Programmatically via *WebApplicationInitializer* Interface**](#programmatically-via-webapplicationinitializer-interface)
        - [**Programmatically via *ConfigurableEnvironment***](#programmatically-via-configurableenvironment)
        - [**Context Parameter in *web.xml***](#context-parameter-in-webxml)
        - [**JVM System Parameter**](#jvm-system-parameter)
        - [**Environment Variable**](#environment-variable)
        - [**Maven Profile**](#maven-profile)
        - [***@ActiveProfile* in Tests**](#activeprofile-in-tests)
      - [**The Default Profile**](#the-default-profile)
      - [**Get Active Profiles**](#get-active-profiles)
        - [Using *Environment*](#using-environment)
    - [Using *spring.profiles.active*](#using-springprofilesactive)
      - [**Example: Separate Data Source Configurations Using Profiles**](#example-separate-data-source-configurations-using-profiles)
    - [•  Spring Expression Language (SpEL)](#%E2%80%A2--spring-expression-language-spel)
      - [**Overview**](#overview)
      - [**Operators**](#operators)
        - [**Arithmetic Operators**](#arithmetic-operators)
        - [**Relational Operators**](#relational-operators)
        - [**Logical Operators**](#logical-operators)
        - [**Conditional Operators**](#conditional-operators)
        - [**Using Regex in SpEL**](#using-regex-in-spel)
        - [**Accessing *List* and *Map* Objects**](#accessing-list-and-map-objects)
        - [**Using Operators in Configuration**](#using-operators-in-configuration)
      - [**Parsing Expressions Programmatically**](#parsing-expressions-programmatically)
        - [**Using *ExpressionParser* to Set a Value**](#using-expressionparser-to-set-a-value)
        - [**Parser Configuration**](#parser-configuration)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# Spring Core Training

## 1 Introduction to Spring

###  • Java configuration and the Spring application context

Thanks [baeldung.com](https://www.baeldung.com/spring-application-context)

#### The *ApplicationContext* Interface

```java
package org.springframework.context;

public interface ApplicationContext extends EnvironmentCapable, ListableBeanFactory, HierarchicalBeanFactory,
        MessageSource, ApplicationEventPublisher, ResourcePatternResolver 
```



##### The interfaces *[BeanFactory](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/BeanFactory.html)* and *[ApplicationContext](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationContext.html)* **represent the Spring IoC container**.

org.springframework.beans.factory.[**BeanFactory**](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/BeanFactory.html)

- org.springframework.beans.factory.

  **HierarchicalBeanFactory**

  - org.springframework.context.

    **ApplicationContext** 

    (also extends org.springframework.context.ApplicationEventPublisher, org.springframework.core.env.EnvironmentCapable, org.springframework.beans.factory.ListableBeanFactory, org.springframework.context.MessageSource, org.springframework.core.io.support.

    ResourcePatternResolver)

    - org.springframework.context.[**ConfigurableApplicationContext**](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ConfigurableApplicationContext.html) (also extends java.io.[Closeable](https://docs.oracle.com/javase/8/docs/api/java/io/Closeable.html?is-external=true), org.springframework.context.[Lifecycle](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/Lifecycle.html))

*BeanFactory* is the root interface for accessing the Spring container. It provides basic functionalities for managing beans.

On the other hand, the *ApplicationContext* is a sub-interface of the *BeanFactory*. Therefore, it offers all the functionalities of *BeanFactory.*

Furthermore, it **provides** **more enterprise-specific functionalities**. The important features of *ApplicationContext* are **resolving messages, supporting internationalization, publishing events, and application-layer specific contexts**.

### • @Configuration and @Bean annotations

##### What Is a Spring Bean?

In Spring, a [bean](https://www.baeldung.com/spring-bean) is **an object that the Spring container instantiates, assembles, and manages**.

As per [Spring documentation](https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-factory-metadata) in general, we should define beans for service layer objects, data access objects (DAOs), presentation objects, infrastructure objects such as Hibernate *SessionFactories,* JMS Queues, and so forth.

Also, typically, we shouldn't configure fine-grained domain objects in the container. It's usually the responsibility of DAOs and business logic to create and load domain objects.

A bean:

```java
public class AccountService {

  @Autowired
  private AccountRepository accountRepository;

  // getters and setters
}
```



##### Java-Based Configuration

```java
@Configuration
public class AccountConfig {

  @Bean
  public AccountService accountService() {
    return new AccountService(accountRepository());
  }

  @Bean
  public AccountRepository accountRepository() {
    return new AccountRepository();
  }
}
```

##### Annotation-Based Configuration

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xmlns:context="http://www.springframework.org/schema/context"
  xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd">
  
  <context:annotation-config/>
  <context:component-scan base-package="com.baeldung.applicationcontext"/>

</beans>
```

Here, **the *annotation-config* tag enables annotation-based mappings**. The *component-scan* tag also tells Spring where to look for annotated classes.

Second, we'll create the *UserService* class and define it as a Spring bean using the *@Component* annotation:

```java
@Component
public class UserService {
  // user service code
}
```

Then we'll write a simple test case to test this configuration:

```java
ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext/user-bean-config.xml");
UserService userService = context.getBean(UserService.class);
assertNotNull(userService);
```

##### XML-Based Configuration

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="
    http://www.springframework.org/schema/beans 
    http://www.springframework.org/schema/beans/spring-beans.xsd">
      
  <bean id="accountService" class="com.baeldung.applicationcontext.AccountService">
    <constructor-arg name="accountRepository" ref="accountRepository" />
  </bean>
    
  <bean id="accountRepository" class="com.baeldung.applicationcontext.AccountRepository" />
</beans>
```

#### Types of *ApplicationContext*

##### *AnnotationConfigApplicationContext*

First, let's see the [*AnnotationConfigApplicationContext* ](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/AnnotationConfigApplicationContext.html)class, which was introduced in Spring 3.0. It can take **classes annotated with *@Configuration*,** ***@Component**,* and JSR-330 metadata as input.

So let's see a simple example of using the *AnnotationConfigApplicationContext* container with our Java-based configuration:

```java
ApplicationContext context = new AnnotationConfigApplicationContext(AccountConfig.class);
AccountService accountService = context.getBean(AccountService.class);
```

##### *AnnotationConfigWebApplicationContext*

[***AnnotationConfigWebApplicationContext*** ](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/context/support/AnnotationConfigWebApplicationContext.html)**is a web-based variant** of *AnnotationConfigApplicationContext*.

We may use this class when we configure Spring's *ContextLoaderListener* servlet listener or a Spring MVC *DispatcherServlet* in a *web.xml* file.

Moreover, from Spring 3.0 onward, we can also configure this application context container programmatically. All we need to do is implement the [*WebApplicationInitializer*](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/WebApplicationInitializer.html) interface:

```java
public class MyWebApplicationInitializer implements WebApplicationInitializer {

  public void onStartup(ServletContext container) throws ServletException {
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.register(AccountConfig.class);
    context.setServletContext(container);

    // servlet configuration
  }
}
```

##### *XmlWebApplicationContext*

If we use the **XML based configuration in a web application**, we can use the [*XmlWebApplicationContext*](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/context/support/XmlWebApplicationContext.html) class.

As a matter of fact, configuring this container is like the *AnnotationConfigWebApplicationContext* class only, which means we can configure it in *web.xml,* or implement the *WebApplicationInitializer* interface:

```java
public class MyXmlWebApplicationInitializer implements WebApplicationInitializer {

  public void onStartup(ServletContext container) throws ServletException {
    XmlWebApplicationContext context = new XmlWebApplicationContext();
    context.setConfigLocation("/WEB-INF/spring/applicationContext.xml");
    context.setServletContext(container);

    // Servlet configuration
  }
}
```

##### *FileSystemXMLApplicationContext*

We use the [*FileSystemXMLApplicationContext* ](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/support/FileSystemXmlApplicationContext.html)class to **load an XML-based Spring configuration file from the file system** or from URLs. This class is useful when we need to load the *ApplicationContext* programmatically. In general, test harnesses and standalone applications are some of the possible use cases for this.

For example, let's see how we can create this Spring container and load the beans for our XML-based configuration:

```java
String path = "C:/myProject/src/main/resources/applicationcontext/account-bean-config.xml";

ApplicationContext context = new FileSystemXmlApplicationContext(path);
AccountService accountService = context.getBean("accountService", AccountService.class);
```

#####  *ClassPathXmlApplicationContext*

In case we want to **load an XML configuration file from the classpath**, we can use the [*ClassPathXmlApplicationContext*](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/support/ClassPathXmlApplicationContext.html) class. Similar to *FileSystemXMLApplicationContext,* it's useful for test harnesses, as well as application contexts embedded within JARs.

So let's see an example of using this class:

```java
ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext/account-bean-config.xml");
AccountService accountService = context.getBean("accountService", AccountService.class);
```

### • @Import: working with multiple configuration files

Thanks [*baeldung.com*](https://www.baeldung.com/spring-import-annotation)

#####  Configuration and Beans

Let's assume that we already have prepared **three beans – *Bird*, *Cat*, and *Dog*** – each with its own configuration class.

Then, we can **provide our context with these *Config* classes**:

```java
package org.shikalenko.springcore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { BirdConfig.class, CatConfig.class, DogConfig.class })
class ConfigUnitTest {

    @Autowired
    ApplicationContext context;

    @Test
    void givenImportedBeans_whenGettingEach_shallFindIt() {
        assertThatBeanExists("dog", Dog.class);
        assertThatBeanExists("cat", Cat.class);
        assertThatBeanExists("bird", Bird.class);
    }

    private void assertThatBeanExists(String beanName, Class<?> beanClass) {
        assertTrue(context.containsBean(beanName));
        assertNotNull(context.getBean(beanClass));
    }
}
```

##### Grouping Configurations with *@Import*

There's no problem in declaring all the configurations. But **imagine the trouble to control dozens of configuration classes within different sources**. There should be a better way.

The @*Import* annotation has a solution, by its capability to group *Configuration* classes:

```java
package org.shikalenko.springcore;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ DogConfig.class, CatConfig.class })
class MammalConfiguration {
}
```

Now, we just need to remember the *mammals*:

```java
package org.shikalenko.springcore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MammalConfiguration.class})
class ConfigUnitTest2 {

    @Autowired
    ApplicationContext context;

    @Test
    void givenImportedBeans_whenGettingEach_shallFindIt() {
        assertThatBeanExists("dog", Dog.class);
        assertThatBeanExists("cat", Cat.class);
        assertFalse(context.containsBean("bird"));
    }

    private void assertThatBeanExists(String beanName, Class<?> beanClass) {
        assertTrue(context.containsBean(beanName));
        assertNotNull(context.getBean(beanClass));
    }
}
```

Well, probably we'll forget our *Bird* soon, so let's do **one more group to include all the *animal* configuration classes**:

```java
package org.shikalenko.springcore;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ MammalConfiguration.class, BirdConfig.class })
class AnimalConfiguration {
}
```

Finally, no one was left behind, and we just need to remember one class:

```java
package org.shikalenko.springcore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AnimalConfiguration.class })
class AnimalConfigUnitTest {

    @Autowired
    ApplicationContext context;

    @Test
    void givenImportedBeans_whenGettingEach_shallFindIt() {
        assertThatBeanExists("dog", Dog.class);
        assertThatBeanExists("cat", Cat.class);
        assertThatBeanExists("bird", Bird.class);
    }

    private void assertThatBeanExists(String beanName, Class<?> beanClass) {
        assertTrue(context.containsBean(beanName));
        assertNotNull(context.getBean(beanClass));
    }
}
```

##### *@Import* vs *@ComponentScan*

Before proceeding with @*Import* examples, let's have a quick stop and compare it to [@*ComponentScan*](https://www.baeldung.com/spring-component-scanning).

Both annotations can **accept any *@Component* or *@Configuration*** class.

Let's add a new @*Component* using @*Import*:

```java
package org.shikalenko.springcore;

import org.springframework.stereotype.Component;

@Component(value = "bug")
public class Bug {

}
```

```java
package org.shikalenko.springcore;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(Bug.class)
class BugConfig {
}
```

Now, the *Bug* bean is available just like any other bean.

```java
package org.shikalenko.springcore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { BugConfig.class })
class BagConfigUnitTest {

    @Autowired
    ApplicationContext context;

    @Test
    void givenImportedBeans_whenGettingEach_shallFindIt() {
        assertThatBeanExists("bug", Bug.class);
    }

    private void assertThatBeanExists(String beanName, Class<?> beanClass) {
        assertTrue(context.containsBean(beanName));
        assertNotNull(context.getBean(beanClass));
    }
}
```

##### Conceptual Difference

Simply put, we **can reach the same result with both annotations**. So, is there any difference between them?

To answer this question, let's remember that Spring generally promotes the [convention-over-configuration](https://en.wikipedia.org/wiki/Convention_over_configuration) approach. 

Making an analogy with our annotations, **@*ComponentScan* is more like convention, while @*Import* looks like configuration**.

On the other hand, **we don't want to write an @*Import* for each new component** because doing so is counterproductive.

##### Working Together

We can aim for the best of both worlds. Let's picture that we have a package only for our *animals*. It could also be a component or module and keep the same idea.

Then we can have one **@*ComponentScan* just for our *animal* package**:

```java
package org.shikalenko.springcore.animal;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AnimalScanConfiguration {
}
```

And an ***@Import* to keep control over what we'll add** to the context:

```java
package com.baeldung.importannotation.zoo;

// imports...

@Configuration
@Import(AnimalScanConfiguration.class)
class ZooApplication {
}
```

### • Defining bean scopes

Thanks [*baeldung.com*](https://www.baeldung.com/spring-bean-scopes)

he latest version of the Spring framework defines 6 types of scopes:

- singleton
- prototype
- request
- session
- application
- websocket

##### **Singleton Scope**

When we define a bean with the *singleton* scope, the container creates a single instance of that bean; all requests for that bean name will return the same object, which is cached. Any modifications to the object will be reflected in all references to the bean. This scope is the default value if no other scope is specified.

Let some configuration class having a method:

```java
@Bean
public Person person() {
    return new Person();
}
```

Because ***singleton*** scope is default that produces the singleton. We can specify it directly with the by using the *@Scope* annotation:

```java
@Bean
@Scope("singleton")
public Person person() {
    return new Person();
}
```

 We can also use a constant instead of the *String* value in the following manner:

```java
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
```

Now we can proceed to write a test that shows that two objects referring to the same bean will have the same values, even if only one of them changes their state, as they are both referencing the same bean instance:

```java
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

```

The *scopes.xml* file in this example should contain the xml definitions of the beans used:

```java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans 
    http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="personSingleton" class="org.baeldung.scopes.Person" scope="singleton"/>    
</beans>
```

##### **Prototype Scope**

A bean with the *prototype* scope will return a different instance every time it is requested from the container. It is defined by setting the value *prototype* to the *@Scope* annotation in the bean definition:

```java
@Bean
@Scope("prototype")
public Person personPrototype() {
    return new Person();
}
```

```java
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
```

We will now write a similar test as before that shows two objects requesting the same bean name with the *prototype* scope. They will have different states as they are no longer referring to the same bean instance:

```java
	private static final String NAME = "John Smith";
	private static final String NAME_OTHER = "Anna Jones";
	private static final String CONTEXT_LOCATION = "scopes.xml";

	@Test
	public void givenAnnotationContextPrototypeScope_whenSetName_thenDifferentNames() {
		AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersonConfig.class);
		Person personA = (Person) applicationContext.getBean("personPrototype");
	    Person personB = (Person) applicationContext.getBean("personPrototype");
	    personA.setName(NAME);
	    personB.setName(NAME_OTHER);
	    assertEquals(NAME, personA.getName());
	    assertEquals(NAME_OTHER, personB.getName());
		applicationContext.close();
	}

	@Test
	public void givenXMLContextPrototypeScope_whenSetName_thenDifferentNames() {
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(CONTEXT_LOCATION);
		Person personA = (Person) applicationContext.getBean("personPrototype");
	    Person personB = (Person) applicationContext.getBean("personPrototype");
	    personA.setName(NAME);
	    personB.setName(NAME_OTHER);
	    assertEquals(NAME, personA.getName());
	    assertEquals(NAME_OTHER, personB.getName());
		applicationContext.close();
	}
```

The *scopes.xml* file is similar to the one presented in the previous section while adding the xml definition for the bean with the *prototype* scope:

```xml
<bean id="personPrototype" class="org.baeldung.scopes.Person" scope="prototype"/>
```

#### **Web Aware Scopes**

As previously mentioned, there are four additional scopes that are only available in a web-aware application context. We use these less often in practice.

Let's create a class to use for instantiating the beans:

```java
public class HelloMessageGenerator {
    private String message;
    
    // standard getter and setter
}

```

##### **Request Scope**

The *request* scope creates a bean instance for a single HTTP request

```java
@Bean
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public HelloMessageGenerator helloMessageGeneratorRS() {
    return new HelloMessageGenerator();
}
```

The *proxyMode* attribute is necessary because at the moment of the instantiation of the web application context, there is no active request. Spring creates a proxy to be injected as a dependency, and instantiates the target bean when it is needed in a request.

We can also use a *@RequestScope* composed annotation that acts as a shortcut for the above definition:

```java
@Bean
@RequestScope
public HelloMessageGenerator helloMessageGeneratorRS() {
    return new HelloMessageGenerator();
}
```

Next we can define a controller that has an injected reference to the *requestScopedBean*. We need to access the same request twice in order to test the web specific scopes.

If we display the *message* each time the request is run, we can see that the value is reset to *null*, even though it is later changed in the method. This is because of a different bean instance being returned for each request.

```java
@Controller
public class ScopesController {
    @Resource(name = "helloMessageGeneratorRS")
    HelloMessageGenerator helloMessageGenerator;

    @RequestMapping("/scopes/request")
    public String getRequestScopeMessage(final Model model) {
        model.addAttribute("previousMessage", helloMessageGenerator.getMessage());
        requestScopedBean.setMessage("Good morning!");
        model.addAttribute("currentMessage", helloMessageGenerator.getMessage());
        return "scopesExample";
    }
}
```

##### **Session Scope**

The s*ession* scope creates a bean instance for an HTTP Session

```java
@Bean
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public HelloMessageGenerator helloMessageGeneratorSS() {
    return new HelloMessageGenerator();
}
```

There's also a dedicated composed annotation we can use to simplify the bean definition:

```java
@Bean
@SessionScope
public HelloMessageGenerator helloMessageGeneratorSS() {
    return new HelloMessageGenerator();
}
```

Next we define a controller with a reference to the *sessionScopedBean*. Again, we need to run two requests in order to show that the value of the *message* field is the same for the session.

In this case, when the request is made for the first time, the value *message* is *null.* However, once it is changed, that value is retained for subsequent requests as the same instance of the bean is returned for the entire session.

```java
@Controller
public class ScopesController {
    @Resource(name = "helloMessageGeneratorSS")
    HelloMessageGenerator helloMessageGenerator;

    @RequestMapping("/scopes/request")
    public String getRequestScopeMessage(final Model model) {
        model.addAttribute("previousMessage", helloMessageGenerator.getMessage());
        requestScopedBean.setMessage("Good afternoon!");
        model.addAttribute("currentMessage", helloMessageGenerator.getMessage());
        return "scopesExample";
    }
}
```

##### **Application Scope**

The *application* scope creates the bean instance for the lifecycle of a *ServletContext*.

This is similar to the *singleton* scope, but there is a very important difference with regards to the scope of the bean.

When beans are *application* scoped, the same instance of the bean is shared across multiple servlet-based applications running in the same *ServletContext*, while *singleton* scoped beans are scoped to a single application context only.

Let's create the bean with the *application* scope:

```java
@Bean
@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public HelloMessageGenerator helloMessageGeneratorAS() {
    return new HelloMessageGenerator();
}
```

Analogous to the *request* and *session* scopes, we can use a shorter version:

```java
@Bean
@ApplicationScope
public HelloMessageGenerator helloMessageGeneratorAS() {
    return new HelloMessageGenerator();
}
```

Now let's create a controller that references this bean:

```java
@Controller
public class ScopesController {
    @Resource(name = "helloMessageGeneratorAS")
    HelloMessageGenerator helloMessageGenerator;

    @RequestMapping("/scopes/request")
    public String getRequestScopeMessage(final Model model) {
        model.addAttribute("previousMessage", helloMessageGenerator.getMessage());
        requestScopedBean.setMessage("Good afternoon!");
        model.addAttribute("currentMessage", helloMessageGenerator.getMessage());
        return "scopesExample";
    }
}
```

In this case, once set in the *applicationScopedBean*, the value *message* will be retained for all subsequent requests, sessions and even for different servlet applications that will access this bean, provided it is running in the same *ServletContext.*

##### **WebSocket Scope**

The *websocket* scope creates it for a particular *WebSocket* session.

Let's create the bean with the *websocket* scope:

```java
@Bean
@Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
public HelloMessageGenerator helloMessageGeneratorWS() {
    return new HelloMessageGenerator();
}
```

When first accessed, *WebSocket* scoped beans are stored in the *WebSocket* session attributes. The same instance of the bean is then returned whenever that bean is accessed during the entire *WebSocket* session.

We can also say that it exhibits singleton behavior, but limited to a *WebSocket* session only.

### •  Launching a Spring Application and obtaining Beans

See  - [Types of *ApplicationContext*](#types-of-applicationcontext)

## 2  Spring JAVA Configuration: A Deeper Look

### •  External properties & Property sources

Thanks [*baeldung.com*](https://www.baeldung.com/properties-with-spring)

##### **Register a Properties File via Annotations**

Spring 3.1 also introduces **the new *@PropertySource* annotation** as a convenient mechanism for adding property sources to the environment.

We can use this annotation in conjunction with the *@Configuration* annotation:

```java
@Configuration
@PropertySource("classpath:foo.properties")
public class PropertiesWithJavaConfig {
    //...
}
```

Another very useful way to register a new properties file is using a placeholder, which allows us to **dynamically select the right file at runtime**:

```java
@PropertySource({ 
  "classpath:persistence-${envTarget:mysql}.properties"
})
...
```

#####  Defining Multiple Property Locations

The *@PropertySource* annotation is repeatable [according to Java 8 conventions](https://docs.oracle.com/javase/tutorial/java/annotations/repeating.html). Therefore, if we're using Java 8 or higher, we can use this annotation to define multiple property locations:

```java
@PropertySource("classpath:foo.properties")
@PropertySource("classpath:bar.properties")
public class PropertiesWithJavaConfig {
    //...
}
```

Of course, **we can also use the *@PropertySources* annotation and specify an array of *@PropertySource*.** This works in any supported Java version, not just in Java 8 or higher:

```java
@PropertySources({
    @PropertySource("classpath:foo.properties"),
    @PropertySource("classpath:bar.properties")
})
public class PropertiesWithJavaConfig {
    //...
}
```

In either case, it's worth noting that in the event of a property name collision, the last source read takes precedence.

##### **Using/Injecting Properties**

**Injecting a property with the [*@Value* annotation](https://www.baeldung.com/spring-value-annotation)** is straightforward:

```java
@Value( "${jdbc.url}" )
private String jdbcUrl;
```

**We can also specify a default value for the property:**

```java
@Value( "${jdbc.url:aDefaultUrl}" )
private String jdbcUrl;
```

The new *PropertySourcesPlaceholderConfigurer* added in Spring 3.1 **resolve ${…} placeholders within bean definition property values and *@Value* annotations**.

Finally, we can **obtain the value of a property using the *Environment* API**:

```java
@Autowired
private Environment env;
...
dataSource.setUrl(env.getProperty("jdbc.url"));
```

##### **Configuration Using Raw Beans — the *PropertySourcesPlaceholderConfigurer***

Besides the convenient methods of getting properties into Spring, we can also define and regiter the property configuration bean manually.

**Working with the *PropertySourcesPlaceholderConfigurer* gives us full control over the configuration, with the downside of being more verbose and most of the time, unnecessary.**

Let's see how we can define this bean using Java configuration:

```java
@Bean
public static PropertySourcesPlaceholderConfigurer properties(){
    PropertySourcesPlaceholderConfigurer pspc
      = new PropertySourcesPlaceholderConfigurer();
    Resource[] resources = new ClassPathResource[ ]
      { new ClassPathResource( "foo.properties" ) };
    pspc.setLocations( resources );
    pspc.setIgnoreUnresolvablePlaceholders( true );
    return pspc;
}
```

##### **Properties in Parent-Child Contexts**

This question comes up again and again: What happens when our **web application has a parent and a child context**? The parent context may have some common core functionality and beans, and then one (or multiple) child contexts, maybe containing servlet-specific beans.

f the file is **defined in the Parent context**:

- *@Value* works in **Child context**: YES

- *@Value* works in **Parent context**: YES

- *environment.getProperty* in **Child context**: YES

- *environment.getProperty* in **Parent context**: YES

If the file is **defined in the Child context**:

- *@Value* works in **Child context**: YES

- *@Value* works in **Parent context**: NO

- *environment.getProperty* in **Child context**: YES

- *environment.getProperty* in **Parent context**: NO

### •  Environment abstraction

Thanks [*baeldung.com*](https://www.baeldung.com/spring-boot-environmentpostprocessor)

#### Spring *Environment*

The *Environment* abstraction in Spring represents the environment in which the current application is running. In the meanwhile, it tends to unify the ways to access properties in a variety of property sources, such as properties files, JVM system properties, system environment variables, and servlet context parameters.

**So in most cases, customizing the *Environment* means manipulation of various properties before they're exposed to our beans.**

#### A Quick Example

Let's now build a simple price calculation application. It'll calculate the price in either gross-based or net-based mode. The system environment variables from a third party will determine which calculation mode to choose.

##### Implementing *EnvironmentPostProcessor*

To do this, let's implement the *EnvironmentPostProcessor* interface.

We'll use it to read a couple of environment variables:

```bash
calculation_mode=GROSS 
gross_calculation_tax_rate=0.15
```

And we'll use the post-processor to expose these in an application-specific way, in this case with a custom prefix:

```properties
com.baeldung.environmentpostprocessor.calculation.mode=GROSS
com.baeldung.environmentpostprocessor.gross.calculation.tax.rate=0.15
```

Then, we can quite simply add our new properties into the *Environment*:

```java
@Order(Ordered.LOWEST_PRECEDENCE)
public class PriceCalculationEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, 
      SpringApplication application) {
        PropertySource<?> system = environment.getPropertySources()
          .get(SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME);
        if (!hasOurPriceProperties(system)) {
          // error handling code omitted
        }
        Map<String, Object> prefixed = names.stream()
          .collect(Collectors.toMap(this::rename, system::getProperty));
        environment.getPropertySources()
          .addAfter(SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME, new MapPropertySource("prefixer", prefixed));
    }

}
```

Let's see what we've done here. First, **we asked *environment* to give us the PropertySource for environment variables.** Calling the resulting *system.getProperty* is similar to calling Java's *System.getenv().get.*

Then, so long as those properties exist in the environment, **we'll create a new map,** ***prefixed.*** For brevity, we'll skip the contents of *rename*, but check out the code sample for the complete implementation. **The resulting map has the same values as *system*, but with prefixed keys.**

Finally, we'll add our new *PropertySource* to the *Environment.* Now, if a bean asks for *com.baeldung.environmentpostprocessor.calculation.mode*, the *Environment* will consult our map.

Note, by the way, that [*EnvironmentPostProcessor*‘s Javadoc](https://github.com/spring-projects/spring-boot/blob/v2.1.3.RELEASE/spring-boot-project/spring-boot/src/main/java/org/springframework/boot/env/EnvironmentPostProcessor.java#L31) encourages us to either implement the *Ordered* interface or [use the *@Order* annotation](https://www.baeldung.com/spring-order).

And this is, of course, **just a single *property source***. Spring Boot allows us to cater to numerous sources and formats.

##### Registration in the *spring.factories*

To invoke the implementation in the Spring Boot bootstrap process, we need to register the class in the *META-INF/spring.factories*:

```properties
org.springframework.boot.env.EnvironmentPostProcessor=
  com.baeldung.environmentpostprocessor.PriceCalculationEnvironmentPostProcessor
```

##### Access the Properties Using *@Value* Annotation

Let's use these in a couple of classes. In the sample, we've got a *PriceCalculator* interface with two implementations: *GrossPriceCalculator* and *NetPriceCalculator.*

In our implementations, **[we can just use *@Value*](https://www.baeldung.com/spring-value-annotation) to retrieve our new properties:**

```java
public class GrossPriceCalculator implements PriceCalculator {
    @Value("${com.baeldung.environmentpostprocessor.gross.calculation.tax.rate}")
    double taxRate;

    @Override
    public double calculate(double singlePrice, int quantity) {
        //calcuation implementation omitted
    }
}
```

This is nice as it's the same way we access any other properties, like those we've defined in *application.properties.*

##### Access the Properties in Spring Boot Auto-configuration

Now, let's see a complex case where we access the preceding properties in Spring Boot autoconfiguration.

We'll create the autoconfiguration class to read those properties. This class will initialize and wire the beans in the application context according to the different property values:

```java
@Configuration
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
public class PriceCalculationAutoConfig {
    @Bean
    @ConditionalOnProperty(name = 
      "com.baeldung.environmentpostprocessor.calculation.mode", havingValue = "NET")
    @ConditionalOnMissingBean
    public PriceCalculator getNetPriceCalculator() {
        return new NetPriceCalculator();
    }

    @Bean
    @ConditionalOnProperty(name = 
      "com.baeldung.environmentpostprocessor.calculation.mode", havingValue = "GROSS")
    @ConditionalOnMissingBean
    public PriceCalculator getGrossPriceCalculator() {
        return new GrossPriceCalculator();
    }
}
```

imilar to the *EnvironmentPostProcessor* implementation, the autoconfiguration class needs to be registered in the *META-INF/spring.factories* as well:

```properties
org.springframework.boot.autoconfigure.EnableAutoConfiguration=
  com.baeldung.environmentpostprocessor.autoconfig.PriceCalculationAutoConfig
```

This works because **custom *EnvironmentPostProcessor* implementations kick in before Spring Boot autoconfiguration does**. This combination makes Spring Boot autoconfiguration more powerful.

##### Test the Custom Implementation

Now it's time to test our code. We can set the system environment variables in Windows by running:

```bash
set calculation_mode=GROSS
set gross_calculation_tax_rate=0.15
```

After that, we could start the test with the *mvn spring-boot:run* command:

```bash
mvn spring-boot:run
  -Dstart-class=com.baeldung.environmentpostprocessor.PriceCalculationApplication
  -Dspring-boot.run.arguments="100,4"
```



### •  Using bean profiles

Thanks [*baeldung.com*](https://www.baeldung.com/spring-profiles)

Profiles are a core feature of the framework — **allowing us to map our beans to different profiles** — for example, *dev*, *test*, and *prod*.

We can then activate different profiles in different environments to bootstrap only the beans we need.

#### Define profile for beans

##### **Use *@Profile* on a Bean**

**We use the *@Profile* annotation — we are mapping the bean to that particular profile**; the annotation simply takes the names of one (or multiple) profiles.

Consider a basic scenario: We have a bean that should only be active during development but not deployed in production.

We annotate that bean with a *dev* profile, and it will only be present in the container during development. In production, the *dev* simply won't be active:

```java
@Component
@Profile("dev")
public class DevDatasourceConfig
```

As a quick sidenote, profile names can also be prefixed with a NOT operator, e.g., *!dev*, to exclude them from a profile.

In the example, the component is activated only if *dev* profile is not active:

```java
@Component
@Profile("!dev")
public class ProdDatasourceConfig
```

##### **Declare Profiles in XML**

Profiles can also be configured in XML. The *<beans>* tag has a *profile* attribute, which takes comma-separated values of the applicable profiles:

```xml
<beans profile="dev">
    <bean id="devDatasourceConfig" 
      class="org.baeldung.profiles.DevDatasourceConfig" />
</beans>
```

#### **Set Profiles**

The next step is to activate and set the profiles so that the respective beans are registered in the container.

This can be done in a variety of ways, which we'll explore in the following sections.

1. Context parameter in *web.xml*
2. *WebApplicationInitializer*
3. JVM System parameter
4. Environment variable
5. Maven profile

##### **Programmatically via *WebApplicationInitializer* Interface**

In web applications, *WebApplicationInitializer* can be used to configure the *ServletContext* programmatically.

It's also a very handy location to set our active profiles programmatically:

```java
@Configuration
public class MyWebApplicationInitializer 
  implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
 
        servletContext.setInitParameter(
          "spring.profiles.active", "dev");
    }
}
```

##### **Programmatically via *ConfigurableEnvironment***

We can also set profiles directly on the environment:

```java
@Autowired
private ConfigurableEnvironment env;
...
env.setActiveProfiles("someProfile");
```

##### **Context Parameter in *web.xml***

Similarly, we can define the active profiles in the *web.xml* file of the web application, using a context parameter:

```xml
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>/WEB-INF/app-config.xml</param-value>
</context-param>
<context-param>
    <param-name>spring.profiles.active</param-name>
    <param-value>dev</param-value>
</context-param>
```

##### **JVM System Parameter**

The profile names can also be passed in via a JVM system parameter. These profiles will be activated during application startup:

```
-Dspring.profiles.active=dev
```

##### **Environment Variable**

In a Windows environment, **profiles can also be activated via the environment variable**:

```bash
set spring_profiles_active=dev
```

##### **Maven Profile**

Spring profiles can also be activated via Maven profiles, by **specifying the \*spring.profiles.active\* configuration property**.

In every Maven profile, we can set a *spring.profiles.active* property:

```xml
<profiles>
    <profile>
        <id>dev</id>
        <activation>
            <activeByDefault>true</activeByDefault>
        </activation>
        <properties>
            <spring.profiles.active>dev</spring.profiles.active>
        </properties>
    </profile>
    <profile>
        <id>prod</id>
        <properties>
            <spring.profiles.active>prod</spring.profiles.active>
        </properties>
    </profile>
</profiles>
```

**Its value will be used to replace the *@spring.profiles.active@* placeholder in *application.properties*:**

```properties
spring.profiles.active=@spring.profiles.active@
```

Now we need to enable resource filtering in *pom.xml*:

```xml
<build>
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <filtering>true</filtering>
        </resource>
    </resources>
    ...
</build>
```

and append a *-P* parameter to switch which Maven profile will be applied:

```xml
mvn clean package -Pprod
```

##### ***@ActiveProfile* in Tests**

Tests make it very easy to specify what profiles are active using the *@ActiveProfile* annotation to enable specific profiles:

```java
@ActiveProfiles("dev")
```

#### **The Default Profile**

Any bean that does not specify a profile belongs to the *default* profile.

Spring also provides a way to set the default profile when no other profile is active — by using the *spring.profiles.default* property.

#### **Get Active Profiles**

We have two ways to do it, **using *Environment* or** ***spring.active.profile*****.**

##### Using *Environment*

We can access the active profiles from the *Environment* object by injecting it:

```java
public class ProfileManager {
    @Autowired
    private Environment environment;

    public void getActiveProfiles() {
        for (String profileName : environment.getActiveProfiles()) {
            System.out.println("Currently active profile - " + profileName);
        }  
    }
}
```

### Using *spring.profiles.active*

Alternatively, we could access the profiles by injecting the property *spring.profiles.active*:

```java
@Value("${spring.profiles.active:}")
private String activeProfile;
```

Here, our *activeProfile* variable **will contain the name of the profile that is currently active**, and if there are several, it'll contain their names separated by a comma.

#### **Example: Separate Data Source Configurations Using Profiles**

Consider a scenario where **we have to maintain the data source configuration for both the development and production environments**.

Let's create a common interface *DatasourceConfig* that needs to be implemented by both data source implementations:

```java
public interface DatasourceConfig {
    public void setup();
}
```

Following is the configuration for the development environment:

```java
@Component
@Profile("dev")
public class DevDatasourceConfig implements DatasourceConfig {
    @Override
    public void setup() {
        System.out.println("Setting up datasource for DEV environment. ");
    }
}
```

And configuration for the production environment:

```java
@Component
@Profile("production")
public class ProductionDatasourceConfig implements DatasourceConfig {
    @Override
    public void setup() {
       System.out.println("Setting up datasource for PRODUCTION environment. ");
    }
}
```

Now let's create a test and inject our DatasourceConfig interface; depending on the active profile, Spring will inject *DevDatasourceConfig* or *ProductionDatasourceConfig* bean:

```java
public class SpringProfilesWithMavenPropertiesIntegrationTest {
    @Autowired
    DatasourceConfig datasourceConfig;

    public void setupDatasource() {
        datasourceConfig.setup();
    }
}
```

When the *dev* profile is active, Spring injects *DevDatasourceConfig* object, and when calling then *setup()* method, the following is the output:

```xml
Setting up datasource for DEV environment.
```

### •  Spring Expression Language (SpEL)

Thanks [*baeldung.com*](https://www.baeldung.com/spring-expression-language)

#### **Overview**

he Spring Expression Language (SpEL) is a powerful expression language that supports querying and manipulating an object graph at runtime. It can be used with XML or annotation-based Spring configurations.

There are several operators available in the language:

| **Type**    | **Operators**                                |
| ----------- | -------------------------------------------- |
| Arithmetic  | +, -, *, /, %, ^, div, mod                   |
| Relational  | <, >, ==, !=, <=, >=, lt, gt, eq, ne, le, ge |
| Logical     | and, or, not, &&, \|\|, !                    |
| Conditional | ?:                                           |
| Regex       | matches                                      |

#### **Operators**

SpEL expressions begin with the *#* symbol, and are wrapped in braces: *#{expression}*. Properties can be referenced in a similar fashion, starting with a *$* symbol, and wrapped in braces: *${property.name}*. Property placeholders cannot contain SpEL expressions, but expressions can contain property references:

```
#{${someProperty} + 2}
```

In the example above, assume *someProperty* has value 2, so resulting expression would be 2 + 2, which would be evaluated to 4.

##### **Arithmetic Operators**

All basic arithmetic operators are supported.

```java
@Value("#{19 + 1}") // 20
private double add; 

@Value("#{'String1 ' + 'string2'}") // "String1 string2"
private String addString; 

@Value("#{20 - 1}") // 19
private double subtract;

@Value("#{10 * 2}") // 20
private double multiply;

@Value("#{36 / 2}") // 19
private double divide;

@Value("#{36 div 2}") // 18, the same as for / operator
private double divideAlphabetic; 

@Value("#{37 % 10}") // 7
private double modulo;

@Value("#{37 mod 10}") // 7, the same as for % operator
private double moduloAlphabetic; 

@Value("#{2 ^ 9}") // 512
private double powerOf;

@Value("#{(2 + 2) * 2 + 9}") // 17
private double brackets;
```

Divide and modulo operations have alphabetic aliases, *div* for */* and *mod* for *%*. The *+* operator can also be used to concatenate strings.

#####  **Relational Operators**

All basic relational operations are also supported.

```java
@Value("#{1 == 1}") // true
private boolean equal;

@Value("#{1 eq 1}") // true
private boolean equalAlphabetic;

@Value("#{1 != 1}") // false
private boolean notEqual;

@Value("#{1 ne 1}") // false
private boolean notEqualAlphabetic;

@Value("#{1 < 1}") // false
private boolean lessThan;

@Value("#{1 lt 1}") // false
private boolean lessThanAlphabetic;

@Value("#{1 <= 1}") // true
private boolean lessThanOrEqual;

@Value("#{1 le 1}") // true
private boolean lessThanOrEqualAlphabetic;

@Value("#{1 > 1}") // false
private boolean greaterThan;

@Value("#{1 gt 1}") // false
private boolean greaterThanAlphabetic;

@Value("#{1 >= 1}") // true
private boolean greaterThanOrEqual;

@Value("#{1 ge 1}") // true
private boolean greaterThanOrEqualAlphabetic;
```

All relational operators have alphabetic aliases, as well. For example, in XML-based configs we can't use operators containing angle brackets (*<*, *<=,* *>*, *>=*). Instead, we can use *lt* (less than), *le* (less than or equal), *gt* (greater than), or *ge* (greater than or equal).

##### **Logical Operators**

SpEL supports all basic logical operations:

```java
@Value("#{250 > 200 && 200 < 4000}") // true
private boolean and; 

@Value("#{250 > 200 and 200 < 4000}") // true
private boolean andAlphabetic;

@Value("#{400 > 300 || 150 < 100}") // true
private boolean or;

@Value("#{400 > 300 or 150 < 100}") // true
private boolean orAlphabetic;

@Value("#{!true}") // false
private boolean not;

@Value("#{not true}") // false
private boolean notAlphabetic;
```

As with arithmetic and relational operators, all logical operators also have alphabetic clones.

##### **Conditional Operators**

Conditional operators are used for injecting different values depending on some condition:

```java
@Value("#{2 > 1 ? 'a' : 'b'}") // "a"
private String ternary;
```

Another common use for the ternary operator is to check if some variable is *null* and then return the variable value or a default:

```java
@Value("#{someBean.someProperty != null ? someBean.someProperty : 'default'}")
private String ternary;
```

The Elvis operator is a way of shortening of the ternary operator syntax for the case above used in the Groovy language. It is also available in SpEL. The code below is equivalent to the code above:

```java
@Value("#{someBean.someProperty ?: 'default'}") // Will inject provided string if someProperty is null
private String elvis;
```

#####  **Using Regex in SpEL**

The *matches* operator can be used to check whether or not a string matches a given regular expression.

```java
@Value("#{'100' matches '\\d+' }") // true
private boolean validNumericStringResult;

@Value("#{'100fghdjf' matches '\\d+' }") // false
private boolean invalidNumericStringResult;

@Value("#{'valid alphabetic string' matches '[a-zA-Z\\s]+' }") // true
private boolean validAlphabeticStringResult;

@Value("#{'invalid alphabetic string #$1' matches '[a-zA-Z\\s]+' }") // false
private boolean invalidAlphabeticStringResult;

@Value("#{someBean.someValue matches '\d+'}") // true if someValue contains only digits
private boolean validNumericValue;
```

##### **Accessing *List* and *Map* Objects**

With help of SpEL, we can access the contents of any *Map* or *List* in the context. We will create new bean *workersHolder* that will store information about some workers and their salaries in a *List* and a *Map*:

```java
@Component("workersHolder")
public class WorkersHolder {
    private List<String> workers = new LinkedList<>();
    private Map<String, Integer> salaryByWorkers = new HashMap<>();

    public WorkersHolder() {
        workers.add("John");
        workers.add("Susie");
        workers.add("Alex");
        workers.add("George");

        salaryByWorkers.put("John", 35000);
        salaryByWorkers.put("Susie", 47000);
        salaryByWorkers.put("Alex", 12000);
        salaryByWorkers.put("George", 14000);
    }

    //Getters and setters
}
```

Now we can access the values of the collections using SpEL:

```java
@Value("#{workersHolder.salaryByWorkers['John']}") // 35000
private Integer johnSalary;

@Value("#{workersHolder.salaryByWorkers['George']}") // 14000
private Integer georgeSalary;

@Value("#{workersHolder.salaryByWorkers['Susie']}") // 47000
private Integer susieSalary;

@Value("#{workersHolder.workers[0]}") // John
private String firstWorker;

@Value("#{workersHolder.workers[3]}") // George
private String lastWorker;

@Value("#{workersHolder.workers.size()}") // 4
private Integer numberOfWorkers;
```

#####  **Using Operators in Configuration**

Each operator from the first section of this article can be used in XML and annotation-based configurations. However, remember that in XML-based configuration, we can't use the angle bracket operator “<“. Instead, we should use the alphabetic aliases, such as *lt* (less than) or *le* (less than or equals). For annotation-based configurations, there are no such restrictions.

```java
public class SpelOperators {
    private boolean equal;
    private boolean notEqual;
    private boolean greaterThanOrEqual;
    private boolean and;
    private boolean or;
    private String addString;
    
    // Getters and setters
    @Override
    public String toString() {
        // toString which include all fields
    }
```

Now we will add a *spelOperators* bean to the application context:

```xml
<bean id="spelOperators" class="com.baeldung.spring.spel.SpelOperators">
   <property name="equal" value="#{1 == 1}"/>
   <property name="notEqual" value="#{1 lt 1}"/>
   <property name="greaterThanOrEqual" value="#{someCar.engine.numberOfCylinders >= 6}"/>
   <property name="and" value="#{someCar.horsePower == 250 and someCar.engine.capacity lt 4000}"/>
   <property name="or" value="#{someCar.horsePower > 300 or someCar.engine.capacity > 3000}"/>
   <property name="addString" value="#{someCar.model + ' manufactured by ' + someCar.make}"/>
</bean>
```

Retrieving that bean from the context, we can then verify that values were injected properly:

```java
ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
SpelOperators spelOperators = (SpelOperators) context.getBean("spelOperators");
```

Here we can see the output of the *toString* method of *spelOperators* bean:

```java
[equal=true, notEqual=false, greaterThanOrEqual=true, and=true, 
or=true, addString=Some model manufactured by Some make]
```

#### **Parsing Expressions Programmatically**

At times, we may want to parse expressions outside the context of configuration. Fortunately, this is possible, using *SpelExpressionParser*. We can use all operators that we saw in previous examples but should use them without braces and hash symbol. That is, if we want to use an expression with the *+* operator when used in Spring configuration, the syntax is *#{1 + 1};* when used outside of configuration, the syntax is simply *1 + 1*.

Let's look at a simple example:

```java
ExpressionParser expressionParser = new SpelExpressionParser();
Expression expression = expressionParser.parseExpression("'Any string'");
String result = (String) expression.getValue();
```

As with using SpEL in configuration, we can use it to call methods, access properties, or call constructors.

```java
Expression expression = expressionParser.parseExpression("'Any string'.length()");
Integer result = (Integer) expression.getValue();
```

Additionally, instead of directly operating on the literal, we could call the constructor:

```java
Expression expression = expressionParser.parseExpression("new String('Any string').length()");
```

We can also access the *bytes* property of *String* class, in the same way, resulting in the byte[] representation of the string:

```java
Expression expression = expressionParser.parseExpression("'Any string'.bytes");
byte[] result = (byte[]) expression.getValue();
```

We can chain method calls, just as in normal Java code:

```java
Expression expression = expressionParser.parseExpression("'Any string'.replace(\" \", \"\").length()");
Integer result = (Integer) expression.getValue();
```

The most common usage is to provide an expression string that is evaluated against a specific object instance:

```java
Car car = new Car();
car.setMake("Good manufacturer");
car.setModel("Model 3");
car.setYearOfProduction(2014);

ExpressionParser expressionParser = new SpelExpressionParser();
Expression expression = expressionParser.parseExpression("model");

EvaluationContext context = new StandardEvaluationContext(car);
String result = (String) expression.getValue(context);
```

In this case, the result will be equal to the value of the *model* field of the *car* object, “*Model 3*“. The *StandardEvaluationContext* class specifies which object the expression will be evaluated against.

It cannot be changed after the context object is created. *StandardEvaluationContext* is expensive to construct, and during repeated usage, it builds up cached state that enables subsequent expression evaluations to be performed more quickly. Because of caching it is good practice to reuse *StandardEvaluationContext* where it possible if the root object does not change.

However, if the root object is changed repeatedly, we can use the mechanism shown in the example below:

```java
Expression expression = expressionParser.parseExpression("model");
String result = (String) expression.getValue(car);
```

Here, we call the *getValue* method with an argument that represents the object to which we want to apply a SpEL expression. We can also use the generic *getValue* method, just as before:

```java
Expression expression = expressionParser.parseExpression("yearOfProduction > 2005");
boolean result = expression.getValue(car, Boolean.class);
```

##### **Using *ExpressionParser* to Set a Value**

Using the *setValue* method on the *Expression* object returned by parsing an expression, we can set values on objects. SpEL will take care of type conversion. By default, SpEL uses *org.springframework.core.convert.ConversionService*. We can create our own custom converter between types. *ConversionService* is generics aware, so it can be used with generics. Let's take a look how we can use it in practice:

```java
Car car = new Car();
car.setMake("Good manufacturer");
car.setModel("Model 3");
car.setYearOfProduction(2014);

CarPark carPark = new CarPark();
carPark.getCars().add(car);

StandardEvaluationContext context = new StandardEvaluationContext(carPark);

ExpressionParser expressionParser = new SpelExpressionParser();
expressionParser.parseExpression("cars[0].model").setValue(context, "Other model");
```

The resulting car object will have *model* “*Other model*” which was changed from “*Model 3*“.

##### **Parser Configuration**

In the previous example, we will use the following class:

```java
public class CarPark {
    private List<Car> cars = new ArrayList<>();

    // Getter and setter
}
```

It is possible to configure *ExpressionParser* by calling the constructor with a *SpelParserConfiguration* object*.* For example, if we try to add *car* object into the *cars* array of *CarPark* class without configuring the parser, we will get an error like this:

```
EL1025E:(pos 4): The collection has '0' elements, index '0' is invalid
```

We can change the behavior of the parser, to allow it to automatically create elements if the specified index is null (*autoGrowNullReferences,* the first parameter to the constructor), or to automatically grow an array or list to accommodate elements beyond its initial size (*autoGrowCollections*, the second parameter).

```java
SpelParserConfiguration config = new SpelParserConfiguration(true, true);
StandardEvaluationContext context = new StandardEvaluationContext(carPark);

ExpressionParser expressionParser = new SpelExpressionParser(config);
expressionParser.parseExpression("cars[0]").setValue(context, car);

Car result = carPark.getCars().get(0);
```

The resulting *car* object will be equal to the *car* object which was set as the first element of the *cars* array of *carPark* object from the previous example.
