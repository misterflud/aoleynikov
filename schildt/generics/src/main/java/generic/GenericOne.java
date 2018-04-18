package generic;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class GenericOne {
	public static void main(String args[]) {
		GenericOne genericOne = new GenericOne();
		genericOne.method2();
	}
	
	public void method1() {
		SomeType someType = new SomeType();
		List<String> list = Arrays.asList("value");
		someType.test(list);
	}
	
	public void method2() {
		SomeType<?> someType = new SomeType<Object>();
		List<String> list = Arrays.asList("value");
		someType.test(list);
	}

	
	public class SomeType<T> {
		public <E> void test(Collection<E> collection) {
			for(E e : collection) {
				System.out.println(e);
			}
		}
		
		public void test (List<Integer> integerList) {
			for (Integer integer : integerList) {
				System.out.println(integer);
			}
		}
	}
}

