package test;

public class TestSrc3 {

	private String strrr;

	public static void run(int a, int b, int c) {
		int num = (int) 3.5;
		int ans = 0;
		String str1 = "abc";
		String str2 = "efg";
		String str3, str4;

		if( ans == 0 ) {
			while(true) {
				ans += str1.length();
				if( ans > 10 ) {
					break;
				}
			}
		}
	}

	public String StringConnector(String str1, String str2) {
		StringBuilder sb = new StringBuilder();
		SampleClass sc = new SampleClass();

		String[] array = new String[10];
		array[1] = "first";
		array[2] = "second";

		this.strrr = sc.str;

		return sb.append(this.strrr).append(array[1]).append(array[2]).toString();
	}

}
