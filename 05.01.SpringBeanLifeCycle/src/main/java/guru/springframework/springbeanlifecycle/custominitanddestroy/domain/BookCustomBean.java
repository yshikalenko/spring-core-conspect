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