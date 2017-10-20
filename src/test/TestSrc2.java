package test;

public class TestSrc2 {
	private static int a = 13;
	private static int b = 11;
	private static int c = 9;
	private static int d = 7;
	private static int e = 5;
	private static int result;

	public static void main(String[] args) {
		result = div(mul(sub(add(a,b), c), d), e);
		System.out.println(String.valueOf(result));
	}

	public static int add(int num1, int num2) {
		return num1 + num2;
	}

	public static int sub(int num1, int num2) {
		return num1 - num2;
	}

	public static int mul(int num1, int num2) {
		return num1 * num2;
	}

	public static int div(int num1, int num2) {
		return num1 / num2;
	}
	
	public static int sample(int arg1, int arg2, int arg3) {
		return 5;
	}
}
