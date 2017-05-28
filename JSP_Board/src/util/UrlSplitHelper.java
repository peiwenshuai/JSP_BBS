package util;

//해당 컨트롤러에 어떤 서블릿을 호출했는지 구분하기 위해, 호출서블릿 URL 문자열을 반환해주는 기능을 제공하는 Class
public class UrlSplitHelper {

	private static String[] doUrl = null;

	public static String getDoUrl(String requestUrl) {
		doUrl = requestUrl.split("/");
		int lastIndex = doUrl.length - 1;
		return doUrl[lastIndex];

	}

}
