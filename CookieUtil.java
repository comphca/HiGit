
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	//用于设置cookie的生命周期
	public static final int MAX_AGE = 365 * 24 * 60 * 60;
	
	public static void addCookie(String name, String value, int MAX_AGE, HttpServletResponse response){
		Cookie cookie = new Cookie(name,value);
		cookie.setMaxAge(MAX_AGE);
		response.addCookie(cookie);
	}
	
	public static void addCookie(String name, String value, HttpServletResponse response){
		addCookie(name, value, MAX_AGE, response);
	}
	
	public static void removeCookie(String key, HttpServletResponse response){
		addCookie(key, "", 0, response);
	}
	
	public static String findCookie(String key, HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		if(cookies != null)
		{
			for(Cookie c : cookies)
			{
				if(c.getName().equals(key))
					return c.getValue();
			}
		}
		return null;
		
	}

}
