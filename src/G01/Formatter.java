package G01;

public class Formatter {
	private Formatter() {};
	public static String errorText(String JUnitErrorText) {
		return JUnitErrorText + ", ";
	};
}
