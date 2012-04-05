package net.daum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public int add(String text) throws Exception {
		if (text.isEmpty()) {
			return 0;
		}
		String delimeter = ",|\n";
		if (text.startsWith("//")) {
			Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
			m.find();
			delimeter = Pattern.quote(m.group(1));
			text = m.group(2);
		}
		
		String[] numbers = text.split(delimeter);
		return sum(numbers);
	}
	
	private int sum(String[] numbers) throws Exception {
		int sum = 0;
		for (String number : numbers) {
			sum += toInt(number);
		}
		return sum;
	}

	private int toInt(String number) throws Exception {
		int result = Integer.parseInt(number);
		if (result < 0) {
			throw new Exception("Cannot add negative number!");
		}
		return result;
	}

}
