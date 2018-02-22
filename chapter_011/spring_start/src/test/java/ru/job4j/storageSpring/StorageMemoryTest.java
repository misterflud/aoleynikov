package ru.job4j.storageSpring;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StorageMemoryTest {

	@Test
	public void whenLoadContextShouldGetBeans() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context1.xml");
		UserStorage memory = context.getBean(UserStorage.class);
		memory.add(new User());
	}
	
	@Test
	public void whenLoadAnnotationShouldGetBeans() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context2.xml");
		UserStorage memory = context.getBean(UserStorage.class);
		memory.add(new User());
	}

}
