package net.daum;

// Assert가 가지는 모든 static 메소드를 import
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// 자바에서는 ctrl + shift + O 를 많이 쓰는데 이 때 *이 다 풀려버림
// 이건 설정에서 바꿔줘야함

import static org.hamcrest.CoreMatchers.*;
// 아래 순서로 반복됨. 그래야 다른 테스트에 독립적으로 돌아갈 수 있음 
// (독립성을 완벽하게 보장하기 위함)
// setup -> test -> teardown
// setup -> test -> teardown
// 그래서 필트에 넣지 않고 setup, teardown 으로 메소드를 별도로 작성함...

// 아래는 JUnit 4
// JUnit 3은 최하단 참고
public class CalculatorTest {

	private static final Logger logger = LoggerFactory
			.getLogger(CalculatorTest.class);
	
	private Caculator calculator;
	
	@Before
	public void stup() {
		// 이 녀석은 다른 테스트 메소드가 실행되기 전에 실행되는 녀석인데
		// 모든 테스트가 실행되기 전에 실행되는건지 아니면 한 번만 실행되는건지...
		// 아니면 필드에 넣지 않은 이유는??
		this.calculator = new Caculator();
	}
	

	@Test
	public void add() {
		// 그 다음으로는 caculator 컴파일 에러를 잡자.
		// 그리고 그 다음에 클래스 컴파일 에러를 잡자.
		Caculator caculator = new Caculator();
		
		// TDD에서는 한 번에 한 가지만 집중하겠다.
		// 즉 caculator 인스턴스를 만드는 것도 다른 작업이다.
		// (인터페이스를 만드는 작업은 엄청 중요한 작업이다.)
		int result = caculator.add(1, 2);
//		Assert.assertEquals(3, result);
		assertEquals(3, result);
		assertThat(caculator.add(1, 2), is(3));
	}
	
	@Test
	public void substract() {
		int result = calculator.substract(10, 4);
		assertEquals(6, result);
		assertThat(calculator.substract(1, 3), is(-2));
//		Assert.assertEquals(6, result);
		
		logger.debug("add: {}", calculator.substract(1, -3));
	}
	
	@Test
	public void multiply() {
		int result = calculator.multiply(10, 3);
//		Assert.assertEquals(30, result);
		assertEquals(30, result);
		assertThat(result, is(30));
	}
	
	@Test
	public void devide() {
		int result = this.calculator.devide(10, 2);
//		Assert.assertEquals(5, result);
		assertEquals(5, result);
		assertThat(result, is(5));
	}
	
	@After
	public void tearDown() {
		logger.debug("test is done");
	}

}


// JUnit 3
// 여기에서는 this.assertEquals이 편함....
//public class CalTest extends TestCase {
//	public void testAdd() {
//		Cal cal = new Cal();
//		assertEquals(3, cal.add(1, 3));
//	}
//}