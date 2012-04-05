package net.daum.old;

// 우리들의 일반적인 개발 방법
public class OldCalculator {
	public int add(int i, int j) {
		return i + j;
	}
	
	public int substract(int i, int j) {
		return i - j;
	}
	
	public int multiply(int i, int j) {
		return i * j;
	}
	
	public int divide(int i, int j) {
		return i / j;
	}
	
	public static void main(String[] args) {
		// 메인 메소드에서 모든 테스트를 커버해야하는 것은 로직이 커짐에 따라 복잡해지고 유지 보수가 어려워
		// 가독성 문제도 발생
		OldCalculator calculator = new OldCalculator();
		System.out.println("add: " + calculator.add(10, 10));
	 	System.out.println("substract: " + calculator.substract(10, 10));
	 	System.out.println("multiply: " + calculator.multiply(10, 10));
	 	System.out.println("divide: " + calculator.divide(10, 3));
	}
}
