package baseball.utils;

public class StringUtil {
	public static boolean isEmpty(String value) {
		if (value == null || "".equals(value)) {
			return true;
		}
		return false;
	}
	
	public static boolean isNumber(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
