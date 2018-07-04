package org.annotation;

import org.junit.Test;

public class FactoryTest{
	
	@Test
	public void whenThen() {
		FactoryRandomNumber<RandomTest> factoryRandomNumber = new FactoryRandomNumber();
		RandomTest randomTest = factoryRandomNumber.getObject(new RandomTest());
		
		System.out.println(randomTest.a);
		
		System.out.println(randomTest.b);
	}
	
	class RandomTest {
		
		@RandomNumberAnnotation(min = 4, max = 11)
		int a;
		
		@RandomNumberAnnotation(min = 12, max = 120)
		int b;
		
		public void setA(int a) {
			this.a = a;
		}
		
		public void setB(int b) {
			this.b = b;
		}
		

	}

}
