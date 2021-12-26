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

Here, **the \*annotation-config\* tag enables annotation-based mappings**. The *component-scan* tag also tells Spring where to look for annotated classes.

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

First, let's see the [*AnnotationConfigApplicationContext* ](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/AnnotationConfigApplicationContext.html)class, which was introduced in Spring 3.0. It can take **classes annotated with \*@Configuration\*,** ***@Component**,* and JSR-330 metadata as input.

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

Thanks [*baeldung.com*](https://www.baeldung.com/spring-import-annotation)

### • @Import: working with multiple configuration files
