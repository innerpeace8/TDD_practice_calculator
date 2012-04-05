package net.daum;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StringCalculatorTest {
	
	StringCalculator calc;
	private static final Logger logger =
			LoggerFactory.getLogger(CalculatorTest.class);
	
	@Before
	public void setup() {
		calc = new StringCalculator();
	}

	@Test
	public void add_empty_string_is_zero() throws Exception {
		logger.debug("빈 문자열이면 0을 반환해야함....");
		int result = calc.add("");
		assertThat(result, is(0));
	}
	
	@Test
	public void add_a_number_is_number() throws Exception {
		logger.debug("숫자가 하나일 때는 해당 숫자를 반환해야한다.");
		int result = calc.add("7");
		assertThat(result, is(7));
	}
	
	@Test
	public void add_string_contains_a_comma() throws Exception {
		logger.debug(",를 포함하면 ,를 구분자로 해당 숫자를 더한다.");
		int result = calc.add("4,3");
		assertThat(result, is(7));
	}
	
	@Test
	public void add_string_contains_many_comma() throws Exception {
		int result = calc.add("3,42,5");
		assertThat(result, is(50));
	}
	
	@Test
	public void add_string_contains_newline() throws Exception {
		int result = calc.add("3,2\n1");
		assertThat(result, is(6));
	}
	
	@Test
	public void add_string_contains_custom_delimeter() throws Exception {
		int result = calc.add("//;\n1;2;3;67");
		assertThat(result, is(73));
	}
	
	@Test
	public void add_string_contains_regr_keyword() throws Exception {
		// TODO: custom delimeter가 -이면 어떡할꺼냐?? -> -는 못쓰게 하자-_-;
		// 소스 리펙토링하는 과정에서 Integer.parseInt 를 따로 뺀 메소드에서 Exception 발생이 들어감
		// 그래서 delimeter가 -라도 상관 없음
		int result = calc.add("//.\n1.3.6.7");
		assertThat(result, is(17));
		
		// TODO: 별도의 테스트 메소드로 빼기?
		result = calc.add("//-\n3-2-5");
		assertThat(result, is(10));
	}
	
	@Test(expected=Exception.class)
	public void add_throw_exception() throws Exception {
		calc.add("-3,3,6");
	}
}
