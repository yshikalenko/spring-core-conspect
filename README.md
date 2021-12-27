

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

And this is, of course, **just a single property source***.* Spring Boot allows us to cater to numerous sources and formats.

##### Registration in the *spring.factories*

To invoke the implementation in the Spring Boot bootstrap process, we need to register the class in the *META-INF/spring.factories*:

```properties
org.springframework.boot.env.EnvironmentPostProcessor=
  com.baeldung.environmentpostprocessor.PriceCalculationEnvironmentPostProcessor
```

##### Access the Properties Using *@Value* Annotation

Let's use these in a couple of classes. In the sample, we've got a *PriceCalculator* interface with two implementations: *GrossPriceCalculator* and *NetPriceCalculator.*

In our implementations, **[we can just use \*@Value\*](https://www.baeldung.com/spring-value-annotation) to retrieve our new properties:**

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

