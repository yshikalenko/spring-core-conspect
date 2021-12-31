

<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [Spring Core Training](#spring-core-training)
  - [1 Introduction to Spring](#1-introduction-to-spring)
    - [Java configuration and the Spring application context](#java-configuration-and-the-spring-application-context)
      - [The *ApplicationContext* Interface](#the-applicationcontext-interface)
        - [The interfaces *BeanFactory* and *ApplicationContext* **represent the Spring IoC container**.](#the-interfaces-beanfactory-and-applicationcontext-represent-the-spring-ioc-container)
    - [@Configuration and @Bean annotations](#configuration-and-bean-annotations)
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
    - [@Import: working with multiple configuration files](#import-working-with-multiple-configuration-files)
        - [Configuration and Beans](#configuration-and-beans)
        - [Grouping Configurations with *@Import*](#grouping-configurations-with-import)
        - [*@Import* vs *@ComponentScan*](#import-vs-componentscan)
        - [Conceptual Difference](#conceptual-difference)
        - [Working Together](#working-together)
    - [Defining bean scopes](#defining-bean-scopes)
        - [**Singleton Scope**](#singleton-scope)
        - [**Prototype Scope**](#prototype-scope)
      - [**Web Aware Scopes**](#web-aware-scopes)
        - [**Request Scope**](#request-scope)
        - [**Session Scope**](#session-scope)
        - [**Application Scope**](#application-scope)
        - [**WebSocket Scope**](#websocket-scope)
    - [Launching a Spring Application and obtaining Beans](#launching-a-spring-application-and-obtaining-beans)
  - [2  Spring JAVA Configuration: A Deeper Look](#2--spring-java-configuration-a-deeper-look)
    - [External properties & Property sources](#external-properties--property-sources)
        - [**Register a Properties File via Annotations**](#register-a-properties-file-via-annotations)
        - [Defining Multiple Property Locations](#defining-multiple-property-locations)
        - [**Using/Injecting Properties**](#usinginjecting-properties)
        - [**Configuration Using Raw Beans — the *PropertySourcesPlaceholderConfigurer***](#configuration-using-raw-beans--the-propertysourcesplaceholderconfigurer)
        - [**Properties in Parent-Child Contexts**](#properties-in-parent-child-contexts)
    - [Environment abstraction](#environment-abstraction)
      - [Spring *Environment*](#spring-environment)
      - [A Quick Example](#a-quick-example)
        - [Implementing *EnvironmentPostProcessor*](#implementing-environmentpostprocessor)
        - [Registration in the *spring.factories*](#registration-in-the-springfactories)
        - [Access the Properties Using *@Value* Annotation](#access-the-properties-using-value-annotation)
        - [Access the Properties in Spring Boot Auto-configuration](#access-the-properties-in-spring-boot-auto-configuration)
        - [Test the Custom Implementation](#test-the-custom-implementation)
    - [Using bean profiles](#using-bean-profiles)
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
    - [Spring Expression Language (SpEL)](#spring-expression-language-spel)
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
  - [3  Annotation-based Dependency Injection](#3--annotation-based-dependency-injection)
      - [**What Is Inversion of Control?**](#what-is-inversion-of-control)
      - [**What Is Dependency Injection?**](#what-is-dependency-injection)
      - [**The Spring IoC Container**](#the-spring-ioc-container)
      - [**Constructor-Based Dependency Injection**](#constructor-based-dependency-injection)
      - [**Setter-Based Dependency Injection**](#setter-based-dependency-injection)
      - [**Field-Based** **Dependency Injection**](#field-based-dependency-injection)
    - [Component scanning](#component-scanning)
      - [***@ComponentScan* Without Arguments**](#componentscan-without-arguments)
        - [**Using *@ComponentScan* in a Spring Application**](#using-componentscan-in-a-spring-application)
      - [***@ComponentScan* With Arguments**](#componentscan-with-arguments)
        - [*@ComponentScan* for Specific Packages](#componentscan-for-specific-packages)
        - [*@ComponentScan* with Exclusions](#componentscan-with-exclusions)
      - [**The Default Package**](#the-default-package)
    - [Autowiring using @Autowired](#autowiring-using-autowired)
      - [Enabling *@Autowired* Annotations](#enabling-autowired-annotations)
      - [Using *@Autowired*](#using-autowired)
        - [***@Autowired* on Properties**](#autowired-on-properties)
        - [***@Autowired* on Setters**](#autowired-on-setters)
        - [***@Autowired* on Constructors**](#autowired-on-constructors)
        - [*@Autowired* and Optional Dependencies](#autowired-and-optional-dependencies)
        - [**Autowiring by *@Qualifier***](#autowiring-by-qualifier)
        - [**Autowiring by Custom Qualifier**](#autowiring-by-custom-qualifier)
        - [**Autowiring by Name**](#autowiring-by-name)
    - [Java configuration versus annotations, mixing.](#java-configuration-versus-annotations-mixing)
      - [Java-based Container Configuration](#java-based-container-configuration)
      - [Annotation-based Container Configuration](#annotation-based-container-configuration)
      - [Mixing Java-based and Annotation-based Container Configuration](#mixing-java-based-and-annotation-based-container-configuration)
      - [Mixing XML and Annotation-based Container Configuration](#mixing-xml-and-annotation-based-container-configuration)
      - [Mixing XML and Java-based Container Configuration](#mixing-xml-and-java-based-container-configuration)
    - [Lifecycle annotations: @PostConstruct and @PreDestroy](#lifecycle-annotations-postconstruct-and-predestroy)
      - [*@PostConstruct*](#postconstruct)
      - [*@PreDestroy*](#predestroy)
      - [Java 9+](#java-9)
    - [Stereotypes and meta-annotations](#stereotypes-and-meta-annotations)
          - [Using Meta-annotations and Composed Annotations](#using-meta-annotations-and-composed-annotations)
  - [4 Factory Pattern in Spring](#4-factory-pattern-in-spring)
    - [Using Spring FactoryBeans](#using-spring-factorybeans)
      - [**The Basics of Factory Beans**](#the-basics-of-factory-beans)
        - [**Implement a *FactoryBean***](#implement-a-factorybean)
        - [**Use *FactoryBean* With XML-based Configuration**](#use-factorybean-with-xml-based-configuration)
        - [**Use *FactoryBean* With Java-based Configuration**](#use-factorybean-with-java-based-configuration)
        - [**Ways to Initialize**](#ways-to-initialize)
        - [***AbstractFactoryBean***](#abstractfactorybean)
  - [5 Advanced Spring: How Does Spring Work Internally?](#5-advanced-spring-how-does-spring-work-internally)
    - [The Spring Bean Lifecycle](#the-spring-bean-lifecycle)
      - [Spring Bean Lifecycle Overview](#spring-bean-lifecycle-overview)
      - [Aware interfaces](#aware-interfaces)
      - [Bean Factory Post Processor and Bean Post Processor](#bean-factory-post-processor-and-bean-post-processor)
    - [Bean Factory Post Processor](#bean-factory-post-processor)
    - [Bean Post Processor](#bean-post-processor)
      - [InitializingBean and DisposableBean Callback Interfaces](#initializingbean-and-disposablebean-callback-interfaces)
      - [Custom Init and Destroy Method](#custom-init-and-destroy-method)
        - [Combining Lifecycle Mechanisms](#combining-lifecycle-mechanisms)
    - [Spring Bean Proxies](#spring-bean-proxies)
      - [@Scope and scoped-proxy](#scope-and-scoped-proxy)
    - [Lookup Method Injection](#lookup-method-injection)
      - [Proxy of @Bean. Further Information About How Java-based Configuration Works Internally](#proxy-of-bean-further-information-about-how-java-based-configuration-works-internally)
    - [@Bean method return types](#bean-method-return-types)
        - [Declaring a Bean](#declaring-a-bean)
  - [6 Aspect-oriented programming](#6-aspect-oriented-programming)
    - [What problems does AOP solve?](#what-problems-does-aop-solve)
      - [What is a cross-cutting concern?](#what-is-a-cross-cutting-concern)
      - [What two problems arise if you don't solve a cross-cutting concern via AOP? **Какие две проблемы возникают, если вы не решаете сквозную проблему с помощью АОП?**](#what-two-problems-arise-if-you-dont-solve-a-cross-cutting-concern-via-aop-%D0%BA%D0%B0%D0%BA%D0%B8%D0%B5-%D0%B4%D0%B2%D0%B5-%D0%BF%D1%80%D0%BE%D0%B1%D0%BB%D0%B5%D0%BC%D1%8B-%D0%B2%D0%BE%D0%B7%D0%BD%D0%B8%D0%BA%D0%B0%D1%8E%D1%82-%D0%B5%D1%81%D0%BB%D0%B8-%D0%B2%D1%8B-%D0%BD%D0%B5-%D1%80%D0%B5%D1%88%D0%B0%D0%B5%D1%82%D0%B5-%D1%81%D0%BA%D0%B2%D0%BE%D0%B7%D0%BD%D1%83%D1%8E-%D0%BF%D1%80%D0%BE%D0%B1%D0%BB%D0%B5%D0%BC%D1%83-%D1%81-%D0%BF%D0%BE%D0%BC%D0%BE%D1%89%D1%8C%D1%8E-%D0%B0%D0%BE%D0%BF)
    - [Defining pointcut expressions](#defining-pointcut-expressions)
      - [Pointcut definition](#pointcut-definition)
        - [The annotation @Pointcut](#the-annotation-pointcut)
        - [XML  *aop:pointcut* tag](#xml--aoppointcut-tag)
      - [**Pointcut Designators**](#pointcut-designators)
        - [***execution***](#execution)
        - [***within***](#within)
        - [***this* and *target***](#this-and-target)
        - [***args***](#args)
        - [***@target***](#target)
        - [***@args***](#args)
        - [***@within***](#within)
        - [***@annotation***](#annotation)
        - [**Combining Pointcut Expressions**](#combining-pointcut-expressions)
    - [Implementing various types of advice](#implementing-various-types-of-advice)
      - [**Enabling Advice**](#enabling-advice)
        - [Spring Boot](#spring-boot)
      - [**Before Advice**](#before-advice)
      - [**After Advice**](#after-advice)
      - [**Around Advice**](#around-advice)
  - [7 Testing a Spring-based Application](#7-testing-a-spring-based-application)
    - [Spring and Test-Driven Development](#spring-and-test-driven-development)
      - [1. Introduction to Spring Testing](#1-introduction-to-spring-testing)
      - [2. Unit Testing](#2-unit-testing)
        - [2.1. Mock Objects](#21-mock-objects)
          - [Environment](#environment)
          - [JNDI](#jndi)
          - [Servlet API](#servlet-api)
          - [Spring Web Reactive](#spring-web-reactive)
        - [2.2. Unit Testing Support Classes](#22-unit-testing-support-classes)
          - [General Testing Utilities](#general-testing-utilities)
          - [Spring MVC Testing Utilities](#spring-mvc-testing-utilities)
      - [3. Integration Testing](#3-integration-testing)
        - [3.1. Overview](#31-overview)
        - [3.2. Goals of Integration Testing](#32-goals-of-integration-testing)
          - [Context Management and Caching](#context-management-and-caching)
          - [Dependency Injection of Test Fixtures](#dependency-injection-of-test-fixtures)
          - [Transaction Management](#transaction-management)
          - [Support Classes for Integration Testing](#support-classes-for-integration-testing)
        - [3.3. JDBC Testing Support](#33-jdbc-testing-support)
        - [3.4. Annotations](#34-annotations)
          - [Spring Testing Annotations](#spring-testing-annotations)
          - [Standard Annotation Support](#standard-annotation-support)
          - [Spring JUnit 4 Testing Annotations](#spring-junit-4-testing-annotations)
          - [Spring JUnit Jupiter Testing Annotations](#spring-junit-jupiter-testing-annotations)
          - [Meta-Annotation Support for Testing](#meta-annotation-support-for-testing)
        - [3.5. Spring TestContext Framework](#35-spring-testcontext-framework)
    - [Spring 5 integration testing with JUnit 5](#spring-5-integration-testing-with-junit-5)
        - [SpringExtension for JUnit Jupiter](#springextension-for-junit-jupiter)
    - [Application context caching and the @DirtiesContext annotation](#application-context-caching-and-the-dirtiescontext-annotation)
        - [Context Caching](#context-caching)
    - [Profile selection with @ActiveProfiles](#profile-selection-with-activeprofiles)
        - [`@ActiveProfiles`](#activeprofiles)
    - [Easy test data setup with @Sql](#easy-test-data-setup-with-sql)
        - [`@Sql`](#sql)
        - [`@SqlConfig`](#sqlconfig)
        - [`@SqlMergeMode`](#sqlmergemode)
        - [`@SqlGroup`](#sqlgroup)
      - [Executing SQL Scripts](#executing-sql-scripts)
        - [Executing SQL scripts programmatically](#executing-sql-scripts-programmatically)
        - [Executing SQL scripts declaratively with @Sql](#executing-sql-scripts-declaratively-with-sql)
  - [8 Data Accss and JDBC with Spring](#8-data-accss-and-jdbc-with-spring)
    - [How Spring integrates with existing data access technologies](#how-spring-integrates-with-existing-data-access-technologies)
      - [DAO Support](#dao-support)
    - [DataAccessException hierarchy](#dataaccessexception-hierarchy)
    - [Spring‘s JdbcTemplate](#springs-jdbctemplate)
      - [**1. Overview**](#1-overview)
      - [**2. Configuration**](#2-configuration)
      - [**3. The *JdbcTemplate* and Running Queries**](#3-the-jdbctemplate-and-running-queries)
        - [**3.1. Basic Queries**](#31-basic-queries)
        - [**3.2. Queries With Named Parameters**](#32-queries-with-named-parameters)
        - [**3.3. Mapping Query Results to Java Object**](#33-mapping-query-results-to-java-object)
      - [**4. Exception Translation**](#4-exception-translation)
      - [**5. JDBC Operations Using SimpleJdbc Classes**](#5-jdbc-operations-using-simplejdbc-classes)
        - [**5.1. *SimpleJdbcInsert***](#51-simplejdbcinsert)
        - [**5.2. Stored Procedures With *SimpleJdbcCall***](#52-stored-procedures-with-simplejdbccall)
      - [**6. Batch Operations**](#6-batch-operations)
        - [**6.1. Basic Batch Operations Using *JdbcTemplate***](#61-basic-batch-operations-using-jdbctemplate)
        - [**6.2. Batch Operations Using *NamedParameterJdbcTemplate***](#62-batch-operations-using-namedparameterjdbctemplate)
  - [9 Database Transactions with Spring](#9-database-transactions-with-spring)
    - [What Is a Transaction?](#what-is-a-transaction)
    - [Transactions overview](#transactions-overview)
      - [Local vs. Global Transactions](#local-vs-global-transactions)
    - [Transaction management with Spring](#transaction-management-with-spring)
      - [Programmatic vs. Declarative](#programmatic-vs-declarative)
      - [Spring Transaction Abstractions](#spring-transaction-abstractions)
    - [Transaction isolation levels](#transaction-isolation-levels)
    - [Transaction propagation rules](#transaction-propagation-rules)
      - [Transactions Support in Spring](#transactions-support-in-spring)
      - [Transactions with Spring and JPA](#transactions-with-spring-and-jpa)
        - [**1. Overview**](#1-overview-1)
        - [**2. Configure Transactions**](#2-configure-transactions)
        - [**3. Configure Transactions With XML**](#3-configure-transactions-with-xml)
        - [**4. The *@Transactional* Annotation**](#4-the-transactional-annotation)
          - [What Is *@Transactional?*](#what-is-transactional)
          - [*@Transactional* Implementation Details](#transactional-implementation-details)
          - [How to Use *@Transactional*](#how-to-use-transactional)
    - [Transaction Propagation](#transaction-propagation)
      - [1. *REQUIRED* Propagation (DEFAULT)](#1-required-propagation-default)
      - [2. *SUPPORTS* Propagation](#2-supports-propagation)
      - [3. *MANDATORY* Propagation](#3-mandatory-propagation)
      - [4. *NEVER* Propagation](#4-never-propagation)
      - [5. *NOT_SUPPORTED* Propagation](#5-not_supported-propagation)
      - [6. *REQUIRES_NEW* Propagation](#6-requires_new-propagation)
      - [7. *NESTED* Propagation](#7-nested-propagation)
    - [Transaction Isolation](#transaction-isolation)
      - [1. *DEFAULT* Isolation](#1-default-isolation)
      - [2. *READ_UNCOMMITTED* Isolation](#2-read_uncommitted-isolation)
      - [3. *READ_COMMITTED* Isolation](#3-read_committed-isolation)
      - [4. *REPEATABLE_READ* Isolation](#4-repeatable_read-isolation)
      - [5. *SERIALIZABLE* Isolation](#5-serializable-isolation)
        - [5. Potential Pitfalls](#5-potential-pitfalls)
          - [**5.1. Transactions and Proxies**](#51-transactions-and-proxies)
          - [**5.2. Changing the Isolation Level**](#52-changing-the-isolation-level)
          - [**5.3. Read-Only Transactions**](#53-read-only-transactions)
          - [**5.4. Transaction Logging**](#54-transaction-logging)
    - [Transaction rollback rules](#transaction-rollback-rules)
          - [5.5. Transaction Rollback](#55-transaction-rollback)
    - [Transactions and integration testing](#transactions-and-integration-testing)
      - [3.5.9. Transaction Management](#359-transaction-management)
        - [Test-managed Transactions](#test-managed-transactions)
        - [Enabling and Disabling Transactions](#enabling-and-disabling-transactions)
        - [Transaction Rollback and Commit Behavior](#transaction-rollback-and-commit-behavior)
        - [Programmatic Transaction Management](#programmatic-transaction-management)
        - [Running Code Outside of a Transaction](#running-code-outside-of-a-transaction)
        - [Configuring a Transaction Manager](#configuring-a-transaction-manager)
        - [Demonstration of All Transaction-related Annotations](#demonstration-of-all-transaction-related-annotations)
  - [10 Spring Boot Introduction](#10-spring-boot-introduction)
    - [Introducing Spring Boot Features](#introducing-spring-boot-features)
      - [Web Development](#web-development)
      - [SpringApplication](#springapplication)
      - [Application Events and Listeners](#application-events-and-listeners)
      - [Admin Support](#admin-support)
      - [Externalized Configuration](#externalized-configuration)
      - [YAML Support](#yaml-support)
      - [Type-safe Configuration](#type-safe-configuration)
      - [Logging](#logging)
      - [Security](#security)
    - [Core Features:](#core-features)
    - [Features:](#features)
    - [Value Proposition of Spring Boot](#value-proposition-of-spring-boot)
      - [What is Micro Service?](#what-is-micro-service)
      - [Advantages](#advantages)
      - [What is Spring Boot?](#what-is-spring-boot)
      - [Advantages](#advantages-1)
      - [Goals](#goals)
      - [Why Spring Boot?](#why-spring-boot)
    - [Creating a simple Boot application using Spring Initializer website](#creating-a-simple-boot-application-using-spring-initializer-website)
      - [Starting with Spring Initializr](#starting-with-spring-initializr)
      - [Create a Simple Web Application](#create-a-simple-web-application)
      - [Create an Application class](#create-an-application-class)
      - [Run the Application](#run-the-application)
      - [Add Unit Tests](#add-unit-tests)
  - [11 Spring Boot Dependencies, Auto-configuration, and Runtime](#11-spring-boot-dependencies-auto-configuration-and-runtime)
    - [Dependency management using Spring Boot starters](#dependency-management-using-spring-boot-starters)
      - [1. Overview](#1-overview)
      - [2. The Web Starter](#2-the-web-starter)
      - [3. The Test Starter](#3-the-test-starter)
      - [4. The Data JPA Starter](#4-the-data-jpa-starter)
      - [5. The Mail Starter](#5-the-mail-starter)
    - [• Auto-configuration](#%E2%80%A2-auto-configuration)
      - [Auto-configuration](#auto-configuration)
        - [1. Gradually Replacing Auto-configuration](#1-gradually-replacing-auto-configuration)
        - [2. Disabling Specific Auto-configuration Classes](#2-disabling-specific-auto-configuration-classes)
    - [How auto-configuration works](#how-auto-configuration-works)
      - [1. Overview](#1-overview-1)
      - [2. *@SpringBootApplication*](#2-springbootapplication)
      - [3. *@EnableAutoConfiguration*](#3-enableautoconfiguration)
      - [4. Auto-Configuration Conditions](#4-auto-configuration-conditions)
        - [4.1. *@ConditionalOnClass* and *@ConditionalOnMissingClass*](#41-conditionalonclass-and-conditionalonmissingclass)
        - [4.2. *@ConditionalOnBean* and *@ConditionalOnMissingBean*](#42-conditionalonbean-and-conditionalonmissingbean)
        - [4.3. *@ConditionalOnProperty*](#43-conditionalonproperty)
        - [4.4. *@ConditionalOnResource*](#44-conditionalonresource)
        - [4.5. *@ConditionalOnWebApplication* and *@ConditionalOnNotWebApplication*](#45-conditionalonwebapplication-and-conditionalonnotwebapplication)
        - [4.6. *@ConditionalExpression*](#46-conditionalexpression)
        - [4.7. *@Conditional*](#47-conditional)
    - [Configuration properties](#configuration-properties)
      - [1. Introduction](#1-introduction)
      - [2. Setup](#2-setup)
      - [3. Simple Properties](#3-simple-properties)
        - [3.1. Spring Boot 2.2](#31-spring-boot-22)
      - [4. Nested Properties](#4-nested-properties)
      - [5. Using *@ConfigurationProperties* on a *@Bean* Method](#5-using-configurationproperties-on-a-bean-method)
      - [6. Property Validation](#6-property-validation)
      - [7. Property Conversion](#7-property-conversion)
        - [7.1. *Duration*](#71-duration)
        - [7.2. *DataSize*](#72-datasize)
        - [7.3. Custom *Converter*](#73-custom-converter)
      - [8. Immutable *@ConfigurationProperties* Binding](#8-immutable-configurationproperties-binding)
      - [9. Java 16 *record*s](#9-java-16-records)
    - [Overriding auto-configuration](#overriding-auto-configuration)
      - [1. Overview](#1-overview-2)
      - [2. Maven Dependencies](#2-maven-dependencies)
      - [3. Creating a Custom Auto-Configuration](#3-creating-a-custom-auto-configuration)
        - [3.1. Class Conditions](#31-class-conditions)
        - [3.2. Bean Conditions](#32-bean-conditions)
        - [3.3. Property Conditions](#33-property-conditions)
        - [3.4. Resource Conditions](#34-resource-conditions)
        - [3.5. Custom Conditions](#35-custom-conditions)
        - [3.6. Application Conditions](#36-application-conditions)
      - [4. Testing the Auto-Configuration](#4-testing-the-auto-configuration)
      - [5. Disabling Auto-Configuration Classes](#5-disabling-auto-configuration-classes)
    - [Using CommandLineRunner](#using-commandlinerunner)
      - [1. Overview](#1-overview-3)
      - [2. Maven Dependencies](#2-maven-dependencies-1)
      - [3. Console Application](#3-console-application)
  - [12 JPA with Spring and Spring Data](#12-jpa-with-spring-and-spring-data)
    - [Quick introduction to ORM with JPA](#quick-introduction-to-orm-with-jpa)
      - [Defining Entities](#defining-entities)
      - [Entity Relationships](#entity-relationships)
      - [Identifiers](#identifiers)
      - [Read Operations](#read-operations)
      - [Query Criteria](#query-criteria)
      - [Pagination and Sorting](#pagination-and-sorting)
      - [Query Results](#query-results)
      - [Write Operations](#write-operations)
    - [Benefits of using Spring with JPA](#benefits-of-using-spring-with-jpa)
      - [3 reasons to use Spring Data JPA](#3-reasons-to-use-spring-data-jpa)
        - [1. No-code Repositories](#1-no-code-repositories)
        - [2. Reduced boilerplate code](#2-reduced-boilerplate-code)
        - [3. Generated queries](#3-generated-queries)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# Spring Core Training

## 1 Introduction to Spring

###  Java configuration and the Spring application context

Thanks [baeldung.com](https://www.baeldung.com/spring-application-context)

#### The *ApplicationContext* Interface

```java
package org.springframework.context;

public interface ApplicationContext extends EnvironmentCapable, ListableBeanFactory, HierarchicalBeanFactory,
        MessageSource, ApplicationEventPublisher, ResourcePatternResolver 
```



##### The interfaces *BeanFactory* and *ApplicationContext* **represent the Spring IoC container**.

org.springframework.beans.factory.[**BeanFactory**](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/BeanFactory.html)

- org.springframework.beans.factory.

  **HierarchicalBeanFactory**

  - org.springframework.context.

    [**ApplicationContext**](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationContext.html)

    (also extends org.springframework.context.ApplicationEventPublisher, org.springframework.core.env.EnvironmentCapable, org.springframework.beans.factory.ListableBeanFactory, org.springframework.context.MessageSource, org.springframework.core.io.support.

    ResourcePatternResolver)

    - org.springframework.context.[**ConfigurableApplicationContext**](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ConfigurableApplicationContext.html) (also extends java.io.[Closeable](https://docs.oracle.com/javase/8/docs/api/java/io/Closeable.html?is-external=true), org.springframework.context.[Lifecycle](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/Lifecycle.html))

*BeanFactory* is the root interface for accessing the Spring container. It provides basic functionalities for managing beans.

On the other hand, the *ApplicationContext* is a sub-interface of the *BeanFactory*. Therefore, it offers all the functionalities of *BeanFactory.*

Furthermore, it **provides** **more enterprise-specific functionalities**. The important features of *ApplicationContext* are **resolving messages, supporting internationalization, publishing events, and application-layer specific contexts**.

### @Configuration and @Bean annotations

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

### @Import: working with multiple configuration files

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

### Defining bean scopes

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

###  Launching a Spring Application and obtaining Beans

See  - [Types of *ApplicationContext*](#types-of-applicationcontext)

## 2  Spring JAVA Configuration: A Deeper Look

###  External properties & Property sources

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

###  Environment abstraction

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



###  Using bean profiles

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

Spring profiles can also be activated via Maven profiles, by **specifying the *spring.profiles.active* configuration property**.

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

###  Spring Expression Language (SpEL)

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

## 3  Annotation-based Dependency Injection

Thanks [*baeldung.com*](https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring)

We'll introduce the concepts of IoC (Inversion of Control) and DI (Dependency Injection), as well as take a look at how these are implemented in the Spring framework.

#### **What Is Inversion of Control?**

Inversion of Control is a principle in software engineering which transfers the control of objects or portions of a program to a container or framework. 

n contrast with traditional programming, in which our custom code makes calls to a library, IoC enables a framework to take control of the flow of a program and make calls to our custom code. To enable this, frameworks use abstractions with additional behavior built in. **If we want to add our own behavior, we need to extend the classes of the framework or plugin our own classes.**

The advantages of this architecture are:

- decoupling the execution of a task from its implementation
- making it easier to switch between different implementations
- greater modularity of a program
- greater ease in testing a program by isolating a component or mocking its dependencies, and allowing components to communicate through contracts

We can achieve Inversion of Control through various mechanisms such as: Strategy design pattern, Service Locator pattern, Factory pattern, and Dependency Injection (DI).

We're going to look at DI next.

#### **What Is Dependency Injection?**

Dependency injection is a pattern we can use to implement IoC, where the control being inverted is setting an object's dependencies.

Here's how we would create an object dependency in traditional programming:

```java
public class Store {
    private Item item;
 
    public Store() {
        item = new ItemImpl1();    
    }
}
```

In the example above, we need to instantiate an implementation of the *Item* interface within the *Store* class itself.

By using DI, we can rewrite the example without specifying the implementation of the *Item* that we want:

```java
public class Store {
    private Item item;
    public Store(Item item) {
        this.item = item;
    }
}
```

#### **The Spring IoC Container**

In the Spring framework, the interface *ApplicationContext* represents the IoC container. The Spring container is responsible for instantiating, configuring and assembling objects known as *beans*, as well as managing their life cycles.

The Spring framework provides several implementations of the *ApplicationContext* interface: *ClassPathXmlApplicationContext* and *FileSystemXmlApplicationContext* for standalone applications, and *WebApplicationContext* for web applications. See [Types of *ApplicationContext*](#types-of-applicationcontext)

Here's one way to manually instantiate a container:

```java
ApplicationContext context
  = new ClassPathXmlApplicationContext("applicationContext.xml");
```

o set the *item* attribute in the example above, we can use metadata. Then the container will read this metadata and use it to assemble beans at runtime.

**Dependency Injection in Spring can be done through constructors, setters or fields.**

#### **Constructor-Based Dependency Injection**

In the case of [constructor-based dependency injection](https://www.baeldung.com/constructor-injection-in-spring), the container will invoke a constructor with arguments each representing a dependency we want to set.

Spring resolves each argument primarily by type, followed by name of the attribute, and index for disambiguation. Let's see the configuration of a bean and its dependencies using annotations:

```java
@Configuration
public class AppConfig {

    @Bean
    public Item item1() {
        return new ItemImpl1();
    }

    @Bean
    public Store store() {
        return new Store(item1());
    }
}
```

Another way to create the configuration of the beans is through XML configuration:

```xml
<bean id="item1" class="org.baeldung.store.ItemImpl1" /> 
<bean id="store" class="org.baeldung.store.Store"> 
    <constructor-arg type="ItemImpl1" index="0" name="item" ref="item1" /> 
</bean>
```

#### **Setter-Based Dependency Injection**

For setter-based DI, the container will call setter methods of our class after invoking a no-argument constructor or no-argument static factory method to instantiate the bean. Let's create this configuration using annotations:

```java
@Bean
public Store store() {
    Store store = new Store();
    store.setItem(item1());
    return store;
}
```

We can also use XML for the same configuration of beans:

```xml
<bean id="store" class="org.baeldung.store.Store">
    <property name="item" ref="item1" />
</bean>
```

We can combine constructor-based and setter-based types of injection for the same bean. The Spring documentation recommends using constructor-based injection for mandatory dependencies, and setter-based injection for optional ones.

#### **Field-Based** **Dependency Injection**

In case of Field-Based DI, we can inject the dependencies by marking them with an *@Autowired* annotation:

```java
public class Store {
    @Autowired
    private Item item; 
}
```

While constructing the *Store* object, if there's no constructor or setter method to inject the *Item* bean, the container will use reflection to inject *Item* into *Store*.

This approach might look simpler and cleaner, but we don't recommend using it because it has a few drawbacks such as:

- This method uses reflection to inject the dependencies, which is costlier than constructor-based or setter-based injection.
- It's really easy to keep adding multiple dependencies using this approach. If we were using constructor injection, having multiple arguments would make us think that the class does more than one thing, which can violate the Single Responsibility Principle.

###  Component scanning

Thanks [*baeldung.com*](https://www.baeldung.com/spring-component-scanning)

We'll cover component scanning in Spring. When working with Spring, we can annotate our classes in order to make them into Spring beans. Furthermore, **we can tell Spring where to search for these annotated classes,** as not all of them must become beans in this particular run.

Of course, there are some defaults for component scanning, but we can also customize the packages for search.

#### ***@ComponentScan* Without Arguments**

##### **Using *@ComponentScan* in a Spring Application**

With Spring, **we use the *@ComponentScan* annotation along with the *@Configuration* annotation to specify the packages that we want to be scanned**. *@ComponentScan* without arguments tells Spring to scan the current package and all of its sub-packages.

Let's say we have the following *@Configuration* in *com.baeldung.componentscan.springapp* package:

```java
@Configuration
@ComponentScan
public class SpringComponentScanApp {
    private static ApplicationContext applicationContext;

    @Bean
    public ExampleBean exampleBean() {
        return new ExampleBean();
    }

    public static void main(String[] args) {
        applicationContext = 
          new AnnotationConfigApplicationContext(SpringComponentScanApp.class);

        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }
}
```

In addition, we have the *Cat* and *Dog* components in *com.baeldung.componentscan.springapp.animals* package:

```java
package com.baeldung.componentscan.springapp.animals;
// ...
@Component
public class Cat {}
package com.baeldung.componentscan.springapp.animals;
// ...
@Component
public class Dog {}
```

Finally, we have the *Rose* component in *com.baeldung.componentscan.springapp.flowers* package:

```java
package com.baeldung.componentscan.springapp.flowers;
// ...
@Component
public class Rose {}
```

The output of the *main()* method will contain all the beans of *com.baeldung.componentscan.springapp* package and its sub-packages:

```plaintext
springComponentScanApp
cat
dog
rose
exampleBean
```

Note that the main application class is also a bean, as it's annotated with *@Configuration,* which is a *@Component*.

We should also note that the main application class and the configuration class are not necessarily the same. If they are different, it doesn't matter where we put the main application class. **Only the location of the configuration class matters, as component scanning starts from its package by default**.

Finally, note that in our example, *@ComponentScan* is equivalent to:

```java
@ComponentScan(basePackages = "com.baeldung.componentscan.springapp")
```

The *basePackages* argument is a package or an array of packages for scanning

#### ***@ComponentScan* With Arguments**

Now let's customize the paths for scanning. For example, let's say we want to exclude the *com.baeldung.componentscan.springapp.flowers.Rose* bean.

##### *@ComponentScan* for Specific Packages

We can do this a few different ways. First, we can change the base package:

```java
@ComponentScan(basePackages = "com.baeldung.componentscan.springapp.animals")
@Configuration
public class SpringComponentScanApp {
   // ...
}
```

Now the output will be:

```plaintext
springComponentScanApp
cat
dog
exampleBean
```

Let's see what's behind this:

- *springComponentScanApp* is created as it's a configuration passed as an argument to the *AnnotationConfigApplicationContext*
- *exampleBean* is a bean configured inside the configuration
- *cat* and *dog* are in the specified *com.baeldung.componentscan.springapp.animals* package

##### *@ComponentScan* with Exclusions

Another way is to use a filter, specifying the pattern for the classes to exclude:

```java
@ComponentScan(excludeFilters = 
  @ComponentScan.Filter(type=FilterType.REGEX,
    pattern="com\\.baeldung\\.componentscan\\.springapp\\.flowers\\..*"))
```

We can also choose a different filter type, as **the annotation supports several [flexible options for filtering](https://www.baeldung.com/spring-componentscan-filter-type) the scanned classes**:

```java
@ComponentScan(excludeFilters = 
  @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Rose.class))
```

#### **The Default Package**

We should avoid putting the *@Configuration* class [in the default package](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-structuring-your-code.html) (i.e. by not specifying the package at all). If we do, Spring scans all the classes in all jars in a classpath, which causes errors and the application probably doesn't start.

### Autowiring using @Autowired

Thanks [*baeldung.com*](https://www.baeldung.com/spring-autowire)

We'll first take a look at how to enable autowiring and the various ways to autowire beans. Afterward, we'll talk about **resolving bean conflicts using *@Qualifier* annotation,** as well as potential exception scenarios.

#### Enabling *@Autowired* Annotations

The Spring framework enables automatic dependency injection. In other words, **by declaring all the bean dependencies in a Spring configuration file, Spring container can autowire relationships between collaborating beans**. This is called ***Spring bean autowiring***.

To use Java-based configuration in our application, let's enable annotation-driven injection to load our Spring configuration:

```java
@Configuration
@ComponentScan("com.baeldung.autowire.sample")
public class AppConfig {}
```

Alternatively, the *\<context:annotation-config/\>* annotation is mainly used to activate the dependency injection annotations in Spring XML files.

#### Using *@Autowired*

After [enabling annotation injection](#enabling-autowired-annotations), **we can use autowiring on properties, setters, and constructors**.

##### ***@Autowired* on Properties**

First, let's define a provider bean:

```java
@Component("fooFormatter")
public class FooFormatter {
    public String format() {
        return "foo";
    }
}
```

Then, we'll inject this bean into a consumer bean using *@Autowired* on the field definition:

```java
@Component
public class FooService {  
    @Autowired
    private FooFormatter fooFormatter;
}
```

As a result, Spring injects *fooFormatter* when *FooService* is created.

##### ***@Autowired* on Setters**

Now let's try adding *@Autowired* annotation on a setter method.

In the following example, the setter method is called with the instance of *FooFormatter* when *FooService* is created:

```java
public class FooService {
    private FooFormatter fooFormatter;
    @Autowired
    public void setFooFormatter(FooFormatter fooFormatter) {
        this.fooFormatter = fooFormatter;
    }
}
```

##### ***@Autowired* on Constructors**

Finally, let's use *@Autowired* on a constructor.

We'll see that an instance of *FooFormatter* is injected by Spring as an argument to the *FooService* constructor:

```java
public class FooService {
    private FooFormatter fooFormatter;
    @Autowired
    public FooService(FooFormatter fooFormatter) {
        this.fooFormatter = fooFormatter;
    }
}
```

##### *@Autowired* and Optional Dependencies

When a bean is being constructed, the *@Autowired* dependencies should be available. Otherwise, **if Spring cannot resolve a bean for wiring, it will throw an exception**.

Consequently, it prevents the Spring container from launching successfully with an exception of the form:

```plaintext
Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: 
No qualifying bean of type [com.autowire.sample.FooDAO] found for dependency: 
expected at least 1 bean which qualifies as autowire candidate for this dependency. 
Dependency annotations: 
{@org.springframework.beans.factory.annotation.Autowired(required=true)}
```

To fix this, we need to declare a bean of the required type:

```java
public class FooService {
    @Autowired(required = false)
    private FooDAO dataAccessor; 
}
```

##### **Autowiring by *@Qualifier***

For instance, let's see how we can use the [*@Qualifier*](https://www.baeldung.com/spring-qualifier-annotation) annotation to indicate the required bean.

First, we'll define 2 beans of type *Formatter*:

```java
@Component("fooFormatter")
public class FooFormatter implements Formatter {
    public String format() {
        return "foo";
    }
}
@Component("barFormatter")
public class BarFormatter implements Formatter {
    public String format() {
        return "bar";
    }
}
```

Now let's try to inject a *Formatter* bean into the *FooService* class:

```java
public class FooService {
    @Autowired
    private Formatter formatter;
}
```

In our example, there are two concrete implementations of *Formatter* available for the Spring container. As a result, **Spring will throw a *NoUniqueBeanDefinitionException* exception when constructing the *FooService***:*
*

```plaintext
Caused by: org.springframework.beans.factory.NoUniqueBeanDefinitionException: 
No qualifying bean of type [com.autowire.sample.Formatter] is defined: 
expected single matching bean but found 2: barFormatter,fooFormatter
```

**We can avoid this by narrowing the implementation using a *@Qualifier* annotation:**

```java
public class FooService {
    @Autowired
    @Qualifier("fooFormatter")
    private Formatter formatter;
}
```

When there are multiple beans of the same type, it's a good idea to **use *@Qualifier* to avoid ambiguity.**

Please note that the value of the *@Qualifier* annotation matches with the name declared in the *@Component* annotation of our *FooFormatter* implementation.

##### **Autowiring by Custom Qualifier**

Spring also allows us to **create our own custom *@Qualifier* annotation**. To do so, we should provide the *@Qualifier* annotation with the definition:

```java
@Qualifier
@Target({
  ElementType.FIELD, ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FormatterType {  
    String value();
}
```

Then we can use the *FormatterType* within various implementations to specify a custom value:

```java
@FormatterType("Foo")
@Component
public class FooFormatter implements Formatter {
    public String format() {
        return "foo";
    }
}
@FormatterType("Bar")
@Component
public class BarFormatter implements Formatter {
    public String format() {
        return "bar";
    }
}
```

Finally, our custom Qualifier annotation is ready to use for autowiring:

```java
@Component
public class FooService {  
    @Autowired
    @FormatterType("Foo")
    private Formatter formatter;
}
```

The value specified in the ***@Target* meta-annotation restricts where to apply the qualifier,** which in our example is fields, methods, types, and parameters.

##### **Autowiring by Name**

**Spring uses the bean's name as a default qualifier value.** It will inspect the container and look for a bean with the exact name as the property to autowire it.

Hence, in our example, Spring matches the *fooFormatter* property name to the *FooFormatter* implementation. Therefore, it injects that specific implementation when constructing *FooService*:

```java
public class FooService {
   @Autowired 
   private Formatter fooFormatter; 
}
```

### Java configuration versus annotations, mixing.

#### Java-based Container Configuration

[docs.spring.io](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-java)

```java
@Configuration
public class AppConfig {

    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
}
```

```java
public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    MyService myService = ctx.getBean(MyService.class);
    myService.doStuff();
}
```

#### Annotation-based Container Configuration

[docs.spring.io](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-annotation-config)

```java
public class MovieRecommender {

    private final CustomerPreferenceDao customerPreferenceDao;

    @Autowired
    public MovieRecommender(CustomerPreferenceDao customerPreferenceDao) {
        this.customerPreferenceDao = customerPreferenceDao;
    }

    // ...
}
```

#### Mixing Java-based and Annotation-based Container Configuration



```java
@Configuration
@ComponentScan
public class SpringComponentScanApp {
    private static ApplicationContext applicationContext;

    @Bean
    public ExampleBean exampleBean() {
        return new ExampleBean();
    }

    public static void main(String[] args) {
        applicationContext = 
          new AnnotationConfigApplicationContext(SpringComponentScanApp.class);

        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }
}
```

#### Mixing XML and Annotation-based Container Configuration

XML Configuration can be mixed with component scan for bean definition annotations:

```xml
?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xmlns:context="http://www.springframework.org/schema/context"
      xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd">

  <context:annotation-config/>
  <context:component-scan base-package="guru.springframework.springbeanlifecycle.custominitanddestroy.domain"/>
</beans>
```

The application should instantiate context in the same way as pure XML context.

For *context.xml* in *classpath*:

```java
ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
```



#### Mixing XML and Java-based Container Configuration

Spring’s `@Configuration` class support does not aim to be a 100% complete replacement for Spring XML. XML Configuration can be mixed with java configuration by using, for example, `ClassPathXmlApplicationContext`, or instantiate it in a “Java-centric” way by using `AnnotationConfigApplicationContext` and the `@ImportResource` annotation to import XML as needed:

The following example shows an ordinary configuration class in Java:

```java
@Configuration
public class AppConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public AccountRepository accountRepository() {
        return new JdbcAccountRepository(dataSource);
    }

    @Bean
    public TransferService transferService() {
        return new TransferService(accountRepository());
    }
}
```

The following example shows part of a sample `system-test-config.xml` file:

```xml
<beans>
    <!-- enable processing of annotations such as @Autowired and @Configuration -->
    <context:annotation-config/>
    <context:property-placeholder location="classpath:/com/acme/jdbc.properties"/>

    <bean class="com.acme.AppConfig"/>

    <bean class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>
</beans>
```

The following example shows a possible `jdbc.properties` file:

```properties
jdbc.url=jdbc:hsqldb:hsql://localhost/xdb
jdbc.username=sa
jdbc.password=
```

Instancing the context:

```java
public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/com/acme/system-test-config.xml");
    TransferService transferService = ctx.getBean(TransferService.class);
    // ...
}
```

### Lifecycle annotations: @PostConstruct and @PreDestroy

Thanks [*baeldung.com*](https://www.baeldung.com/spring-postconstruct-predestroy)

Spring allows us to attach custom actions to [bean creation and destruction](https://www.baeldung.com/running-setup-logic-on-startup-in-spring). We can, for example, do it by implementing the *InitializingBean* and *DisposableBean* interfaces.

We'll look at a second possibility: the *@PostConstruct* and *@PreDestroy* annotations.

#### *@PostConstruct*

**Spring calls methods annotated with *@PostConstruct* only once, just after the initialization of bean properties**. Keep in mind that these methods will run even if there is nothing to initialize.

The method annotated with *@PostConstruct* can have any access level but it can't be static.

One example usage of *@PostConstruct* is populating a database. During development, for instance, we might want to create some default users:

```java
@Component
public class DbInit {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void postConstruct() {
        User admin = new User("admin", "admin password");
        User normalUser = new User("user", "user password");
        userRepository.save(admin, normalUser);
    }
}
```

The above example will first initialize *UserRepository* and then run *@PostConstruct* method.

#### *@PreDestroy*

A method annotated with *@PreDestroy* runs only once, just before Spring removes our bean from the application context.

Same as with *@PostConstruct*, the methods annotated with *@PreDestroy* can have any access level but can't be static.

```java
@Component
public class UserRepository {

    private DbConnection dbConnection;
    @PreDestroy
    public void preDestroy() {
        dbConnection.close();
    }
}
```

The purpose of this method should be to release resources or perform any other cleanup tasks before the bean gets destroyed, for example closing a database connection.

#### Java 9+

Note that both *@PostConstruct* and *@PreDestroy* annotations are part of Java EE. And since [Java EE has been deprecated in Java 9](https://www.baeldung.com/java-enterprise-evolution) and removed in Java 11 we have to add an additional dependency to use these annotations:

```xml
<dependency>
    <groupId>javax.annotation</groupId>
    <artifactId>javax.annotation-api</artifactId>
    <version>1.3.2</version>
</dependency>
```



### Stereotypes and meta-annotations

Thanks [eidher](https://dev.to/eidher/stereotype-and-meta-annotations-in-spring-1klk)

@ComponentScan checks not only for components but for annotations that are themselves annotated with @Component too. Those are stereotype annotations:

- Component
- Controller
- Repository
- Service

We could add @Configuration and @RestController because @Configuration is annotated with @Component and @RestController is annotated with @Controller (some people disagree)

Meta-annotations are annotations that can be used to annotate other annotations. 

###### Using Meta-annotations and Composed Annotations

[docs.spring.ion](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-meta-annotations)

Many of the annotations provided by Spring can be used as meta-annotations in your own code. A meta-annotation is an annotation that can be applied to another annotation. For example, the `@Service` annotation mentioned [earlier](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-stereotype-annotations) is meta-annotated with `@Component`, as the following example shows:

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component 
public @interface Service {

    // ...
}
```

| The `@Component` causes `@Service` to be treated in the same way as `@Component`. |
| ------------------------------------------------------------ |

You can also combine meta-annotations to create “composed annotations”. For example, the `@RestController` annotation from Spring MVC is composed of `@Controller` and `@ResponseBody`.

In addition, composed annotations can optionally redeclare attributes from meta-annotations to allow customization. This can be particularly useful when you want to only expose a subset of the meta-annotation’s attributes. For example, Spring’s `@SessionScope` annotation hardcodes the scope name to `session` but still allows customization of the `proxyMode`. The following listing shows the definition of the `SessionScope` annotation:

```java
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Scope(WebApplicationContext.SCOPE_SESSION)
public @interface SessionScope {

    /**
     * Alias for {@link Scope#proxyMode}.
     * <p>Defaults to {@link ScopedProxyMode#TARGET_CLASS}.
     */
    @AliasFor(annotation = Scope.class)
    ScopedProxyMode proxyMode() default ScopedProxyMode.TARGET_CLASS;

}
```

You can then use `@SessionScope` without declaring the `proxyMode` as follows:

```java
@Service
@SessionScope
public class SessionScopedService {
    // ...
}
```

You can also override the value for the `proxyMode`, as the following example shows:

```java
@Service
@SessionScope(proxyMode = ScopedProxyMode.INTERFACES)
public class SessionScopedUserService implements UserService {
    // ...
}
```

For further details, see the [Spring Annotation Programming Model](https://github.com/spring-projects/spring-framework/wiki/Spring-Annotation-Programming-Model) wiki page.

```java
@MyTransactionalService
public class TransferServiceImpl implements TransferService {
  ...
}

@Retention(RUNTIME)
@Target(TYPE)
@Service
@Transactional(timeout=60)
public @interface MyTransactionalService {
  String value() default "";
}
```

## 4 Factory Pattern in Spring

### Using Spring FactoryBeans

Thanks [*baeldung.com*](https://www.baeldung.com/spring-factorybean)

There are two kinds of beans in the Spring bean container: ordinary beans and factory beans. Spring uses the former directly, whereas latter can produce objects themselves, which are managed by the framework.

And, simply put, we can build a factory bean by implementing *org.springframework.beans.factory.FactoryBean* interface.

#### **The Basics of Factory Beans**

##### **Implement a *FactoryBean***

Let's look at the *FactoryBean* interface first:

```java
public interface FactoryBean {
    T getObject() throws Exception;
    Class<?> getObjectType();
    boolean isSingleton();
}
```

Let's discuss the three methods:

- *getObject()* – returns an object produced by the factory, and this is the object that will be used by Spring container
- *getObjectType()* – returns the type of object that this *FactoryBean* produces
- *isSingleton()* – denotes if the object produced by this *FactoryBean* is a singleton

Now, let's implement an example *FactoryBean*. We'll implement a *ToolFactory* which produces objects of the type *Tool*:

```java
public class Tool {

    private int id;

    // standard constructors, getters and setters
}
```

The *ToolFactory* itself:

```java
public class ToolFactory implements FactoryBean<Tool> {

    private int factoryId;
    private int toolId;

    @Override
    public Tool getObject() throws Exception {
        return new Tool(toolId);
    }

    @Override
    public Class<?> getObjectType() {
        return Tool.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    // standard setters and getters
}
```

As we can see, the *ToolFactory* is a *FactoryBean*, which can produce *Tool* objects.

##### **Use *FactoryBean* With XML-based Configuration**

Let's now have a look at how to use our *ToolFactory*.

We'll start constructing a tool with XML-based configuration – *factorybean-spring-ctx.xml*:

```xml
<beans ...>

    <bean id="tool" class="com.baeldung.factorybean.ToolFactory">
        <property name="factoryId" value="9090"/>
        <property name="toolId" value="1"/>
    </bean>
</beans>
```

Next, we can test if the *Tool* object is injected correctly:

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:factorybean-spring-ctx.xml" })
public class FactoryBeanXmlConfigTest {
    @Autowired
    private Tool tool;

    @Test
    public void testConstructWorkerByXml() {
        assertThat(tool.getId(), equalTo(1));
    }
}
```

The test result shows we manage to inject the tool object produced by the *ToolFactory* with the properties we configured in the *factorybean-spring-ctx.xml*.

The test result also shows that the Spring container uses the object produced by the *FactoryBean* instead of itself for dependency injection.

Although the Spring container uses the *FactoryBean*‘s *getObject()* method's return value as the bean, you can also use the *FactoryBean* itself.

**To access the *FactoryBean*, you just need to add a “&” before the bean name.**

Let's try getting the factory bean and its *factoryId* property:

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:factorybean-spring-ctx.xml" })
public class FactoryBeanXmlConfigTest {

    @Resource(name = "&tool")
    private ToolFactory toolFactory;

    @Test
    public void testConstructWorkerByXml() {
        assertThat(toolFactory.getFactoryId(), equalTo(9090));
    }
}
```

##### **Use *FactoryBean* With Java-based Configuration**

Use *FactoryBean* with Java-based configuration is a little different with XML-based configuration, you have to call the *FactoryBean*‘s *getObject()* method explicitly.

Let's convert the example in the previous subsection into a Java-based configuration example:

```java
@Configuration
public class FactoryBeanAppConfig {
 
    @Bean(name = "tool")
    public ToolFactory toolFactory() {
        ToolFactory factory = new ToolFactory();
        factory.setFactoryId(7070);
        factory.setToolId(2);
        return factory;
    }

    @Bean
    public Tool tool() throws Exception {
        return toolFactory().getObject();
    }
}
```

Then, we test if the *Tool* object is injected correctly:

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FactoryBeanAppConfig.class)
public class FactoryBeanJavaConfigTest {

    @Autowired
    private Tool tool;
 
    @Resource(name = "&tool")
    private ToolFactory toolFactory;

    @Test
    public void testConstructWorkerByJava() {
        assertThat(tool.getId(), equalTo(2));
        assertThat(toolFactory.getFactoryId(), equalTo(7070));
    }
}
```

The test result shows the similar effect as the previous XML-based configuration test.

##### **Ways to Initialize**

Sometimes you need to perform some operations after the *FactoryBean* has been set but before the *getObject()* method is called, like properties check.

You can achieve this by implementing the *InitializingBean* interface or using *@PostConstruct* annotation.

More details about using these two solutions have been introduced in another article: [Guide To Running Logic on Startup in Spring](https://www.baeldung.com/running-setup-logic-on-startup-in-spring).

##### ***AbstractFactoryBean***

Spring provides the *AbstractFactoryBean* as a simple template superclass for *FactoryBean* implementations. With this base class, we can now more conveniently implement a factory bean which creates a singleton or a prototype object.

Let's implement a *SingleToolFactory* and a *NonSingleToolFactory* to show how to use *AbstractFactoryBean* for both singleton and prototype type:

```java
public class SingleToolFactory extends AbstractFactoryBean<Tool> {

    private int factoryId;
    private int toolId;

    @Override
    public Class<?> getObjectType() {
        return Tool.class;
    }

    @Override
    protected Tool createInstance() throws Exception {
        return new Tool(toolId);
    }

    // standard setters and getters
}
```

And now the nonsingleton implementation:

```java
public class NonSingleToolFactory extends AbstractFactoryBean<Tool> {

    private int factoryId;
    private int toolId;

    public NonSingleToolFactory() {
        setSingleton(false);
    }

    @Override
    public Class<?> getObjectType() {
        return Tool.class;
    }

    @Override
    protected Tool createInstance() throws Exception {
        return new Tool(toolId);
    }

    // standard setters and getters
}
```

Also, the XML config for these factory beans:

```xml
<beans ...>

    <bean id="singleTool" class="com.baeldung.factorybean.SingleToolFactory">
        <property name="factoryId" value="3001"/>
        <property name="toolId" value="1"/>
    </bean>

    <bean id="nonSingleTool" class="com.baeldung.factorybean.NonSingleToolFactory">
        <property name="factoryId" value="3002"/>
        <property name="toolId" value="2"/>
    </bean>
</beans>
```

Now we can test if the *Worker* objects' properties are injected as we expect:

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:factorybean-abstract-spring-ctx.xml" })
public class AbstractFactoryBeanTest {

    @Resource(name = "singleTool")
    private Tool tool1;
 
    @Resource(name = "singleTool")
    private Tool tool2;
 
    @Resource(name = "nonSingleTool")
    private Tool tool3;
 
    @Resource(name = "nonSingleTool")
    private Tool tool4;

    @Test
    public void testSingleToolFactory() {
        assertThat(tool1.getId(), equalTo(1));
        assertTrue(tool1 == tool2);
    }

    @Test
    public void testNonSingleToolFactory() {
        assertThat(tool3.getId(), equalTo(2));
        assertThat(tool4.getId(), equalTo(2));
        assertTrue(tool3 != tool4);
    }
}
```

As we can see from the tests, the *SingleToolFactory* produces singleton object, and the *NonSingleToolFactory* produces prototype object.

Note that there's no need to set singleton property in *SingleToolFactory* because, in *AbstractFactory*, singleton property's default value is *true*.

## 5 Advanced Spring: How Does Spring Work Internally? 

### The Spring Bean Lifecycle

Thanks [*springframework.guru*](https://springframework.guru/spring-bean-lifecycle/)

The Spring IoC (Inversion of Control) container manages Spring beans. A “Spring bean” is just a Spring managed instantiation of a Java class.

The Spring IoC container is responsible for instantiating, initializing, and wiring beans. The container also manages the life cycle of beans.

Spring provides several ways through which you can tap into the bean lifecycle. For example, once a bean is instantiated, you might need to perform some initialization to get the bean into a usable state. Similarly, you might need to clean up resources before a bean is removed from the container.

In this post, we will examine the steps of Spring bean lifecycle. This is how the Spring Framework creates and destroys Spring beans.

#### Spring Bean Lifecycle Overview

This Figure shows two parts of the Spring bean lifecycle:

![img](http://springframework.guru/wp-content/uploads/2019/08/lifecycle-1024x442.png)

**Part 1:** Shows the different stages a bean goes through after instantiation until it is ready for use.
**Part 2:** Shows what happens to a bean once the Spring IoC container shuts down.

As you can see in Part 1 of the preceding figure, the container instantiates a bean by calling its constructor and then populates its properties.

This is followed by several calls to the bean until the bean is in the ready state.

Similarly, as shown in Part 2, when the container shuts down, the container calls the bean to enable it to perform any required tasks before the bean is destroyed.

#### Aware interfaces

Spring provides several aware interfaces. These are used to access the Spring Framework infrastructure. The aware interfaces are largely used within the framework and rarely used by Spring programmers.

You as Spring programmers should be familiar with the following three aware interfaces.

* *BeanFactoryAware* : Provides *setBeanFactory()*, a callback that supplies the owning factory to the bean instance.
* *BeanNameAware*: The *setBeanName()* callback of this interface supplies the name of the bean.
* *AplicationContextAware*: The *setApplicationContext()*  method of this interface provides the *ApplicationContext* object of this bean.

The code to use the preceding aware interfaces is this.

```java
package guru.springframework.springbeanlifecycle.awareinterfaces.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Arrays;

public class AwareBeanImpl implements ApplicationContextAware, BeanNameAware, BeanFactoryAware {
	
	private boolean enabled;
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		System.out.println("Set 'enabled' property of AwareBeanImpl called !! ");
		this.enabled = enabled;
	}

	public AwareBeanImpl() {
		System.out.println("Constructor of AwareBeanImpl called !! ");
	}
	
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("setBeanFactory method of AwareBeanImpl is called");
		System.out.println("setBeanFactory:: AwareBeanImpl singleton= " + beanFactory.isSingleton("awareBean"));
	}

	@Override
	public void setBeanName(String beanName) {
		System.out.println("setBeanName method of AwareBeanImpl is called");
		System.out.println("setBeanName:: Bean Name defined in context= " + beanName);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("setApplicationContext method of AwareBeanImpl is called");
		System.out.println("setApplicationContext:: Bean Definition Names= "
		        + Arrays.toString(applicationContext.getBeanDefinitionNames()));
	}
}
```

The preceding bean implements the *ApplicationContextAware*, *BeanNameAware* and *BeanFactoryAware* interfaces. In the preceding code:

* The code overrides the *setBeanFactory()* method of the *BeanFactoryAware* interface. During runtime, Spring passes the *BeanFactory* object that created the bean. The code uses the *BeanFactory* object to print whether or not this bean is a singleton.
* Overrides the *setBeanName()* method of the *BeanNameAware* interface. During runtime, Spring passes the name of the bean as a String that the code prints out. The code uses the beanName to print the bean name defined in context.
* The code overrides the *setApplicationContext()* method of the *ApplicationContextAware* interface. During runtime, Spring passes the *ApplicationContext* object that created the bean. The code uses the *ApplicationContext* object to print the bean definition names.

Next, we will write the bean configuration to define the *AwareBeanImpl*.
The code of the *aware-beans.xml* is this.

```xml
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

    <!-- aware interfaces -->
   <bean id="awareBean" class="guru.springframework.springbeanlifecycle.awareinterfaces.domain.AwareBeanImpl">
    <property name="enabled" value="true"/>
   </bean>

</beans>
```

Finally, let us write the main class which will load the *aware-beans.xml* and test the aware interface methods.

```java
package guru.springframework.springbeanlifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanLifecycleApplication {

	public static void main(String[] args) {
		
		if (args.length < 1) {
			System.err.println("Parameter missed: contextResource");
			System.exit(1);
		}
		try (AbstractApplicationContext context1 = new ClassPathXmlApplicationContext(args[0])) {
			((AbstractApplicationContext) context1).registerShutdownHook();
		}

	}
}
```

The output on running the ***guru.springframework.springbeanlifecycle.SpringBeanLifecycleApplication*** class with "aware-beans.xml" parameter  is this:

```plaintext
Constructor of AwareBeanImpl called !! 
Set 'enabled' property of AwareBeanImpl called !! 
setBeanName method of AwareBeanImpl is called
setBeanName:: Bean Name defined in context= awareBean
setBeanFactory method of AwareBeanImpl is called
setBeanFactory:: AwareBeanImpl singleton= true
setApplicationContext method of AwareBeanImpl is called
setApplicationContext:: Bean Definition Names= [awareBean]
```

#### Bean Factory Post Processor and Bean Post Processor 

Thanks [*araknoid*](https://stackoverflow.com/questions/30455536/beanfactorypostprocessor-and-beanpostprocessor-in-lifecycle-events/30456202#30456202)

![enter image description here](https://i.stack.imgur.com/jg555.png)

The differences about `BeanFactoryPostProcessor` and `BeanPostProcessor`:

1. A bean implementing `BeanFactoryPostProcessor` is called when all bean definitions will have been loaded, but no beans will have been instantiated yet. This allows for overriding or adding properties even to eager-initializing beans. This will let you have access to all the beans that you have defined in XML or that are annotated (scanned via component-scan).
2. A bean implementing `BeanPostProcessor` operate on bean (or object) instances which means that when the Spring IoC container instantiates a bean instance then BeanPostProcessor interfaces do their work.
3. `BeanFactoryPostProcessor` implementations are "called" during startup of the Spring context after all bean definitions will have been loaded while `BeanPostProcessor` are "called" when the Spring IoC container instantiates a bean (i.e. during the startup for all the singleton and on demand for the proptotypes one)

### Bean Factory Post Processor

A bean implementing BeanFactoryPostProcessor is called when all bean definitions will have been loaded, but no beans will have been instantiated yet. This allows for overriding or adding properties even to eager-initializing beans. This will let you have access to all the beans that you have defined in XML or that are annotated (scanned via component-scan).

```java
public class CustomBeanFactory implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        for (String beanName : beanFactory.getBeanDefinitionNames()) {

            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);

            // Manipulate the beanDefiniton or whatever you need to do

        }
    }
}
```

### Bean Post Processor 

Spring provides the *BeanPostProcessor* interface that gives you the means to tap into the Spring context life cycle and interact with beans as they are processed.

The *BeanPostProcessor* interface contains two methods.

* *postProcessBeforeInitialization*: Spring calls this method after calling the methods of the aware interfaces and before any bean initialization callbacks, such as InitializingBean’s afterPropertiesSet or a custom init-method.
* *postProcessAfterInitialization*: Spring calls this method after any bean initialization callbacks.



Let us start by creating a bean, named BookBean.



```java
package guru.springframework.springbeanlifecycle.beanpostprocessor.domain;

public class BookBean {
	private String bookName;

	public BookBean() {
		System.out.println("Constructor of BookBean called !! ");

	}

	public BookBean(String bookName) {
		this.bookName = bookName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		System.out.println("Set 'bookName' property of BookBean called !! ");
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return "BookBean{" + "bookName='" + bookName + '\'' + '}';
	}
}
```

Next, we will create the *BookBeanPostProcessor*.

The code for *BookBeanPostProcessor* is this.

```java
package guru.springframework.springbeanlifecycle.beanpostprocessor.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BookBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Post Process Before Initialization method is called : Bean Name " + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Post Process After Initialization method is called : Bean Name " + beanName);
		return bean;
	}
}
```

The preceding code implements the *BeanPostProcessor* interface and overrides the *postProcessBeforeInitialization()* and *postProcessAfterInitialization()* methods.

Spring calls the *postProcessBeforeInitialization()* method after calling the methods of the aware interfaces.

Spring calls the *postProcessAfterInitialization()* method after any bean initialization callbacks, such as InitializingBean’s *afterPropertiesSet* or a custom init-method. We will discuss both going ahead.

At runtime, Spring will inject the new bean instance and the name of the bean to both the methods.

Next, we will define *BookBean* and *BookBeanProcessor* as beans in the XML configuration.

The configuration code of the *post-beans.xml* is this.

```xml
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <bean id="bookBeanPost" class="guru.springframework.springbeanlifecycle.beanpostprocessor.domain.BookBean">
       <property name="bookName" value="Gone with the Wind"></property>
   </bean>
   <bean id="bookBeanPostProcessor"
         class="guru.springframework.springbeanlifecycle.beanpostprocessor.domain.BookBeanPostProcessor"/>
</beans>
```

The output on running the ***guru.springframework.springbeanlifecycle.SpringBeanLifecycleApplication*** class with "post-beans.xml" parameter  is this:

```plaintext
Constructor of BookBean called !! 
Set 'bookName' property of BookBean called !! 
Post Process Before Initialization method is called : Bean Name bookBeanPost
Post Process After Initialization method is called : Bean Name bookBeanPost
```

To see subsequence of calling aware interfaces methods and post processors methods we'll join configuration files into "beans.xml".



```xml
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

    <!-- aware interfaces -->
   <bean id="awareBean" class="guru.springframework.springbeanlifecycle.awareinterfaces.domain.AwareBeanImpl">
    <property name="enabled" value="true"/>
   </bean>

   <bean id="bookBeanPost" class="guru.springframework.springbeanlifecycle.beanpostprocessor.domain.BookBean">
       <property name="bookName" value="Gone with the Wind"></property>
   </bean>
   <bean id="bookBeanPostProcessor"
         class="guru.springframework.springbeanlifecycle.beanpostprocessor.domain.BookBeanPostProcessor"/>

</beans>
```

The output on running the ***guru.springframework.springbeanlifecycle.SpringBeanLifecycleApplication*** class with "beans.xml" parameter  is this:

```plaintext
Constructor of AwareBeanImpl called !! 
Set 'enabled' property of AwareBeanImpl called !! 
setBeanName method of AwareBeanImpl is called
setBeanName:: Bean Name defined in context= awareBean
setBeanFactory method of AwareBeanImpl is called
setBeanFactory:: AwareBeanImpl singleton= true
setApplicationContext method of AwareBeanImpl is called
setApplicationContext:: Bean Definition Names= [awareBean, bookBeanPost, bookBeanPostProcessor]
Post Process Before Initialization method is called : Bean Name awareBean
Post Process After Initialization method is called : Bean Name awareBean
Constructor of BookBean called !! 
Set 'bookName' property of BookBean called !! 
Post Process Before Initialization method is called : Bean Name bookBeanPost
Post Process After Initialization method is called : Bean Name bookBeanPost

```

#### InitializingBean and DisposableBean Callback Interfaces

Spring provides the following two callback interfaces:

*InitializingBean*: Declares the *afterPropertiesSet()* method which can be used to write the initialization logic. The container calls the method after properties are set.
*DisposableBean*: Declares the *destroy()* method which can be used to write any cleanup code. The container calls this method during bean destruction in shutdown.
Let’s write a bean that implements the *InitalizingBean* and *DisposableBean* interfaces.

The code of the Book bean is this.

```java
package guru.springframework.springbeanlifecycle.callbackinterfaces.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Book implements InitializingBean, DisposableBean {
	private String bookName;

	public Book() {
		System.out.println("Constructor of Book bean is called !! ");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy method of Book bean called !! ");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet method of Book bean is called !! ");
	}

	public Book(String bookName) {
		this.bookName = bookName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		System.out.println("Set 'bookName' property of Book called !! ");
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return "Book{" + "bookName='" + bookName + '\'' + '}';
	}
}
```

The preceding *Book* bean implements the *InitializingBean* and *DisposableBean* interfaces and overrides their *afterPropertiesSet()* and *destroy()* methods.

Next, we will write the bean configuration to define the *Book* bean.

The code of the *initializing-disposable-beans.xml* file is this.

```xml
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <!--  callback interfaces-->
   <bean id="bookBean" class="guru.springframework.springbeanlifecycle.callbackinterfaces.domain.Book">
       <property name="bookName" value="Believe in Yourself"/>
   </bean>
</beans>
```

The output on running the ***guru.springframework.springbeanlifecycle.SpringBeanLifecycleApplication*** class with "initializing-disposable-beans.xml" parameter  is this:

```plaintext
Constructor of Book bean is called !! 
Set 'bookName' property of Book called !! 
afterPropertiesSet method of Book bean is called !! 
Destroy method of Book bean called !! 
```

To see subsequence of calling aware interfaces methods,  InitializingBean and DisposableBean Callback Interfaces methods and post processors methods we'll add content of "initializing-disposable-beans.xml" file into "beans.xml".

```xml
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

    <!-- aware interfaces -->
   <bean id="awareBean" class="guru.springframework.springbeanlifecycle.awareinterfaces.domain.AwareBeanImpl">
    <property name="enabled" value="true"/>
   </bean>

   <!--  callback interfaces-->
   <bean id="bookBean" class="guru.springframework.springbeanlifecycle.callbackinterfaces.domain.Book">
       <property name="bookName" value="Believe in Yourself"/>
   </bean>

   <bean id="bookBeanPost" class="guru.springframework.springbeanlifecycle.beanpostprocessor.domain.BookBean">
       <property name="bookName" value="Gone with the Wind"></property>
   </bean>
   <bean id="bookBeanPostProcessor"
         class="guru.springframework.springbeanlifecycle.beanpostprocessor.domain.BookBeanPostProcessor"/>

</beans>
```

Then the output on running the ***guru.springframework.springbeanlifecycle.SpringBeanLifecycleApplication*** class with "beans.xml" parameter  is this:

```plaintext
Constructor of AwareBeanImpl called !! 
Set 'enabled' property of AwareBeanImpl called !! 
setBeanName method of AwareBeanImpl is called
setBeanName:: Bean Name defined in context= awareBean
setBeanFactory method of AwareBeanImpl is called
setBeanFactory:: AwareBeanImpl singleton= true
setApplicationContext method of AwareBeanImpl is called
setApplicationContext:: Bean Definition Names= [awareBean, bookBean, bookBeanPost, bookBeanPostProcessor]
Post Process Before Initialization method is called : Bean Name awareBean
Post Process After Initialization method is called : Bean Name awareBean
Constructor of Book bean is called !! 
Set 'bookName' property of Book called !! 
Post Process Before Initialization method is called : Bean Name bookBean
afterPropertiesSet method of Book bean is called !! 
Post Process After Initialization method is called : Bean Name bookBean
Constructor of BookBean called !! 
Set 'bookName' property of BookBean called !! 
Post Process Before Initialization method is called : Bean Name bookBeanPost
Post Process After Initialization method is called : Bean Name bookBeanPost
Destroy method of Book bean called !! 
```

#### Custom Init and Destroy Method

While declaring bean in XML configuration, you can specify the *init*-method and *destroy*-method attributes in the  tag. Both the attributes specify custom methods in the bean class.

The method declared in the *init*-method attribute is called after Spring initializes bean properties through setter or constructor arguments. You can use this method to validate the injected properties or perform any other tasks.

Spring calls the method declared in the *destroy*-method attribute just before the bean is destroyed.

Let’s use the custom *init* and destroy methods in a bean, named BookCustomBean.

Also let bean to print all described below interfaces calling to see all bean lifecycle.

Also add methods annotated with @PostConstruct and @PreDestroy to see more full bean lifecycle.

The code for *BookCustomBean* is this.

```java
package guru.springframework.springbeanlifecycle.custominitanddestroy.domain;

import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BookCustomBean implements ApplicationContextAware, BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {
	private String bookName;

	public BookCustomBean() {
		System.out.println("Constructor of BookCustomBean bean is called !! ");
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("@PostConstruct of BookCustomBean bean is called !! ");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("@PreDestroy of BookCustomBean bean is called !! ");
	}
	
	public void customDestroy() throws Exception {
		System.out.println("Custom destroy method of BookCustomBean called !! ");
	}

	public void customInit() throws Exception {
		System.out.println("Custom Init method of BookCustomBean called !! ");
	}

	public BookCustomBean(String bookName) {
		this.bookName = bookName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		System.out.println("Set 'bookName' property of BookCustomBean called !! ");
		this.bookName = bookName;
	}


	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy method of BookCustomBean called !! ");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet method of BookCustomBean is called !! ");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("setBeanFactory method of BookCustomBean is called");
		System.out.println("setBeanFactory:: BookCustomBean singleton= " + beanFactory.isSingleton("customLifeCycleBookBean"));
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("setBeanName method of BookCustomBean is called");
		System.out.println("setBeanName:: Bean Name defined in context= " + name);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("setApplicationContext method of BookCustomBean is called");
		System.out.println("setApplicationContext:: Bean Definition Names= "
		        + Arrays.toString(applicationContext.getBeanDefinitionNames()));
	}
	
	@Override
	public String toString() {
		return "Book{" + "bookName='" + bookName + '\'' + '}';
	}
}
```

To fully lifecycle printing, we added post processor to *init-destroy-beans.xml* config file and *context:component-scan* to scan  the methods annotated with @PostConstruct and @PreDestroy

```xml
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xmlns:context="http://www.springframework.org/schema/context"
      xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd">

   <context:component-scan base-package="guru.springframework.springbeanlifecycle.custominitanddestroy.domain"/>
   <!--     Declare custom init and destroy methods-->
   <bean id="customLifeCycleBookBean"
         class="guru.springframework.springbeanlifecycle.custominitanddestroy.domain.BookCustomBean"
         init-method="customInit"
         destroy-method="customDestroy">
       <property name="bookName" value="Life and Laughing"></property>
   </bean>

   <bean id="bookBeanPostProcessor"
         class="guru.springframework.springbeanlifecycle.beanpostprocessor.domain.BookBeanPostProcessor"/>
</beans>
```

The output on running the ***guru.springframework.springbeanlifecycle.SpringBeanLifecycleApplication*** class with "init-destroy-beans.xml" parameter  is this:

```plaintext
Constructor of BookCustomBean bean is called !! 
Set 'bookName' property of BookCustomBean called !! 
setBeanName method of BookCustomBean is called
setBeanName:: Bean Name defined in context= customLifeCycleBookBean
setBeanFactory method of BookCustomBean is called
setBeanFactory:: BookCustomBean singleton= true
setApplicationContext method of BookCustomBean is called
setApplicationContext:: Bean Definition Names= [org.springframework.context.annotation.internalConfigurationAnnotationProcessor, org.springframework.context.annotation.internalAutowiredAnnotationProcessor, org.springframework.context.annotation.internalCommonAnnotationProcessor, org.springframework.context.event.internalEventListenerProcessor, org.springframework.context.event.internalEventListenerFactory, customLifeCycleBookBean, bookBeanPostProcessor]
Post Process Before Initialization method is called : Bean Name customLifeCycleBookBean
@PostConstruct of BookCustomBean bean is called !! 
afterPropertiesSet method of BookCustomBean is called !! 
Custom Init method of BookCustomBean called !! 
Post Process After Initialization method is called : Bean Name customLifeCycleBookBean
@PreDestroy of BookCustomBean bean is called !! 
Destroy method of BookCustomBean called !! 
Custom destroy method of BookCustomBean called !! 

```

##### Combining Lifecycle Mechanisms

[Combining Lifecycle Mechanisms](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-lifecycle-combined-effects)

Multiple lifecycle mechanisms configured for the same bean, with different initialization methods, are called as follows:

1. Methods annotated with `@PostConstruct`
2. `afterPropertiesSet()` as defined by the `InitializingBean` callback interface
3. A custom configured `init()` method

Destroy methods are called in the same order:

1. Methods annotated with `@PreDestroy`
2. `destroy()` as defined by the `DisposableBean` callback interface
3. A custom configured `destroy()` method

### Spring Bean Proxies

[Basic Concepts: @Bean and @Configuration](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-java-basic-concepts)

The central artifacts in Spring’s new Java-configuration support are `@Configuration`-annotated classes and `@Bean`-annotated methods.

The `@Bean` annotation is used to indicate that a method instantiates, configures, and initializes a new object to be managed by the Spring IoC container. For those familiar with Spring’s `<beans/>` XML configuration, the `@Bean` annotation plays the same role as the `<bean/>` element. You can use `@Bean`-annotated methods with any Spring `@Component`. However, they are most often used with `@Configuration` beans.

Annotating a class with `@Configuration` indicates that its primary purpose is as a source of bean definitions. Furthermore, `@Configuration` classes let inter-bean dependencies be defined by calling other `@Bean` methods in the same class. The simplest possible `@Configuration` class reads as follows:

```java
@Configuration
public class AppConfig {

    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
}
```

The preceding `AppConfig` class is equivalent to the following Spring `<beans/>` XML:

```xml
<beans>
    <bean id="myService" class="com.acme.services.MyServiceImpl"/>
</beans>
```

#### @Scope and scoped-proxy

[@Scope and scoped-proxy](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-java-scoped-proxy)

Spring offers a convenient way of working with scoped dependencies through [scoped proxies](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-scopes-other-injection). The easiest way to create such a proxy when using the XML configuration is the `<aop:scoped-proxy/>` element. Configuring your beans in Java with a `@Scope` annotation offers equivalent support with the `proxyMode` attribute. The default is `ScopedProxyMode.DEFAULT`, which typically indicates that no scoped proxy should be created unless a different default has been configured at the component-scan instruction level. You can specify `ScopedProxyMode.TARGET_CLASS`, `ScopedProxyMode.INTERFACES` or `ScopedProxyMode.NO`.

If you port the scoped proxy example from the XML reference documentation (see [scoped proxies](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-scopes-other-injection)) to our `@Bean` using Java, it resembles the following:

```java
// an HTTP Session-scoped bean exposed as a proxy
@Bean
@SessionScope
public UserPreferences userPreferences() {
    return new UserPreferences();
}

@Bean
public Service userService() {
    UserService service = new SimpleUserService();
    // a reference to the proxied userPreferences bean
    service.setUserPreferences(userPreferences());
    return service;
}
```

### Lookup Method Injection

As noted earlier, [lookup method injection](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-method-injection) is an advanced feature that you should use rarely. It is useful in cases where a singleton-scoped bean has a dependency on a prototype-scoped bean. Using Java for this type of configuration provides a natural means for implementing this pattern. The following example shows how to use lookup method injection:

```java
public abstract class CommandManager {
    public Object process(Object commandState) {
        // grab a new instance of the appropriate Command interface
        Command command = createCommand();
        // set the state on the (hopefully brand new) Command instance
        command.setState(commandState);
        return command.execute();
    }

    // okay... but where is the implementation of this method?
    protected abstract Command createCommand();
}
```

By using Java configuration, you can create a subclass of `CommandManager` where the abstract `createCommand()` method is overridden in such a way that it looks up a new (prototype) command object. The following example shows how to do so:

```java
@Bean
@Scope("prototype")
public AsyncCommand asyncCommand() {
    AsyncCommand command = new AsyncCommand();
    // inject dependencies here as required
    return command;
}

@Bean
public CommandManager commandManager() {
    // return new anonymous implementation of CommandManager with createCommand()
    // overridden to return a new prototype Command object
    return new CommandManager() {
        protected Command createCommand() {
            return asyncCommand();
        }
    }
}
```

#### Proxy of @Bean. Further Information About How Java-based Configuration Works Internally

[Proxy of @Bean](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-java-further-information-java-config)

Consider the following example, which shows a `@Bean` annotated method being called twice:

```java
@Configuration
public class AppConfig {

    @Bean
    public ClientService clientService1() {
        ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.setClientDao(clientDao());
        return clientService;
    }

    @Bean
    public ClientService clientService2() {
        ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.setClientDao(clientDao());
        return clientService;
    }

    @Bean
    public ClientDao clientDao() {
        return new ClientDaoImpl();
    }
}
```

`clientDao()` has been called once in `clientService1()` and once in `clientService2()`. Since this method creates a new instance of `ClientDaoImpl` and returns it, you would normally expect to have two instances (one for each service). That definitely would be problematic: In Spring, instantiated beans have a `singleton` scope by default. This is where the magic comes in: All `@Configuration` classes are subclassed at startup-time with `CGLIB`. In the subclass, the child method checks the container first for any cached (scoped) beans before it calls the parent method and creates a new instance.

|      | The behavior could be different according to the scope of your bean. We are talking about singletons here. |
| ---- | ------------------------------------------------------------ |
|      |                                                              |

|      | As of Spring 3.2, it is no longer necessary to add CGLIB to your classpath because CGLIB classes have been repackaged under `org.springframework.cglib` and included directly within the spring-core JAR. |
| ---- | ------------------------------------------------------------ |
|      |                                                              |

|      | There are a few restrictions due to the fact that CGLIB dynamically adds features at startup-time. In particular, configuration classes must not be final. However, as of 4.3, any constructors are allowed on configuration classes, including the use of `@Autowired` or a single non-default constructor declaration for default injection.If you prefer to avoid any CGLIB-imposed limitations, consider declaring your `@Bean` methods on non-`@Configuration` classes (for example, on plain `@Component` classes instead). Cross-method calls between `@Bean` methods are not then intercepted, so you have to exclusively rely on dependency injection at the constructor or method level there. |
| ---- | ------------------------------------------------------------ |
|      |                                                              |

### @Bean method return types

[ Using the @Bean Annotation](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-java-bean-annotation)

##### Declaring a Bean

To declare a bean, you can annotate a method with the `@Bean` annotation. You use this method to register a bean definition within an `ApplicationContext` of the type specified as the method’s return value. By default, the bean name is the same as the method name. The following example shows a `@Bean` method declaration:

The preceding configuration is exactly equivalent to the following Spring XML:

```xml
<beans>
    <bean id="transferService" class="com.acme.TransferServiceImpl"/>
</beans>
```

Both declarations make a bean named `transferService` available in the `ApplicationContext`, bound to an object instance of type `TransferServiceImpl`, as the following text image shows:

```
transferService -> com.acme.TransferServiceImpl
```

You can also use default methods to define beans. This allows composition of bean configurations by implementing interfaces with bean definitions on default methods.

```java
public interface BaseConfig {

    @Bean
    default TransferServiceImpl transferService() {
        return new TransferServiceImpl();
    }
}

@Configuration
public class AppConfig implements BaseConfig {

}
```

You can also declare your `@Bean` method with an interface (or base class) return type, as the following example shows:

```java
@Configuration
public class AppConfig {

    @Bean
    public TransferService transferService() {
        return new TransferServiceImpl();
    }
}
```

However, this limits the visibility for advance type prediction to the specified interface type (`TransferService`). Then, with the full type (`TransferServiceImpl`) known to the container only once the affected singleton bean has been instantiated. Non-lazy singleton beans get instantiated according to their declaration order, so you may see different type matching results depending on when another component tries to match by a non-declared type (such as `@Autowired TransferServiceImpl`, which resolves only once the `transferService` bean has been instantiated).

| If you consistently refer to your types by a declared service interface, your `@Bean` return types may safely join that design decision. However, for components that implement several interfaces or for components potentially referred to by their implementation type, it is safer to declare the most specific return type possible (at least as specific as required by the injection points that refer to your bean). |
| ------------------------------------------------------------ |

Let test different @bean return types

Create an interface

```java
package org.shikalenko.spring.proxy;

public interface IComponent {
}
```

Then create the interface extension

```java
package org.shikalenko.spring.proxy;

public interface IComponentExt extends IComponent {
    IComponent getComponentA();
}
```

Then create interface realizations

```java
package org.shikalenko.spring.proxy;

public class ComponentA implements IComponent {
}
```

```java
package org.shikalenko.spring.proxy;

public class ComponentB extends ComponentA implements IComponentExt {

    private IComponent componentA;
    
    public ComponentB(IComponent component) {
        this.componentA = component;
    }

    @Override
    public IComponent getComponentA() {
        return componentA;
    }

}
```

Then create java configuration file

```java
package org.shikalenko.spring.proxy;

import java.math.BigDecimal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  
  @Bean
  public IComponent componentA() {
    return new ComponentA();
  }
  
  @Bean
  public IComponentExt componentB() {
    return new ComponentB(componentA());
  }
  
  @Bean("sayHello")
  public String hello() {
      return "Hello";
  }
  
  @Bean 
  public int age() {
      return 18;
  }

  @Bean (name = {"age1", "age2"}) 
  public BigDecimal bigage() {
      return new BigDecimal(age());
  }  
}
```

AppConfig class methods returns next types:

- IComponent 
- IComponentExt
- String
- int
- BigDecimal

What do we expect from an application context built using this class?

To check that create a unit test

```java
package org.shikalenko.spring.proxy;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class AppConfigTest {
    

    AbstractApplicationContext context;
    AppConfig appConfigSpring;
    AppConfig appConfig;

    @BeforeEach
    public void setUp() throws Exception {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        appConfigSpring = context.getBean(AppConfig.class);
        appConfig = new AppConfig();
    }
    @AfterEach
    public void tearDown() {
        if (context != null) {
            context.close();
        }
    }

```

Preceding code before each test:

- Creates an ***AnnotationConfigApplicationContext*** based on *AppConfig.class* and stores it to the *context* field 
- Retrieves the bean with *AppConfig*.class type and stores it to the *appConfigSpring* field
- Creates new *AppConfig* class instance and stores it to the *appConfig* field

Again what we exepect:

1. Beans got twice from *appConfigSpring* are the same instances if they are singletons and spring proxies the getting bean methods
2. Beans got twice from *appConfig* are not the same instances because new created instance of *AppConfig* class is not proxied by spring

```java
    @Test
    public void testSinleton() {
        IComponent a1 = appConfigSpring.componentA();
        IComponent a2 = appConfigSpring.componentA();

        IComponent a3 = appConfig.componentA();
        IComponent a4 = appConfig.componentA();
        
        System.out.append("a1: ").println(a1);
        System.out.append("a2: ").println(a2);
        assertSame(a1, a2, "Sigletons repeatable returned by spring config must be same");        
        System.out.append("a3: ").println(a3);
        System.out.append("a4: ").println(a4);
        assertNotSame(a3, a4, "Instances repeatable returned by config must not be same");
    }
```

Run this testcase and it results with success and console output:

```plaintext
a1: org.shikalenko.spring.proxy.ComponentA@48e92c5c
a2: org.shikalenko.spring.proxy.ComponentA@48e92c5c
a3: org.shikalenko.spring.proxy.ComponentA@7dda48d9
a4: org.shikalenko.spring.proxy.ComponentA@6e4566f1
```

What else we expect:

1. *getClass*() method of all new created instance of *AppConfig* class will return the same class which is returned by *appConfig.getClass()*
2.  *appConfig.getClass()* returns not the same class as *appConfigSpring.getClass()* returns, because instance stored in *appConfigSpring* is a proxy.

```java
    @Test
    public void testProxy() {
        AppConfig appConfig0 = new AppConfig();
        System.out.append("appConfig0: ").println(appConfig0.getClass());
        System.out.append("appConfig: ").println(appConfig.getClass());
        assertSame(appConfig0.getClass(), appConfig.getClass(), "Config directly created appConfig instances have same classes");
        System.out.append("appConfig: ").println(appConfig.getClass());
        System.out.append("appConfigSpring: ").println(appConfigSpring.getClass());
        assertNotSame(appConfig.getClass(), appConfigSpring.getClass(), "Config as bean in spring has class different with directly created appConfig");
    }
```

Run this testcase and it results with success and console output:

```plaintext
appConfig0: class org.shikalenko.spring.proxy.AppConfig
appConfig: class org.shikalenko.spring.proxy.AppConfig
appConfig: class org.shikalenko.spring.proxy.AppConfig
appConfigSpring: class org.shikalenko.spring.proxy.AppConfig$$EnhancerBySpringCGLIB$$71be8953
```

What else we expect: Beans having next types are accessible from context by class and by name:

1. String type
2. Int type
3.  Bigdecimal type

```java
    @Test 
    public void testStringBeanType() {
        String hello1 = context.getBean(String.class);
        String hello2 = appConfigSpring.hello();
        System.out.append("hello1: ").println(hello1);
        System.out.append("hello2: ").println(hello2);
        assertEquals("Hello", hello1);
        assertSame(hello1, hello2, "Instances returned by config and context must be same");
    }

    @Test 
    public void testStringBeanTypeByName() {
        String hello1 = String.valueOf(context.getBean("sayHello"));
        String hello2 = appConfigSpring.hello();
        System.out.append("hello1: ").println(hello1);
        System.out.append("hello2: ").println(hello2);
        assertEquals("Hello", hello1);
        assertSame(hello1, hello2, "Instances returned by config and context must be same");
    }

    @Test 
    public void testIntBeanType() {
        Integer int1 = context.getBean(Integer.class);
        Integer int2 = appConfigSpring.age();
        System.out.append("int1: ").println(int1);
        System.out.append("int2: ").println(int2);
        assertEquals(Integer.valueOf(18), int1);
        assertNotSame(int1, int2, "Instances returned by config int primitive method and context cannot be same");
    }

    @Test 
    public void testIntBeanTypeByName() {
        Integer int1 = (Integer) context.getBean("age");
        Integer int2 = appConfigSpring.age();
        System.out.append("int1: ").println(int1);
        System.out.append("int2: ").println(int2);
        assertEquals(Integer.valueOf(18), int1);
        assertNotSame(int1, int2, "Instances returned by config int primitive method context must cannot be same");
    }

    @Test 
    public void testBigdecimalBeanType() {
        BigDecimal age1 = context.getBean("age1", BigDecimal.class);
        BigDecimal age2 = context.getBean("age2", BigDecimal.class);
        System.out.append("age1: ").println(age1);
        System.out.append("age2: ").println(age2);
        assertEquals(BigDecimal.valueOf(18), age1);
        assertSame(age1, age2, "Instances returned by context must be same");
    }

```

Run these testcases and they results with success and console output:

```plaintext
hello1: Hello
hello2: Hello

hello1: Hello
hello2: Hello

int1: 18
int2: 18

int1: 18
int2: 18

age1: 18
age2: 18
```

What else we expect: Beans having next types are accessible from context by class and by name:

1. The exception when we try to get bean by class *ComponentA* because *AppConfig* has two methods that return instance of  *ComponentA* class: *componentA()* returns the instance of *ComponentA* while componentB() returns the instance of *ComponentB* which extends *ComponentA
2. The exception when we try to get bean by class *IComponent* because *AppConfig* has two methods that return instance of  *IComponent interface* class: *componentA()* and componentB()

```java
    @Test 
    public void testComponentsNoUniqueBeanDefinitionExtensionA() {
    	assertThrows(NoUniqueBeanDefinitionException.class, () -> context.getBean(ComponentA.class), "Exception must be thrown on ComponentA which is extended by ComponentB");
    }

    @Test 
    public void testComponentsDiffInterfacesExtendedOne() {
    	assertThrows(NoUniqueBeanDefinitionException.class, () -> context.getBean(IComponent.class), "Exception must be thrown on IComponent which is extended by IComponentExt");
    }

```

Run these testcases and they results with success and console output:

```plaintext
org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'org.shikalenko.spring.proxy.ComponentA' available: expected single matching bean but found 2: componentA,componentB

org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'org.shikalenko.spring.proxy.IComponent' available: expected single matching bean but found 2: componentA,componentB
```

## 6 Aspect-oriented programming

**AOP** – *Aspect Oriented Programming* – a programming paradigm that complements Object-oriented Programming (OOP) by providing a way to separate groups of cross-cutting concerns from business logic code.

**АОП** - *Аспектно-ориентированное программирование* - парадигма программирования, которая дополняет объектно-ориентированное программирование (ООП), предоставляя способ отделения групп сквозных проблем от кода бизнес-логики.

It is important to remember that AOP is not something that should be used instead of OOP. We should use AOP together with OOP. And when we are facing with that OOP with design patterns, SOLID concepts and such far cannot give us a proper solution to the problem, then we should look at the AOP.

Важно помнить, что АОП не следует использовать вместо ООП. Мы должны использовать АОП вместе с ООП. И когда мы сталкиваемся с этим ООП с шаблонами проектирования, концепциями SOLID и так далее, не можем дать нам правильного решения проблемы, тогда мы должны взглянуть на АОП.

It is also important not to overuse AOP because we might end up with the code that is much harder to read, maintain and debug than if you would only write pure OOP code.

Также важно не злоупотреблять АОП, потому что мы можем получить код, который будет намного сложнее читать, поддерживать и отлаживать, чем если бы вы писали только чистый ООП-код.

AOP allows us to implement cross-cutting concerns. This is achieved by the ability to add additional behaviour to the code without having to modify the code itself. This is achieved by specifying: 

АОП позволяет нам решать общие задачи. Это достигается за счет возможности добавлять к коду дополнительное поведение без необходимости изменять сам код. Это достигается указанием:

- Pointcut is matched with Join point - location of the code which behaviour should be altered. Pointcut     совпадает с точкой соединения - местоположением кода, поведение которого     следует изменить.
- Advice - code which should be executed that implements cross-cutting concern. Advice - код,     который должен быть выполнен, который реализует сквозную проблему

### What problems does AOP solve?

Aspect-Oriented Programming solves the following challenges:

Аспектно-ориентированное программирование решает следующие задачи:

- Allows proper implementation of Cross-Cutting Concerns. Позволяет правильно реализовать сквозные проблемы
- Solves Code Duplications by eliminating the need to repeat the code for functionalities across different layers, such functionalities may include logging, performance logging, monitoring, transactions, caching. Решает проблемы дублирования кода, устраняя необходимость повторения кода для функций на разных уровнях, такие функции могут включать в себя ведение журнала, ведение журнала производительности, мониторинг, транзакции, кеширование.
- Avoids mixing unrelated code, for example mixing transaction logic code (commit, rollback) with business code makes code harder to read, by separating concerns code is easier to read, interpret, maintain. Избегает смешивания несвязанного кода, например, смешивание кода логики транзакции (фиксация, откат) с бизнес-кодом затрудняет чтение кода, за счет разделения кода проблем легче читать, интерпретировать, поддерживать.

#### What is a cross-cutting concern? 

Common cross-cutting concerns:

- Logging
- Performance Logging
- Caching
- Security
- Transactions
- Monitoring

#### What two problems arise if you don't solve a cross-cutting concern via AOP? **Какие две проблемы возникают, если вы не решаете сквозную проблему с помощью АОП?**

Implementing cross-cutting concerns without using AOP, produces the following challenges:

Реализация сквозных задач без использования АОП порождает следующие проблемы:

- **Code duplications** – Before/After code duplicated in all locations when normally Advise would be applied, refactoring by extraction helps but does not fully solve the problem. **Дублирование кода** - код до и после во всех местах, когда обычно применяется Advise, рефакторинг путем извлечения помогает, но не решает проблему полностью
- **Mixing of concerns** – business logic code mixed with logging, transactions, caching makes code hard read and maintain. **Смешение     проблем** - код     бизнес-логики, смешанный с журналированием, транзакциями, кешированием,     затрудняет чтение и поддержку кода.

### Defining pointcut expressions

Thanks [baeldung.com](https://www.baeldung.com/spring-aop-pointcut-tutorial)

We will discuss the Spring AOP pointcut expression language.

We will first introduce some terminology used in aspect-oriented programming. A *join point* is a step of the program execution, such as the execution of a method or the handling of an exception. In Spring AOP, a join point always represents a method execution. A *pointcut* is a predicate that matches the join points and a *pointcut expression language* is a way of describing pointcuts programmatically.

#### Pointcut definition

##### The annotation @Pointcut

A pointcut expression can appear as a value of the *@Pointcut* annotation:

```java
@Pointcut("within(@org.springframework.stereotype.Repository *)")
public void repositoryClassMethods() {/* No body!!! */}
```

Such method declaration is called the **pointcut signature**. It provides a name that can be used by advice annotations to refer to that pointcut.

```java
@Around("repositoryClassMethods()")
public Object measureMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
    ...
}
```

##### XML  *aop:pointcut* tag

A pointcut expression could also appear as the value of the *expression* property of an *aop:pointcut* tag:

```xml
<aop:config>
    <aop:pointcut id="anyDaoMethod" 
      expression="@target(org.springframework.stereotype.Repository)"/>
</aop:config>
```

#### **Pointcut Designators**

A pointcut expression starts with a **pointcut designator (PCD)**, which is a keyword telling Spring AOP what to match. There are several pointcut designators, such as the execution of a method, a type, method arguments, or annotations.

##### ***execution***

The primary Spring PCD is *execution*, which matches method execution join points.

```java
@Pointcut("execution(public String com.baeldung.pointcutadvice.dao.FooDao.findById(Long))")
```

This example pointcut will match exactly the execution of *findById* method of the *FooDao* class. This works, but it is not very flexible. Suppose we would like to match all the methods of the *FooDao* class, which may have different signatures, return types, and arguments. To achieve this we may use wildcards:

```java
@Pointcut("execution(* com.baeldung.pointcutadvice.dao.FooDao.*(..))")
```

Here the first wildcard matches any return value, the second matches any method name, and the *(..)* pattern matches any number of parameters (zero or more).

##### ***within***

Another way to achieve the same result from the previous section is by using the *within* PCD, which limits matching to join points of certain types.

```java
@Pointcut("within(com.baeldung.pointcutadvice.dao.FooDao)")
```

We could also match any type within the *com.baeldung* package or a sub-package.

```java
@Pointcut("within(com.baeldung..*)")
```

##### ***this* and *target***

*this* limits matching to join points where the bean reference is an instance of the given type, while *target* limits matching to join points where the target object is an instance of the given type. The former works when Spring AOP creates a CGLIB-based proxy, and the latter is used when a JDK-based proxy is created. Suppose that the target class implements an interface:

```java
public class FooDao implements BarDao {
    ...
}
```

In this case, Spring AOP will use the JDK-based proxy and you should use the *target* PCD because the proxied object will be an instance of *Proxy* class and implement the *BarDao* interface:

```java
@Pointcut("target(com.baeldung.pointcutadvice.dao.BarDao)")
```

On the other hand if *FooDao* doesn't implement any interface or *proxyTargetClass* property is set to true then the proxied object will be a subclass of *FooDao* and the *this* PCD could be used:

```java
@Pointcut("this(com.baeldung.pointcutadvice.dao.FooDao)")
```

##### ***args***

This PCD is used for matching particular method arguments:

```java
@Pointcut("execution(* *..find*(Long))")
```

This pointcut matches any method that starts with find and has only one parameter of type *Long*. If we want to match a method with any number of parameters but having the fist parameter of type *Long*, we could use the following expression:

```java
@Pointcut("execution(* *..find*(Long,..))")
```

##### ***@target***

The *@target* PCD (not to be confused with the *target* PCD described above) limits matching to join points where the class of the executing object has an annotation of the given type:

```java
@Pointcut("@target(org.springframework.stereotype.Repository)")
```

#####  ***@args***

This PCD limits matching to join points where the runtime type of the actual arguments passed have annotations of the given type(s). Suppose that we want to trace all the methods accepting beans annotated with *@Entity* annotation:

```java
@Pointcut("@args(com.baeldung.pointcutadvice.annotations.Entity)")
public void methodsAcceptingEntities() {}
```

To access the argument we should provide a *JoinPoint* argument to the advice:

```java
@Before("methodsAcceptingEntities()")
public void logMethodAcceptionEntityAnnotatedBean(JoinPoint jp) {
    logger.info("Accepting beans with @Entity annotation: " + jp.getArgs()[0]);
}
```

##### ***@within***

This PCD limits matching to join points within types that have the given annotation:

```java
@Pointcut("@within(org.springframework.stereotype.Repository)")
```

Which is equivalent to:

```java
@Pointcut("within(@org.springframework.stereotype.Repository *)")
```

##### ***@annotation***

This PCD limits matching to join points where the subject of the join point has the given annotation. For example we may create a *@Loggable* annotation:

```java
@Pointcut("@annotation(com.baeldung.pointcutadvice.annotations.Loggable)")
public void loggableMethods() {}
```

Then we may log execution of the methods marked by that annotation:

```java
@Before("loggableMethods()")
public void logMethod(JoinPoint jp) {
    String methodName = jp.getSignature().getName();
    logger.info("Executing method: " + methodName);
}
```

##### **Combining Pointcut Expressions**

Pointcut expressions can be combined using **&&**, **||** and **!** operators:

```java
@Pointcut("@target(org.springframework.stereotype.Repository)")
public void repositoryMethods() {}

@Pointcut("execution(* *..create*(Long,..))")
public void firstLongParamMethods() {}

@Pointcut("repositoryMethods() && firstLongParamMethods()")
public void entityCreationMethods() {}
```

### Implementing various types of advice

Thanks [baeldung.com](https://www.baeldung.com/spring-aop-advice-tutorial)

We'll discuss different types of AOP advice that can be created in Spring.

**Advice** is an action taken by an aspect at a particular join point. **Different types of advice include “around,” “before” and “after” advice.** The main purpose of aspects is to support cross-cutting concerns, such as logging, profiling, caching, and transaction management.

#### **Enabling Advice**

With Spring, you can declare advice using AspectJ annotations, but you must first **apply the *@EnableAspectJAutoProxy* annotation to your configuration class**, which will enable support for handling components marked with AspectJ's *@Aspect* annotation.

```java
@Configuration
@EnableAspectJAutoProxy
public class AopConfiguration {
    ...
}
```

##### Spring Boot

In Spring Boot projects, we don't have to explicitly use the *@EnableAspectJAutoProxy*. There's a dedicated [*AopAutoConfiguration*](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/aop/AopAutoConfiguration.html) that enables Spring's AOP support if the *Aspect* or *Advice* is on the classpath.

#### **Before Advice**

**This advice, as the name implies, is executed before the join point.** It doesn't prevent the continued execution of the method it advises unless an exception is thrown.

Consider the following aspect that simply logs the method name before it is called:

```java
@Component
@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Pointcut("@target(org.springframework.stereotype.Repository)")
    public void repositoryMethods() {};

    @Before("repositoryMethods()")
    public void logMethodCall(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        logger.info("Before " + methodName);
    }
}
```

The *logMethodCall* advice will be executed before any repository method defined by the *repositoryMethods* pointcut.

#### **After Advice**

**After advice, declared by using the *@After* annotation, is executed after a matched method's execution, whether or not an exception was thrown.**

In some ways, it is similar to a *finally* block. In case you need advice to be triggered only after normal execution, you should use the *returning advice* declared by *@AfterReturning* annotation. If you want your advice to be triggered only when the target method throws an exception, you should use *throwing advice,* declared by using the *@AfterThrowing* annotation.

Suppose that we wish to notify some application components when a new instance of *Foo* is created. We could publish an event from *FooDao*, but this would violate the single responsibility principle.

Instead, we can accomplish this by defining the following aspect:

```java
@Component
@Aspect
public class PublishingAspect {

    private ApplicationEventPublisher eventPublisher;

    @Autowired
    public void setEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Pointcut("@target(org.springframework.stereotype.Repository)")
    public void repositoryMethods() {}

    @Pointcut("execution(* *..create*(Long,..))")
    public void firstLongParamMethods() {}

    @Pointcut("repositoryMethods() && firstLongParamMethods()")
    public void entityCreationMethods() {}

    @AfterReturning(value = "entityCreationMethods()", returning = "entity")
    public void logMethodCall(JoinPoint jp, Object entity) throws Throwable {
        eventPublisher.publishEvent(new FooCreationEvent(entity));
    }
}
```

Notice, first, that by using the *@AfterReturning* annotation we can access the target method's return value. Second, by declaring a parameter of type *JoinPoint,* we can access the arguments of the target method's invocation.

Next we create a listener which will simply log the [event](https://www.baeldung.com/spring-events):

```java
@Component
public class FooCreationEventListener implements ApplicationListener<FooCreationEvent> {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public void onApplicationEvent(FooCreationEvent event) {
        logger.info("Created foo instance: " + event.getSource().toString());
    }
}
```

#### **Around Advice**

**Around advice** surrounds a join point such as a method invocation.

This is the most powerful kind of advice. **Around advice can perform custom behavior both before and after the method invocation.** It's also responsible for choosing whether to proceed to the join point or to shortcut the advised method execution by providing its own return value or throwing an exception.

To demonstrate its use, suppose that we want to measure method execution time. Let's create an Aspect for this:

```java
@Aspect
@Component
public class PerformanceAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("within(@org.springframework.stereotype.Repository *)")
    public void repositoryClassMethods() {};

    @Around("repositoryClassMethods()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();
        Object retval = pjp.proceed();
        long end = System.nanoTime();
        String methodName = pjp.getSignature().getName();
        logger.info("Execution of " + methodName + " took " + 
          TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
        return retval;
    }
}
```

This advice is triggered when any of the join points matched by the *repositoryClassMethods* pointcut is executed.

This advice takes one parameter of type ***ProceedingJointPoint*. The parameter gives us an opportunity to take action before the target method call. I**n this case, we simply save the method start time.

Second, the advice return type is *Object* since the target method can return a result of any type. If target method is *void,* *null* will be returned. After the target method call, we can measure the timing, log it, and return the method's result value to the caller.

## 7 Testing a Spring-based Application

### Spring and Test-Driven Development

[docs.spring.io](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html)

This chapter covers Spring’s support for integration testing and best practices for unit testing. The Spring team advocates test-driven development (TDD). The Spring team has found that the correct use of inversion of control (IoC) certainly does make both unit and integration testing easier (in that the presence of setter methods and appropriate constructors on classes makes them easier to wire together in a test without having to set up service locator registries and similar structures).

#### 1. Introduction to Spring Testing

Testing is an integral part of enterprise software development. This chapter focuses on the value added by the IoC principle to [unit testing](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#unit-testing) and on the benefits of the Spring Framework’s support for [integration testing](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing). (A thorough treatment of testing in the enterprise is beyond the scope of this reference manual.)

#### 2. Unit Testing

Dependency injection should make your code less dependent on the container than it would be with traditional Java EE development. The POJOs that make up your application should be testable in JUnit or TestNG tests, with objects instantiated by using the `new` operator, without Spring or any other container. You can use [mock objects](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#mock-objects) (in conjunction with other valuable testing techniques) to test your code in isolation. If you follow the architecture recommendations for Spring, the resulting clean layering and componentization of your codebase facilitate easier unit testing. For example, you can test service layer objects by stubbing or mocking DAO or repository interfaces, without needing to access persistent data while running unit tests.

True unit tests typically run extremely quickly, as there is no runtime infrastructure to set up. Emphasizing true unit tests as part of your development methodology can boost your productivity. You may not need this section of the testing chapter to help you write effective unit tests for your IoC-based applications. For certain unit testing scenarios, however, the Spring Framework provides mock objects and testing support classes, which are described in this chapter.

##### 2.1. Mock Objects

Spring includes a number of packages dedicated to mocking:

- [Environment](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#mock-objects-env)
- [JNDI](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#mock-objects-jndi)
- [Servlet API](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#mock-objects-servlet)
- [Spring Web Reactive](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#mock-objects-web-reactive)

###### Environment

The `org.springframework.mock.env` package contains mock implementations of the `Environment` and `PropertySource` abstractions (see [Bean Definition Profiles](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-definition-profiles) and [`PropertySource` Abstraction](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-property-source-abstraction)). `MockEnvironment` and `MockPropertySource` are useful for developing out-of-container tests for code that depends on environment-specific properties.

###### JNDI

The `org.springframework.mock.jndi` package contains a partial implementation of the JNDI SPI, which you can use to set up a simple JNDI environment for test suites or stand-alone applications. If, for example, JDBC `DataSource` instances get bound to the same JNDI names in test code as they do in a Java EE container, you can reuse both application code and configuration in testing scenarios without modification.

| The mock JNDI support in the `org.springframework.mock.jndi` package is officially deprecated as of Spring Framework 5.2 in favor of complete solutions from third parties such as [Simple-JNDI](https://github.com/h-thurow/Simple-JNDI). |
| ------------------------------------------------------------ |

###### Servlet API

The `org.springframework.mock.web` package contains a comprehensive set of Servlet API mock objects that are useful for testing web contexts, controllers, and filters. These mock objects are targeted at usage with Spring’s Web MVC framework and are generally more convenient to use than dynamic mock objects (such as [EasyMock](http://easymock.org/)) or alternative Servlet API mock objects (such as [MockObjects](http://www.mockobjects.com/)).

|      | Since Spring Framework 5.0, the mock objects in `org.springframework.mock.web` are based on the Servlet 4.0 API. |
| ---- | ------------------------------------------------------------ |
|      |                                                              |

The Spring MVC Test framework builds on the mock Servlet API objects to provide an integration testing framework for Spring MVC. See [MockMvc](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-mvc-test-framework).

###### Spring Web Reactive

The `org.springframework.mock.http.server.reactive` package contains mock implementations of `ServerHttpRequest` and `ServerHttpResponse` for use in WebFlux applications. The `org.springframework.mock.web.server` package contains a mock `ServerWebExchange` that depends on those mock request and response objects.

Both `MockServerHttpRequest` and `MockServerHttpResponse` extend from the same abstract base classes as server-specific implementations and share behavior with them. For example, a mock request is immutable once created, but you can use the `mutate()` method from `ServerHttpRequest` to create a modified instance.

In order for the mock response to properly implement the write contract and return a write completion handle (that is, `Mono<Void>`), it by default uses a `Flux` with `cache().then()`, which buffers the data and makes it available for assertions in tests. Applications can set a custom write function (for example, to test an infinite stream).

The [WebTestClient](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#webtestclient) builds on the mock request and response to provide support for testing WebFlux applications without an HTTP server. The client can also be used for end-to-end tests with a running server.

##### 2.2. Unit Testing Support Classes

Spring includes a number of classes that can help with unit testing. They fall into two categories:

- [General Testing Utilities](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#unit-testing-utilities)
- [Spring MVC Testing Utilities](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#unit-testing-spring-mvc)

###### General Testing Utilities

The `org.springframework.test.util` package contains several general purpose utilities for use in unit and integration testing.

`ReflectionTestUtils` is a collection of reflection-based utility methods. You can use these methods in testing scenarios where you need to change the value of a constant, set a non-`public` field, invoke a non-`public` setter method, or invoke a non-`public` configuration or lifecycle callback method when testing application code for use cases such as the following:

- ORM frameworks (such as JPA and Hibernate) that condone `private` or `protected` field access as opposed to `public` setter methods for properties in a domain entity.
- Spring’s support for annotations (such as `@Autowired`, `@Inject`, and `@Resource`), that provide dependency injection for `private` or `protected` fields, setter methods, and configuration methods.
- Use of annotations such as `@PostConstruct` and `@PreDestroy` for lifecycle callback methods.

[`AopTestUtils`](https://docs.spring.io/spring-framework/docs/5.3.14/javadoc-api/org/springframework/test/util/AopTestUtils.html) is a collection of AOP-related utility methods. You can use these methods to obtain a reference to the underlying target object hidden behind one or more Spring proxies. For example, if you have configured a bean as a dynamic mock by using a library such as EasyMock or Mockito, and the mock is wrapped in a Spring proxy, you may need direct access to the underlying mock to configure expectations on it and perform verifications. For Spring’s core AOP utilities, see [`AopUtils`](https://docs.spring.io/spring-framework/docs/5.3.14/javadoc-api/org/springframework/aop/support/AopUtils.html) and [`AopProxyUtils`](https://docs.spring.io/spring-framework/docs/5.3.14/javadoc-api/org/springframework/aop/framework/AopProxyUtils.html).

###### Spring MVC Testing Utilities

The `org.springframework.test.web` package contains [`ModelAndViewAssert`](https://docs.spring.io/spring-framework/docs/5.3.14/javadoc-api/org/springframework/test/web/ModelAndViewAssert.html), which you can use in combination with JUnit, TestNG, or any other testing framework for unit tests that deal with Spring MVC `ModelAndView` objects.

| Unit testing Spring MVC Controllers <br />To unit test your Spring MVC `Controller` classes as POJOs, use `ModelAndViewAssert` combined with `MockHttpServletRequest`, `MockHttpSession`, and so on from Spring’s [Servlet API mocks](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#mock-objects-servlet). For thorough integration testing of your Spring MVC and REST `Controller` classes in conjunction with your `WebApplicationContext` configuration for Spring MVC, use the [Spring MVC Test Framework](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-mvc-test-framework) instead. |
| ------------------------------------------------------------ |

#### 3. Integration Testing

This section (most of the rest of this chapter) covers integration testing for Spring applications. It includes the following topics:

- [Overview](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-overview)
- [Goals of Integration Testing](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-goals)
- [JDBC Testing Support](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-support-jdbc)
- [Annotations](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations)
- [Spring TestContext Framework](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-framework)
- [MockMvc](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-mvc-test-framework)

##### 3.1. Overview

It is important to be able to perform some integration testing without requiring deployment to your application server or connecting to other enterprise infrastructure. Doing so lets you test things such as:

- The correct wiring of your Spring IoC container contexts.
- Data access using JDBC or an ORM tool. This can include such things as the correctness of SQL statements, Hibernate queries, JPA entity mappings, and so forth.

The Spring Framework provides first-class support for integration testing in the `spring-test` module. The name of the actual JAR file might include the release version and might also be in the long `org.springframework.test` form, depending on where you get it from (see the [section on Dependency Management](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#dependency-management) for an explanation). This library includes the `org.springframework.test` package, which contains valuable classes for integration testing with a Spring container. This testing does not rely on an application server or other deployment environment. Such tests are slower to run than unit tests but much faster than the equivalent Selenium tests or remote tests that rely on deployment to an application server.

Unit and integration testing support is provided in the form of the annotation-driven [Spring TestContext Framework](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-framework). The TestContext framework is agnostic of the actual testing framework in use, which allows instrumentation of tests in various environments, including JUnit, TestNG, and others.

##### 3.2. Goals of Integration Testing

Spring’s integration testing support has the following primary goals:

- To manage [Spring IoC container caching](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testing-ctx-management) between tests.
- To provide [Dependency Injection of test fixture instances](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testing-fixture-di).
- To provide [transaction management](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testing-tx) appropriate to integration testing.
- To supply [Spring-specific base classes](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testing-support-classes) that assist developers in writing integration tests.

The next few sections describe each goal and provide links to implementation and configuration details.

###### Context Management and Caching

The Spring TestContext Framework provides consistent loading of Spring `ApplicationContext` instances and `WebApplicationContext` instances as well as caching of those contexts. Support for the caching of loaded contexts is important, because startup time can become an issue — not because of the overhead of Spring itself, but because the objects instantiated by the Spring container take time to instantiate. For example, a project with 50 to 100 Hibernate mapping files might take 10 to 20 seconds to load the mapping files, and incurring that cost before running every test in every test fixture leads to slower overall test runs that reduce developer productivity.

Test classes typically declare either an array of resource locations for XML or Groovy configuration metadata — often in the classpath — or an array of component classes that is used to configure the application. These locations or classes are the same as or similar to those specified in `web.xml` or other configuration files for production deployments.

By default, once loaded, the configured `ApplicationContext` is reused for each test. Thus, the setup cost is incurred only once per test suite, and subsequent test execution is much faster. In this context, the term “test suite” means all tests run in the same JVM — for example, all tests run from an Ant, Maven, or Gradle build for a given project or module. In the unlikely case that a test corrupts the application context and requires reloading (for example, by modifying a bean definition or the state of an application object) the TestContext framework can be configured to reload the configuration and rebuild the application context before executing the next test.

See [Context Management](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-ctx-management) and [Context Caching](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-ctx-management-caching) with the TestContext framework.

###### Dependency Injection of Test Fixtures

When the TestContext framework loads your application context, it can optionally configure instances of your test classes by using Dependency Injection. This provides a convenient mechanism for setting up test fixtures by using preconfigured beans from your application context. A strong benefit here is that you can reuse application contexts across various testing scenarios (for example, for configuring Spring-managed object graphs, transactional proxies, `DataSource` instances, and others), thus avoiding the need to duplicate complex test fixture setup for individual test cases.

As an example, consider a scenario where we have a class (`HibernateTitleRepository`) that implements data access logic for a `Title` domain entity. We want to write integration tests that test the following areas:

- The Spring configuration: Basically, is everything related to the configuration of the `HibernateTitleRepository` bean correct and present?
- The Hibernate mapping file configuration: Is everything mapped correctly and are the correct lazy-loading settings in place?
- The logic of the `HibernateTitleRepository`: Does the configured instance of this class perform as anticipated?

See dependency injection of test fixtures with the [TestContext framework](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-fixture-di).

###### Transaction Management

One common issue in tests that access a real database is their effect on the state of the persistence store. Even when you use a development database, changes to the state may affect future tests. Also, many operations — such as inserting or modifying persistent data — cannot be performed (or verified) outside of a transaction.

The TestContext framework addresses this issue. By default, the framework creates and rolls back a transaction for each test. You can write code that can assume the existence of a transaction. If you call transactionally proxied objects in your tests, they behave correctly, according to their configured transactional semantics. In addition, if a test method deletes the contents of selected tables while running within the transaction managed for the test, the transaction rolls back by default, and the database returns to its state prior to execution of the test. Transactional support is provided to a test by using a `PlatformTransactionManager` bean defined in the test’s application context.

If you want a transaction to commit (unusual, but occasionally useful when you want a particular test to populate or modify the database), you can tell the TestContext framework to cause the transaction to commit instead of roll back by using the [`@Commit`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations) annotation.

See transaction management with the [TestContext framework](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-tx).

###### Support Classes for Integration Testing

The Spring TestContext Framework provides several `abstract` support classes that simplify the writing of integration tests. These base test classes provide well-defined hooks into the testing framework as well as convenient instance variables and methods, which let you access:

- The `ApplicationContext`, for performing explicit bean lookups or testing the state of the context as a whole.
- A `JdbcTemplate`, for executing SQL statements to query the database. You can use such queries to confirm database state both before and after execution of database-related application code, and Spring ensures that such queries run in the scope of the same transaction as the application code. When used in conjunction with an ORM tool, be sure to avoid [false positives](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-tx-false-positives).

In addition, you may want to create your own custom, application-wide superclass with instance variables and methods specific to your project.

See support classes for the [TestContext framework](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-support-classes).

##### 3.3. JDBC Testing Support

The `org.springframework.test.jdbc` package contains `JdbcTestUtils`, which is a collection of JDBC-related utility functions intended to simplify standard database testing scenarios. Specifically, `JdbcTestUtils` provides the following static utility methods.

- `countRowsInTable(..)`: Counts the number of rows in the given table.
- `countRowsInTableWhere(..)`: Counts the number of rows in the given table by using the provided `WHERE` clause.
- `deleteFromTables(..)`: Deletes all rows from the specified tables.
- `deleteFromTableWhere(..)`: Deletes rows from the given table by using the provided `WHERE` clause.
- `dropTables(..)`: Drops the specified tables.

| [`AbstractTransactionalJUnit4SpringContextTests`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-support-classes-junit4) and [`AbstractTransactionalTestNGSpringContextTests`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-support-classes-testng) provide convenience methods that delegate to the aforementioned methods in `JdbcTestUtils`.The `spring-jdbc` module provides support for configuring and launching an embedded database, which you can use in integration tests that interact with a database. For details, see [Embedded Database Support](https://docs.spring.io/spring-framework/docs/current/reference/html/data-access.html#jdbc-embedded-database-support) and [Testing Data Access Logic with an Embedded Database](https://docs.spring.io/spring-framework/docs/current/reference/html/data-access.html#jdbc-embedded-database-dao-testing). |
| ------------------------------------------------------------ |

##### 3.4. Annotations

This section covers annotations that you can use when you test Spring applications. It includes the following topics:

- [Spring Testing Annotations](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations-spring)
- [Standard Annotation Support](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations-standard)
- [Spring JUnit 4 Testing Annotations](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations-junit4)
- [Spring JUnit Jupiter Testing Annotations](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations-junit-jupiter)
- [Meta-Annotation Support for Testing](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations-meta)

###### Spring Testing Annotations

The Spring Framework provides the following set of Spring-specific annotations that you can use in your unit and integration tests in conjunction with the TestContext framework. See the corresponding javadoc for further information, including default attribute values, attribute aliases, and other details.

Spring’s testing annotations include the following:

- [`@BootstrapWith`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-bootstrapwith)
- [`@ContextConfiguration`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-contextconfiguration)
- [`@WebAppConfiguration`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-webappconfiguration)
- [`@ContextHierarchy`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-contexthierarchy)
- [`@ActiveProfiles`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-activeprofiles)
- [`@TestPropertySource`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-testpropertysource)
- [`@DynamicPropertySource`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-dynamicpropertysource)
- [`@DirtiesContext`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-dirtiescontext)
- [`@TestExecutionListeners`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-testexecutionlisteners)
- [`@RecordApplicationEvents`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-recordapplicationevents)
- [`@Commit`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-commit)
- [`@Rollback`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-rollback)
- [`@BeforeTransaction`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-beforetransaction)
- [`@AfterTransaction`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-aftertransaction)
- [`@Sql`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-sql)
- [`@SqlConfig`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-sqlconfig)
- [`@SqlMergeMode`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-sqlmergemode)
- [`@SqlGroup`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-sqlgroup)

###### Standard Annotation Support

The following annotations are supported with standard semantics for all configurations of the Spring TestContext Framework. Note that these annotations are not specific to tests and can be used anywhere in the Spring Framework.

- `@Autowired`
- `@Qualifier`
- `@Value`
- `@Resource` (javax.annotation) if JSR-250 is present
- `@ManagedBean` (javax.annotation) if JSR-250 is present
- `@Inject` (javax.inject) if JSR-330 is present
- `@Named` (javax.inject) if JSR-330 is present
- `@PersistenceContext` (javax.persistence) if JPA is present
- `@PersistenceUnit` (javax.persistence) if JPA is present
- `@Required`
- `@Transactional` (org.springframework.transaction.annotation) *with [limited attribute support](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-tx-attribute-support)*

| JSR-250 Lifecycle Annotations<br />In the Spring TestContext Framework, you can use `@PostConstruct` and `@PreDestroy` with standard semantics on any application components configured in the `ApplicationContext`. However, these lifecycle annotations have limited usage within an actual test class.<br /><br />If a method within a test class is annotated with `@PostConstruct`, that method runs before any before methods of the underlying test framework (for example, methods annotated with JUnit Jupiter’s `@BeforeEach`), and that applies for every test method in the test class. On the other hand, if a method within a test class is annotated with `@PreDestroy`, that method never runs. Therefore, within a test class, we recommend that you use test lifecycle callbacks from the underlying test framework instead of `@PostConstruct` and `@PreDestroy`. |
| ------------------------------------------------------------ |

###### Spring JUnit 4 Testing Annotations

The following annotations are supported only when used in conjunction with the [SpringRunner](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-junit4-runner), [Spring’s JUnit 4 rules](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-junit4-rules), or [Spring’s JUnit 4 support classes](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-support-classes-junit4):

- [`@IfProfileValue`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations-junit4-ifprofilevalue)
- [`@ProfileValueSourceConfiguration`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations-junit4-profilevaluesourceconfiguration)
- [`@Timed`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations-junit4-timed)
- [`@Repeat`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations-junit4-repeat)

###### Spring JUnit Jupiter Testing Annotations

The following annotations are supported when used in conjunction with the [`SpringExtension`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-junit-jupiter-extension) and JUnit Jupiter (that is, the programming model in JUnit 5):

- [`@SpringJUnitConfig`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations-junit-jupiter-springjunitconfig)
- [`@SpringJUnitWebConfig`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations-junit-jupiter-springjunitwebconfig)
- [`@TestConstructor`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations-testconstructor)
- [`@NestedTestConfiguration`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations-nestedtestconfiguration)
- [`@EnabledIf`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations-junit-jupiter-enabledif)
- [`@DisabledIf`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations-junit-jupiter-disabledif)

###### Meta-Annotation Support for Testing

You can use most test-related annotations as [meta-annotations](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-meta-annotations) to create custom composed annotations and reduce configuration duplication across a test suite.

You can use each of the following as a meta-annotation in conjunction with the [TestContext framework](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-framework).

- `@BootstrapWith`
- `@ContextConfiguration`
- `@ContextHierarchy`
- `@ActiveProfiles`
- `@TestPropertySource`
- `@DirtiesContext`
- `@WebAppConfiguration`
- `@TestExecutionListeners`
- `@Transactional`
- `@BeforeTransaction`
- `@AfterTransaction`
- `@Commit`
- `@Rollback`
- `@Sql`
- `@SqlConfig`
- `@SqlMergeMode`
- `@SqlGroup`
- `@Repeat` *(only supported on JUnit 4)*
- `@Timed` *(only supported on JUnit 4)*
- `@IfProfileValue` *(only supported on JUnit 4)*
- `@ProfileValueSourceConfiguration` *(only supported on JUnit 4)*
- `@SpringJUnitConfig` *(only supported on JUnit Jupiter)*
- `@SpringJUnitWebConfig` *(only supported on JUnit Jupiter)*
- `@TestConstructor` *(only supported on JUnit Jupiter)*
- `@NestedTestConfiguration` *(only supported on JUnit Jupiter)*
- `@EnabledIf` *(only supported on JUnit Jupiter)*
- `@DisabledIf` *(only supported on JUnit Jupiter)*

##### 3.5. Spring TestContext Framework

[docs.spring.io](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-framework)



### Spring 5 integration testing with JUnit 5

[docs.spring.io](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-junit-jupiter-extension)

##### SpringExtension for JUnit Jupiter

The Spring TestContext Framework offers full integration with the JUnit Jupiter testing framework, introduced in JUnit 5. By annotating test classes with `@ExtendWith(SpringExtension.class)`, you can implement standard JUnit Jupiter-based unit and integration tests and simultaneously reap the benefits of the TestContext framework, such as support for loading application contexts, dependency injection of test instances, transactional test method execution, and so on.

Furthermore, thanks to the rich extension API in JUnit Jupiter, Spring provides the following features above and beyond the feature set that Spring supports for JUnit 4 and TestNG:

- Dependency injection for test constructors, test methods, and test lifecycle callback methods. See [Dependency Injection with `SpringExtension`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-junit-jupiter-di) for further details.
- Powerful support for [conditional test execution](https://junit.org/junit5/docs/current/user-guide/#extensions-conditions) based on SpEL expressions, environment variables, system properties, and so on. See the documentation for `@EnabledIf` and `@DisabledIf` in [Spring JUnit Jupiter Testing Annotations](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations-junit-jupiter) for further details and examples.
- Custom composed annotations that combine annotations from Spring and JUnit Jupiter. See the `@TransactionalDevTestConfig` and `@TransactionalIntegrationTest` examples in [Meta-Annotation Support for Testing](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations-meta) for further details.

The following code listing shows how to configure a test class to use the `SpringExtension` in conjunction with `@ContextConfiguration`:

```java
// Instructs JUnit Jupiter to extend the test with Spring support.
@ExtendWith(SpringExtension.class)
// Instructs Spring to load an ApplicationContext from TestConfig.class
@ContextConfiguration(classes = TestConfig.class)
class SimpleTests {

    @Test
    void testMethod() {
        // test logic...
    }
}
```

Since you can also use annotations in JUnit 5 as meta-annotations, Spring provides the `@SpringJUnitConfig` and `@SpringJUnitWebConfig` composed annotations to simplify the configuration of the test `ApplicationContext` and JUnit Jupiter.

The following example uses `@SpringJUnitConfig` to reduce the amount of configuration used in the previous example:

```java
// Instructs Spring to register the SpringExtension with JUnit
// Jupiter and load an ApplicationContext from TestConfig.class
@SpringJUnitConfig(TestConfig.class)
class SimpleTests {

    @Test
    void testMethod() {
        // test logic...
    }
}
```

Similarly, the following example uses `@SpringJUnitWebConfig` to create a `WebApplicationContext` for use with JUnit Jupiter:

```java
// Instructs Spring to register the SpringExtension with JUnit
// Jupiter and load a WebApplicationContext from TestWebConfig.class
@SpringJUnitWebConfig(TestWebConfig.class)
class SimpleWebTests {

    @Test
    void testMethod() {
        // test logic...
    }
}
```

See the documentation for `@SpringJUnitConfig` and `@SpringJUnitWebConfig` in [Spring JUnit Jupiter Testing Annotations](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations-junit-jupiter) for further details.

### Application context caching and the @DirtiesContext annotation

[docs.spring.io](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-ctx-management-caching)

##### Context Caching

Once the TestContext framework loads an `ApplicationContext` (or `WebApplicationContext`) for a test, that context is cached and reused for all subsequent tests that declare the same unique context configuration within the same test suite. To understand how caching works, it is important to understand what is meant by “unique” and “test suite.”

An `ApplicationContext` can be uniquely identified by the combination of configuration parameters that is used to load it. Consequently, the unique combination of configuration parameters is used to generate a key under which the context is cached. The TestContext framework uses the following configuration parameters to build the context cache key:

- `locations` (from `@ContextConfiguration`)
- `classes` (from `@ContextConfiguration`)
- `contextInitializerClasses` (from `@ContextConfiguration`)
- `contextCustomizers` (from `ContextCustomizerFactory`) – this includes `@DynamicPropertySource` methods as well as various features from Spring Boot’s testing support such as `@MockBean` and `@SpyBean`.
- `contextLoader` (from `@ContextConfiguration`)
- `parent` (from `@ContextHierarchy`)
- `activeProfiles` (from `@ActiveProfiles`)
- `propertySourceLocations` (from `@TestPropertySource`)
- `propertySourceProperties` (from `@TestPropertySource`)
- `resourceBasePath` (from `@WebAppConfiguration`)

For example, if `TestClassA` specifies `{"app-config.xml", "test-config.xml"}` for the `locations` (or `value`) attribute of `@ContextConfiguration`, the TestContext framework loads the corresponding `ApplicationContext` and stores it in a `static` context cache under a key that is based solely on those locations. So, if `TestClassB` also defines `{"app-config.xml", "test-config.xml"}` for its locations (either explicitly or implicitly through inheritance) but does not define `@WebAppConfiguration`, a different `ContextLoader`, different active profiles, different context initializers, different test property sources, or a different parent context, then the same `ApplicationContext` is shared by both test classes. This means that the setup cost for loading an application context is incurred only once (per test suite), and subsequent test execution is much faster.

| Test suites and forked processes<br />The Spring TestContext framework stores application contexts in a static cache. This means that the context is literally stored in a `static` variable. In other words, if tests run in separate processes, the static cache is cleared between each test execution, which effectively disables the caching mechanism.<br /><br />To benefit from the caching mechanism, all tests must run within the same process or test suite. This can be achieved by executing all tests as a group within an IDE. Similarly, when executing tests with a build framework such as Ant, Maven, or Gradle, it is important to make sure that the build framework does not fork between tests. For example, if the [`forkMode`](https://maven.apache.org/plugins/maven-surefire-plugin/test-mojo.html#forkMode) for the Maven Surefire plug-in is set to `always` or `pertest`, the TestContext framework cannot cache application contexts between test classes, and the build process runs significantly more slowly as a result. |
| ------------------------------------------------------------ |

The size of the context cache is bounded with a default maximum size of 32. Whenever the maximum size is reached, a least recently used (LRU) eviction policy is used to evict and close stale contexts. You can configure the maximum size from the command line or a build script by setting a JVM system property named `spring.test.context.cache.maxSize`. As an alternative, you can set the same property via the [`SpringProperties`](https://docs.spring.io/spring-framework/docs/current/reference/html/appendix.html#appendix-spring-properties) mechanism.

Since having a large number of application contexts loaded within a given test suite can cause the suite to take an unnecessarily long time to run, it is often beneficial to know exactly how many contexts have been loaded and cached. To view the statistics for the underlying context cache, you can set the log level for the `org.springframework.test.context.cache` logging category to `DEBUG`.

In the unlikely case that a test corrupts the application context and requires reloading (for example, by modifying a bean definition or the state of an application object), you can annotate your test class or test method with `@DirtiesContext` (see the discussion of `@DirtiesContext` in [Spring Testing Annotations](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-dirtiescontext)). This instructs Spring to remove the context from the cache and rebuild the application context before running the next test that requires the same application context. Note that support for the `@DirtiesContext` annotation is provided by the `DirtiesContextBeforeModesTestExecutionListener` and the `DirtiesContextTestExecutionListener`, which are enabled by default.

### Profile selection with @ActiveProfiles

[docs.spring.io](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-activeprofiles)

##### `@ActiveProfiles`

`@ActiveProfiles` is a class-level annotation that is used to declare which bean definition profiles should be active when loading an `ApplicationContext` for an integration test.

The following example indicates that the `dev` profile should be active:

```java
@ContextConfiguration
@ActiveProfiles("dev") 
class DeveloperTests {
    // class body...
}
```

| Indicate that the `dev` profile should be active. |
| ------------------------------------------------- |

The following example indicates that both the `dev` and the `integration` profiles should be active:

```java
@ContextConfiguration
@ActiveProfiles({"dev", "integration"}) 
class DeveloperIntegrationTests {
    // class body...
}
```

| Indicate that the `dev` and `integration` profiles should be active. |
| ------------------------------------------------------------ |

| `@ActiveProfiles` provides support for inheriting active bean definition profiles declared by superclasses and enclosing classes by default. You can also resolve active bean definition profiles programmatically by implementing a custom [`ActiveProfilesResolver`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-ctx-management-env-profiles-ActiveProfilesResolver) and registering it by using the `resolver` attribute of `@ActiveProfiles`. |
| ------------------------------------------------------------ |

See [Context Configuration with Environment Profiles](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-ctx-management-env-profiles), [`@Nested` test class configuration](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-junit-jupiter-nested-test-configuration), and the [`@ActiveProfiles`](https://docs.spring.io/spring-framework/docs/5.3.14/javadoc-api/org/springframework/test/context/ActiveProfiles.html) javadoc for examples and further details.

### Easy test data setup with @Sql

[docs.spring.io](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-sql)

##### `@Sql`

`@Sql` is used to annotate a test class or test method to configure SQL scripts to be run against a given database during integration tests. The following example shows how to use it:

```java
@Test
@Sql({"/test-schema.sql", "/test-user-data.sql"}) 
void userTest() {
    // run code that relies on the test schema and test data
}
```

| Run two scripts for this test. |
| ------------------------------ |

See [Executing SQL scripts declaratively with @Sql](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-executing-sql-declaratively) for further details.

##### `@SqlConfig`

`@SqlConfig` defines metadata that is used to determine how to parse and run SQL scripts configured with the `@Sql` annotation. The following example shows how to use it:

```java
@Test
@Sql(
    scripts = "/test-user-data.sql",
    config = @SqlConfig(commentPrefix = "`", separator = "@@") 
)
void userTest() {
    // run code that relies on the test data
}
```

| Set the comment prefix and the separator in SQL scripts. |
| -------------------------------------------------------- |

##### `@SqlMergeMode`

`@SqlMergeMode` is used to annotate a test class or test method to configure whether method-level `@Sql` declarations are merged with class-level `@Sql` declarations. If `@SqlMergeMode` is not declared on a test class or test method, the `OVERRIDE` merge mode will be used by default. With the `OVERRIDE` mode, method-level `@Sql` declarations will effectively override class-level `@Sql` declarations.

Note that a method-level `@SqlMergeMode` declaration overrides a class-level declaration.

The following example shows how to use `@SqlMergeMode` at the class level.

```java
@SpringJUnitConfig(TestConfig.class)
@Sql("/test-schema.sql")
@SqlMergeMode(MERGE) 
class UserTests {

    @Test
    @Sql("/user-test-data-001.sql")
    void standardUserProfile() {
        // run code that relies on test data set 001
    }
}
```

| Set the `@Sql` merge mode to `MERGE` for all test methods in the class. |
| ------------------------------------------------------------ |

The following example shows how to use `@SqlMergeMode` at the method level.

```java
@SpringJUnitConfig(TestConfig.class)
@Sql("/test-schema.sql")
class UserTests {

    @Test
    @Sql("/user-test-data-001.sql")
    @SqlMergeMode(MERGE) 
    void standardUserProfile() {
        // run code that relies on test data set 001
    }
}
```

| Set the `@Sql` merge mode to `MERGE` for a specific test method. |
| ------------------------------------------------------------ |

##### `@SqlGroup`

`@SqlGroup` is a container annotation that aggregates several `@Sql` annotations. You can use `@SqlGroup` natively to declare several nested `@Sql` annotations, or you can use it in conjunction with Java 8’s support for repeatable annotations, where `@Sql` can be declared several times on the same class or method, implicitly generating this container annotation. The following example shows how to declare an SQL group:

```java
@Test
@SqlGroup({ 
    @Sql(scripts = "/test-schema.sql", config = @SqlConfig(commentPrefix = "`")),
    @Sql("/test-user-data.sql")
)}
void userTest() {
    // run code that uses the test schema and test data
}
```

| Declare a group of SQL scripts. |
| ------------------------------- |

#### Executing SQL Scripts

[docs.spring.io](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-sql)

When writing integration tests against a relational database, it is often beneficial to run SQL scripts to modify the database schema or insert test data into tables. The `spring-jdbc` module provides support for *initializing* an embedded or existing database by executing SQL scripts when the Spring `ApplicationContext` is loaded. See [Embedded database support](https://docs.spring.io/spring-framework/docs/current/reference/html/data-access.html#jdbc-embedded-database-support) and [Testing data access logic with an embedded database](https://docs.spring.io/spring-framework/docs/current/reference/html/data-access.html#jdbc-embedded-database-dao-testing) for details.

Although it is very useful to initialize a database for testing *once* when the `ApplicationContext` is loaded, sometimes it is essential to be able to modify the database *during* integration tests. The following sections explain how to run SQL scripts programmatically and declaratively during integration tests.

##### Executing SQL scripts programmatically

Spring provides the following options for executing SQL scripts programmatically within integration test methods.

- `org.springframework.jdbc.datasource.init.ScriptUtils`
- `org.springframework.jdbc.datasource.init.ResourceDatabasePopulator`
- `org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests`
- `org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests`

`ScriptUtils` provides a collection of static utility methods for working with SQL scripts and is mainly intended for internal use within the framework. However, if you require full control over how SQL scripts are parsed and run, `ScriptUtils` may suit your needs better than some of the other alternatives described later. See the [javadoc](https://docs.spring.io/spring-framework/docs/5.3.14/javadoc-api/org/springframework/jdbc/datasource/init/ScriptUtils.html) for individual methods in `ScriptUtils` for further details.

`ResourceDatabasePopulator` provides an object-based API for programmatically populating, initializing, or cleaning up a database by using SQL scripts defined in external resources. `ResourceDatabasePopulator` provides options for configuring the character encoding, statement separator, comment delimiters, and error handling flags used when parsing and running the scripts. Each of the configuration options has a reasonable default value. See the [javadoc](https://docs.spring.io/spring-framework/docs/5.3.14/javadoc-api/org/springframework/jdbc/datasource/init/ResourceDatabasePopulator.html) for details on default values. To run the scripts configured in a `ResourceDatabasePopulator`, you can invoke either the `populate(Connection)` method to run the populator against a `java.sql.Connection` or the `execute(DataSource)` method to run the populator against a `javax.sql.DataSource`. The following example specifies SQL scripts for a test schema and test data, sets the statement separator to `@@`, and run the scripts against a `DataSource`:

```java
@Test
void databaseTest() {
    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
    populator.addScripts(
            new ClassPathResource("test-schema.sql"),
            new ClassPathResource("test-data.sql"));
    populator.setSeparator("@@");
    populator.execute(this.dataSource);
    // run code that uses the test schema and data
}
```

Note that `ResourceDatabasePopulator` internally delegates to `ScriptUtils` for parsing and running SQL scripts. Similarly, the `executeSqlScript(..)` methods in [`AbstractTransactionalJUnit4SpringContextTests`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-support-classes-junit4) and [`AbstractTransactionalTestNGSpringContextTests`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-support-classes-testng) internally use a `ResourceDatabasePopulator` to run SQL scripts. See the Javadoc for the various `executeSqlScript(..)` methods for further details.

##### Executing SQL scripts declaratively with @Sql

[docs.spring.io](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-executing-sql-declaratively)

## 8 Data Accss and JDBC with Spring

Thanks [baeldung.com](https://www.baeldung.com/spring-interview-questions#Q23)

### How Spring integrates with existing data access technologies

There is an [entire series](https://www.baeldung.com/persistence-with-spring-series/) discussing persistence in Spring that provides a more in-depth look.

[How Spring integrates with existing data access technologies](https://docs.spring.io/spring-framework/docs/current/reference/html/data-access.html#dao)

#### DAO Support

The Data Access Object (DAO) support in Spring is aimed at making it easy to work with data access technologies (such as JDBC, Hibernate, or JPA) in a consistent way. This lets you switch between the aforementioned persistence technologies fairly easily, and it also lets you code without worrying about catching exceptions that are specific to each technology.

### DataAccessException hierarchy

Spring provides a convenient translation from technology-specific exceptions, such as `SQLException` to its own exception class hierarchy, which has `DataAccessException` as the root exception. These exceptions wrap the original exception so that there is never any risk that you might lose any information about what might have gone wrong.

In addition to JDBC exceptions, Spring can also wrap JPA- and Hibernate-specific exceptions, converting them to a set of focused runtime exceptions. This lets you handle most non-recoverable persistence exceptions in only the appropriate layers, without having annoying boilerplate catch-and-throw blocks and exception declarations in your DAOs. (You can still trap and handle exceptions anywhere you need to though.) As mentioned above, JDBC exceptions (including database-specific dialects) are also converted to the same hierarchy, meaning that you can perform some operations with JDBC within a consistent programming model.

The following image shows the exception hierarchy that Spring provides. (Note that the class hierarchy detailed in the image shows only a subset of the entire `DataAccessException` hierarchy.)

![DataAccessException](https://docs.spring.io/spring-framework/docs/current/reference/html/images/DataAccessException.png)

### Spring‘s JdbcTemplate

Thanks [baeldung.com](https://www.baeldung.com/spring-jdbc-jdbctemplate)

#### **1. Overview**

We'll go through practical use cases of the Spring JDBC module (spring-jdbc).

All the classes in Spring JDBC are divided into four separate packages:

- ***core*** — the core functionality of JDBC. Some of the important classes under this package include *JdbcTemplate*, *SimpleJdbcInsert*, *SimpleJdbcCall* and *NamedParameterJdbcTemplate*.
- ***datasource*** — utility classes to access a data source. It also has various data source implementations for testing JDBC code outside the Jakarta EE container.
- ***object*** — DB access in an object-oriented manner. It allows running queries and returning the results as a business object. It also maps the query results between the columns and properties of business objects.
- ***support*** — support classes for classes under *core* and *object* packages, e.g., provides the *SQLException* translation functionality

#### **2. Configuration**

Let's start with some simple configuration of the data source.

We'll use a MySQL database:

```java
@Configuration
@ComponentScan("com.baeldung.jdbc")
public class SpringJdbcConfig {
    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
        dataSource.setUsername("guest_user");
        dataSource.setPassword("guest_password");

        return dataSource;
    }
}
```

Alternatively, we can also make good use of an embedded database for development or testing.

Here is a quick configuration that creates an instance of H2 embedded database and pre-populates it with simple SQL scripts:

```java
@Bean
public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()
      .setType(EmbeddedDatabaseType.H2)
      .addScript("classpath:jdbc/schema.sql")
      .addScript("classpath:jdbc/test-data.sql").build();
}
```

Finally, the same can be done using XML configuring for the *datasource*:

```java
<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" 
  destroy-method="close">
    <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://localhost:3306/springjdbc"/>
    <property name="username" value="guest_user"/>
    <property name="password" value="guest_password"/>
</bean>
```

Then we can create *jdbcTemplate* from any injection of *dataSource* bean.

```java
jdbcTemplate = new JdbcTemplate(dataSource);
```



#### **3. The *JdbcTemplate* and Running Queries**

##### **3.1. Basic Queries**

The JDBC template is the main API through which we'll access most of the functionality that we're interested in:

- creation and closing of connections
- running statements and stored procedure calls
- iterating over the *ResultSet* and returning results

First, let’s start with a simple example to see what the *JdbcTemplate* can do:

```java
int result = jdbcTemplate.queryForObject(
    "SELECT COUNT(*) FROM EMPLOYEE", Integer.class);
```

And here's a simple INSERT:

```java
public int addEmplyee(int id) {
    return jdbcTemplate.update(
      "INSERT INTO EMPLOYEE VALUES (?, ?, ?, ?)", id, "Bill", "Gates", "USA");
}
```

Notice the standard syntax of providing parameters using the *?* character.

Next, let's look at an alternative to this syntax.

##### **3.2. Queries With Named Parameters**

To get **support for named parameters**, we'll use the other JDBC template provided by the framework — the *NamedParameterJdbcTemplate*.

Additionally, this wraps the *JbdcTemplate* and provides an alternative to the traditional syntax using ? to specify parameters.

Under the hood, it substitutes the named parameters to JDBC *?* placeholder and delegates to the wrapped *JDBCTemplate* to run the queries:

```java
namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", 1);
return namedParameterJdbcTemplate.queryForObject(
  "SELECT FIRST_NAME FROM EMPLOYEE WHERE ID = :id", namedParameters, String.class);
```

Notice how we are using the *MapSqlParameterSource* to provide the values for the named parameters.

Let's look at using properties from a bean to determine the named parameters:

```java
namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
Employee employee = new Employee();
employee.setFirstName("James");

String SELECT_BY_ID = "SELECT COUNT(*) FROM EMPLOYEE WHERE FIRST_NAME = :firstName";

SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(employee);
return namedParameterJdbcTemplate.queryForObject(
  SELECT_BY_ID, namedParameters, Integer.class);
```

Note how we're now using the *BeanPropertySqlParameterSource* implementations instead of specifying the named parameters manually like before.

##### **3.3. Mapping Query Results to Java Object**

Another very useful feature is the ability to map query results to Java objects by implementing the *RowMapper* interface.

For example, for every row returned by the query, Spring uses the row mapper to populate the java bean:

```java
public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();

        employee.setId(rs.getInt("ID"));
        employee.setFirstName(rs.getString("FIRST_NAME"));
        employee.setLastName(rs.getString("LAST_NAME"));
        employee.setAddress(rs.getString("ADDRESS"));

        return employee;
    }
}
```

Subsequently, we can now pass the row mapper to the query API and get fully populated Java objects:

```java
String query = "SELECT * FROM EMPLOYEE WHERE ID = ?";
Employee employee = jdbcTemplate.queryForObject(
  query, new Object[] { id }, new EmployeeRowMapper());
```

#### **4. Exception Translation**

Spring comes with its own data exception hierarchy out of the box — with *DataAccessException* as the root exception — and it translates all underlying raw exceptions to it.

So, we keep our sanity by not handling low-level persistence exceptions. We also benefit from the fact that Spring wraps the low-level exceptions in *DataAccessException* or one of its sub-classes.

This also keeps the exception handling mechanism independent of the underlying database we are using.

Besides the default *SQLErrorCodeSQLExceptionTranslator*, we can also provide our own implementation of *SQLExceptionTranslator*.

Here's a quick example of a custom implementation — customizing the error message when there is a duplicate key violation, which results in [error code 23505](https://www.h2database.com/javadoc/org/h2/api/ErrorCode.html#c23505) when using H2:

```java
public class CustomSQLErrorCodeTranslator extends SQLErrorCodeSQLExceptionTranslator {
    @Override
    protected DataAccessException
      customTranslate(String task, String sql, SQLException sqlException) {
        if (sqlException.getErrorCode() == 23505) {
          return new DuplicateKeyException(
            "Custom Exception translator - Integrity constraint violation.", sqlException);
        }
        return null;
    }
}
```

To use this custom exception translator, we need to pass it to the *JdbcTemplate* by calling *setExceptionTranslator()* method:

```java
CustomSQLErrorCodeTranslator customSQLErrorCodeTranslator = 
  new CustomSQLErrorCodeTranslator();
jdbcTemplate.setExceptionTranslator(customSQLErrorCodeTranslator);
```

#### **5. JDBC Operations Using SimpleJdbc Classes**

*SimpleJdbc* classes provide an easy way to configure and run SQL statements. These classes use database metadata to build basic queries. So, *SimpleJdbcInsert* and *SimpleJdbcCall* classes provide an easier way to run insert and stored procedure calls.

##### **5.1. *SimpleJdbcInsert***

Let's take a look at running simple insert statements with minimal configuration.

**The INSERT statement is generated based on the configuration of *SimpleJdbcInsert*.** All we need is to provide the Table name, Column names and values.

First, let's create a *SimpleJdbcInsert*:

```java
SimpleJdbcInsert simpleJdbcInsert = 
  new SimpleJdbcInsert(dataSource).withTableName("EMPLOYEE");
```

Next, let's provide the Column names and values, and run the operation:

```java
public int addEmplyee(Employee emp) {
    Map<String, Object> parameters = new HashMap<String, Object>();
    parameters.put("ID", emp.getId());
    parameters.put("FIRST_NAME", emp.getFirstName());
    parameters.put("LAST_NAME", emp.getLastName());
    parameters.put("ADDRESS", emp.getAddress());

    return simpleJdbcInsert.execute(parameters);
}
```

Further, we can use the *executeAndReturnKey()* API to allow the **database to generate the primary key**. We'll also need to configure the actual auto-generated column:

```java
SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                                        .withTableName("EMPLOYEE")
                                        .usingGeneratedKeyColumns("ID");

Number id = simpleJdbcInsert.executeAndReturnKey(parameters);
System.out.println("Generated id - " + id.longValue());
```

Finally, we can also pass in this data by using the *BeanPropertySqlParameterSource* and *MapSqlParameterSource*.

##### **5.2. Stored Procedures With *SimpleJdbcCall***

Let's also take a look at running stored procedures.

We'll make use of the *SimpleJdbcCall* abstraction:

```java
SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource)
		                     .withProcedureName("READ_EMPLOYEE");
public Employee getEmployeeUsingSimpleJdbcCall(int id) {
    SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
    Map<String, Object> out = simpleJdbcCall.execute(in);

    Employee emp = new Employee();
    emp.setFirstName((String) out.get("FIRST_NAME"));
    emp.setLastName((String) out.get("LAST_NAME"));

    return emp;
}
```

#### **6. Batch Operations**

Another simple use case is batching multiple operations together.

##### **6.1. Basic Batch Operations Using *JdbcTemplate***

Using *JdbcTemplate*, *Batch Operations* can be run via the *batchUpdate()* API.

The interesting part here is the concise but highly useful *BatchPreparedStatementSetter* implementation:

```java
public int[] batchUpdateUsingJdbcTemplate(List<Employee> employees) {
    return jdbcTemplate.batchUpdate("INSERT INTO EMPLOYEE VALUES (?, ?, ?, ?)",
        new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, employees.get(i).getId());
                ps.setString(2, employees.get(i).getFirstName());
                ps.setString(3, employees.get(i).getLastName());
                ps.setString(4, employees.get(i).getAddress();
            }
            @Override
            public int getBatchSize() {
                return 50;
            }
        });
}
```

##### **6.2. Batch Operations Using *NamedParameterJdbcTemplate***

We also have the option of batching operations with the *NamedParameterJdbcTemplate* – *batchUpdate()* API.

This API is simpler than the previous one. So, there's no need to implement any extra interfaces to set the parameters, as it has an internal prepared statement setter to set the parameter values.

Instead, the parameter values can be passed to the *batchUpdate()* method as an array of *SqlParameterSource*.

```java
namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(employees.toArray());
int[] updateCounts = namedParameterJdbcTemplate.batchUpdate(
    "INSERT INTO EMPLOYEE VALUES (:id, :firstName, :lastName, :address)", batch);
return updateCounts;
```

## 9 Database Transactions with Spring

Thanks [baeldung.com](https://www.baeldung.com/java-transactions#what_is_transaction)

### What Is a Transaction?

Transactions in Java, as in general refer to [a series of actions that must all complete successfully](https://www.baeldung.com/transactions-intro). Hence, **if one or more action fails, all other actions must back out leaving the state of the application unchanged**. This is necessary to ensure that the integrity of the application state is never compromised.

Also, these transactions may involve one or more resources like database, message queue, giving rise to different ways to perform actions under a transaction. These include performing resource local transactions with individual resources. Alternatively, multiple resources can participate in a global transaction.

### Transactions overview

Thanks [tutorialspoint.com](https://www.tutorialspoint.com/spring/spring_transaction_management.htm)

A database transaction is a sequence of actions that are treated as a single unit of work. These actions should either complete entirely or take no effect at all. Transaction management is an important part of RDBMS-oriented enterprise application to ensure data integrity and consistency. The concept of transactions can be described with the following four key properties described as **ACID** −

- **Atomicity** − A transaction should be treated as a single unit of operation, which means either the entire sequence of operations is successful or unsuccessful.
- **Consistency** − This represents the consistency of the referential integrity of the database, unique primary keys in tables, etc.
- **Isolation** − There may be many transaction processing with the same data set at the same time. Each transaction should be isolated from others to prevent data corruption.
- **Durability** − Once a transaction has completed, the results of this transaction have to be made permanent and cannot be erased from the database due to system failure.

A real RDBMS database system will guarantee all four properties for each transaction. The simplistic view of a transaction issued to the database using SQL is as follows −

- Begin the transaction using *begin transaction* command.
- Perform various deleted, update or insert operations using SQL queries.
- If all the operation are successful then perform *commit* otherwise *rollback* all the operations.

#### Local vs. Global Transactions

Local transactions are specific to a single transactional resource like a JDBC connection, whereas global transactions can span multiple transactional resources like transaction in a distributed system.

Local transaction management can be useful in a centralized computing environment where application components and resources are located at a single site, and transaction management only involves a local data manager running on a single machine. Local transactions are easier to be implemented.

Global transaction management is required in a distributed computing environment where all the resources are distributed across multiple systems. In such a case, transaction management needs to be done both at local and global levels. A distributed or a global transaction is executed across multiple systems, and its execution requires coordination between the global transaction management system and all the local data managers of all the involved systems.

### Transaction management with Spring

Thanks [tutorialspoint.com](https://www.tutorialspoint.com/spring/spring_transaction_management.htm)

Spring framework provides an abstract layer on top of different underlying transaction management APIs. Spring's transaction support aims to provide an alternative to EJB transactions by adding transaction capabilities to POJOs. Spring supports both programmatic and declarative transaction management. EJBs require an application server, but Spring transaction management can be implemented without the need of an application server.

#### Programmatic vs. Declarative

Spring supports two types of transaction management −

- [Programmatic transaction management](https://www.tutorialspoint.com/spring/programmatic_management.htm) − This means that you have to manage the transaction with the help of programming. That gives you extreme flexibility, but it is difficult to maintain.
- [Declarative transaction management](https://www.tutorialspoint.com/spring/declarative_management.htm) − This means you separate transaction management from the business code. You only use annotations or XML-based configuration to manage the transactions.

Declarative transaction management is preferable over programmatic transaction management though it is less flexible than programmatic transaction management, which allows you to control transactions through your code. But as a kind of crosscutting concern, declarative transaction management can be modularized with the AOP approach. Spring supports declarative transaction management through the Spring AOP framework.

#### Spring Transaction Abstractions

The key to the Spring transaction abstraction is defined by the *org.springframework.transaction.PlatformTransactionManager* interface, which is as follows −

```java
public interface PlatformTransactionManager {
   TransactionStatus getTransaction(TransactionDefinition definition);
   throws TransactionException;
   
   void commit(TransactionStatus status) throws TransactionException;
   void rollback(TransactionStatus status) throws TransactionException;
}
```



| Sr.No | Method & Description                                         |
| :---: | :----------------------------------------------------------- |
|   1   | **TransactionStatus getTransaction(TransactionDefinition definition)**<br />This method returns a currently active transaction or creates a new one, according to the specified propagation behavior. |
|   2   | **void commit(TransactionStatus status)**<br />This method commits the given transaction, with regard to its status. |
|   3   | **void rollback(TransactionStatus status)**<br />This method performs a rollback of the given transaction. |

The *TransactionDefinition* is the core interface of the transaction support in Spring and it is defined as follows −

```java
public interface TransactionDefinition {
   int getPropagationBehavior();
   int getIsolationLevel();
   String getName();
   int getTimeout();
   boolean isReadOnly();
}
```

| Sr.No | Method & Description                                         |
| :---: | :----------------------------------------------------------- |
|   1   | **int getPropagationBehavior()**<br />This method returns the propagation behavior. Spring offers all of the transaction propagation options familiar from EJB CMT. |
|   2   | **int getIsolationLevel()**<br />This method returns the degree to which this transaction is isolated from the work of other transactions. |
|   3   | **String getName()**<br />This method returns the name of this transaction. |
|   4   | **int getTimeout()**<br />This method returns the time in seconds in which the transaction must complete. |
|   5   | **boolean isReadOnly()**<br />This method returns whether the transaction is read-only. |

### Transaction isolation levels

Following are the possible values for isolation level −

| Sr.No | Isolation & Description                                      |
| :---: | :----------------------------------------------------------- |
|   1   | **TransactionDefinition.ISOLATION_DEFAULT**<br />This is the default isolation level. |
|   2   | **TransactionDefinition.ISOLATION_READ_COMMITTED**<br />Indicates that dirty reads are prevented; non-repeatable reads and phantom reads can occur. |
|   3   | **TransactionDefinition.ISOLATION_READ_UNCOMMITTED**<br />Indicates that dirty reads, non-repeatable reads, and phantom reads can occur. |
|   4   | **TransactionDefinition.ISOLATION_REPEATABLE_READ**<br />Indicates that dirty reads and non-repeatable reads are prevented; phantom reads can occur. |
|   5   | **TransactionDefinition.ISOLATION_SERIALIZABLE**<br />Indicates that dirty reads, non-repeatable reads, and phantom reads are prevented. |

### Transaction propagation rules

Following are the possible values for propagation types −

| Sr.No. | Propagation & Description                                    |
| :----: | :----------------------------------------------------------- |
|   1    | **TransactionDefinition.PROPAGATION_MANDATORY**<br />Supports a current transaction; throws an exception if no current transaction exists. |
|   2    | **TransactionDefinition.PROPAGATION_NESTED**<br />Executes within a nested transaction if a current transaction exists. |
|   3    | **TransactionDefinition.PROPAGATION_NEVER**<br />Does not support a current transaction; throws an exception if a current transaction exists. |
|   4    | **TransactionDefinition.PROPAGATION_NOT_SUPPORTED**<br />Does not support a current transaction; rather always execute nontransactionally. |
|   5    | **TransactionDefinition.PROPAGATION_REQUIRED**<br />Supports a current transaction; creates a new one if none exists. |
|   6    | **TransactionDefinition.PROPAGATION_REQUIRES_NEW**<br />Creates a new transaction, suspending the current transaction if one exists. |
|   7    | **TransactionDefinition.PROPAGATION_SUPPORTS**<br />Supports a current transaction; executes non-transactionally if none exists. |
|   8    | **TransactionDefinition.TIMEOUT_DEFAULT**<br />Uses the default timeout of the underlying transaction system, or none if timeouts are not supported. |

The *TransactionStatus* interface provides a simple way for transactional code to control transaction execution and query transaction status.

```
public interface TransactionStatus extends SavepointManager {
   boolean isNewTransaction();
   boolean hasSavepoint();
   void setRollbackOnly();
   boolean isRollbackOnly();
   boolean isCompleted();
}
```



| Sr.No. | Method & Description                                         |
| :----: | :----------------------------------------------------------- |
|   1    | **boolean hasSavepoint()**<br />This method returns whether this transaction internally carries a savepoint, i.e., has been created as nested transaction based on a savepoint. |
|   2    | **boolean isCompleted()**<br />This method returns whether this transaction is completed, i.e., whether it has already been committed or rolled back. |
|   3    | **boolean isNewTransaction()**<br />This method returns true in case the present transaction is new. |
|   4    | **boolean isRollbackOnly()**<br />This method returns whether the transaction has been marked as rollback-only. |
|   5    | **void setRollbackOnly()**<br />This method sets the transaction as rollback-only. |

#### Transactions Support in Spring

Thanks [baeldung.com](https://www.baeldung.com/java-transactions#transactions_support_in_spring)

We have seen that **handling transactions are rather an involved task which includes a lot of boilerplate coding** and configurations. Moreover, each resource has its own way of handling local transactions. In Java, JTA abstracts us from these variations but further brings provider-specific details and the complexity of the application server.

Spring platform **provides us a much cleaner way of handling transactions, both resource local and global transactions** in Java. This together with the other benefits of Spring creates a compelling case for using Spring to handle transactions. Moreover, it's quite easy to configure and switch a transaction manager with Spring, which can be server provided or standalone.

Spring provides us this **seamless abstraction by creating a proxy for the methods** with transactional code. The proxy manages the transaction state on behalf of the code with the help of *TransactionManager*:
![img](https://www.baeldung.com/wp-content/uploads/2020/08/Spring-Transactions.jpg)
The central interface here is *PlatformTransactionManager* which has a number of different implementations available. It provides abstractions over JDBC (DataSource), JMS, JPA, JTA, and many other resources.

#### Transactions with Spring and JPA

Thanks [baeldung.com](https://www.baeldung.com/transaction-configuration-with-jpa-and-spring)

##### **1. Overview**

This tutorial will discuss **the right way to configure Spring Transactions**, how to use the *@Transactional* annotation, and common pitfalls.

For a more in-depth discussion on the core persistence configuration, check out the [Spring with JPA tutorial](https://www.baeldung.com/the-persistence-layer-with-spring-and-jpa).

Basically, there are two distinct ways to configure Transactions, annotations and AOP, each with their own advantages. We're going to discuss the more common annotation-config here.

##### **2. Configure Transactions**

Spring 3.1 introduces **the *@EnableTransactionManagement* annotation** that we can use in a *@Configuration* class to enable transactional support:

```java
@Configuration
@EnableTransactionManagement
public class PersistenceJPAConfig{

   @Bean
   public LocalContainerEntityManagerFactoryBean
     entityManagerFactoryBean(){
      //...
   }

   @Bean
   public PlatformTransactionManager transactionManager(){
      JpaTransactionManager transactionManager
        = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(
        entityManagerFactoryBean().getObject() );
      return transactionManager;
   }
}
```

However, **if we're using a Spring Boot project and have a spring-data-* or spring-tx dependencies on the classpath, then transaction management will be enabled by default**.

##### **3. Configure Transactions With XML**

For versions before 3.1, or if Java is not an option, here is the XML configuration using *annotation-driven* and the namespace support:

```xml
<bean id="txManager" class="org.springframework.orm.jpa.JpaTransactionManager">
   <property name="entityManagerFactory" ref="myEmf" />
</bean>
<tx:annotation-driven transaction-manager="txManager" />
```

##### **4. The *@Transactional* Annotation**

With transactions configured, we can now annotate a bean with *@Transactional* either at the class or method level:

```java
@Service
@Transactional
public class FooService {
    //...
}
```

The annotation supports **further configuration** as well:

- the *Propagation Type* of the transaction
- the *Isolation Level* of the transaction
- a *Timeout* for the operation wrapped by the transaction
- a *readOnly flag* – a hint for the persistence provider that the transaction should be read only
- the *Rollback* rules for the transaction

Note that by default, rollback happens for runtime, unchecked exceptions only. **The checked exception does not trigger a rollback** of the transaction. We can, of course, configure this behavior with the *rollbackFor* and *noRollbackFor* annotation parameters.

###### What Is *@Transactional?*

[Thanks baeldung.com](https://www.baeldung.com/spring-transactional-propagation-isolation#transactional-annotation)

We can use *[@Transactional](https://www.baeldung.com/transaction-configuration-with-jpa-and-spring)* to wrap a method in a database transaction.

It allows us to set propagation, isolation, timeout, read-only, and rollback conditions for our transaction. We can also specify the transaction manager.

###### *@Transactional* Implementation Details

Spring creates a proxy, or manipulates the class byte-code, to manage the creation, commit, and rollback of the transaction. In the case of a proxy, Spring ignores *@Transactional* in internal method calls.

Simply put, if we have a method like *callMethod* and we mark it as *@Transactional,* Spring will wrap some transaction management code around the invocation*@Transactional* method called:

```java
createTransactionIfNecessary();
try {
    callMethod();
    commitTransactionAfterReturning();
} catch (exception) {
    completeTransactionAfterThrowing();
    throw exception;
}
```

###### How to Use *@Transactional*

We can put the annotation on definitions of interfaces, classes, or directly on methods. They override each other according to the priority order; from lowest to highest we have: interface, superclass, class, interface method, superclass method, and class method.

**Spring applies the class-level annotation to all public methods of this class that we did not annotate with *@Transactional*.**

**However, if we put the annotation on a private or protected method, Spring will ignore it without an error.**

Let's start with an interface sample:

```java
@Transactional
public interface TransferService {
    void transfer(String user1, String user2, double val);
}
```

Usually it's not recommended to set *@Transactional* on the interface; however, it is acceptable for cases like *@Repository* with Spring Data. We can put the annotation on a class definition to override the transaction setting of the interface/superclass:

```java
@Service
@Transactional
public class TransferServiceImpl implements TransferService {
    @Override
    public void transfer(String user1, String user2, double val) {
        // ...
    }
}
```

Now let's override it by setting the annotation directly on the method:

```java
@Transactional
public void transfer(String user1, String user2, double val) {
    // ...
}
```

### Transaction Propagation

Thanks [baeldung.com](https://www.baeldung.com/spring-transactional-propagation-isolation#transaction-propagations)

Propagation defines our business logic's transaction boundary. Spring manages to start and pause a transaction according to our *propagation* setting.

Spring calls *TransactionManager::getTransaction* to get or create a transaction according to the propagation. It supports some of the propagations for all types of *TransactionManager*, but there are a few of them that are only supported by specific implementations of *TransactionManager*.

Let's go through the different propagations and how they work.

#### 1. *REQUIRED* Propagation (DEFAULT)

*REQUIRED* is the default propagation. Spring checks if there is an active transaction, and if nothing exists, it creates a new one. Otherwise, the business logic appends to the currently active transaction:

```java
@Transactional(propagation = Propagation.REQUIRED)
public void requiredExample(String user) { 
    // ... 
}
```

Furthermore, since *REQUIRED* is the default propagation, we can simplify the code by dropping it:

```java
@Transactional
public void requiredExample(String user) { 
    // ... 
}
```

Let's see the pseudo-code of how transaction creation works for *REQUIRED* propagation:

```java
if (isExistingTransaction()) {
    if (isValidateExistingTransaction()) {
        validateExisitingAndThrowExceptionIfNotValid();
    }
    return existing;
}
return createNewTransaction();
```

#### 2. *SUPPORTS* Propagation

For *SUPPORTS*, Spring first checks if an active transaction exists. If a transaction exists, then the existing transaction will be used. If there isn't a transaction, it is executed non-transactional:

```java
@Transactional(propagation = Propagation.SUPPORTS)
public void supportsExample(String user) { 
    // ... 
}
```

Let's see the transaction creation's pseudo-code for *SUPPORTS*:

```java
if (isExistingTransaction()) {
    if (isValidateExistingTransaction()) {
        validateExisitingAndThrowExceptionIfNotValid();
    }
    return existing;
}
return emptyTransaction;
```

#### 3. *MANDATORY* Propagation

When the propagation is *MANDATORY*, if there is an active transaction, then it will be used. If there isn't an active transaction, then Spring throws an exception:

```java
@Transactional(propagation = Propagation.MANDATORY)
public void mandatoryExample(String user) { 
    // ... 
}
```

Let's again see the pseudo-code:

```java
if (isExistingTransaction()) {
    if (isValidateExistingTransaction()) {
        validateExisitingAndThrowExceptionIfNotValid();
    }
    return existing;
}
throw IllegalTransactionStateException;
```

#### 4. *NEVER* Propagation

For transactional logic with *NEVER* propagation, Spring throws an exception if there's an active transaction:

```java
@Transactional(propagation = Propagation.NEVER)
public void neverExample(String user) { 
    // ... 
}
```

Let's see the pseudo-code of how transaction creation works for *NEVER* propagation:

```java
if (isExistingTransaction()) {
    throw IllegalTransactionStateException;
}
return emptyTransaction;
```

#### 5. *NOT_SUPPORTED* Propagation

If a current transaction exists, first Spring suspends it, and then the business logic is executed without a transaction:

```java
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public void notSupportedExample(String user) { 
    // ... 
}
```

**The *JTATransactionManager* supports real transaction suspension out-of-the-box. Others simulate the suspension by holding a reference to the existing one and then clearing it from the thread context**

#### 6. *REQUIRES_NEW* Propagation

When the propagation is *REQUIRES_NEW*, Spring suspends the current transaction if it exists, and then creates a new one:

```java
@Transactional(propagation = Propagation.REQUIRES_NEW)
public void requiresNewExample(String user) { 
    // ... 
}
```

**Similar to *NOT_SUPPORTED*, we need the *JTATransactionManager* for actual transaction suspension.**

The pseudo-code looks like so:

```java
if (isExistingTransaction()) {
    suspend(existing);
    try {
        return createNewTransaction();
    } catch (exception) {
        resumeAfterBeginException();
        throw exception;
    }
}
return createNewTransaction();
```

#### 7. *NESTED* Propagation

For *NESTED* propagation, Spring checks if a transaction exists, and if so, it marks a save point. This means that if our business logic execution throws an exception, then the transaction rollbacks to this save point. If there's no active transaction, it works like *REQUIRED*.

***DataSourceTransactionManager* supports this propagation out-of-the-box. Some implementations of *JTATransactionManager* may also support this.**

**[*JpaTransactionManager*](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/orm/jpa/JpaTransactionManager.html) supports *NESTED* only for JDBC connections. However, if we set the *nestedTransactionAllowed* flag to *true*, it also works for JDBC access code in JPA transactions if our JDBC driver supports save points.
**

Finally, let's set the *propagation* to *NESTED*:

```java
@Transactional(propagation = Propagation.NESTED)
public void nestedExample(String user) { 
    // ... 
}
```

### Transaction Isolation

Thanks [baeldung.com](https://www.baeldung.com/spring-transactional-propagation-isolation#transactional-isolations)

Isolation is one of the common ACID properties: Atomicity, Consistency, Isolation, and Durability. Isolation describes how changes applied by concurrent transactions are visible to each other.

Each isolation level prevents zero or more concurrency side effects on a transaction:

- **Dirty read:** read the uncommitted change of a concurrent transaction
- **Nonrepeatable read**: get different value on re-read of a row if a concurrent transaction updates the same row and commits
- **Phantom read:** get different rows after re-execution of a range query if another transaction adds or removes some rows in the range and commits

We can set the isolation level of a transaction by *@Transactional::isolation.* It has these five enumerations in Spring: *DEFAULT*, *READ_UNCOMMITTED*, *READ_COMMITTED*, *REPEATABLE_READ*, *SERIALIZABLE.*

#### 1. *DEFAULT* Isolation

The default isolation level is *DEFAULT*. As a result, when Spring creates a new transaction, the isolation level will be the default isolation of our RDBMS. Therefore, we should be careful if we change the database.

We should also consider cases when we call a chain of methods with different isolation*.* In the normal flow, the isolation only applies when a new transaction is created. Thus, if for any reason we don't want to allow a method to execute in different isolation, we have to set *TransactionManager::setValidateExistingTransaction* to true.

Then the pseudo-code of transaction validation will be:

```java
if (isolationLevel != ISOLATION_DEFAULT) {
    if (currentTransactionIsolationLevel() != isolationLevel) {
        throw IllegalTransactionStateException
    }
}
```

Now let's get deep in different isolation levels and their effects.

#### 2. *READ_UNCOMMITTED* Isolation

*READ_UNCOMMITTED* is the lowest isolation level and allows for the most concurrent access.

As a result, it suffers from all three mentioned concurrency side effects. A transaction with this isolation reads uncommitted data of other concurrent transactions. Also, both non-repeatable and phantom reads can happen. Thus we can get a different result on re-read of a row or re-execution of a range query.

We can set the *isolation* level for a method or class:

```java
@Transactional(isolation = Isolation.READ_UNCOMMITTED)
public void log(String message) {
    // ...
}
```

**Postgres does not support *READ_UNCOMMITTED* isolation and falls back to *READ_COMMITED* instead.** **Also, Oracle does not support or allow *READ_UNCOMMITTED*.**

#### 3. *READ_COMMITTED* Isolation

The second level of isolation, *READ_COMMITTED,* prevents dirty reads.

The rest of the concurrency side effects could still happen. So uncommitted changes in concurrent transactions have no impact on us, but if a transaction commits its changes, our result could change by re-querying.

Here we set the *isolation* level:

```java
@Transactional(isolation = Isolation.READ_COMMITTED)
public void log(String message){
    // ...
}
```

***READ_COMMITTED* is the default level with Postgres, SQL Server, and Oracle.**

#### 4. *REPEATABLE_READ* Isolation

The third level of isolation, *REPEATABLE_READ,* prevents dirty, and non-repeatable reads. So we are not affected by uncommitted changes in concurrent transactions.

Also, when we re-query for a row, we don't get a different result. However, in the re-execution of range-queries, we may get newly added or removed rows.

Moreover, it is the lowest required level to prevent the lost update. The lost update occurs when two or more concurrent transactions read and update the same row. *REPEATABLE_READ* does not allow simultaneous access to a row at all. Hence the lost update can't happen.

Here is how to set the *isolation* level for a method:

```java
@Transactional(isolation = Isolation.REPEATABLE_READ) 
public void log(String message){
    // ...
}
```

***REPEATABLE_READ* is the default level in Mysql.** **Oracle does not support *REPEATABLE_READ*.**

#### 5. *SERIALIZABLE* Isolation

*SERIALIZABLE* is the highest level of isolation. It prevents all mentioned concurrency side effects, but can lead to the lowest concurrent access rate because it executes concurrent calls sequentially.

In other words, concurrent execution of a group of serializable transactions has the same result as executing them in serial.

Now let's see how to set *SERIALIZABLE* as the *isolation* level:

```java
@Transactional(isolation = Isolation.SERIALIZABLE)
public void log(String message){
    // ...
}
```

##### 5. Potential Pitfalls

###### **5.1. Transactions and Proxies**

At a high level, **Spring creates proxies for all the classes annotated with *@Transactional***, either on the class or on any of the methods. The proxy allows the framework to inject transactional logic before and after the running method, mainly for starting and committing the transaction.

What's important to keep in mind is that, if the transactional bean is implementing an interface, by default the proxy will be a Java Dynamic Proxy. This means that only external method calls that come in through the proxy will be intercepted. **Any self-invocation calls will not start any transaction,** even if the method has the *@Transactional* annotation.

Another caveat of using proxies is that **only public methods should be annotated with *@Transactional.*** Methods of any other visibilities will simply ignore the annotation silently as these are not proxied.

###### **5.2. Changing the Isolation Level**

```java
courseDao.createWithRuntimeException(course);
```

We can also change the transaction isolation level:

```java
@Transactional(isolation = Isolation.SERIALIZABLE)
```

Note that this has actually been [introduced](https://jira.spring.io/browse/SPR-5012) in Spring 4.1; if we run the above example before Spring 4.1, it will result in:

> *org.springframework.transaction.InvalidIsolationLevelException*: Standard JPA does not support custom isolation levels – use a special *JpaDialect* for your JPA implementation

###### **5.3. Read-Only Transactions**

The *readOnly* flag usually generates confusion, especially when working with JPA. From the Javadoc:

> This just serves as a hint for the actual transaction subsystem; it will *not necessarily* cause failure of write access attempts. A transaction manager which cannot interpret the read-only hint will *not* throw an exception when asked for a read-only transaction.

The fact is that **we can't be sure that an insert or update won't occur when the *readOnly* flag is set.** This behavior is vendor dependent, whereas JPA is vendor agnostic.

It's also important to understand that **the *readOnly* flag is only relevant inside a transaction.** If an operation occurs outside of a transactional context, the flag is simply ignored. A simple example of that would call a method annotated with:

```java
@Transactional( propagation = Propagation.SUPPORTS,readOnly = true )
```

From a non-transactional context, a transaction will not be created and the *readOnly* flag will be ignored.

###### **5.4. Transaction Logging**

A helpful method to understand transactional related issues is fine-tuning logging in the transactional packages. The relevant package in Spring is “*org.springframework.transaction”*, which should be configured with a logging level of *TRACE.*

### Transaction rollback rules

###### 5.5. Transaction Rollback

The *@Transactional* annotation is the metadata that specifies the semantics of the transactions on a method. We have two ways to rollback a transaction: declarative and programmatic.

In the **declarative** approach, we annotate the methods with the **@Transactional** **annotation**. The *@Transactional* annotation makes use of the attributes *rollbackFor* or *rollbackForClassName* to rollback the transactions, and the attributes *noRollbackFor* or *noRollbackForClassName* to avoid rollback on listed exceptions.

The default rollback behavior in the declarative approach will rollback on runtime exceptions.

Let's see a simple example using the declarative approach to rollback a transaction for runtime exceptions or errors:

```java
@Transactional
public void createCourseDeclarativeWithRuntimeException(Course course) {
    courseDao.create(course);
    throw new DataIntegrityViolationException("Throwing exception for demoing Rollback!!!");
}
```

Next we'll use the declarative approach to rollback a transaction for the listed checked exceptions. The rollback in our example is on *SQLException*:

```java
@Transactional(rollbackFor = { SQLException.class })
public void createCourseDeclarativeWithCheckedException(Course course) throws SQLException {
    courseDao.create(course);
    throw new SQLException("Throwing exception for demoing rollback");
}
```

Let's see a simple use of attribute *noRollbackFor* in the declarative approach to prevent rollback of the transaction for the listed exception:

```java
@Transactional(noRollbackFor = { SQLException.class })
public void createCourseDeclarativeWithNoRollBack(Course course) throws SQLException {
    courseDao.create(course);
    throw new SQLException("Throwing exception for demoing rollback");
}
```

In the **programmatic approach**, we rollback the transactions using *TransactionAspectSupport*:

```java
public void createCourseDefaultRatingProgramatic(Course course) {
    try {
       courseDao.create(course);
    } catch (Exception e) {
       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }
}
```

The **declarative rollback strategy should be favored over the programmatic rollback strategy**.

###  Transactions and integration testing

[docs.spring.io](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-tx)

#### 3.5.9. Transaction Management

In the TestContext framework, transactions are managed by the `TransactionalTestExecutionListener`, which is configured by default, even if you do not explicitly declare `@TestExecutionListeners` on your test class. To enable support for transactions, however, you must configure a `PlatformTransactionManager` bean in the `ApplicationContext` that is loaded with `@ContextConfiguration` semantics (further details are provided later). In addition, you must declare Spring’s `@Transactional` annotation either at the class or the method level for your tests.

##### Test-managed Transactions

Test-managed transactions are transactions that are managed declaratively by using the `TransactionalTestExecutionListener` or programmatically by using `TestTransaction` (described later). You should not confuse such transactions with Spring-managed transactions (those managed directly by Spring within the `ApplicationContext` loaded for tests) or application-managed transactions (those managed programmatically within application code that is invoked by tests). Spring-managed and application-managed transactions typically participate in test-managed transactions. However, you should use caution if Spring-managed or application-managed transactions are configured with any propagation type other than `REQUIRED` or `SUPPORTS` (see the discussion on [transaction propagation](https://docs.spring.io/spring-framework/docs/current/reference/html/data-access.html#tx-propagation) for details).

| Preemptive timeouts and test-managed transactionsCaution must be taken when using any form of preemptive timeouts from a testing framework in conjunction with Spring’s test-managed transactions.<br /><br />Specifically, Spring’s testing support binds transaction state to the current thread (via a `java.lang.ThreadLocal` variable) *before* the current test method is invoked. If a testing framework invokes the current test method in a new thread in order to support a preemptive timeout, any actions performed within the current test method will *not* be invoked within the test-managed transaction. Consequently, the result of any such actions will not be rolled back with the test-managed transaction. On the contrary, such actions will be committed to the persistent store — for example, a relational database — even though the test-managed transaction is properly rolled back by Spring.<br /><br />Situations in which this can occur include but are not limited to the following.<br /><br />JUnit 4’s `@Test(timeout = …)` support and `TimeOut` ruleJUnit<br /><br /> Jupiter’s `assertTimeoutPreemptively(…)` methods in the `org.junit.jupiter.api.Assertions` class<br /><br />TestNG’s `@Test(timeOut = …)` support |
| ------------------------------------------------------------ |
|                                                              |

##### Enabling and Disabling Transactions

Annotating a test method with `@Transactional` causes the test to be run within a transaction that is, by default, automatically rolled back after completion of the test. If a test class is annotated with `@Transactional`, each test method within that class hierarchy runs within a transaction. Test methods that are not annotated with `@Transactional` (at the class or method level) are not run within a transaction. Note that `@Transactional` is not supported on test lifecycle methods — for example, methods annotated with JUnit Jupiter’s `@BeforeAll`, `@BeforeEach`, etc. Furthermore, tests that are annotated with `@Transactional` but have the `propagation` attribute set to `NOT_SUPPORTED` or `NEVER` are not run within a transaction.

| Attribute                                    | Supported for test-managed transactions                      |
| :------------------------------------------- | :----------------------------------------------------------- |
| `value` and `transactionManager`             | yes                                                          |
| `propagation`                                | only `Propagation.NOT_SUPPORTED` and `Propagation.NEVER` are supported |
| `isolation`                                  | no                                                           |
| `timeout`                                    | no                                                           |
| `readOnly`                                   | no                                                           |
| `rollbackFor` and `rollbackForClassName`     | no: use `TestTransaction.flagForRollback()` instead          |
| `noRollbackFor` and `noRollbackForClassName` | no: use `TestTransaction.flagForCommit()` instead            |

| Method-level lifecycle methods — for example, methods annotated with JUnit Jupiter’s `@BeforeEach` or `@AfterEach` — are run within a test-managed transaction. On the other hand, suite-level and class-level lifecycle methods — for example, methods annotated with JUnit Jupiter’s `@BeforeAll` or `@AfterAll` and methods annotated with TestNG’s `@BeforeSuite`, `@AfterSuite`, `@BeforeClass`, or `@AfterClass` — are *not* run within a test-managed transaction.If you need to run code in a suite-level or class-level lifecycle method within a transaction, you may wish to inject a corresponding `PlatformTransactionManager` into your test class and then use that with a `TransactionTemplate` for programmatic transaction management. |
| ------------------------------------------------------------ |

Note that [`AbstractTransactionalJUnit4SpringContextTests`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-support-classes-junit4) and [`AbstractTransactionalTestNGSpringContextTests`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-support-classes-testng) are preconfigured for transactional support at the class level.

The following example demonstrates a common scenario for writing an integration test for a Hibernate-based `UserRepository`:

```java
@SpringJUnitConfig(TestConfig.class)
@Transactional
class HibernateUserRepositoryTests {

    @Autowired
    HibernateUserRepository repository;

    @Autowired
    SessionFactory sessionFactory;

    JdbcTemplate jdbcTemplate;

    @Autowired
    void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Test
    void createUser() {
        // track initial state in test database:
        final int count = countRowsInTable("user");

        User user = new User(...);
        repository.save(user);

        // Manual flush is required to avoid false positive in test
        sessionFactory.getCurrentSession().flush();
        assertNumUsers(count + 1);
    }

    private int countRowsInTable(String tableName) {
        return JdbcTestUtils.countRowsInTable(this.jdbcTemplate, tableName);
    }

    private void assertNumUsers(int expected) {
        assertEquals("Number of rows in the [user] table.", expected, countRowsInTable("user"));
    }
}
```

As explained in [Transaction Rollback and Commit Behavior](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-tx-rollback-and-commit-behavior), there is no need to clean up the database after the `createUser()` method runs, since any changes made to the database are automatically rolled back by the `TransactionalTestExecutionListener`.

##### Transaction Rollback and Commit Behavior

By default, test transactions will be automatically rolled back after completion of the test; however, transactional commit and rollback behavior can be configured declaratively via the `@Commit` and `@Rollback` annotations. See the corresponding entries in the [annotation support](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations) section for further details.

##### Programmatic Transaction Management

You can interact with test-managed transactions programmatically by using the static methods in `TestTransaction`. For example, you can use `TestTransaction` within test methods, before methods, and after methods to start or end the current test-managed transaction or to configure the current test-managed transaction for rollback or commit. Support for `TestTransaction` is automatically available whenever the `TransactionalTestExecutionListener` is enabled.

The following example demonstrates some of the features of `TestTransaction`. See the javadoc for [`TestTransaction`](https://docs.spring.io/spring-framework/docs/5.3.14/javadoc-api/org/springframework/test/context/transaction/TestTransaction.html) for further details.

```java
@ContextConfiguration(classes = TestConfig.class)
public class ProgrammaticTransactionManagementTests extends
        AbstractTransactionalJUnit4SpringContextTests {

    @Test
    public void transactionalTest() {
        // assert initial state in test database:
        assertNumUsers(2);

        deleteFromTables("user");

        // changes to the database will be committed!
        TestTransaction.flagForCommit();
        TestTransaction.end();
        assertFalse(TestTransaction.isActive());
        assertNumUsers(0);

        TestTransaction.start();
        // perform other actions against the database that will
        // be automatically rolled back after the test completes...
    }

    protected void assertNumUsers(int expected) {
        assertEquals("Number of rows in the [user] table.", expected, countRowsInTable("user"));
    }
}
```

##### Running Code Outside of a Transaction

Occasionally, you may need to run certain code before or after a transactional test method but outside the transactional context — for example, to verify the initial database state prior to running your test or to verify expected transactional commit behavior after your test runs (if the test was configured to commit the transaction). `TransactionalTestExecutionListener` supports the `@BeforeTransaction` and `@AfterTransaction` annotations for exactly such scenarios. You can annotate any `void` method in a test class or any `void` default method in a test interface with one of these annotations, and the `TransactionalTestExecutionListener` ensures that your before transaction method or after transaction method runs at the appropriate time.

| Any before methods (such as methods annotated with JUnit Jupiter’s `@BeforeEach`) and any after methods (such as methods annotated with JUnit Jupiter’s `@AfterEach`) are run within a transaction. In addition, methods annotated with `@BeforeTransaction` or `@AfterTransaction` are not run for test methods that are not configured to run within a transaction. |
| ------------------------------------------------------------ |

##### Configuring a Transaction Manager

`TransactionalTestExecutionListener` expects a `PlatformTransactionManager` bean to be defined in the Spring `ApplicationContext` for the test. If there are multiple instances of `PlatformTransactionManager` within the test’s `ApplicationContext`, you can declare a qualifier by using `@Transactional("myTxMgr")` or `@Transactional(transactionManager = "myTxMgr")`, or `TransactionManagementConfigurer` can be implemented by an `@Configuration` class. Consult the [javadoc for `TestContextTransactionUtils.retrieveTransactionManager()`](https://docs.spring.io/spring-framework/docs/5.3.14/javadoc-api/org/springframework/test/context/transaction/TestContextTransactionUtils.html#retrieveTransactionManager-org.springframework.test.context.TestContext-java.lang.String-) for details on the algorithm used to look up a transaction manager in the test’s `ApplicationContext`.

##### Demonstration of All Transaction-related Annotations

The following JUnit Jupiter based example displays a fictitious integration testing scenario that highlights all transaction-related annotations. The example is not intended to demonstrate best practices but rather to demonstrate how these annotations can be used. See the [annotation support](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations) section for further information and configuration examples. [Transaction management for `@Sql`](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-executing-sql-declaratively-tx) contains an additional example that uses `@Sql` for declarative SQL script execution with default transaction rollback semantics. The following example shows the relevant annotations:

```java
@SpringJUnitConfig
@Transactional(transactionManager = "txMgr")
@Commit
class FictitiousTransactionalTest {

    @BeforeTransaction
    void verifyInitialDatabaseState() {
        // logic to verify the initial state before a transaction is started
    }

    @BeforeEach
    void setUpTestDataWithinTransaction() {
        // set up test data within the transaction
    }

    @Test
    // overrides the class-level @Commit setting
    @Rollback
    void modifyDatabaseWithinTransaction() {
        // logic which uses the test data and modifies database state
    }

    @AfterEach
    void tearDownWithinTransaction() {
        // run "tear down" logic within the transaction
    }

    @AfterTransaction
    void verifyFinalDatabaseState() {
        // logic to verify the final state after transaction has rolled back
    }

}
```


Avoid false positives when testing ORM code

When you test application code that manipulates the state of a Hibernate session or JPA persistence context, make sure to flush the underlying unit of work within test methods that run that code. Failing to flush the underlying unit of work can produce false positives: Your test passes, but the same code throws an exception in a live, production environment. Note that this applies to any ORM framework that maintains an in-memory unit of work. In the following Hibernate-based example test case, one method demonstrates a false positive, and the other method correctly exposes the results of flushing the session:

```java
// ...

@Autowired
SessionFactory sessionFactory;

@Transactional
@Test // no expected exception!
public void falsePositive() {
    updateEntityInHibernateSession();
    // False positive: an exception will be thrown once the Hibernate
    // Session is finally flushed (i.e., in production code)
}

@Transactional
@Test(expected = ...)
public void updateWithSessionFlush() {
    updateEntityInHibernateSession();
    // Manual flush is required to avoid false positive in test
    sessionFactory.getCurrentSession().flush();
}

// ...
```

The following example shows matching methods for JPA:

```java
// ...

@PersistenceContext
EntityManager entityManager;

@Transactional
@Test // no expected exception!
public void falsePositive() {
    updateEntityInJpaPersistenceContext();
    // False positive: an exception will be thrown once the JPA
    // EntityManager is finally flushed (i.e., in production code)
}

@Transactional
@Test(expected = ...)
public void updateWithEntityManagerFlush() {
    updateEntityInJpaPersistenceContext();
    // Manual flush is required to avoid false positive in test
    entityManager.flush();
}

// ...
```



## 10 Spring Boot Introduction

Thanks [geeksforgeeks.org](https://www.geeksforgeeks.org/introduction-to-spring-boot/)

Spring is widely used for creating scalable applications. For web applications Spring provides
Spring MVC which is a widely used module of spring which is used to create scalable web applications.
But main **disadvantage of spring projects is that configuration is really time-consuming and can be a bit overwhelming for the new developers.** Making the application production-ready takes some time if you are new to the spring.

Solution to this is Spring Boot. Spring Boot is built on the top of the spring and contains all the features of spring. And is becoming favourite of developer’s these days because of it’s a rapid production-ready environment which enables the developers to directly focus on the logic instead of struggling with the configuration and set up.

[docs.spring.io](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#getting-started.introducing-spring-boot)

Spring Boot helps you to create stand-alone, production-grade Spring-based applications that you can run. We take an opinionated view of the Spring platform and third-party libraries, so that you can get started with minimum fuss. Most Spring Boot applications need very little Spring configuration.

You can use Spring Boot to create Java applications that can be started by using `java -jar` or more traditional war deployments. We also provide a command line tool that runs “spring scripts”.

### Introducing Spring Boot Features

Thanks [javatpoint.com](https://www.javatpoint.com/spring-boot-features)

- Web Development
- SpringApplication
- Application events and listeners
- Admin features
- Externalized Configuration
- Properties Files
- YAML Support
- Type-safe Configuration
- Logging
- Security

#### Web Development

It is well suited Spring module for web application development. We can easily create a self-contained HTTP server using embedded Tomcat, Jetty or Undertow. We can use the spring-boot- starter-web module to start and running application quickly.

#### SpringApplication

It is a class which provides the convenient way to bootstrap a spring application which can be started from main method. You can call start your application just by calling a static run() method.

```java
public static void main(String[] args){  
    SpringApplication.run(className.class, args);  
}  
```

#### Application Events and Listeners

Spring Boot uses events to handle variety of tasks. It allows us to create factories file that are used to add listeners. we can refer it by using ApplicationListener key.

Always create factories file in META-INF folder like: **META-INF/spring.factories**

#### Admin Support

Spring Boot provides the facility to enable admin related features for the application. It is used to access and manage application remotely. We can enable it by simply using spring.application.admin.enabled property.

#### Externalized Configuration

Spring Boot allows us to externalize our configuration so that we can work with the same application in different environments. Application use YAML files (And properties) to externalize configuration.

#### YAML Support

It provides convenient way for specifying hierarchical configuration. It is a superset of JSON. The SpringApplication class automatically support YAML. It is successful alternative of properties.

#### Type-safe Configuration

Strong type-safe configuration is provided to govern and validate the configuration of application. Application configuration is always a crucial task which should be type-safe. We can also use annotation provided by this library.

#### Logging

Spring Boot uses Common logging for all internal logging. Logging dependencies are managed by default. We should not change logging dependencies, if there is no required customization is needed.

#### Security

Spring Boot applications are spring bases web applications. So, it is secure by default with basic authentication on all HTTP endpoints. A rich set of Endpoints are available for develop a secure Spring Boot application.

[docs.spring.io](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features)

### Core Features:

- [7.1. SpringApplication](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.spring-application)
- [7.2. Externalized Configuration](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.external-config)
- [7.3. Profiles](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.profiles)
- [7.4. Logging](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.logging)
- [7.5. Internationalization](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.internationalization)
- [7.6. JSON](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.json)
- [7.7. Task Execution and Scheduling](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.task-execution-and-scheduling)
- [7.8. Testing](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.testing)
- [7.9. Creating Your Own Auto-configuration](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.developing-auto-configuration)
- [7.10. Kotlin support](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.kotlin)

### Features:

- [8. Web](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#web)
- [9. Data](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#data)
- [10. Messaging](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#messaging)
- [11. IO](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#io)
- [12. Container Images](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#container-images)
- [13. Production-ready Features](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#actuator)

- [15. Spring Boot CLI](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#cli)
- [16. Build Tool Plugins](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#build-tool-plugins)

### Value Proposition of Spring Boot

Thanks [tutorialspoint.com](https://www.tutorialspoint.com/spring_boot/spring_boot_introduction.htm)

#### What is Micro Service?

Micro Service is an architecture that allows the developers to develop and deploy services independently. Each service running has its own process and this achieves the lightweight model to support business applications.

#### Advantages

Micro services offers the following advantages to its developers −

- Easy deployment
- Simple scalability
- Compatible with Containers
- Minimum configuration
- Lesser production time

#### What is Spring Boot?

Spring Boot provides a good platform for Java developers to develop a stand-alone and production-grade spring application that you can **just run**. You can get started with minimum configurations without the need for an entire Spring configuration setup.

#### Advantages

Spring Boot offers the following advantages to its developers −

- Easy to understand and develop spring applications
- Increases productivity
- Reduces the development time

#### Goals

Spring Boot is designed with the following goals −

- To avoid complex XML configuration in Spring
- To develop a production ready Spring applications in an easier way
- To reduce the development time and run the application independently
- Offer an easier way of getting started with the application

#### Why Spring Boot?

You can choose Spring Boot because of the features and benefits it offers as given here −

- It provides a flexible way to configure Java Beans, XML configurations, and Database Transactions.
- It provides a powerful batch processing and manages REST endpoints.
- In Spring Boot, everything is auto configured; no manual configurations are needed.
- It offers annotation-based spring application
- Eases dependency management
- It includes Embedded Servlet Container

### Creating a simple Boot application using Spring Initializer website

[spring.io](https://spring.io/guides/gs/spring-boot/)

#### Starting with Spring Initializr

You can use this [pre-initialized project](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.5.5&packaging=jar&jvmVersion=11&groupId=com.example&artifactId=spring-boot&name=spring-boot&description=Demo project for Spring Boot&packageName=com.example.spring-boot&dependencies=web) and click Generate to download a ZIP file. This project is configured to fit the examples in this tutorial.

To manually initialize the project:

1. Navigate to [https://start.spring.io](https://start.spring.io/). This service pulls in all the dependencies you need for an application and does most of the setup for you.
2. Choose either Gradle or Maven and the language you want to use. This guide assumes that you chose Java.
3. Click **Dependencies** and select **Spring Web**.
4. Click **Generate**.
5. Download the resulting ZIP file, which is an archive of a web application that is configured with your choices.

#### Create a Simple Web Application

Now you can create a web controller for a simple web application, as the following listing (from `src/main/java/com/example/springboot/HelloController.java`) shows:

```java
package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
```

The class is flagged as a `@RestController`, meaning it is ready for use by Spring MVC to handle web requests. `@GetMapping` maps `/` to the `index()` method. When invoked from a browser or by using curl on the command line, the method returns pure text. That is because `@RestController` combines `@Controller` and `@ResponseBody`, two annotations that results in web requests returning data rather than a view.

#### Create an Application class

The Spring Initializr creates a simple application class for you. However, in this case, it is too simple. You need to modify the application class to match the following listing (from `src/main/java/com/example/springboot/Application.java`):

```java
package com.example.springboot;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

}
```

`@SpringBootApplication` is a convenience annotation that adds all of the following:

- `@Configuration`: Tags the class as a source of bean definitions for the application context.
- `@EnableAutoConfiguration`: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if `spring-webmvc` is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a `DispatcherServlet`.
- `@ComponentScan`: Tells Spring to look for other components, configurations, and services in the `com/example` package, letting it find the controllers.

The `main()` method uses Spring Boot’s `SpringApplication.run()` method to launch an application. Did you notice that there was not a single line of XML? There is no `web.xml` file, either. This web application is 100% pure Java and you did not have to deal with configuring any plumbing or infrastructure.

There is also a `CommandLineRunner` method marked as a `@Bean`, and this runs on start up. It retrieves all the beans that were created by your application or that were automatically added by Spring Boot. It sorts them and prints them out.

#### Run the Application

To run the application, run the following command in a terminal window (in the `complete`) directory:

```bash
./gradlew bootRun
```

If you use Maven, run the following command in a terminal window (in the `complete`) directory:

```bash
./mvnw spring-boot:run
```

You should see output similar to the following:

```plaintext
Let's inspect the beans provided by Spring Boot:
application
beanNameHandlerMapping
defaultServletHandlerMapping
dispatcherServlet
embeddedServletContainerCustomizerBeanPostProcessor
handlerExceptionResolver
helloController
httpRequestHandlerAdapter
messageSource
mvcContentNegotiationManager
mvcConversionService
mvcValidator
org.springframework.boot.autoconfigure.MessageSourceAutoConfiguration
org.springframework.boot.autoconfigure.PropertyPlaceholderAutoConfiguration
org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration
org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration$DispatcherServletConfiguration
org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration$EmbeddedTomcat
org.springframework.boot.autoconfigure.web.ServerPropertiesAutoConfiguration
org.springframework.boot.context.embedded.properties.ServerProperties
org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor
org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor
org.springframework.context.annotation.internalAutowiredAnnotationProcessor
org.springframework.context.annotation.internalCommonAnnotationProcessor
org.springframework.context.annotation.internalConfigurationAnnotationProcessor
org.springframework.context.annotation.internalRequiredAnnotationProcessor
org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration
propertySourcesBinder
propertySourcesPlaceholderConfigurer
requestMappingHandlerAdapter
requestMappingHandlerMapping
resourceHandlerMapping
simpleControllerHandlerAdapter
tomcatEmbeddedServletContainerFactory
viewControllerHandlerMapping
```

You can clearly see `org.springframework.boot.autoconfigure` beans. There is also a `tomcatEmbeddedServletContainerFactory`.

Now run the service with curl (in a separate terminal window), by running the following command (shown with its output):

```bash
curl localhost:8080
Greetings from Spring Boot
```

#### Add Unit Tests

You will want to add a test for the endpoint you added, and Spring Test provides some machinery for that.

If you use Gradle, add the following dependency to your `build.gradle` file:

```
testImplementation('org.springframework.boot:spring-boot-starter-test')
```

If you use Maven, add the following to your `pom.xml` file:

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
</dependency>COPY
```

Now write a simple unit test that mocks the servlet request and response through your endpoint, as the following listing (from `src/test/java/com/example/springboot/HelloControllerTest.java`) shows:

```java
package com.example.springboot;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Greetings from Spring Boot!")));
	}
}
```

`MockMvc` comes from Spring Test and lets you, through a set of convenient builder classes, send HTTP requests into the `DispatcherServlet` and make assertions about the result. Note the use of `@AutoConfigureMockMvc` and `@SpringBootTest` to inject a `MockMvc` instance. Having used `@SpringBootTest`, we are asking for the whole application context to be created. An alternative would be to ask Spring Boot to create only the web layers of the context by using `@WebMvcTest`. In either case, Spring Boot automatically tries to locate the main application class of your application, but you can override it or narrow it down if you want to build something different.

As well as mocking the HTTP request cycle, you can also use Spring Boot to write a simple full-stack integration test. For example, instead of (or as well as) the mock test shown earlier, we could create the following test (from `src/test/java/com/example/springboot/HelloControllerIT.java`):

```java
package com.example.springboot;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIT {

	@Autowired
	private TestRestTemplate template;

    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = template.getForEntity("/", String.class);
        assertThat(response.getBody()).isEqualTo("Greetings from Spring Boot!");
    }
}
```

The embedded server starts on a random port because of `webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT`, and the actual port is configured automatically in the base URL for the `TestRestTemplate`.

## 11 Spring Boot Dependencies, Auto-configuration, and Runtime

### Dependency management using Spring Boot starters

Thanks [baeldung.com](https://www.baeldung.com/spring-boot-starters)

#### 1. Overview

Dependency management is a critical aspects of any complex project. And doing this manually is less than ideal; the more time you spent on it the less time you have on the other important aspects of the project.

Spring Boot starters were built to address exactly this problem. Starter POMs are a set of convenient dependency descriptors that you can include in your application. You get a one-stop-shop for all the Spring and related technology that you need, without having to hunt through sample code and copy-paste loads of dependency descriptors.

We have more than 30 Boot starters available.

[docs.spring.io](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.build-systems.starters)

| Name                                          | Description                                                  |
| :-------------------------------------------- | :----------------------------------------------------------- |
| `spring-boot-starter`                         | Core starter, including auto-configuration support, logging and YAML |
| `spring-boot-starter-activemq`                | Starter for JMS messaging using Apache ActiveMQ              |
| `spring-boot-starter-amqp`                    | Starter for using Spring AMQP and Rabbit MQ                  |
| `spring-boot-starter-aop`                     | Starter for aspect-oriented programming with Spring AOP and AspectJ |
| `spring-boot-starter-artemis`                 | Starter for JMS messaging using Apache Artemis               |
| `spring-boot-starter-batch`                   | Starter for using Spring Batch                               |
| `spring-boot-starter-cache`                   | Starter for using Spring Framework’s caching support         |
| `spring-boot-starter-data-cassandra`          | Starter for using Cassandra distributed database and Spring Data Cassandra |
| `spring-boot-starter-data-cassandra-reactive` | Starter for using Cassandra distributed database and Spring Data Cassandra Reactive |
| `spring-boot-starter-data-couchbase`          | Starter for using Couchbase document-oriented database and Spring Data Couchbase |
| `spring-boot-starter-data-couchbase-reactive` | Starter for using Couchbase document-oriented database and Spring Data Couchbase Reactive |
| `spring-boot-starter-data-elasticsearch`      | Starter for using Elasticsearch search and analytics engine and Spring Data Elasticsearch |
| `spring-boot-starter-data-jdbc`               | Starter for using Spring Data JDBC                           |
| `spring-boot-starter-data-jpa`                | Starter for using Spring Data JPA with Hibernate             |
| `spring-boot-starter-data-ldap`               | Starter for using Spring Data LDAP                           |
| `spring-boot-starter-data-mongodb`            | Starter for using MongoDB document-oriented database and Spring Data MongoDB |
| `spring-boot-starter-data-mongodb-reactive`   | Starter for using MongoDB document-oriented database and Spring Data MongoDB Reactive |
| `spring-boot-starter-data-neo4j`              | Starter for using Neo4j graph database and Spring Data Neo4j |
| `spring-boot-starter-data-r2dbc`              | Starter for using Spring Data R2DBC                          |
| `spring-boot-starter-data-redis`              | Starter for using Redis key-value data store with Spring Data Redis and the Lettuce client |
| `spring-boot-starter-data-redis-reactive`     | Starter for using Redis key-value data store with Spring Data Redis reactive and the Lettuce client |
| `spring-boot-starter-data-rest`               | Starter for exposing Spring Data repositories over REST using Spring Data REST |
| `spring-boot-starter-freemarker`              | Starter for building MVC web applications using FreeMarker views |
| `spring-boot-starter-groovy-templates`        | Starter for building MVC web applications using Groovy Templates views |
| `spring-boot-starter-hateoas`                 | Starter for building hypermedia-based RESTful web application with Spring MVC and Spring HATEOAS |
| `spring-boot-starter-integration`             | Starter for using Spring Integration                         |
| `spring-boot-starter-jdbc`                    | Starter for using JDBC with the HikariCP connection pool     |
| `spring-boot-starter-jersey`                  | Starter for building RESTful web applications using JAX-RS and Jersey. An alternative to [`spring-boot-starter-web`](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#spring-boot-starter-web) |
| `spring-boot-starter-jooq`                    | Starter for using jOOQ to access SQL databases with JDBC. An alternative to [`spring-boot-starter-data-jpa`](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#spring-boot-starter-data-jpa) or [`spring-boot-starter-jdbc`](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#spring-boot-starter-jdbc) |
| `spring-boot-starter-json`                    | Starter for reading and writing json                         |
| `spring-boot-starter-jta-atomikos`            | Starter for JTA transactions using Atomikos                  |
| `spring-boot-starter-mail`                    | Starter for using Java Mail and Spring Framework’s email sending support |
| `spring-boot-starter-mustache`                | Starter for building web applications using Mustache views   |
| `spring-boot-starter-oauth2-client`           | Starter for using Spring Security’s OAuth2/OpenID Connect client features |
| `spring-boot-starter-oauth2-resource-server`  | Starter for using Spring Security’s OAuth2 resource server features |
| `spring-boot-starter-quartz`                  | Starter for using the Quartz scheduler                       |
| `spring-boot-starter-rsocket`                 | Starter for building RSocket clients and servers             |
| `spring-boot-starter-security`                | Starter for using Spring Security                            |
| `spring-boot-starter-test`                    | Starter for testing Spring Boot applications with libraries including JUnit Jupiter, Hamcrest and Mockito |
| `spring-boot-starter-thymeleaf`               | Starter for building MVC web applications using Thymeleaf views |
| `spring-boot-starter-validation`              | Starter for using Java Bean Validation with Hibernate Validator |
| `spring-boot-starter-web`                     | Starter for building web, including RESTful, applications using Spring MVC. Uses Tomcat as the default embedded container |
| `spring-boot-starter-web-services`            | Starter for using Spring Web Services                        |
| `spring-boot-starter-webflux`                 | Starter for building WebFlux applications using Spring Framework’s Reactive Web support |
| `spring-boot-starter-websocket`               | Starter for building WebSocket applications using Spring Framework’s WebSocket support |

In addition to the application starters, the following starters can be used to add *[production ready](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#actuator)* features:

| Name                           | Description                                                  |
| :----------------------------- | :----------------------------------------------------------- |
| `spring-boot-starter-actuator` | Starter for using Spring Boot’s Actuator which provides production ready features to help you monitor and manage your application |

Finally, Spring Boot also includes the following starters that can be used if you want to exclude or swap specific technical facets:

| Name                                | Description                                                  |
| :---------------------------------- | :----------------------------------------------------------- |
| `spring-boot-starter-jetty`         | Starter for using Jetty as the embedded servlet container. An alternative to [`spring-boot-starter-tomcat`](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#spring-boot-starter-tomcat) |
| `spring-boot-starter-log4j2`        | Starter for using Log4j2 for logging. An alternative to [`spring-boot-starter-logging`](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#spring-boot-starter-logging) |
| `spring-boot-starter-logging`       | Starter for logging using Logback. Default logging starter   |
| `spring-boot-starter-reactor-netty` | Starter for using Reactor Netty as the embedded reactive HTTP server. |
| `spring-boot-starter-tomcat`        | Starter for using Tomcat as the embedded servlet container. Default servlet container starter used by [`spring-boot-starter-web`](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#spring-boot-starter-web) |
| `spring-boot-starter-undertow`      | Starter for using Undertow as the embedded servlet container. An alternative to [`spring-boot-starter-tomcat`](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#spring-boot-starter-tomcat) |

Let's see some of them in the following sections.

#### 2. The Web Starter

First, let's look at developing the REST service; we can use libraries like Spring MVC, Tomcat and Jackson – a lot of dependencies for a single application.

Spring Boot starters can help to reduce the number of manually added dependencies just by adding one dependency. So instead of manually specifying the dependencies just add one starter as in the following example:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

Now we can create a REST controller. For the sake of simplicity we won't use the database and focus on the REST controller:

```java
@RestController
public class GenericEntityController {
    private List<GenericEntity> entityList = new ArrayList<>();

    @RequestMapping("/entity/all")
    public List<GenericEntity> findAll() {
        return entityList;
    }

    @RequestMapping(value = "/entity", method = RequestMethod.POST)
    public GenericEntity addEntity(GenericEntity entity) {
        entityList.add(entity);
        return entity;
    }

    @RequestMapping("/entity/findby/{id}")
    public GenericEntity findById(@PathVariable Long id) {
        return entityList.stream().
                 filter(entity -> entity.getId().equals(id)).
                   findFirst().get();
    }
}
```

The *GenericEntity* is a simple bean with *id* of type *Long* and *value* of type *String*.

That's it – with the application running, you can access [http://localhost:8080/entity/all](http://localhost:8080/springbootapp/entity/all) and check the controller is working.

We have created a REST application with quite a minimal configuration.

#### 3. The Test Starter

For testing we usually use the following set of libraries: Spring Test, JUnit, Hamcrest, and Mockito. We can include all of these libraries manually, but Spring Boot starter can be used to automatically include these libraries in the following way:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

Notice that you don't need to specify the version number of an artifact. Spring Boot will figure out what version to use – all you need to specify is the version of *spring-boot-starter-parent* artifact. If later on you need to upgrade the Boot library and dependencies, just upgrade the Boot version in one place and it will take care of the rest.

Let's actually test the controller we created in the previous example.

There are two ways to test the controller:

- Using the mock environment
- Using the embedded Servlet container (like Tomcat or Jetty)

In this example we'll use a mock environment:

```java
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class SpringBootApplicationIntegrationTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void givenRequestHasBeenMade_whenMeetsAllOfGivenConditions_thenCorrect()
      throws Exception { 
        MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
        MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
        mockMvc.perform(MockMvcRequestBuilders.get("/entity/all")).
        andExpect(MockMvcResultMatchers.status().isOk()).
        andExpect(MockMvcResultMatchers.content().contentType(contentType)).
        andExpect(jsonPath("$", hasSize(4))); 
    } 
}
```

The above test calls the */entity/all* endpoint and verifies that the JSON response contains 4 elements. For this test to pass, we also have to initialize our list in the controller class:

```java
public class GenericEntityController {
    private List<GenericEntity> entityList = new ArrayList<>();

    {
        entityList.add(new GenericEntity(1l, "entity_1"));
        entityList.add(new GenericEntity(2l, "entity_2"));
        entityList.add(new GenericEntity(3l, "entity_3"));
        entityList.add(new GenericEntity(4l, "entity_4"));
    }
    //...
}
```

What is important here is that *@WebAppConfiguration* annotation and *MockMVC* are part of the *spring-test* module, *hasSize* is a Hamcrest matcher, and *@Before* is a JUnit annotation. These are all available by importing one this one starter dependency.

#### 4. The Data JPA Starter

Most web applications have some sort of persistence – and that's quite often JPA.

Instead of defining all of the associated dependencies manually – let's go with the starter instead:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

Notice that out of the box we have automatic support for at least the following databases: H2, Derby and Hsqldb. In our example, we'll use H2.

Now let's create the repository for our entity:

```java
public interface GenericEntityRepository extends JpaRepository<GenericEntity, Long> {}
```

Time to test the code. Here is the JUnit test:

```java
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class SpringBootJPATest {
    
    @Autowired
    private GenericEntityRepository genericEntityRepository;

    @Test
    public void givenGenericEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
        GenericEntity genericEntity = 
          genericEntityRepository.save(new GenericEntity("test"));
        GenericEntity foundedEntity = 
          genericEntityRepository.findOne(genericEntity.getId());
        
        assertNotNull(foundedEntity);
        assertEquals(genericEntity.getValue(), foundedEntity.getValue());
    }
}
```

We didn't spend time on specifying the database vendor, URL connection, and credentials. No extra configuration is necessary as we're benefiting from the solid Boot defaults; but of course all of these details can still be configured if necessary.

#### 5. The Mail Starter

A very common task in enterprise development is sending email, and dealing directly with Java Mail API usually can be difficult.

Spring Boot starter hides this complexity – mail dependencies can be specified in the following way:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```

Now we can directly use the *JavaMailSender*, so let's write some tests.

For the testing purpose, we need a simple SMTP server. In this example, we'll use Wiser. This is how we can include it in our POM:

```xml
<dependency>
    <groupId>org.subethamail</groupId>
    <artifactId>subethasmtp</artifactId>
    <version>3.1.7</version>
    <scope>test</scope>
</dependency>
```

The latest version of Wiser can be found on [Maven central repository](https://search.maven.org/classic/#search|ga|1|subethasmtp).

Here is the source code for the test:

```java
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class SpringBootMailTest {
    @Autowired
    private JavaMailSender javaMailSender;

    private Wiser wiser;

    private String userTo = "user2@localhost";
    private String userFrom = "user1@localhost";
    private String subject = "Test subject";
    private String textMail = "Text subject mail";

    @Before
    public void setUp() throws Exception {
        final int TEST_PORT = 25;
        wiser = new Wiser(TEST_PORT);
        wiser.start();
    }

    @After
    public void tearDown() throws Exception {
        wiser.stop();
    }

    @Test
    public void givenMail_whenSendAndReceived_thenCorrect() throws Exception {
        SimpleMailMessage message = composeEmailMessage();
        javaMailSender.send(message);
        List<WiserMessage> messages = wiser.getMessages();

        assertThat(messages, hasSize(1));
        WiserMessage wiserMessage = messages.get(0);
        assertEquals(userFrom, wiserMessage.getEnvelopeSender());
        assertEquals(userTo, wiserMessage.getEnvelopeReceiver());
        assertEquals(subject, getSubject(wiserMessage));
        assertEquals(textMail, getMessage(wiserMessage));
    }

    private String getMessage(WiserMessage wiserMessage)
      throws MessagingException, IOException {
        return wiserMessage.getMimeMessage().getContent().toString().trim();
    }

    private String getSubject(WiserMessage wiserMessage) throws MessagingException {
        return wiserMessage.getMimeMessage().getSubject();
    }

    private SimpleMailMessage composeEmailMessage() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userTo);
        mailMessage.setReplyTo(userFrom);
        mailMessage.setFrom(userFrom);
        mailMessage.setSubject(subject);
        mailMessage.setText(textMail);
        return mailMessage;
    }
}
```

In the test, the *@Before* and *@After* methods are in charge of starting and stopping the mail server.

Notice that we're wiring in the *JavaMailSender* bean – the bean was **automatically created by Spring Boot**.

Just like any other defaults in Boot, the email settings for the *JavaMailSender* can be customized in *application.properties*:

```plaintext
spring.mail.host=localhost
spring.mail.port=25
spring.mail.properties.mail.smtp.auth=false
```

So we configured the mail server on *localhost:25* and we didn't require authentication.

### • Auto-configuration

[docs.spring.io](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.auto-configuration)

#### Auto-configuration

Spring Boot auto-configuration attempts to automatically configure your Spring application based on the jar dependencies that you have added. For example, if `HSQLDB` is on your classpath, and you have not manually configured any database connection beans, then Spring Boot auto-configures an in-memory database.

You need to opt-in to auto-configuration by adding the `@EnableAutoConfiguration` or `@SpringBootApplication` annotations to one of your `@Configuration` classes.

| You should only ever add one `@SpringBootApplication` or `@EnableAutoConfiguration` annotation. We generally recommend that you add one or the other to your primary `@Configuration` class only. |
| ------------------------------------------------------------ |

##### 1. Gradually Replacing Auto-configuration

Auto-configuration is non-invasive. At any point, you can start to define your own configuration to replace specific parts of the auto-configuration. For example, if you add your own `DataSource` bean, the default embedded database support backs away.

If you need to find out what auto-configuration is currently being applied, and why, start your application with the `--debug` switch. Doing so enables debug logs for a selection of core loggers and logs a conditions report to the console.

##### 2. Disabling Specific Auto-configuration Classes

If you find that specific auto-configuration classes that you do not want are being applied, you can use the exclude attribute of `@SpringBootApplication` to disable them, as shown in the following example:

```java
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class MyApplication {

}
```

If the class is not on the classpath, you can use the `excludeName` attribute of the annotation and specify the fully qualified name instead. If you prefer to use `@EnableAutoConfiguration` rather than `@SpringBootApplication`, `exclude` and `excludeName` are also available. Finally, you can also control the list of auto-configuration classes to exclude by using the `spring.autoconfigure.exclude` property.

|      | You can define exclusions both at the annotation level and by using the property. |
| ---- | ------------------------------------------------------------ |
|      |                                                              |

|      | Even though auto-configuration classes are `public`, the only aspect of the class that is considered public API is the name of the class which can be used for disabling the auto-configuration. The actual contents of those classes, such as nested configuration classes or bean methods are for internal use only and we do not recommend using those directly. |
| ---- | ------------------------------------------------------------ |
|      |                                                              |

### How auto-configuration works

Thanks [baeldung-cn.com](https://baeldung-cn.com/spring-boot-annotations)

#### 1. Overview

Spring Boot made configuring Spring easier with its auto-configuration feature.

In this quick tutorial, we'll explore the annotations from the *org.springframework.boot.autoconfigure* and *org.springframework.boot.autoconfigure.condition* packages.

#### 2. *@SpringBootApplication*

We use this annotation to **mark the main class of a Spring Boot application**:

```java
@SpringBootApplication
class VehicleFactoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicleFactoryApplication.class, args);
    }
}
```

*@SpringBootApplication* encapsulates ***@Configuration*, *@EnableAutoConfiguration*, and *@ComponentScan*** annotations with their default attributes.

#### 3. *@EnableAutoConfiguration*

*@EnableAutoConfiguration*, as its name says, enables auto-configuration. It means that **Spring Boot looks for auto-configuration beans** on its classpath and automatically applies them.

Note, that we have to use this annotation with *@Configuration*:

```java
@Configuration
@EnableAutoConfiguration
class VehicleFactoryConfig {}
```

#### 4. Auto-Configuration Conditions

Usually, when we write our **custom auto-configurations**, we want Spring to **use them conditionally**. We can achieve this with the annotations in this section.

We can place the annotations in this section on *@Configuration* classes or *@Bean* methods.

In the next sections, we'll only introduce the basic concept behind each condition. For further information, please visit [this article](https://baeldung-cn.com/spring-boot-custom-auto-configuration).

##### 4.1. *@ConditionalOnClass* and *@ConditionalOnMissingClass*

Using these conditions, Spring will only use the marked auto-configuration bean if the class in the annotation's **argument is present/absent**:

```java
@Configuration
@ConditionalOnClass(DataSource.class)
class MySQLAutoconfiguration {
    //...
}
```

##### 4.2. *@ConditionalOnBean* and *@ConditionalOnMissingBean*

We can use these annotations when we want to define conditions based on the **presence or absence of a specific bean**:

```java
@Bean
@ConditionalOnBean(name = "dataSource")
LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    // ...
}
```

##### 4.3. *@ConditionalOnProperty*

With this annotation, we can make conditions on the **values of properties**:

```java
@Bean
@ConditionalOnProperty(
    name = "usemysql", 
    havingValue = "local"
)
DataSource dataSource() {
    // ...
}
```

##### 4.4. *@ConditionalOnResource*

We can make Spring to use a definition only when a specific **resource is present**:

```java
@ConditionalOnResource(resources = "classpath:mysql.properties")
Properties additionalProperties() {
    // ...
}
```

##### 4.5. *@ConditionalOnWebApplication* and *@ConditionalOnNotWebApplication*

With these annotations, we can create conditions based on if the current **application is or isn't a web application**:

```java
@ConditionalOnWebApplication
HealthCheckController healthCheckController() {
    // ...
}
```

##### 4.6. *@ConditionalExpression*

We can use this annotation in more complex situations. Spring will use the marked definition when the **SpEL expression is evaluated to true**:

```java
@Bean
@ConditionalOnExpression("${usemysql} && ${mysqlserver == 'local'}")
DataSource dataSource() {
    // ...
}
```

##### 4.7. *@Conditional*

For even more complex conditions, we can create a class evaluating the **custom condition**. We tell Spring to use this custom condition with *@Conditional*:

```java
@Conditional(HibernateCondition.class)
Properties additionalProperties() {
    //...
}
```

### Configuration properties

Thanks 

[baeldung.com](https://www.baeldung.com/configuration-properties-in-spring-boot)

#### 1. Introduction

Spring Boot has many useful features including **externalized configuration and easy access to properties defined in properties files**. An earlier [tutorial](https://www.baeldung.com/properties-with-spring) described various ways in which this could be done.

We are now going to explore the *@ConfigurationProperties* annotation in greater detail.

#### 2. Setup

This tutorial uses a fairly standard setup. We start by adding [*spring-boot-starter-parent*](https://search.maven.org/search?q=a:spring-boot-starter-parent AND g:org.springframework.boot) as the parent in our *pom.xml*:

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.4.0</version>
    <relativePath/>
</parent>
```

To be able to validate properties defined in the file, we also need an implementation of JSR-303, and [*hibernate-validator*](https://search.maven.org/search?q=a:hibernate-validator AND g:org.hibernate) is one of them.

Let's add it to our *pom.xml* as well:

```xml
<dependency>
   <groupId>org.hibernate</groupId>
   <artifactId>hibernate-validator</artifactId>
   <version>6.0.16.Final</version>
</dependency>
```

The [“Getting Started with Hibernate Validator”](http://hibernate.org/validator/documentation/getting-started/) page has more details.

#### 3. Simple Properties

**The official documentation advises that we isolate configuration properties into separate POJOs**

So let's start by doing that:

```java
@Configuration
@ConfigurationProperties(prefix = "mail")
public class ConfigProperties {
    
    private String hostName;
    private int port;
    private String from;

    // standard getters and setters
}
```

We use *@Configuration* so that Spring creates a Spring bean in the application context.

***@ConfigurationProperties* works best with hierarchical properties that all have the same prefix;** therefore, we add a prefix of *mail*.

The Spring framework uses standard Java bean setters, so we must declare setters for each of the properties.

Note: If we don't use *@Configuration* in the POJO, then we need to add *@EnableConfigurationProperties(ConfigProperties.class)* in the main Spring application class to bind the properties into the POJO:

```java
@SpringBootApplication
@EnableConfigurationProperties(ConfigProperties.class)
public class EnableConfigurationDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(EnableConfigurationDemoApplication.class, args);
    }
}
```

That's it! **Spring will automatically bind any property defined in our property file that has the prefix *mail* and the same name as one of the fields in the *ConfigProperties* class**.

Spring uses some relaxed rules for binding properties. As a result, the following variations are all bound to the property *hostName*:

```properties
mail.hostName
mail.hostname
mail.host_name
mail.host-name
mail.HOST_NAME
```

Therefore, we can use the following properties file to set all the fields:

```properties
#Simple properties
mail.hostname=host@mail.com
mail.port=9000
mail.from=mailer@mail.com
```

##### 3.1. Spring Boot 2.2

**As of [Spring Boot 2.2](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.2-Release-Notes#configurationproperties-scanning), Spring finds and registers *@ConfigurationProperties* classes via classpath scanning**. Therefore, **there is no need to annotate such classes with *@Component*** *(and other meta-annotations like @Configuration),* **or even use the *@EnableConfigurationProperties:***

```java
@ConfigurationProperties(prefix = "mail") 
public class ConfigProperties { 

    private String hostName; 
    private int port; 
    private String from; 

    // standard getters and setters 
}
```

The classpath scanner enabled by *@SpringBootApplication* finds the *ConfigProperties* class, even though we didn't annotate this class with *@Component.*

In addition, we can use **the *[@ConfigurationPropertiesScan](https://docs.spring.io/spring-boot/docs/2.2.0.RELEASE/api/org/springframework/boot/context/properties/ConfigurationPropertiesScan.html)* annotation to scan custom locations for configuration property classes:**

```java
@SpringBootApplication
@ConfigurationPropertiesScan("com.baeldung.configurationproperties")
public class EnableConfigurationDemoApplication { 

    public static void main(String[] args) {   
        SpringApplication.run(EnableConfigurationDemoApplication.class, args); 
    } 
}
```

This way Spring will look for configuration property classes only in the *com.baeldung.properties* package.

#### 4. Nested Properties

**We can have nested properties in *Lists, Maps,* and *Classes.***

Let's create a new *Credentials* class to use for some nested properties:

```java
public class Credentials {
    private String authMethod;
    private String username;
    private String password;

    // standard getters and setters
}
```

We also need to update the *ConfigProperties* class to use a *List,* a *Map*, and the *Credentials* class:

```java
@ConfigurationProperties(prefix = "mail")
public class ConfigProperties {

    private String host;
    private int port;
    private String from;
    private List<String> defaultRecipients;
    private Map<String, String> additionalHeaders;
    private Credentials credentials;
 
    // standard getters and setters
}
```

The following properties file will set all the fields:

```properties
#Simple properties
mail.hostname=mailer@mail.com
mail.port=9000
mail.from=mailer@mail.com

#List properties
mail.defaultRecipients[0]=admin@mail.com
mail.defaultRecipients[1]=owner@mail.com

#Map Properties
mail.additionalHeaders.redelivery=true
mail.additionalHeaders.secure=true

#Object properties
mail.credentials.username=john
mail.credentials.password=password
mail.credentials.authMethod=SHA1
```

#### 5. Using *@ConfigurationProperties* on a *@Bean* Method

**We can also use the *@ConfigurationProperties* annotation on *@Bean*-annotated methods.**

This approach may be particularly useful when we want to bind properties to a third-party component that's outside of our control.

Let's create a simple *Item* class that we'll use in the next example:

```java
public class Item {
    private String name;
    private int size;

    // standard getters and setters
}
```

Now let's see how we can use *@ConfigurationProperties* on a *@Bean* method to bind externalized properties to the *Item* instance:

```java
@Configuration
public class ConfigProperties {

    @Bean
    @ConfigurationProperties(prefix = "item")
    public Item item() {
        return new Item();
    }
}
```

Consequently, any item-prefixed property will be mapped to the *Item* instance managed by the Spring context.

#### 6. Property Validation

***@ConfigurationProperties* provides validation of properties using the JSR-303 format.** This allows all sorts of neat things.

For example, let's make the *hostName* property mandatory:

```java
@NotBlank
private String hostName;
```

Next, let's make the *authMethod* property from 1 to 4 characters long:

```java
@Length(max = 4, min = 1)
private String authMethod;
```

Then the *port* property from 1025 to 65536:

```java
@Min(1025)
@Max(65536)
private int port;
```

Finally, the *from* property must match an email address format:

```java
@Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$")
private String from;
```

This helps us reduce a lot of *if – else* conditions in our code, and makes it look much cleaner and more concise.

**If any of these validations fail, then the main application would fail to start with an *IllegalStateException***.

The Hibernate Validation framework uses standard Java bean getters and setters, so it's important that we declare getters and setters for each of the properties.

#### 7. Property Conversion

*@ConfigurationProperties* supports conversion for multiple types of binding the properties to their corresponding beans.

##### 7.1. *Duration*

We'll start by looking at converting properties into *Duration* objects*.*

Here we have two fields of type *Duration*:

```java
@ConfigurationProperties(prefix = "conversion")
public class PropertyConversion {

    private Duration timeInDefaultUnit;
    private Duration timeInNano;
    ...
}
```

This is our properties file:

```properties
conversion.timeInDefaultUnit=10
conversion.timeInNano=9ns
```

As a result, the field *timeInDefaultUnit* will have a value of 10 milliseconds, and *timeInNano* will have a value of 9 nanoseconds.

**The supported units are *ns, us, ms, s, m, h* and *d* for nanoseconds, microseconds, milliseconds, seconds, minutes, hours, and days, respectively.**

The default unit is milliseconds, which means if we don't specify a unit next to the numeric value, Spring will convert the value to milliseconds.

We can also override the default unit using *@DurationUnit:*

```java
@DurationUnit(ChronoUnit.DAYS)
private Duration timeInDays;
```

This is the corresponding property:

```properties
conversion.timeInDays=2
```

##### 7.2. *DataSize*

**Similarly, Spring Boot *@ConfigurationProperties* supports *DataSize* type conversion.**

Let's add three fields of type *DataSize*:

```java
private DataSize sizeInDefaultUnit;

private DataSize sizeInGB;

@DataSizeUnit(DataUnit.TERABYTES)
private DataSize sizeInTB;
```

These are the corresponding properties:

```properties
conversion.sizeInDefaultUnit=300
conversion.sizeInGB=2GB
conversion.sizeInTB=4
```

**In this case, the *sizeInDefaultUnit* value will be 300 bytes, as the default unit is bytes.**

The supported units are *B, KB, MB, GB*, and *TB.* We can also override the default unit using *@DataSizeUnit.*

##### 7.3. Custom *Converter*

We can also add our own custom *Converter* to support converting a property to a specific class type.

Let's add a simple class *Employee*:

```java
public class Employee {
    private String name;
    private double salary;
}
```

Then we'll create a custom converter to convert this property:

```bash
conversion.employee=john,2000
```

We will convert it to a file of type *Employee*:

```java
private Employee employee;
```

We will need to implement the *Converter* interface, then **use *@ConfigurationPropertiesBinding* annotation to register our custom *Converter***:

```java
@Component
@ConfigurationPropertiesBinding
public class EmployeeConverter implements Converter<String, Employee> {

    @Override
    public Employee convert(String from) {
        String[] data = from.split(",");
        return new Employee(data[0], Double.parseDouble(data[1]));
    }
}
```

#### 8. Immutable *@ConfigurationProperties* Binding

As of Spring Boot 2.2, **we can use the *@ConstructorBinding* annotation to bind our configuration properties**.

This essentially means that *@ConfigurationProperties*-annotated classes may now be [immutable](https://www.baeldung.com/java-immutable-object).

```java
@ConfigurationProperties(prefix = "mail.credentials")
@ConstructorBinding
public class ImmutableCredentials {

    private final String authMethod;
    private final String username;
    private final String password;

    public ImmutableCredentials(String authMethod, String username, String password) {
        this.authMethod = authMethod;
        this.username = username;
        this.password = password;
    }

    public String getAuthMethod() {
        return authMethod;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
```

As we can see, when using *@ConstructorBinding,* we need to provide the constructor with all the parameters we'd like to bind.

Note that all the fields of *ImmutableCredentials* are final. Also, there are no setter methods.

Furthermore, it's important to emphasize that **to use the constructor binding, we need to explicitly enable our configuration class either with *@EnableConfigurationProperties* or *with @ConfigurationPropertiesScan****.*

#### 9. Java 16 *record*s

Java 16 introduced the *record* types as part of [JEP 395](https://openjdk.java.net/jeps/395). Records are classes that act as transparent carriers for immutable data. This makes them perfect candidates for configuration holders and DTOs. As a matter of fact, **we can define Java records as configuration properties in Spring Boot**. For instance, the previous example can be rewritten as:

```java
@ConstructorBinding
@ConfigurationProperties(prefix = "mail.credentials")
public record ImmutableCredentials(String authMethod, String username, String password) {
}
```

Obviously, it's more concise compared to all those noisy getters and setters.

Moreover, as of [Spring Boot 2.6](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.6.0-M2-Release-Notes#records-and-configurationproperties), **for single-constructor records, we can drop the *@ConstructorBinding* annotation**. If our record has multiple constructors, however, *@ConstructorBinding* should still be used to identify the constructor to use for property binding.

### Overriding auto-configuration

Thanks [baeldung.com](https://www.baeldung.com/spring-boot-custom-auto-configuration)

#### 1. Overview

Simply put, the Spring Boot autoconfiguration represents a way to automatically configure a Spring application based on the dependencies that are present on the classpath.

This can make development faster and easier by eliminating the need for defining certain beans that are included in the auto-configuration classes.

In the following section, we're going to take a look at **creating our custom Spring Boot auto-configuration**.

#### 2. Maven Dependencies

Let's start with the dependencies that we need:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
    <version>2.4.0</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.19</version>
</dependency>
```

The latest versions of [spring-boot-starter-data-jpa](https://search.maven.org/classic/#search|ga|1|a%3A"spring-boot-starter-data-jpa") and [mysql-connector-java](https://search.maven.org/classic/#search%7Cga%7C1%7Ca%3A%22mysql-connector-java%22%20AND%20g%3A%22mysql%22) can be downloaded from Maven Central.

#### 3. Creating a Custom Auto-Configuration

**To create a custom auto-configuration, we need to create a class annotated as *@Configuration* and register it.**

Let's create a custom configuration for a *MySQL* data source:

```java
@Configuration
public class MySQLAutoconfiguration {
    //...
}
```

The next mandatory step is registering the class as an auto-configuration candidate, by adding the name of the class under the key *org.springframework.boot.autoconfigure.EnableAutoConfiguration* in the standard file *resources/META-INF/spring.factories*:

```properties
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
com.baeldung.autoconfiguration.MySQLAutoconfiguration
```

If we want our auto-configuration class to have priority over other auto-configuration candidates, we can add the *@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)* annotation.

Auto-configuration is designed using classes and beans marked with *@Conditional* annotations so that the auto-configuration or specific parts of it can be replaced.

**Note that the auto-configuration is only in effect if the auto-configured beans are not defined in the application. If you define your bean, then the default one will be overridden.**

##### 3.1. Class Conditions

Class conditions allow us to **specify that a configuration bean will be included if a specified class is present** using the *@ConditionalOnClass* annotation, **or if a class is absent** using the *@ConditionalOnMissingClass* annotation.

Let's specify that our *MySQLConfiguration* will only be loaded if the class *DataSource* is present, in which case we can assume the application will use a database:

```java
@Configuration
@ConditionalOnClass(DataSource.class)
public class MySQLAutoconfiguration {
    //...
}
```

##### 3.2. Bean Conditions

If we want to **include a bean only if a specified bean is present or not**, we can use the *@ConditionalOnBean* and *@ConditionalOnMissingBean* annotations.

To exemplify this, let's add an *entityManagerFactory* bean to our configuration class, and specify we only want this bean to be created if a bean called *dataSource* is present and if a bean called *entityManagerFactory* is not already defined:

```java
@Bean
@ConditionalOnBean(name = "dataSource")
@ConditionalOnMissingBean
public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean em
      = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource());
    em.setPackagesToScan("com.baeldung.autoconfiguration.example");
    em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    if (additionalProperties() != null) {
        em.setJpaProperties(additionalProperties());
    }
    return em;
}
```

Let's also configure a *transactionManager* bean that will only be loaded if a bean of type *JpaTransactionManager* is not already defined:

```java
@Bean
@ConditionalOnMissingBean(type = "JpaTransactionManager")
JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory);
    return transactionManager;
}
```

##### 3.3. Property Conditions

The *@ConditionalOnProperty* annotation is used to **specify if a configuration will be loaded based on the presence and value of a Spring Environment property**.

First, let's add a property source file for our configuration that will determine where the properties will be read from:

```java
@PropertySource("classpath:mysql.properties")
public class MySQLAutoconfiguration {
    //...
}
```

We can configure the main *DataSource* bean that will be used to create connections to the database in such a way that it will only be loaded if a property called *usemysql* is present.

We can use the attribute *havingValue* to specify certain values of the *usemysql* property that have to be matched.

Let's define the *dataSource* bean with default values that connect to a local database called *myDb* if the *usemysql* property is set to *local*:

```java
@Bean
@ConditionalOnProperty(
  name = "usemysql", 
  havingValue = "local")
@ConditionalOnMissingBean
public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
 
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/myDb?createDatabaseIfNotExist=true");
    dataSource.setUsername("mysqluser");
    dataSource.setPassword("mysqlpass");

    return dataSource;
}
```

If the *usemysql* property is set to *custom,* the *dataSource* bean will be configured using custom properties values for the database URL, user, and password:

```java
@Bean(name = "dataSource")
@ConditionalOnProperty(
  name = "usemysql", 
  havingValue = "custom")
@ConditionalOnMissingBean
public DataSource dataSource2() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl(env.getProperty("mysql.url"));
    dataSource.setUsername(env.getProperty("mysql.user") != null 
      ? env.getProperty("mysql.user") : "");
    dataSource.setPassword(env.getProperty("mysql.pass") != null 
      ? env.getProperty("mysql.pass") : "");
        
    return dataSource;
}
```

The *mysql.properties* file will contain the *usemysql* property:

```properties
usemysql=local
```

If an application that uses the *MySQLAutoconfiguration* wishes to override the default properties, all it needs to do is add different values for the *mysql.url*, *mysql.user* and *mysql.pass* properties and the *usemysql=custom* line in the *mysql.properties* file.

##### 3.4. Resource Conditions

Adding the *@ConditionalOnResource* annotation means that the **configuration will only be loaded when a specified resource is present**.

Let's define a method called *additionalProperties()* that will return a *Properties* object containing Hibernate-specific properties to be used by the *entityManagerFactory* bean, only if the resource file *mysql.properties* is present:

```java
@ConditionalOnResource(
  resources = "classpath:mysql.properties")
@Conditional(HibernateCondition.class)
Properties additionalProperties() {
    Properties hibernateProperties = new Properties();

    hibernateProperties.setProperty("hibernate.hbm2ddl.auto", 
      env.getProperty("mysql-hibernate.hbm2ddl.auto"));
    hibernateProperties.setProperty("hibernate.dialect", 
      env.getProperty("mysql-hibernate.dialect"));
    hibernateProperties.setProperty("hibernate.show_sql", 
      env.getProperty("mysql-hibernate.show_sql") != null 
      ? env.getProperty("mysql-hibernate.show_sql") : "false");
    return hibernateProperties;
}
```

We can add the Hibernate specific properties to the *mysql.properties* file:

```properties
mysql-hibernate.dialect=org.hibernate.dialect.MySQLDialect
mysql-hibernate.show_sql=true
mysql-hibernate.hbm2ddl.auto=create-drop
```

##### 3.5. Custom Conditions

If we don't want to use any of the conditions available in Spring Boot, we can also **define custom conditions by extending the *SpringBootCondition* class and overriding the *getMatchOutcome()* method**.

Let's create a condition called *HibernateCondition* for our *additionalProperties()* method that will verify whether a *HibernateEntityManager* class is present on the classpath:

```java
static class HibernateCondition extends SpringBootCondition {

    private static String[] CLASS_NAMES
      = { "org.hibernate.ejb.HibernateEntityManager", 
          "org.hibernate.jpa.HibernateEntityManager" };

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, 
      AnnotatedTypeMetadata metadata) {
 
        ConditionMessage.Builder message
          = ConditionMessage.forCondition("Hibernate");
        return Arrays.stream(CLASS_NAMES)
          .filter(className -> ClassUtils.isPresent(className, context.getClassLoader()))
          .map(className -> ConditionOutcome
            .match(message.found("class")
            .items(Style.NORMAL, className)))
          .findAny()
          .orElseGet(() -> ConditionOutcome
            .noMatch(message.didNotFind("class", "classes")
            .items(Style.NORMAL, Arrays.asList(CLASS_NAMES))));
    }
}
```

Then we can add the condition to the *additionalProperties()* method:

```java
@Conditional(HibernateCondition.class)
Properties additionalProperties() {
  //...
}
```

##### 3.6. Application Conditions

We can also **specify that the configuration can be loaded only inside/outside a web context**, by adding the *@ConditionalOnWebApplication* or *@ConditionalOnNotWebApplication* annotation.

#### 4. Testing the Auto-Configuration

Let's create a very simple example to test our auto-configuration. We will create an entity class called *MyUser*, and a *MyUserRepository* interface using Spring Data:

```java
@Entity
public class MyUser {
    @Id
    private String email;

    // standard constructor, getters, setters
}
public interface MyUserRepository 
  extends JpaRepository<MyUser, String> { }
```

To enable auto-configuration, we can use one of the *@SpringBootApplication* or *@EnableAutoConfiguration* annotations:

```java
@SpringBootApplication
public class AutoconfigurationApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutoconfigurationApplication.class, args);
    }
}
```

Next, let's write a *JUnit* test that saves a *MyUser* entity:

```java
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
  classes = AutoconfigurationApplication.class)
@EnableJpaRepositories(
  basePackages = { "com.baeldung.autoconfiguration.example" })
public class AutoconfigurationTest {

    @Autowired
    private MyUserRepository userRepository;

    @Test
    public void whenSaveUser_thenOk() {
        MyUser user = new MyUser("user@email.com");
        userRepository.save(user);
    }
}
```

Since we have not defined our *DataSource* configuration, the application will use the auto-configuration we have created to connect to a *MySQL* database called *myDb*.

**The connection string contains the *createDatabaseIfNotExist=true* property, so the database does not need to exist. However, the user *mysqluser* or the one specified through the *mysql.user* property if it is present, needs to be created.**

We can check the application log to see that the *MySQL* data source is being used:

```bash
web - 2017-04-12 00:01:33,956 [main] INFO  o.s.j.d.DriverManagerDataSource - Loaded JDBC driver: com.mysql.cj.jdbc.Driver
```

#### 5. Disabling Auto-Configuration Classes

If we wanted to **exclude the auto-configuration from being loaded**, we could add the *@EnableAutoConfiguration* annotation with *exclude* or *excludeName* attribute to a configuration class:

```java
@Configuration
@EnableAutoConfiguration(
  exclude={MySQLAutoconfiguration.class})
public class AutoconfigurationApplication {
    //...
}
```

Another option to disable specific auto-configurations is by setting the *spring.autoconfigure.exclude* property:

```bash
spring.autoconfigure.exclude=com.baeldung.autoconfiguration.MySQLAutoconfiguration
```

### Using CommandLineRunner

 Spring Boot will automatically call the *run* method of all beans implementing *CommandLineRunner* interface after the application context has been loaded.

Lets see that on example simple console application realized using Spring Boot.

Thanks [baeldung.com](https://www.baeldung.com/spring-boot-console-app)

#### 1. Overview

In this quick tutorial, we'll explore how to create a simple console-based application using Spring Boot.

#### 2. Maven Dependencies

Our project relies on the spring-boot parent:

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.4.0</version>
</parent>
```

The initial dependency required is:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
</dependency>
```

#### 3. Console Application

Our console application consists of a single class: *SpringBootConsoleApplication.java* – this is the main class for out Spring Boot console application.

We're using **Spring's *@SpringBootApplication* annotation** on our main class to enable auto-configuration.

This class also implements **Spring's *CommandLineRunner* interface**. *CommandLineRunner* is a simple Spring Boot interface with a *run* method. **Spring Boot will automatically call the *run* method of all beans implementing this interface after the application context has been loaded**.

Here is our console application:

```java
@SpringBootApplication
public class SpringBootConsoleApplication 
  implements CommandLineRunner {

    private static Logger LOG = LoggerFactory
      .getLogger(SpringBootConsoleApplication.class);

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(SpringBootConsoleApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }
 
    @Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");
 
        for (int i = 0; i < args.length; ++i) {
            LOG.info("args[{}]: {}", i, args[i]);
        }
    }
}
```

**We should also specify the *spring.main.web-application-type=NONE* [Spring property](https://www.baeldung.com/properties-with-spring). This property will explicitly inform Spring that this isn't a web application.**

When we execute *SpringBootConsoleApplication*, we can see the following logged:

```shell
00:48:51.888 [main] INFO  c.b.s.SpringBootConsoleApplication - STARTING THE APPLICATION
00:48:52.752 [main] INFO  c.b.s.SpringBootConsoleApplication - No active profile set, falling back to default profiles: default
00:48:52.851 [main] INFO  o.s.c.a.AnnotationConfigApplicationContext 
  - Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@6497b078: startup date [Sat Jun 16 00:48:52 IST 2018]; root of context hierarchy
00:48:53.832 [main] INFO  o.s.j.e.a.AnnotationMBeanExporter - Registering beans for JMX exposure on startup
00:48:53.854 [main] INFO  c.b.s.SpringBootConsoleApplication - EXECUTING : command line runner
00:48:53.854 [main] INFO  c.b.s.SpringBootConsoleApplication - args[0]: Hello World!
00:48:53.860 [main] INFO  c.b.s.SpringBootConsoleApplication - Started SpringBootConsoleApplication in 1.633 seconds (JVM running for 2.373)
00:48:53.860 [main] INFO  c.b.s.SpringBootConsoleApplication - APPLICATION FINISHED
00:48:53.868 [Thread-2] INFO  o.s.c.a.AnnotationConfigApplicationContext 
  - Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@6497b078: startup date [Sat Jun 16 00:48:52 IST 2018]; root of context hierarchy
00:48:53.870 [Thread-2] INFO  o.s.j.e.a.AnnotationMBeanExporter - Unregistering JMX-exposed beans on shutdown
```

Notice that the *run* method is called after application context is loaded but before the execution of the *main* method is complete.

Most console applications will only have a single class that implements *CommandLineRunner*. If your application has multiple classes that implement *CommandLineRunner*, the order of execution can be specified using [Spring's *@Order* annotation](https://www.baeldung.com/spring-order).

## 12 JPA with Spring and Spring Data

### Quick introduction to ORM with JPA

Thanks [baeldung.com](https://www.baeldung.com/learn-jpa-hibernate)

Object-Relational Mapping (ORM) is the process of converting Java objects to database tables. In other words, this allows us to interact with a relational database without any SQL. **The Java Persistence API (JPA) is a specification that defines how to persist data in Java applications.** The primary focus of JPA is the ORM layer.

Hibernate is one of the most popular Java ORM frameworks in use today. Its first release was almost twenty years ago, and still has excellent community support and regular releases. Additionally, **Hibernate is a standard implementation of the JPA specification**, with a few additional features that are specific to Hibernate. Let's take a look at some core features of JPA and Hibernate.

#### Defining Entities

- [Defining JPA Entities](https://www.baeldung.com/jpa-entities)
- [Hibernate Entity Lifecycle](https://www.baeldung.com/hibernate-entity-lifecycle)
- [JPA Entity Lifecycle Events](https://www.baeldung.com/jpa-entity-lifecycle-events)
- [Default Column Values in JPA](https://www.baeldung.com/jpa-default-column-values)
- [JPA @Basic Annotation](https://www.baeldung.com/jpa-basic-annotation)
- [Mapping Entity Class Names to SQL Table Names with JPA](https://www.baeldung.com/jpa-entity-table-names)
- [Difference Between @Size, @Length, and @Column(length=value)](https://www.baeldung.com/jpa-size-length-column-differences)
- [JPA Entity Equality](https://www.baeldung.com/jpa-entity-equality)
- [JPA @Embedded And @Embeddable](https://www.baeldung.com/jpa-embedded-embeddable)
- [JPA Attribute Converters](https://www.baeldung.com/jpa-attribute-converters)
- [Hibernate @NotNull vs @Column(nullable = false)](https://www.baeldung.com/hibernate-notnull-vs-nullable)
- [Defining Unique Constraints in JPA](https://www.baeldung.com/jpa-unique-constraints)
- [JPA Entities and the Serializable Interface](https://www.baeldung.com/jpa-entities-serializable)

#### Entity Relationships

- [One-to-One Relationship in JPA](https://www.baeldung.com/jpa-one-to-one)
- [Many-To-Many Relationship in JPA](https://www.baeldung.com/jpa-many-to-many)
- [@JoinColumn Annotation Explained](https://www.baeldung.com/jpa-join-column)
- [Difference Between @JoinColumn and mappedBy](https://www.baeldung.com/jpa-joincolumn-vs-mappedby)
- [Mapping a Single Entity to Multiple Tables in JPA](https://www.baeldung.com/jpa-mapping-single-entity-to-multiple-tables)
- [Overview of JPA/Hibernate Cascade Types](https://www.baeldung.com/jpa-cascade-types)
- [Hibernate @WhereJoinTable Annotation](https://www.baeldung.com/hibernate-wherejointable)
- [Hibernate Inheritance Mapping](https://www.baeldung.com/hibernate-inheritance)
- [Hibernate One to Many Annotation Tutorial](https://www.baeldung.com/hibernate-one-to-many)

#### Identifiers

- [An Overview of Identifiers in Hibernate/JPA](https://www.baeldung.com/hibernate-identifiers)
- [Composite Primary Keys in JPA](https://www.baeldung.com/jpa-composite-primary-keys)
- [When Does JPA Set the Primary Key](https://www.baeldung.com/jpa-strategies-when-set-primary-key)

#### Read Operations

- [Types of JPA Queries](https://www.baeldung.com/jpa-queries)
- [JPA Query Parameters Usage](https://www.baeldung.com/jpa-composite-primary-keys)
- [Constructing a JPA Query Between Unrelated Entities](https://www.baeldung.com/jpa-query-parameters)
- [Working with Lazy Element Collections in JPA](https://www.baeldung.com/java-jpa-lazy-collections)
- [JPA Join Types](https://www.baeldung.com/jpa-join-types)
- [FetchMode in Hibernate](https://www.baeldung.com/hibernate-fetchmode)
- [Hibernate Named Query](https://www.baeldung.com/hibernate-named-query)

#### Query Criteria

- [Combining JPA And/Or Criteria Predicates](https://www.baeldung.com/jpa-and-or-criteria-predicates)
- [Criteria API – An Example of IN Expressions](https://www.baeldung.com/jpa-criteria-api-in-expressions)
- [JPA Criteria Queries](https://www.baeldung.com/hibernate-criteria-queries)

#### Pagination and Sorting

- [Sorting with JPA](https://www.baeldung.com/jpa-sort)
- [JPA Pagination](https://www.baeldung.com/jpa-pagination)
- [Hibernate Pagination](https://www.baeldung.com/hibernate-pagination)
- [JPA Criteria Queries](https://www.baeldung.com/hibernate-criteria-queries)

#### Query Results

- [A Guide to SqlResultSetMapping](https://www.baeldung.com/jpa-sql-resultset-mapping)
- [Customizing the Result of JPA Queries with Aggregation Functions](https://www.baeldung.com/jpa-queries-custom-result-with-aggregation-functions)

#### Write Operations

- [INSERT Statement in JPA](https://www.baeldung.com/jpa-insert)
- [Batch Insert/Update with Hibernate/JPA](https://www.baeldung.com/jpa-hibernate-batch-insert-update)
- [Deleting Objects with Hibernate](https://www.baeldung.com/delete-with-hibernate)
- [Hibernate: save, persist, update, merge, saveOrUpdate](https://www.baeldung.com/hibernate-save-persist-update-merge-saveorupdate)

### Benefits of using Spring with JPA

Thanks [thorben-janssen.com](https://thorben-janssen.com/what-is-spring-data-jpa-and-why-should-you-use-it/#reasons)

#### 3 reasons to use Spring Data JPA

OK, so if the JPA specification and its implementations provide most of the features that you use with Spring Data JPA, do you really need the additional layer? Can’t you just use the Hibernate or EclipseLink directly?

You can, of course, do that. That’s what a lot of Java SE applications do. Jakarta EE provides a good integration for JPA without adding an extra layer.

But the Spring Data team took the extra step to make your job a little bit easier. The additional layer on top of JPA enables them to integrate JPA into the Spring stack seamlessly. They also provide a lot of functionality that you otherwise would need to implement yourself.

Here are my 3 favorite features that Spring Data adds on top of JPA.

##### 1. No-code Repositories

The [repository pattern](https://thorben-janssen.com/implementing-the-repository-pattern-with-jpa-and-hibernate/) is one of the most popular persistence-related patterns. It hides the data store specific implementation details and enables you to implement your business code on a higher abstraction level.

Implementing that pattern isn’t too complicated but writing the standard CRUD operations for each entity creates a lot of repetitive code. Spring Data JPA provides you a set of repository interfaces which you only need to extend to define a specific repository for one of your entities.

I will show you Spring Data repositories in more details at the end of this article. Here is a quick example of a repository that provides the required methods:

- to [persist, update and remove](https://thorben-janssen.com/persist-save-merge-saveorupdate-whats-difference-one-use/) one or multiple *Author* entities,
- to find one or more *Author*s by their primary keys,
- to count, get and remove all *Author*s and
- to check if an *Author* with a given [primary key](https://thorben-janssen.com/jpa-generate-primary-keys/) exists.

```java
package org.thoughts.on.java.spring.data.repository;
 
import org.springframework.data.repository.CrudRepository;
import org.thoughts.on.java.spring.data.model.Author;
 
public interface AuthorRepository extends CrudRepository<Author, Long> {}

```

And before you ask: Yes, that code sample is correct and complete. The *CrudRepository* interface defines all methods I mentioned before. So, you just need to extend it.

##### 2. Reduced boilerplate code

To make it even easier, Spring Data JPA provides a default implementation for each method defined by one of its repository interfaces. That means that you no longer need to implement basic read or write operations. And even so all of these operations don’t require a lot of code, not having to implement them makes life a little bit easier and it reduces the risk of stupid bugs.

##### 3. Generated queries

Another comfortable feature of Spring Data JPA is the generation of database queries based on method names. As long as your query isn’t too complex, you just need to define a method on your repository interface with a name that starts with *find…By*. Spring then parses the method name and creates a query for it.

Here is a simple example of a query that loads a *Book* entity with a given *title*. Internally, Spring generates a [JPQL query](https://thorben-janssen.com/jpql/) based on the method name, sets the provided method parameters as bind parameter values, executes the query and returns the result.

```java
public interface BookRepository extends CrudRepository<Book, Long> {
     
    Book findByTitle(String title);
}
```

